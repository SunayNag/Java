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
    }
    public static void main(String[] args) {
        Node root = null;
        BinaryST bst = new BinaryST();
        int[] arr = {5,3,2,4,6,1};
        for(int i: arr){
            root = bst.insert(root, i);
        }
        bst.inOrder(root);
        System.err.println();
        System.out.println(bst.search(root, 7));
    }
}
