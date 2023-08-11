class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class StructurallyIdenticalBST {
    Node root;

    void insert(int data){
        root = insertHelper(root, data);
    }

    Node insertHelper(Node root, int data){
        if(root==null){
            root = new Node(data);
            return root;
        }

        if(data<root.data){
            root.left = insertHelper(root.left, data);
        }

        else if(data>root.data){
            root.right = insertHelper(root.right, data);
        }

        return root;
    }

    static boolean isIdentical(Node root1, Node root2){
        if(root1==null && root2==null){
            return true;
        }

        if(root1==null || root2==null){
            return false;
        }

        boolean left = isIdentical(root1.left, root2.left);
        boolean right = isIdentical(root1.right, root2.right);

        if(left&right){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        StructurallyIdenticalBST bst1 = new StructurallyIdenticalBST();
        StructurallyIdenticalBST bst2 = new StructurallyIdenticalBST();
        bst1.insert(10);
        bst1.insert(5);
        bst1.insert(20);
        bst1.insert(40);

        bst2.insert(100);
        bst2.insert(50);
        bst2.insert(200);
        bst2.insert(400);

        boolean ans = isIdentical(bst1.root, bst2.root);
        if(ans){
            System.out.println("Trees are identical");
        }
        
        else{
            System.out.println("Trees are not identical");
        }
    }
}
