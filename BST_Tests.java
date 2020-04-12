import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BST_Tests {
    public static void main(String[] args) {
        testPrint();
    }

    private static void testPrint() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        System.out.println("Array:");
        BacktrackingArray array = new BacktrackingArray(new Stack(), 100);
        array.insert(4);
        array.insert(8);
        array.insert(2);
        array.insert(3);
        array.print();
        System.out.println();

        System.out.println("Sorted Array:");
        BacktrackingSortedArray sortedArray = new BacktrackingSortedArray(new Stack(), 100);
        sortedArray.insert(4);
        sortedArray.insert(8);
        sortedArray.insert(2);
        sortedArray.insert(3);
        sortedArray.print();
        System.out.println();

        System.out.println("BST:");
        BacktrackingBST bst = new BacktrackingBST(new Stack(), new Stack());
        bst.insert(new BacktrackingBST.Node(12, null));
        bst.insert(new BacktrackingBST.Node(6, null));
        bst.insert(new BacktrackingBST.Node(1, null));
        bst.insert(new BacktrackingBST.Node(29, null));
        bst.insert(new BacktrackingBST.Node(17, null));
        bst.insert(new BacktrackingBST.Node(33, null));
        bst.insert(new BacktrackingBST.Node(30, null));
        bst.insert(new BacktrackingBST.Node(46, null));



        bst.print();

        System.out.flush();
        System.setOut(old);
        String expected ="Array:\n" +
                "4 8 2 3\n" +
                "Sorted Array:\n" +
                "2 3 4 8\n" +
                "BST:\n" +
                "12 6 1 29 17 33 30 46";
        String actual = baos.toString()
                .replaceAll("\r", "")
                .replaceAll(" \n", "\n")
                .trim();

        System.out.println("actual: \n" + actual);
        System.out.println("expected: \n" + expected);

        if (expected.equals(actual)){
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }
    }
}