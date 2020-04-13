import com.sun.jmx.snmp.SnmpUsmKeyHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BST_Tests {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack stackRedo = new Stack();
        BacktrackingBST bst = new BacktrackingBST(stack, stackRedo);
        Stack stack1 = new Stack();
        Stack stackRedo1 = new Stack();
        BacktrackingBST bst1 = new BacktrackingBST(stack1, stackRedo1);

        //Insert Test

        System.out.println("---------Insert Tests:------------");
        System.out.println();
        System.out.println("Insert to bst");
        System.out.println();
        BacktrackingBST.Node n12 = new BacktrackingBST.Node(12, null);
        BacktrackingBST.Node n6 = new BacktrackingBST.Node(6, null);
        BacktrackingBST.Node n1 = new BacktrackingBST.Node(1, null);
        BacktrackingBST.Node n29 = new BacktrackingBST.Node(29, null);
        BacktrackingBST.Node n17 = new BacktrackingBST.Node(17, null);
        BacktrackingBST.Node n33 = new BacktrackingBST.Node(33, null);
        BacktrackingBST.Node n30 = new BacktrackingBST.Node(30, null);
        BacktrackingBST.Node n46 = new BacktrackingBST.Node(46, null);
        bst.insert(n12);
        bst.insert(n6);
        bst.insert(n1);
        bst.insert(n29);
        bst.insert(n17);
        bst.insert(n33);
        bst.insert(n30);
        bst.insert(n46);

        bst.print();
        System.out.println();

        System.out.println("Insert to bst1");
        System.out.println();
        BacktrackingBST.Node n15 = new BacktrackingBST.Node(15, null);
        BacktrackingBST.Node n31 = new BacktrackingBST.Node(31, null);
        BacktrackingBST.Node n0 = new BacktrackingBST.Node(0, null);
        BacktrackingBST.Node n16 = new BacktrackingBST.Node(16, null);
        BacktrackingBST.Node n3 = new BacktrackingBST.Node(3, null);
        BacktrackingBST.Node n78 = new BacktrackingBST.Node(78, null);
        BacktrackingBST.Node n100 = new BacktrackingBST.Node(100, null);
        BacktrackingBST.Node n5= new BacktrackingBST.Node(5, null);


        bst1.insert(n15);
        bst1.insert(n31);
        bst1.insert(n0);
        bst1.insert(n16);
        bst1.insert(n3);
        bst1.insert(n78);
        bst1.insert(n100);
        bst1.insert(n5);


        bst1.print();
        System.out.println();







        //successor text
        System.out.println();
        System.out.println("--------------successor Tests:-----------------");
        System.out.println();
        System.out.print("find succ of 1. expected: 6 received: ");
        System.out.println(bst.successor(n1).getKey());
        System.out.println();
        System.out.print("find succ of 12. expected: 17 received: ");
        System.out.println(bst.successor(n12).getKey());
        System.out.println();
        System.out.print("find succ of 30. expected: 33 received: ");
        System.out.println(bst.successor(n30).getKey());
        System.out.println();
        System.out.print("find succ of 29. expected: 30 received: ");
        System.out.println(bst.successor(n29).getKey());
        System.out.println();
        System.out.print("find succ of 46. expected: null received: ");
        System.out.println(bst.successor(n46));


        //predecessor text
        System.out.println();
        System.out.println("--------------predecessor Tests:-----------------");
        System.out.println();
        System.out.print("find succ of 6. expected: 1 received: ");
        System.out.println(bst.predecessor(n6).getKey());
        System.out.println();
        System.out.print("find succ of 1. expected: null received: ");
        System.out.println(bst.predecessor(n1));
        System.out.println();


        //maximum test
        System.out.println();
        System.out.println("--------------Maximum Tests:-----------------");
        System.out.println();
        System.out.print("Maximum bst expected : 46    received : ");
        System.out.println(bst.maximum().getKey());
        bst.delete(n46);
        System.out.print("delete maximum. test again:");
        System.out.println();
        System.out.print("Maximum bst expected : 33    received :");
        System.out.println(bst.maximum().getKey());
        System.out.print("Maximum bst1 expected : 100    received :");
        System.out.println(bst1.maximum().getKey());
        System.out.print("delete maximum. test again:");
        System.out.println();
        bst1.delete(n100);
        System.out.print("Maximum bst1 expected : 78    received :");
        System.out.println(bst1.maximum().getKey());

        //minimum test
        System.out.println();
        System.out.println("----------minimum Tests:-----------------");
        System.out.println();
        System.out.print("minimum bst expected : 1    received :");
        System.out.println(bst.minimum().getKey());
        bst.delete(n1);
        System.out.print("delete minimum. test again:");
        System.out.println();
        System.out.print("minimum bst expected : 6    received :");
        System.out.println(bst.minimum().getKey());
        System.out.println();
        System.out.print("minimum bst1 expected : 0    received :");
        System.out.println(bst1.minimum().getKey());

        bst1.delete(n0);
        System.out.print("delete minimum. test again:");
        System.out.println();
        System.out.print("minimum bst expected : 3    received :");
        System.out.println(bst1.minimum().getKey());
        System.out.println();

        // BACKTRACK test
        System.out.println("--------------BACKTRACK test:-----------------");
        System.out.println();
        System.out.println("before:");
        bst.print();
        System.out.println();
        bst.insert(new BacktrackingBST.Node(70, null));
        System.out.println("insert 70:");
        bst.print();
        System.out.println("after backtrack:");
        bst.backtrack();
        bst.print();
        System.out.println("insert 80:");
        bst.insert(new BacktrackingBST.Node(80, null));
        bst.print();
        System.out.println("after backtrack:");
        bst.backtrack();
        bst.print();
        System.out.println("delete 6:");
        bst.delete(n6);
        bst.print();
        System.out.println("after backtrack:");
          bst.backtrack(); //TODO; FUCKKKKKKKKKKK
        bst.print();


        //Delete Tests
        bst.insert(n46);
        bst.insert(n1);


        System.out.println("--------Delete Tests:-----------");
        System.out.println("Delete Tests: ***bst only***");
        System.out.println();

        System.out.println("before:");
        bst.print();
        System.out.println();
        System.out.println("after delete 1:");
        bst.delete(n1);
        bst.print();
        System.out.println();

        System.out.println("after insert 1:");
        bst.insert(n1);
        bst.print();
        System.out.println();


        System.out.println("after delete 30:");
        bst.delete(n30);
        bst.print();
        System.out.println();

        System.out.println("Delete root bst");
        System.out.println("before:");
        bst.print();
        System.out.println("after:");
        bst.delete(bst.getRoot());
        bst.print();
        System.out.println();

        System.out.println("Delete leaf 46");
        System.out.println("before:");
        bst.print();
        System.out.println("after:");
        bst.delete(n46);
        bst.print();
        System.out.println();

        System.out.println("insert leaf 46");
        bst.insert(n46);
        bst.print();
        System.out.println();

        System.out.println("Delete middle 6");

        System.out.println("before:");
        bst.print();
        System.out.println("after:");
        bst.delete(n6);
        bst.print();
        System.out.println();

        System.out.println("delete middle 29");
        bst.delete(n29);

        bst.print();
        System.out.println();

        // ---------------Delete Tests: ***bst1 only***-------------------------

        System.out.println("Delete Tests: ***bst1 only***");

        bst1.insert(n100);
        System.out.println("cant insert 0 now- because its not a leaf and this changes the tree. once BACKTRACK is ready will test this");
        System.out.println("before (100 should be back as leaf):");
        bst1.print();
        System.out.println();

        System.out.println("Delete root bst1:");
        bst1.delete(bst1.getRoot());
        bst1.print();
        System.out.println();

        System.out.println("Delete leaf 5");
        System.out.println("before:");
        bst1.print();
        System.out.println("after:");
        bst1.delete(n5);
        bst1.print();
        System.out.println();

        System.out.println("insert leaf 5");
        bst1.insert(n5);
        bst1.print();
        System.out.println();

        System.out.println("Delete middle 3");
        System.out.println("before:");
        bst1.print();
        System.out.println("after:");
        bst1.delete(n3);
        bst1.print();
        System.out.println();








    }
 /*   public static void main(String[] args) {
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

 */
}