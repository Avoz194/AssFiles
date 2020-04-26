import com.sun.jmx.snmp.SnmpUsmKeyHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BST_Tests { //test
    public static void main(String[] args) {

      /*  Stack stack = new Stack();
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
          bst.backtrack();
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
        System.out.println();}*/









 /*   public static void main(String[] args) {
        testPrint();
    }

    private static void testPrint() {
      /*  ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);*/

 //************* Aviv's Tests***************

        System.out.println("BST:");
        BacktrackingBST bst = new BacktrackingBST(new Stack(), new Stack());
        BacktrackingBST.Node b15 = new BacktrackingBST.Node(15, null);
        bst.insert(b15);
        BacktrackingBST.Node b30 = new BacktrackingBST.Node(30, null);
        bst.insert(b30);
        BacktrackingBST.Node b0 = new BacktrackingBST.Node(0, null);

        bst.insert(b0);
        BacktrackingBST.Node b17 = new BacktrackingBST.Node(17, null);

        bst.insert(b17);
        BacktrackingBST.Node b3 = new BacktrackingBST.Node(3, null);
        bst.insert(b3);
        BacktrackingBST.Node b5 = new BacktrackingBST.Node(5, null);
        bst.insert(b5);
        BacktrackingBST.Node b78 = new BacktrackingBST.Node(78, null);
        bst.insert(b78);
        BacktrackingBST.Node b50 = new BacktrackingBST.Node(50, null);
        bst.insert(b50);

        BacktrackingBST.Node b51 = new BacktrackingBST.Node(51, null);
        bst.insert(b51);

        BacktrackingBST.Node b100 = new BacktrackingBST.Node(100, null);
        bst.insert(b100);
        BacktrackingBST.Node b96 = new BacktrackingBST.Node(96, null);
        bst.insert(b96);

        //Tests part:

        bst.print();

        bst.delete(b78);
        bst.print();

        BacktrackingBST.Node b97 = new BacktrackingBST.Node(97, null);
        bst.insert(b97);
        bst.print();
        bst.delete(b15);
        bst.print();
        BacktrackingBST.Node bms = new BacktrackingBST.Node(-10, null);
        bst.insert(bms);
        bst.print();

        bst.backtrack();
        bst.print();
        bst.backtrack();
        bst.print();
        bst.backtrack();
        bst.print();

        bst.backtrack();
        bst.print();

        bst.retrack();
        bst.print();
        bst.retrack();
        bst.print();
        bst.retrack();
        bst.print();

        bst.retrack();
        bst.print();

        bst.retrack();
        bst.print();

        bst.retrack();
        bst.print();

        bst.retrack();
        bst.print();

        bst.retrack();
        bst.print();
        bst.retrack();
        bst.print();







        /* Backtrack and Retrack tests:
            1. Case one delete (96), (5)   V
            1.5 Case one - root            V
            2. Case 2 delete (0), (100)    V
            2.5 case 2 - root              V
            3. Case 3 delete none root (30)V
            3.5 redelete succ (50)         V
            4. Case 3 delete root (15)     V
            5. case 2 delete and insert (not same area) V
                remove (3), insert (96)     V
            6. Case 2 delete and insert (same area) V
                remove (100) insert (97) V
                remove (100) insert (101) V
            7. Case 2 delete and insert (same value) V
                remove (100) insert (100)            V
            8. Case 3 delete and insert (not same area)V
                remove (30) insert (-1)           V
            9. Case 3 delete and insert (same area) V
                remove (30) insert (51)             V
            10. Case 3 delete and insert (same value) V
                remove (30) insert (30)             V
            11. Case 3 delete and insert (root)     V
                remove (15) insert (15)             V
            12.Case 3 delete and insert (value to right of successor)
            13.Case 3 delete and insert (value to left of successor)

         */
       /*Test small cases
        BacktrackingBST bst2 = new BacktrackingBST(new Stack(), new Stack());
        BacktrackingBST.Node b15s = new BacktrackingBST.Node(15, null);
        BacktrackingBST.Node b30s = new BacktrackingBST.Node(30, null);
        bst2.insert(b15s);
        bst2.insert(b30s);
        bst2.delete(b15s);
        bst2.backtrack();
        bst2.print();
        bst2.retrack();
        bst2.print();



        //"15 0 3 5 30 17 78 100 96"



        //************* Aviv's Tests***************

        /*
        System.out.flush();
        System.setOut(old);
        String expected ="Array:\n" +
                "4 8 2 3\n" +
                "Sorted Array:\n" +
                "2 3 4 8\n" +
                "BST:\n" +
                "15 0 -5 3 5 30 17 78 100 96";
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
        }*/

/*
        System.out.println("BST:");
        BacktrackingBST bst = new BacktrackingBST(new Stack(), new Stack());
        BacktrackingBST.Node b5 = new BacktrackingBST.Node(5, null);
        bst.insert(b5);
        BacktrackingBST.Node b4 = new BacktrackingBST.Node(4, null);
        bst.insert(b4);
        BacktrackingBST.Node b1 = new BacktrackingBST.Node(1, null);

        bst.insert(b1);
        BacktrackingBST.Node b2 = new BacktrackingBST.Node(2, null);

        bst.insert(b2);
        BacktrackingBST.Node b10 = new BacktrackingBST.Node(10, null);
        bst.insert(b10);
        BacktrackingBST.Node b8 = new BacktrackingBST.Node(8, null);
        bst.insert(b8);
        BacktrackingBST.Node b6 = new BacktrackingBST.Node(6, null);
        bst.insert(b6);
        BacktrackingBST.Node b9 = new BacktrackingBST.Node(9, null);
        bst.insert(b9);


        //Tests part:

        bst.print();
        bst.delete(b8);
        bst.print();

        BacktrackingBST.Node b7 = new BacktrackingBST.Node(7, null);
        bst.insert(b7);
        bst.print();
        bst.delete(b5);
        bst.print();
        BacktrackingBST.Node b3 = new BacktrackingBST.Node(3, null);
        bst.insert(b3);
        bst.print();

        bst.backtrack();
        bst.print();
        bst.backtrack();
        bst.print();
        bst.backtrack();
        bst.print();

        bst.backtrack();
        bst.print();*/
        }



}