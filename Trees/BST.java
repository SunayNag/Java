import java.util.*;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    static class BinaryST{
        void inOrder(Node root){
            if(root==null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        Node insert(Node root, int n){
            if(root==null){
                return new Node(n);
            }
            if(root.data>n){
                root.left = insert(root.left, n);
            }
            else{
                root.right = insert(root.right, n);
            }
            return root;
        }

        boolean search(Node root,int key){
            if(root==null){
                return false;
            }
            boolean result;
            if(root.data==key){
                result=true;
            }
            else if(root.data>key){
                result = search(root.left, key);
            }
            else{
                result = search(root.right, key);
            }
            return result;
        }

        Node delete(Node root, int n){
            if(root.data>n){
                root.left = delete(root.left, n);
                return root;
            }
            else if(root.data<n){
                root.right = delete(root.right, n);
                return root;
            }
            if(!(root.left==null || root.right==null)){
                Node pointer = root.right;
                while(pointer.left!=null){
                    pointer = pointer.left;
                }
                int data = pointer.data;
                delete(root, data);
                pointer.left=root.left;
                pointer.right=root.right;
                return pointer;
            }
            if(root.left==null && root.right==null){
                return null;
            }
            else{
                if(root.left!=null){
                    return root.left;
                }
                else{
                    return root.right;
                }
            }
        }

        void inRange(Node root, int a, int b){
            if(root==null || root.data<a || root.data>b){
                return;
            }
            inRange(root.left, a, b);
            System.out.print(root.data+" ");
            inRange(root.right, a, b);
        }

        void printRootToLeaf(Node n){
            List<Integer> path = new ArrayList<>();
            getPath(path, n);
        }

        void getPath(List<Integer> path, Node n){
            if(n==null){
                return;
            }
            path.add(n.data);
            if(n.left==null && n.right==null){
                System.out.println(path);
                path.remove(path.size()-1);
                return;
            }
            getPath(path, n.left);
            getPath(path, n.right);
            path.remove(path.size()-1);
            
        }
    }
    public static void main(String[] args) {
        Node root = null;
        BinaryST bst = new BinaryST();
        int[] arr = {8,5,10,3,6,11,1,4,14,13};
        for(int i: arr){
            root = bst.insert(root, i);
        }
        bst.inOrder(root);
        System.err.println();
        System.out.println(bst.search(root, 7));
        bst.delete(root, 13);
        bst.inOrder(root);
        System.out.println();
        bst.inRange(root, 3, 8);
        System.out.println();
        bst.printRootToLeaf(root);
    }
}
