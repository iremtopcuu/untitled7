import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BST tree = new BST();

        int[] data = {50, 30, 70, 20, 40, 60, 80, 35, 45, 65};

        // A) Insert
        for (int v : data) {
            tree.insert(v);
        }

        AsciiTreePrinter.print(tree.root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to insert into the BST: ");
        int userNum = sc.nextInt();

        tree.insert(userNum);

        System.out.println("BST after inserting " + userNum + ":");
        AsciiTreePrinter.print(tree.root);

        // B) Search 45
        System.out.println("Search 45: " + (tree.search(45) ? "Found" : "Not found"));

        // C) Delete 30
        tree.delete(30);
        System.out.println("BST after deleting 30:");
        AsciiTreePrinter.print(tree.root);

        System.out.println();
    }
}
