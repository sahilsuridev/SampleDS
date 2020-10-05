package arrays;

public class RotateArray {
    public static void main(String[] args) {
        int [] arr = {1, 3, 7, 9, 22, 23, 25};
        int d = 3;
        // final output should be 9, 22, 23, 25, 1, 3, 7

        reverseArray(arr, 0, d-1);
        // output should be 7, 3, 1, 9, 22, 23, 25

        reverseArray(arr, d, arr.length - 1);
        // output should be 7, 3, 1, 25, 23, 22, 9

        reverseArray(arr, 0, arr.length - 1);
        // final output should be 9, 22, 23, 25, 1, 3, 7
        for (int a:arr) {
            System.out.print(a + " ");
        }
        int [] arr1 = {1, 3, 7, 9, 22, 23, 25};
        rotateArray(arr1, 3);
    }

    private static void reverseArray(int[] arr, int startIndex, int endIndex) {
        int count = 0;
        while(count <= (endIndex - startIndex)/2) {
            int temp = arr[startIndex + count];
            arr[startIndex + count] = arr[endIndex - count];
            arr[endIndex - count] = temp;
            count ++;
        }
    }

    private static void rotateArray(int[] arr, int d) {
        int outerLoop = 0;
        while(outerLoop < d) {
            int temp = arr[0];
            for(int i = 0; i < arr.length -1 ; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
            outerLoop ++;
        }

        System.out.println("===== rotate array ====");
        for (int a:arr) {
            System.out.print(a + " ");
        }
    }
}
