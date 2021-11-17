import java.util.ArrayList;
import java.util.List;

public class Task1 {
    private static int DEFAULT_NUMBER_OF_CHAR = 1;

    public static void main(String[] args) {
        String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
        System.out.println(text);
    }

    private static String encode(String compressedStr) {
        List<Character> result = new ArrayList<>();
        int count = 0;
        while (withinRange(count, compressedStr.length())) {
            result.add(compressedStr.charAt(count));
            int numberOfChar = countChar(compressedStr, count);
            if (isDisplayCount(numberOfChar)) {
                String num = Integer.toString(numberOfChar);
                for (int i = 0; i < num.length(); i++) {
                    result.add(num.charAt(i));
                }
            }
            count += numberOfChar;
        }
        return toStr(result);
    }

    private static int countChar(String compressedStr, int startPoint) {
        int total = DEFAULT_NUMBER_OF_CHAR;
        for (int i = startPoint; i < compressedStr.length() - 1; i++) {
            char prev = compressedStr.charAt(i);
            char next = compressedStr.charAt(i + 1);
            if (prev == next) {
                total++;
                continue;
            }
            break;
        }
        return total;
    }

    private static String toStr(List<Character> characters) {
        StringBuilder builder = new StringBuilder();
        for (Character character : characters) {
            builder.append(String.valueOf(character));
        }
        return builder.toString();
    }

    private static boolean withinRange(int a, int b) {
        return a < b;
    }

    private static boolean isDisplayCount(int b) {
        return DEFAULT_NUMBER_OF_CHAR < b;
    }
}
