package bitwise;

import java.util.Scanner;

public class FirstBitSetFromRight {
    public static int getFirstSetBitPos(int n){
        if(n==0) return 0;
        return (int)(Math.log(n&-n)/Math.log(2.0)) + 1;
        //doing AND of n and -n as n and -n will have only one bit similar so and will turn all other
        //bits into zero. The result has its log2 taken to find the position and we add 1 to get
        //count from 1 instead of zero
    }

    public static int getFirstSetBitPos2(int n){
        if(n==0) return 0;
        int index = 0;
        while(n > 0) {
            if((n & 1) != 0) return ++ index;
            n = n >> 1;
            ++index;
        }
        return index;
    }

    public static void main (String[] args) {
        System.out.print("Enter number: ");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        System.out.println(getFirstSetBitPos(t));
        System.out.println(getFirstSetBitPos2(t));
//        while(t-->0){
//            int n=sc.nextInt();
//            System.out.println(getFirstSetBitPos(n));
//        }
    }
}

