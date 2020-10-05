package bitwise;

import java.util.Scanner;

public class GeneratePowerSets {

    public static void main(String[] args) {
        generatePowerSets();
    }

    private static void generatePowerSets() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter string for subsets: ");
        String input = myObj.next();
        int count = 1 << input.length();
        for(int i = 0; i < count; i++) {
            String output = "";
            for (int j = 0 ; j < input.length(); j++) {
                if((i & (1 << j)) != 0) {
                    output = output + input.charAt(j);
                }
            }
            System.out.println(output);
        }
    }
}
