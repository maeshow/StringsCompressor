public class StringExpander {
    public static void main(String[] args) {
        String text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String decode(String expandedStr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expandedStr.length(); i++) {
            addChar(builder, expandedStr, i);
        }
        return builder.toString();
    }

    private static void addChar(StringBuilder builder, String expandedStr, int index) {
        char character = expandedStr.charAt(index);
        if (!isNumber(character)) {
            builder.append(character);
            return;
        }
        character = expandedStr.charAt(index - 1);
        if (!isNumber(character)) {
            int numberOfChar = extractionCount(expandedStr, index) - 1;
            builder.append(outputString(numberOfChar, character));
        }
    }

    private static int extractionCount(String expandedStr, int startPoint) {
        StringBuilder builder = new StringBuilder();
        for (int i = startPoint; i < expandedStr.length() - 1; i++) {
            char current = expandedStr.charAt(i);
            char next = expandedStr.charAt(i + 1);
            builder.append(String.valueOf(current));
            if (isNumber(current) && isNumber(next)) {
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
