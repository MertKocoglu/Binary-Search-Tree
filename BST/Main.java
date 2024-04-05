import java.util.Scanner;

public class Main {
    private static BST bst;

    public static void main(String[] args) {
        bst = new BST();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) break;

            if (input.startsWith("CONSTRUCT")) {
                constructTree(input);
            } else if (input.startsWith("INSERT")) {
                insertValue(input);
            } else if (input.equals("LIST")) {
                bst.inorderTraversal(bst.root);
                System.out.println();
            } else if (input.startsWith("PARENT")) {
                findParent(input);
            } else if (input.startsWith("DELETE")) {
                deleteValue(input);
            }
        }

        scanner.close();
    }

    private static void constructTree(String input) {
        String[] values = input.replaceAll("CONSTRUCT \\[|\\]", "").split(",");
        bst.root = null; 
        for (String value : values) {
            bst.root = bst.add(bst.root, Integer.parseInt(value.trim()));
        }
    }

    private static void insertValue(String input) {
        int value = Integer.parseInt(input.substring("INSERT ".length()));
        bst.root = bst.add(bst.root, value);
        BST.Node parent = bst.findParent(bst.root, value);
        if (parent == null) {
            System.out.println("It is a root node");
        } else {
            System.out.println("The parent of " + value + " is " + parent.number);
        }
    }

    private static void findParent(String input) {
        int value = Integer.parseInt(input.substring("PARENT ".length()));
        BST.Node parent = bst.findParent(bst.root, value);
        if (parent == null) {
            System.out.println("It is a root node");
        } else {
            System.out.println("The parent of " + value + " is " + parent.number);
        }
    }

    private static void deleteValue(String input) {
        int value = Integer.parseInt(input.substring("DELETE ".length()));
        int rootValueBefore = bst.root != null ? bst.root.number : -1;
        bst.root = bst.delete(bst.root, value);
        int rootValueAfter = bst.root != null ? bst.root.number : -1;
        if (rootValueBefore != rootValueAfter) {
            System.out.println("Root changed. The new root is " + rootValueAfter);
        }
    }
}
