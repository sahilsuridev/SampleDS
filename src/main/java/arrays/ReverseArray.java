package arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int [] arr = {1, 3, 7, 9, 22, 23, 25};
        reverseArray(arr);
    }

    private static void reverseArray(int[] arr) {
        for(int i = 0; i <= arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
}
