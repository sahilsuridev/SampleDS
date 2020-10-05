package arrays;

public class LeaderInArr {
    public static void main(String[] args) {
        //Those who dont have any value greater on right side
        System.out.println("****");
        int arr[] = {16, 17, 4, 3, 5, 2};
        leadersInArray(arr);
    }

    private static void leadersInArray(int[] arr) {
        // The element in right is always leader, we start from right
        int maxValue = arr[arr.length - 1];
        System.out.print(maxValue + " ");
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > maxValue) {
                maxValue = arr[i];
                System.out.print(maxValue + " ");
            }
        }
    }
}
