package strings;

public class CamelCaseDelimiter_30 {
    public static void main(String[] args) {
        System.out.println(convertToCamelCase("  hi-i_AM$Vikas SHArMa(& "));
    }

    private static String convertToCamelCase(String input) {
        input = toUpper(0, input);
        System.out.println(input);
        for(int i =1; i < input.length() - 2; i++) {
            if((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') ||
                    (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                // Do nothing
            } else {
                input = input.substring(0, i)
                        + ' '
                        + input.substring(i + 1).toLowerCase();
                input = toUpper(++i, input);
            }
        }
        return input;
    }

    private static String toUpper(int index, String input) {
        if((input.charAt(index) >= 'a' && input.charAt(index) <= 'z') ||
                (input.charAt(index) >= 'A' && input.charAt(index) <= 'Z')) {
            String result = "";
            if (index == 0) {
                result = input.substring(index, 1).toUpperCase() +
                        input.substring(1);
            } else {
                    result = input.substring(0, index) + input.substring(index, index + 1).toUpperCase() +
                            input.substring(index + 1);
            }
            return result;
        } else {
            input = input.substring(0, index)
                    + ' '
                    + input.substring(index + 1).toLowerCase();
        }
        return input;
    }
}
