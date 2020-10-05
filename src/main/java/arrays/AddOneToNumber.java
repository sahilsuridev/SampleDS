package arrays;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {
        public static boolean isValidSubsequence(int[] array, int [] sequence) {
            // Write your code here.
            boolean found = false;
            int temp = 0;
            for(int i = 0; i < sequence.length; i++) {
                found = false;
                for(int j = temp; j < array.length; j++) {
                    if(sequence[i] == array[j]) {
                        found = true;
                        temp = i + 1;
                        break;
                    }
                }
                if(!found) return false;
            }
            return true;
        }

    public static boolean isValidSubsequence1(int[] array, int [] sequence) {
        // Write your code here.
        int temp = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == sequence[temp]) temp ++;
            if(temp == sequence.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] seq = {1, 6, -1, 10};
        System.out.println(isValidSubsequence1(arr, seq));
    }
}
