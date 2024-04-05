class BST {
    Node root;

    public void constructPrint(int[] array) {
        System.out.println("CONSTRUCT " + java.util.Arrays.toString(array));
    }
    public static class Node {
        int number;
        Node leftChild, rightChild;

        public Node(int number) {
            this.number = number;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public Node add(Node root, int value) {
    Node new_node = new Node(value);
    if (root == null) {
        root = new_node;
        return root;
    }
    if (value <= root.number) { 
        root.leftChild = add(root.leftChild, value);
    } else {
        root.rightChild = add(root.rightChild, value);
    }
    return root;
}


    public Node delete(Node root, int dNumber) {
        if (root == null) {
            return null;
        }
        if (dNumber < root.number) {
            root.leftChild = delete(root.leftChild, dNumber);
        } else if (dNumber > root.number) {
            root.rightChild = delete(root.rightChild, dNumber);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }
            Node temp = findMinNode(root.rightChild);
            root.number = temp.number;
            root.rightChild = delete(root.rightChild, temp.number);
        }
        return root;
    }

    Node findMinNode(Node node) {
        Node current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.leftChild);
            System.out.print(root.number + " ");
            inorderTraversal(root.rightChild);
        }
    }

    public Node findParent(Node root, int pNumber) {
        Node parent = null;
        Node current = root;
        while (current != null) {
            if (pNumber < current.number) {
                parent = current;
                current = current.leftChild;
            } else if (pNumber > current.number) {
                parent = current;
                current = current.rightChild;
            } else {
                break;
            }
        }
        return parent;
    }
}