public class Warmup {

    public static int backtrackingSearch(int[] arr, int x, int fd, int bk, Stack myStack) {
        int countSteps = 0; //counts number of steps
        for (int i = 0; i < arr.length; i = i + 1) {
            myStack.push(arr[i]);
            if (x == arr[i])
                return i;
            countSteps = countSteps + 1;
            if (countSteps == fd) { // fd steps were made
                i = i - bk;
                countSteps = 0;
                for (int j = bk; j > 0; j = j - 1) { //clearing bk elements from the stack
                    myStack.pop();
                }
            }
        }
        return -1; //x was not found in the array
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        int right = arr.length - 1;
        int left = 0;
        while (right >= left) {
            int mid = (right + left) / 2;
            myStack.push(arr[mid]);
            while (isConsistent(arr) != 0) // the array is not consistent
                myStack.pop();
            if (arr[mid] == x) // if x was found
                return mid;
            if (arr[mid] < x)  // x is bigger than the element in arr[mid]
                left = mid + 1;
            else // x is smaller than the element in arr[mid]
                right = mid - 1;
        }
        return-1; // x was not found
}

    private static int isConsistent(int[] arr) {
        double res = Math.random() * 100 - 75;

        if (res > 0) {
            return (int) Math.round(res / 10);
        } else {
            return 0;
        }

    }
    public static void main(String[]args) {

        int [] arr = {17,62,19,10,1,78,20,20,20,10};
        //int [] arr = {1,1,2,14,15,16,23,99,100,100,100,132,193,196,197};
        Stack st = new Stack ();
        int ans = backtrackingSearch(arr,20,3,2,st);
        //int ans = consistentBinSearch(arr,1,st);
        System.out.println(ans);

    }

}

