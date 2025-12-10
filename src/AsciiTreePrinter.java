import java.util.ArrayList;
import java.util.List;

public class AsciiTreePrinter {

    public static void print(Node root) {
        if (root == null) {
            System.out.println("(empty)");
            return;
        }

        List<List<String>> lines = new ArrayList<>();

        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();

        level.add(root);
        int nodeCount = 1;

        int widest = 0;

        while (nodeCount != 0) {
            List<String> line = new ArrayList<>();
            nodeCount = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                    continue;
                }

                String val = Integer.toString(n.val);
                line.add(val);
                if (val.length() > widest) widest = val.length();

                next.add(n.left);
                next.add(n.right);

                if (n.left != null) nodeCount++;
                if (n.right != null) nodeCount++;
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> temp = level;
            level = next;
            next = temp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1).size() * (widest + 4);

        for (List<String> line : lines) {
            for (String f : line) {

                if (f == null) f = "";

                int gap1 = perPiece / 2 - f.length() / 2;
                int gap2 = perPiece / 2 - f.length() - gap1;

                System.out.print(" ".repeat(Math.max(gap1, 0)));
                System.out.print(f);
                System.out.print(" ".repeat(Math.max(gap2, 0)));
            }
            System.out.println();
            perPiece /= 2;
        }
    }
}
