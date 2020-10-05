package bitwise;

import java.util.Scanner;

public class PowerOfTwo {
//    public static void main(String[] args) {
//        checkPowOf2();
//    }

    private static void checkPowOf2() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter number: ");
        int input = myObj.nextInt();
        if(input != 0 && ((input & input -1) == 0)) {
            System.out.println(input + " is power of 2");
        } else {
            System.out.println(input + " is not power of 2");
        }
    }
}
