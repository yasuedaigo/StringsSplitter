public class Tools {

    private static final int BLANK = 0;

    public static boolean isBlank(StringBuilder sb) {
        return sb.length() == BLANK;
    }

    public static boolean isBlank(String text) {
        StringBuilder sb = new StringBuilder(text);
        return isBlank(sb);
    }

    public static boolean isContain(StringBuilder sb, String text) {
        return getIndexOfText(sb, text) != -1;
    }

    public static int getIndexOfText(StringBuilder sb, String text) {
        return sb.indexOf(text);
    }

}
