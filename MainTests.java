public class MainTests {
    public static void main(String[] args) {

        // int[] arr = {17, 62, 19, 10, 1, 78, 20, 20, 20, 10};
        int [] arr = {1,3,5,7,9,11,13,15,17,19,21};
        Stack st = new Stack();
        BacktrackingSortedArray arr1 = new BacktrackingSortedArray(st,10);
        // int ans = backtrackingSearch(arr, 20, 3, 2, st);
      //  int ans = consistentBinSearch(arr,1,st);
        arr1.print();

    }

}
