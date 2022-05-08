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
        StringBuilder buildText = new StringBuilder(text);
        int listIndex = FIRST_INDEX;
        lines.add(listIndex, BLANK);
        while (!isFinish(buildText)) {
            if (isLBCodeFarst(buildText)) {
                listIndex++;
                lines.add(listIndex, BLANK);
                deleteFarstLBCode(buildText);
            }
            String lineText = cutLineBeforLBCode(buildText);
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
        return Tools.getIndexOfText(sb, LB_CODE) == FIRST_INDEX;
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
