public class Tools {

    private static final int BLANK = 0;
    private static final int NO_CONTAIN_CODE = -1;

    public static boolean isBlank(StringBuilder sb) {
        if (sb.length() == BLANK) {
            return true;
        }
        return false;
    }

    public static boolean isBlank(String text) {
        StringBuilder sb = new StringBuilder(text);
        return Tools.isBlank(sb);
    }

    public static boolean isContain(StringBuilder sb, String code) {
        if (getIndexOfCode(sb, code) == NO_CONTAIN_CODE) {
            return false;
        }
        return true;
    }

    public static int getIndexOfCode(StringBuilder sb, String code) {
        return sb.indexOf(code);
    }

}
