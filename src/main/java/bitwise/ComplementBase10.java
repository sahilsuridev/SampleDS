package bitwise;


//Input: 5
//        Output: 2
//        Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
public class ComplementBase10 {

    public static void main(String[] args) {
        System.out.println("**output "+bitwiseComplement(5));
    }

    public static int bitwiseComplement(int N) {
        int result = 0;
        int power = 1;
        while (N > 0) {
            // xor will flip the number
            result += (N % 2 ^ 1) * power;
            power = power << 1;
            N = N / 2;
        }
        return result;
    }
}
