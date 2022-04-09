import java.util.List;

public class StringsMoreSplitter {

    private static final String LB_CODE = "¥n";
    private static final String PERIOD_AND_LB_CODE = "。¥n";
    private static final String PERIOD = "。";
    private static final int NO_CONTAIN_CODE = -1;
    private static final int FIRST_INDEX = 0;

    public static void execution() {
        List<String> lines = splitWithLineBreakCodeAndPeriod(
                "１行目。２行目。¥n３行目。４行目。¥n¥n５行目。");
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static String processing(String text) {
        StringBuilder buildedText = new StringBuilder(text);
        insertLBCodeAfterCode(buildedText, PERIOD);
        return buildedText.toString();
    }

    private static void insertLBCodeAfterCode(StringBuilder sb, String targetText) {
        int checkIndex = FIRST_INDEX;
        while (isContainPeriodAfterIndex(sb, checkIndex)) {
            int periodIndex = sb.indexOf(targetText, checkIndex);
            if (!isPeriodAndLBCode(sb, periodIndex)) {
                addLBCodeAfterPeriod(sb, periodIndex);
            }
            checkIndex = periodIndex + 1;
        }
    }

    private static List<String> splitWithLineBreakCodeAndPeriod(String text) {
        String processedText = processing(text);
        return StringsSplitter.splitWithLineBreakCode(processedText);
    }

    private static boolean isContainPeriodAfterIndex(StringBuilder sb, int Index) {
        return sb.indexOf(PERIOD, Index) != NO_CONTAIN_CODE;
    }

    private static void addLBCodeAfterPeriod(StringBuilder sb, int periodIndex) {
        sb.insert(periodIndex + 1, LB_CODE);
    }

    private static boolean isPeriodAndLBCode(StringBuilder sb, int periodIndex) {
        if (sb.substring(periodIndex).length() < PERIOD_AND_LB_CODE.length()) {
            return false;
        }
        if (sb.substring(periodIndex, periodIndex + PERIOD_AND_LB_CODE.length())
                .equals(PERIOD_AND_LB_CODE)) {
            return true;
        }
        return false;
    }

}