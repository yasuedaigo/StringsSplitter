import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringsJaHyphenationSplitter {

    private static final int FIRST_INDEX = 0;
    private static final List<String> PUNCTUATION = new ArrayList(Arrays.asList("、","。"));

    public static void execution(){
        List<String> lines =
            splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(
                "このプログラムは、句読点を行頭禁則処理するサンプル。¥n"
                + "最後の行です",
                8
        );
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static List<String> splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod
        (String text,int lineLength)
    {
        String processedText = StringsMoreSplitter.processing(text);
        List<String> lines = StringsSplitter.splitWithLineBreakCode(processedText);
        splitLength(lines,lineLength);
        return lines;
    }

    private static boolean topIsPunctuation(String text){
        if(StringsSplitter.isBlank(text)){
            return false;
        }
        if(PUNCTUATION.contains(String.valueOf(text.charAt(FIRST_INDEX)))){
            return true;
        }
        return false;
    }

    private static void splitLength(List<String> lines, int lineLength) {
        int listIndex = 0;
        while(StringsFixedLengthSplitter.canGetLine(lines,listIndex)){
            if(StringsFixedLengthSplitter.overLength(lines.get(listIndex),lineLength)){
                cutLineAfterLength(lines,listIndex,lineLength);
            }
            listIndex++;
        }
    }

    private static void cutLineAfterLength(List<String> lines, int listIndex,int lineLength) {
        StringBuilder text = new StringBuilder(lines.get(listIndex));
        String beforLengthText = text.substring(FIRST_INDEX,lineLength);
        String afterLengthText = text.substring(lineLength,text.length());

        while(topIsPunctuation(afterLengthText)){
            String topString = afterLengthText.substring(FIRST_INDEX,1);
            StringBuilder buildText = new StringBuilder(afterLengthText);
            buildText.delete(FIRST_INDEX,1);
            afterLengthText = buildText.toString();
            beforLengthText = beforLengthText + topString;
        }

        lines.set(listIndex,beforLengthText);
        if(!StringsSplitter.isBlank(afterLengthText)){
            lines.add(listIndex + 1,afterLengthText);
        }
    }
}
