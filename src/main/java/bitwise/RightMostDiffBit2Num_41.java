package bitwise;

import java.util.Scanner;

public class RightMostDiffBit2Num_41 {
    public static void main (String[] args) {
//        System.out.print("Enter total inputs: ");
//        Scanner sc=new Scanner(System.in);
//        int t=sc.nextInt();
//        int[] inputs = new int[t];
//        for(int i = 0; i< inputs.length; i++) {
//            System.out.print("Enter" + (i+1) + "inputs ");
//            inputs[i] = sc.nextInt();
//        }
//        System.out.println(rightmostdifferentBit(inputs[0], inputs[1]));

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int m,n;
        while(t-->0) {
            m = sc.nextInt();
            n = sc.nextInt();
            System.out.println(rightmostdifferentBit(m, n));
        }
    }

    private static int rightmostdifferentBit(int input1, int input2) {
        int index = 0;
        while(input1 >0 || input2 > 0) {
            if((input1 & 1) != (input2 & 1)) return ++ index;
            input1 = input1 >> 1;
            input2 = input2 >> 1;
            ++index;
        }
        return index;
    }
}
