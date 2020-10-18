package bitwise;

import java.util.Scanner;

public class CountSetBits_34 {

    public static void main(String[] args) {
        countCheckBits();
    }

    private static void countCheckBits() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter number: ");
        int input = myObj.nextInt();
        int result = 0;
        // it will convert the last set bit to 0 in each iteration, like 8 & 7 = 0, so 8 last bit 1000 changes to 0000
        while(input > 0) {
            input = input & (input - 1);
            result ++;
        }
        System.out.println("no of set bits is "+result);
    }
}
