package bitwise;

import java.util.Scanner;

public class NBitSet {
//    public static void main(String[] args) {
//        checkKthBitSet2();
//    }

    private static void checkKthBitSet() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number: ");
        int input = myObj.nextInt();
        //int input = 6;
        int k = 2;
        // Need to check if kth bit is set in input

        int num = 1 << k-1;
        if((input & num) != 0) {
            System.out.println("Kth bit is set : "+(input & num));
        } else {
            System.out.println("Kth bit is not set !!");
        }
    }

    private static void checkKthBitSet2() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number: ");
        int input = myObj.nextInt();
        //int input = 6;
        System.out.println("Enter kth byte to check: ");
        int k = myObj.nextInt();;
        // Need to check if kth bit is set in input
        if(((input >> k-1) & 1)  == 1) {
            System.out.println("Kth bit is set : ");
        } else {
            System.out.println("Kth bit is not set !!");
        }
    }
}
