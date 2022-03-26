import java.util.ArrayList;
import java.util.List;

public class StringsSplitter {

    private static final String LB_CODE = "¥n";
    private static final String BLANK = "";
    private static final int CODE_NUMBER = 2;
    private static final int NO_CONTAIN_CODE = -1;
    private static final int FIRST_INDEX = 0;
    public static void main(String[] args){
        StringsMoreSplitter.execution();

        List<String> lines = splitWithLineBreakCode(  
            "１行目。¥n２行目。¥n３行目。¥n４行目。¥n¥n５行目¥n"
        );
        for (String line : lines) {  
            System.out.println(line);
        }
    }

    public static List<String> splitWithLineBreakCode(String text){
        List<String> lines = new ArrayList<>();
        StringBuilder buildedText = new StringBuilder(text);
        int listIndex = FIRST_INDEX;
        lines.add(listIndex,BLANK);
        while(isContain(buildedText,LB_CODE) || !isBlank(buildedText)){
            if(isLBCodeFarst(buildedText)){
                listIndex++;
                lines.add(listIndex,BLANK);
                deleteFarstLBCode(buildedText);
            }
            String lineText = cutLine(buildedText);
            lines.set(listIndex,lineText);
        }
        return lines;
    }

    

    private static void deleteFarstLBCode(StringBuilder sb) {
        sb.delete(FIRST_INDEX,CODE_NUMBER);
    }

    private static boolean isLBCodeFarst(StringBuilder sb) {
        if(getIndexOfCode(sb,LB_CODE) == FIRST_INDEX){
            return true;
        }
        return false;
    }

    private static String cutLine(StringBuilder sb) {
        String lineText;
        int startIndex = sb.indexOf(LB_CODE);
        if(!isContain(sb,LB_CODE)){
            return cutAll(sb);
        }
        lineText = sb.substring(FIRST_INDEX,startIndex);
        sb.delete(FIRST_INDEX,startIndex);
        
        return lineText;
    }

    public static boolean isBlank(StringBuilder sb){
        if(sb.length() == 0){
            return true;
        }
        return false;
    }

    public static boolean isContain(StringBuilder sb,String code){
        if(getIndexOfCode(sb,code) == NO_CONTAIN_CODE){
            return false;
        }
        return true;
    }

    public static int getIndexOfCode(StringBuilder sb,String code) {
        return sb.indexOf(code);
    }

    public static String cutAll(StringBuilder sb){
        String text = sb.substring(FIRST_INDEX);
        sb.delete(FIRST_INDEX,sb.length());
        return text;
    }
}
