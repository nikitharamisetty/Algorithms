public class BinarySTree {
    static Node root = null;
    class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
            left = null;
            right = null;
        }
    }

    public Node insert(Node node, int val){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if(node.value<val){
            node.right = insert(node.right,val);
        }
        else{
            node.left=insert(node.left,val);
        }
        return node;

    }
    public void inOrder(Node node){
        if(node == null){
            return ;
        }
        inOrder(node.left);
        System.out.print(node.value+ "\t");
        inOrder(node.right);
    }

    public int successor(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node.value;
    }

    public int predecessor(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node.value;
    }
    public Node delete(Node root,int val){
        if(root == null){
            return root ;

        }
        if(val>root.value){
            root.right = delete(root.right,val);
        }
        else if (val<root.value){
            root.left = delete(root.left,val);
        }
        else{
            if (root.left == null) {
                return root.right;
            }
            else if (root.right ==null){
                return root.left;
            }
            root.value = predecessor(root.left);
            root.left = delete (root.left, root.value);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySTree tree = new BinarySTree();
        int[] newTree = {40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46};

        for (int i = 0; i < newTree.length; i++) {
            root = tree.insert(root,newTree[i]);
        }
        System.out.println("InOrder Traversal after inserting:");
        tree.inOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("InOrder Traversal after deleting 40:");
        tree.delete(root,40);
        tree.inOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("InOrder Traversal after deleting 20:");
        tree.delete(root,20);
        tree.inOrder(root);

    }
}
