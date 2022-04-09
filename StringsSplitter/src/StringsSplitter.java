import java.util.ArrayList;
import java.util.List;

public class StringsSplitter {

    private static final String LB_CODE = "¥n";
    private static final String BLANK = "";
    private static final int FIRST_INDEX = 0;

    public static void main(String[] args) {
        List<String> lines = splitWithLineBreakCode(
                "１行目。¥n２行目。¥n３行目。¥n４行目。¥n¥n５行目¥n");
        for (String line : lines) {
            System.out.println(line);
        }
        StringsMoreSplitter.execution();
        StringsFixedLengthSplitter.execution();
        StringsJaHyphenationSplitter.execution();
    }

    public static List<String> splitWithLineBreakCode(String text) {
        List<String> lines = new ArrayList<>();
        StringBuilder buildedText = new StringBuilder(text);
        int listIndex = FIRST_INDEX;
        lines.add(listIndex, BLANK);
        while (!isFinish(buildedText)) {
            if (isLBCodeFarst(buildedText)) {
                listIndex++;
                lines.add(listIndex, BLANK);
                deleteFarstLBCode(buildedText);
            }
            String lineText = cutLineBeforLBCode(buildedText);
            lines.set(listIndex, lineText);
        }
        return lines;
    }

    private static void deleteFarstLBCode(StringBuilder sb) {
        sb.delete(FIRST_INDEX, LB_CODE.length());
    }

    private static boolean isFinish(StringBuilder sb) {
        if (Tools.isContain(sb, LB_CODE)) {
            return false;
        }
        return Tools.isBlank(sb);

    }

    private static boolean isLBCodeFarst(StringBuilder sb) {
        if (Tools.getIndexOfCode(sb, LB_CODE) == FIRST_INDEX) {
            return true;
        }
        return false;
    }

    private static String cutLineBeforLBCode(StringBuilder sb) {
        String lineText;
        int startIndex = sb.indexOf(LB_CODE);
        if (!Tools.isContain(sb, LB_CODE)) {
            return cutAll(sb);
        }
        lineText = sb.substring(FIRST_INDEX, startIndex);
        sb.delete(FIRST_INDEX, startIndex);

        return lineText;
    }

    public static String cutAll(StringBuilder sb) {
        String text = sb.substring(FIRST_INDEX);
        sb.delete(FIRST_INDEX, sb.length());
        return text;
    }
}
