public class Task2 {
    private static char DEFAULT = 'a';

    public static void main(String[] args) {
        String text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String decode(String expandedStr) {
        StringBuilder builder = new StringBuilder();
        boolean isSkip = false;
        char character = DEFAULT;
        for (int i = 0; i < expandedStr.length(); i++) {
            if (!isNumber(expandedStr.charAt(i))) {
                character = expandedStr.charAt(i);
                builder.append(character);
                isSkip = false;
                continue;
            }
            if (!isSkip) {
                isSkip = true;
                int numberOfChar = extractionCount(expandedStr, i) - 1;
                builder.append(outputString(numberOfChar, character));
            }
        }
        return builder.toString();
    }

    private static int extractionCount(String expandedStr, int startPoint) {
        StringBuilder builder = new StringBuilder();
        for (int i = startPoint; i < expandedStr.length() - 1; i++) {
            char prev = expandedStr.charAt(i);
            char next = expandedStr.charAt(i + 1);
            builder.append(String.valueOf(prev));
            if (isNumber(prev) && isNumber(next)) {
                continue;
            }
            break;
        }
        return Integer.parseInt(builder.toString());
    }

    private static String outputString(int count, char c) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(c);
        }
        return builder.toString();
    }

    private static boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
