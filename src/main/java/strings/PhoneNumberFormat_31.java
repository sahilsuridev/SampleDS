package strings;

public class PhoneNumberFormat_31 {

    // format numbers in pair of 3, and last two can be of 2 each. string can contain spaces and "-".
    public static void main(String[] args) {
        solution2("4-400546    45645   6564");
        solution2("4-400");
        solution2("4-4004");
        solution2("4-40045");
    }

    public static String solution(String s) {
        s = s.replaceAll("\\s+","");
        s = s.replaceAll("\\-+","");
        if(s.length() <= 3) return s;
        StringBuilder result = new StringBuilder();
        int mod = s.length() % 3;
        int length = s.length();
        if(mod == 1) {
            length = length - 4;
        }
        for (int i = 0; i <= length - 1; i++) {
            result.append(s.charAt(i));
            if(i == length -1 && mod != 1) break;
            if ((i+1) % 3 == 0) {
                result.append("-");
            }
        }
        int diff = s.length() - length;
        while(diff > 0) {
            if(diff  == 2) result.append("-");
            result.append(s.charAt(s.length() - diff));
            diff --;
        }
        return result.toString();
    }

    public static String solution2(String s) {
        s = s.replaceAll("\\s+","");
        s = s.replaceAll("\\-+","");
        if(s.length() <= 3) return s;
        StringBuilder result = new StringBuilder();
        int mod = s.length() % 3;
        int count = (int) Math.ceil((double)s.length() / 3);
        int lengthCounter = 0;
        while (-- count >= 0) {
            int toPickNumbers = 3;
            if(mod == 1  && count <=1) {
                toPickNumbers = 2;
            }
            if(mod == 2  && count == 0) {
                toPickNumbers = 2;
            }
            String substring = s.substring(lengthCounter, lengthCounter + toPickNumbers);
            result.append(substring);
            lengthCounter += toPickNumbers;
            if(count > 0) {
                result.append("-");
            }
        }
        System.out.println(" --- "+result.toString());
        return result.toString();
    }
}


//"00-"