import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.start();
    }

    public void start() {
        Tree tree = new Tree();

        while(true) {
            System.out.println("\n=================================================\n");
            int choice = queryChoice();
        
            System.out.println("\n=================================================\n");
            if(choice == 1) searchNode(tree);
            else if(choice == 2) insertNode(tree);
            else if(choice == 3) displayPreOrder(tree);
            else if(choice == 4) displayPostOrder(tree);
            else if(choice == 5) displayInOrder(tree);
        }
    }

    public int queryChoice() {
        try {
            System.out.println("[1] Search");
            System.out.println("[2] Insert");
            System.out.println("[3] Pre Order Traversal");
            System.out.println("[4] Post Order Traversal");
            System.out.println("[5] In Order Traversal");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if(choice < 1 || choice > 5) throw new Exception();
            return choice;
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            System.out.println("\n=================================================\n");
            return queryChoice();
        }
    }

    public void insertNode(Tree tree) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a value: ");
            int value = sc.nextInt();
            tree.insert(value);
            System.out.format("Value of %d is successfuly inserted!\n", value);
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            System.out.println("\n=================================================\n");
            insertNode(tree);
        }
    }

    public void searchNode(Tree tree) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Search a value: ");
            int value = sc.nextInt();
            System.out.format("Value of %d is found: %s\n", value, tree.search(value));
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            System.out.println("\n=================================================\n");
            insertNode(tree);
        }
    }

    public void displayPreOrder(Tree tree) {
        System.out.format("Pre order traverse:%s\n", tree.preOrder());
    }

    public void displayPostOrder(Tree tree) {
        System.out.format("Post order traverse:%s\n", tree.postOrder());
    }

    public void displayInOrder(Tree tree) {
        System.out.format("In order traverse:%s\n", tree.inOrder());
    }

}