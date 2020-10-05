package arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        getMaxSum();
    }

    private static void getMaxSum() {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int currentSum = 0;
        for(int j = 0; j < k ; j++) {
            currentSum += arr[j];
        }
        int max_sum = currentSum;
        for (int i = k; i <= arr.length - 1 ; i++) {
            currentSum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, currentSum);
        }
        System.out.println("max value is "+max_sum);
    }
}
