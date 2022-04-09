import java.util.List;

public class StringsMoreSplitter {

    private static final String LB_CODE = "¥n";
    private static final String PERIOD_AND_LB_CODE = "。¥n";
    private static final String PERIOD = "。";
    private static final int NO_CONTAIN_CODE = -1;

    public static void execution(){
        List<String> lines = splitWithLineBreakCodeAndPeriod(
            "１行目。２行目。¥n３行目。４行目。¥n¥n５行目。"
        );
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static String processing(String text){
        StringBuilder buildedText = new StringBuilder(text);
        insertLBCodeAfterCode(buildedText,PERIOD);
        return buildedText.toString();
    }

    private static void insertLBCodeAfterCode(StringBuilder sb, String targetText){
        int fromIndex = 0;
        while(sb.indexOf(targetText,fromIndex) != NO_CONTAIN_CODE){
            int periodIndex = sb.indexOf(targetText,fromIndex);
            if(!isPeriodAndLBCode(sb,periodIndex)){
                sb.insert(periodIndex +1,LB_CODE);
            }
            fromIndex = periodIndex +1;
        }
    }

    private static boolean isPeriodAndLBCode(StringBuilder sb,int periodIndex){
        if(sb.substring(periodIndex).length() < PERIOD_AND_LB_CODE.length()){
            return false;
        }
        if(sb.substring(periodIndex,periodIndex + PERIOD_AND_LB_CODE.length())
            .equals(PERIOD_AND_LB_CODE)){
            return true;
        }
        return false;
    }

    private static List<String> splitWithLineBreakCodeAndPeriod(String text){
        String processedText = processing(text);
        List<String> lines = StringsSplitter.splitWithLineBreakCode(processedText);
        return lines;
    }
}