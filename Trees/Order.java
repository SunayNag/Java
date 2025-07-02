import java.util.*;

public class Order {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    static class Info{
        int height;
        int diameter;

        Info(Node n){
            if(n==null){
                this.height=0;
                this.diameter=0;
                return;
            }
            Info leftInfo = new Info(n.left);
            Info rightInfo = new Info(n.right);

            height=Math.max(leftInfo.height, rightInfo.height)+1;
            diameter = leftInfo.height+rightInfo.height+1;
            diameter=Math.max(diameter, Math.max(leftInfo.diameter, rightInfo.diameter));
        }
    }
    static class BinaryTree{
        static int idx =-1;
        Node buildPre(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildPre(nodes);
            newNode.right = buildPre(nodes);

            return newNode;
        }

        void preOrder(Node N){
            if(N==null){
                return;
            }
            System.out.print(N.data+" ");
            preOrder(N.left);
            preOrder(N.right);
        }

        void levelOrder(Node n){
            Queue<Node> q = new LinkedList<>();
            q.add(n);
            q.add(null);
            while(!q.isEmpty()){
                Node temp = q.remove();
                if(temp==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    q.add(null);
                    continue;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                System.out.print(temp.data+" ");
            }
        }

        int height(Node n){
            if(n==null){
                return 0;
            }

            int res = Math.max(height(n.left), height(n.right))+1;
            return res;
        }

        int countNode(Node n){
            if(n==null){
                return 0;
            }
            return countNode(n.left)+countNode(n.right)+1;
        }

        int sumNode(Node n){
            if(n==null){
                return 0;
            }
            return sumNode(n.left)+sumNode(n.right)+n.data;
        }
    
        //Diameter
        int diam(Node n){
            Info inf = new Info(n);
            return inf.diameter;
        }

        //Subtree match
        boolean subtree(Node n, Node s){
            if(n==null){
                return false;
            }
            if(n.data==s.data){
                return isIdentical(n,s);
            }

            return subtree(n.left, s) || subtree(n.right, s);
        }

        boolean isIdentical(Node n, Node s){
            if(n==s){
                return true;
            }
            else if(n==null||s==null||n.data!=s.data){
                return false;
            }
            return isIdentical(n.left, s.left) && isIdentical(n.right, s.right);
        }
    
        //kth level using recursion
        void kthLevel(Node n, int k){
            levelHelper(n, k, 1);
        }

        void levelHelper(Node n, int k, int lvl){
            if(n==null){
                return;
            }
            if(k==lvl){
                System.out.print(n.data+" ");
            }
            levelHelper(n.left, k, lvl+1);
            levelHelper(n.right, k, lvl+1);
        }
        
        //Lowest common Ancestor
        int lca(Node n, int a, int b){
            List<Integer> pathA = new ArrayList<>();
            List<Integer> pathB = new ArrayList<>();

            getPath(n, a, pathA);
            getPath(n, b, pathB);
            Collections.reverse(pathA);
            Collections.reverse(pathB);
            // System.out.println(pathA);
            // System.out.println(pathB);
            int lca = -1;
            for(int i=0;i<pathA.size() && i<pathB.size();i++){
                if(pathA.get(i)!=pathB.get(i)){
                    break;
                }
                lca = pathA.get(i);
            }

            return lca;
            
        }

        boolean getPath(Node n, int a, List<Integer> path){
            if(n==null){
                return false;
            }
            if(n.data==a){
                path.add(a);
                return true;
            }
            boolean left =  getPath(n.left, a, path);
            boolean right = getPath(n.right, a, path);
            if(left || right){
                path.add(n.data);
                return true;
            }
            return false;
        }
        
        //LCA second approach
        Node lca2(Node n, int a, int b){
            if(n==null || n.data==a || n.data==b){
                return n;
            }
            Node left = lca2(n.left, a, b);
            Node right = lca2(n.right, a, b);

            if(right == null){
                return left;
            }
            if(left==null){
                return right;
            }
            // System.out.println("hey "+n.data+" "+left.data+" "+right.data);
            return n;
        }
    
        //Min Distance My Approach
        int minDist(Node n, int a, int b){
            List<Integer> pathA = new ArrayList<>();
            List<Integer> pathB = new ArrayList<>();

            getPath(n, a, pathA);
            getPath(n, b, pathB);
            Collections.reverse(pathA);
            Collections.reverse(pathB);
            // System.out.println(pathA);
            // System.out.println(pathB);
            int i=0;
            for(;i<pathA.size() && i<pathB.size();i++){
                if(pathA.get(i)!=pathB.get(i)){
                    break;
                }
            }
            int A = pathA.size()-i;
            int B = pathB.size()-i;
            return A+B;
        }
    
        //Min Distance using LCA2
        int minDist2(Node n, int a, int b){
            Node lca = lca2(n, a, b);
            int n1 = lcaDist(lca, a);
            int n2 = lcaDist(lca, b);
            return n1+n2;


        }
        int lcaDist(Node n, int a){
            if(n==null){
                return -1;
            }
            if(n.data==a){
                return 0;
            }
            int left = lcaDist(n.left, a);
            int right = lcaDist(n.right, a);
            if(left<0 && right<0){
                return -1;
            }
            return (left>right?left:right)+1;
        }


        //Kth Ancestor
        int kthAncestor(Node n, int t, int k){
            List<Integer> path = new ArrayList<>();
            getPath(n, t, path);
            // System.out.println(path);
            if(k>path.size()-1) return -1;
            int result=path.get(0);
            for(int i=1;i<=k;i++){
                result=path.get(i);
            }
            return result;
        }
    }
    public static void main(String[] args) {
        int[] tree = {1,2,4,8,-1,-1,-1,5,-1,9,-1,-1,3,6,-1,-1,7,-1,10,-1,-1};
        int[] subTree = {2,4,-1,-1,5,-1,-1};

        BinaryTree bt = new BinaryTree();

        Node rootPre = bt.buildPre(tree);
        bt.idx=-1;
        Node subT = bt.buildPre(subTree);

        System.out.print("preOrder:");
        bt.preOrder(rootPre);
        System.out.println();
        System.out.println("Level Order:");
        bt.levelOrder(rootPre);
        System.out.println("Height:"+bt.height(rootPre));
        System.out.println("No. of Nodes:"+bt.countNode(rootPre));
        System.out.println("Sum of Nodes:"+bt.sumNode(rootPre));
        System.out.println("Diameter:"+bt.diam(rootPre));
        System.out.println("Is Subtree:"+bt.subtree(rootPre, subT));
        System.out.print("Kth Level:");
        bt.kthLevel(rootPre, 4);
        System.out.println();
        System.out.println("LCA1:"+bt.lca(rootPre, 8, 12));
        System.out.println("LCA2:"+bt.lca2(rootPre, 8, 10).data);
        System.out.println("Min1:"+bt.minDist(rootPre,10, 8));
        System.out.println("Min2:"+bt.minDist2(rootPre, 10, 8));
        System.out.println("Kth Ancestor:"+bt.kthAncestor(rootPre, 10,2));
    }
}
