public class WarmupTest {
    public static void main(String[] args) {
/*
        int[] arr = {17, 62, 19, 10, 1, 78, 20, 20, 20, 10};
       // int [] arr = {2,14,15,16,23,99,100,100,100,132,193,196,197};
        Stack st = new Stack();
        int ans = backtrackingSearch(arr, 20, 3, 2,st);
       // int ans = consistentBinSearch(arr,1,st);
        System.out.println(ans+"\n\n\n a");

*/
//_______________________backtrackingSearch_________________________________
       int[] arr = {17, 62, 19, 10, 1, 78, 20, 20, 20, 10};
        Stack st = new Stack();
      //  if(st.isEmpty())
       //      System.out.println("stack is empty");

        int answer = Warmup.backtrackingSearch(arr,10,3,2,st);
        System.out.println(answer);
        System.out.println("elements in stack (should be ,2,1,0, . received :");
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());


        System.out.println("find index of first 20");
        System.out.println(Warmup.backtrackingSearch(arr,20,8,1,st));
        System.out.println("value doesnt exist. -1 is expected");
        System.out.println(Warmup.backtrackingSearch(arr,5,2,1,st));






//___________________________________consistentBinSearch____________________________________

        System.out.println("consistentBinSearch tests");

        int [] arr1 = {1,1,2,14,15,16,23,99,100,100,100,132,193,196,197};
        Stack st1 = new Stack();
        int ans = Warmup.consistentBinSearch(arr1,132,st1);
        System.out.println(ans);
        //System.out.println(st1.pop());
        System.out.println("find index of first 100");
        System.out.println(Warmup.consistentBinSearch(arr1,100,st1));
        System.out.println(Warmup.consistentBinSearch(arr1,1,st1));

        System.out.println("find index of 14");
        System.out.println(Warmup.consistentBinSearch(arr1,14,st1));
        System.out.println(st1.pop());
        System.out.println(st1.pop());
    }

}
