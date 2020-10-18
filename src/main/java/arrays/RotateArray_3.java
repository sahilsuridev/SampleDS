package arrays;

public class RotateArray_3 {
    public static void main(String[] args) {
        int [] arr = {1, 3, 7, 9, 22, 23, 25};
        int d = 3;

        int[] num = {1,2,3,4,5,6,7 };
        rotate(num, 3);
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

    /*
    Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
     */

    public static void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int outerLoop = 0;
        while(outerLoop < k) {
            int temp = nums[nums.length -1];
            for(int i = nums.length -1; i >= 1; i--) {
                nums[i] = nums[i -1];
            }
            nums[0] = temp;
            outerLoop ++;
        }
    }
}
