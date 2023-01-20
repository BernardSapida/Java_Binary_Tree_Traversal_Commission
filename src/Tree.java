public class Tree {
    Node root = null;

    public boolean search(int val) {
        Node current = this.root;

        while(current != null) {
            if(val < current.val) current = current.left;
            else if(val > current.val) current = current.right;
            else return true;
        }

        return false;
    }

    public boolean insert(int val) {
        Node newNode = new Node(val);

        if(root == null) this.root = newNode;
        else {
            Node currentNode = this.root;

            while(true) {
                if(val == currentNode.val) return false;
                if(val < currentNode.val) {
                    if(currentNode.left == null) {
                        currentNode.left = newNode;
                        return true;
                    }
                    currentNode = currentNode.left;
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = newNode;
                        return true;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
        return false;
    }

    public String preOrder() {
        Node current = this.root;
        return preOrderTraversal(current);
    }

    public String preOrderTraversal(Node current) {
        String result = " " + current.val;
        if(current.left != null) result += preOrderTraversal(current.left);
        if(current.right != null) result += preOrderTraversal(current.right);
        return result;
    }

    public String postOrder() {
        Node current = this.root;
        return postOrderTraverse(current);
    }

    public String postOrderTraverse(Node current) {
        String result = "";
        if(current.left != null) result += postOrderTraverse(current.left);
        if(current.right != null) result += postOrderTraverse(current.right);
        return result + " " + current.val;
    }

    public String inOrder() {
        Node current = this.root;
        return inOrderTraverse(current);
    }

    public String inOrderTraverse(Node current) {
        String result = "";
        if(current.left != null) result += inOrderTraverse(current.left);
        result += " " + current.val;
        if(current.right != null) result += inOrderTraverse(current.right);
        return result;
    }
}