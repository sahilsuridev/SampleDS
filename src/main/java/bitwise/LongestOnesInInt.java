package bitwise;

import java.util.HashMap;
import java.util.Scanner;

public class LongestOnesInInt {
    public static void main(String[] args) {
        subStringWithEqualOnesAndZero();
    }

    private static void subStringWithEqualOnesAndZero() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter number: ");
        String input = myObj.next();

        HashMap<Integer, Integer> indexCount = new HashMap<>();
        // count, index
        // 10010
        int count = 0, maxLength = 0;
        for(int i =0; i < input.length(); i++) {
            if(input.charAt(i) == '1') {
                count ++;
            } else if(input.charAt(i) == '0') {
                count --;
            }

            if(!indexCount.containsKey(count)) {
                indexCount.put(count, i);
            } else {
                maxLength = Math.max(maxLength, (i - indexCount.get(count)));
            }
        }
        System.out.println("hasmap "+indexCount);
    }

}
