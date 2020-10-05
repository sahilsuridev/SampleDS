package bitwise;

public class OddElementInArray {
    public static void main(String[] args) {
        checkOddElementInArray();
        checkTwoOddElementsInArray();
    }

    private static void checkOddElementInArray() {
        // Xor --> x ^ x = 0;
        // x ^ 0 = x
        // x ^ y ^ z = y ^ x ^ z
        System.out.println("check odd elements in an Array !!");
        int[] arr = {1, 2 , 2, 1, 1, 1, 3, 3, 4, 4 , 7, 7, 84};
        int result = 0;
        for (int a: arr
             ) {
            result = a ^ result;
        }
        System.out.println("Odd occuring element is "+result);
    }

    private static void checkTwoOddElementsInArray() {
        // Xor --> x ^ x = 0;
        // x ^ 0 = x
        // x ^ y ^ z = y ^ x ^ z
        System.out.println("check odd elements in an Array !!");
        int[] arr = {1, 2 , 2, 1, 1, 1, 3, 3, 4, 4 , 7, 7, 84};
        int result = 0;
        for (int a: arr
        ) {
            result = a ^ result;
        }
        System.out.println("Odd occuring element is "+result);
    }
}
