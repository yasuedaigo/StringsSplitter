import java.util.List;

public class StringsFixedLengthSplitter {

    private static final int FIRST_INDEX = 0;

    public static void execution(){
        List<String> lines = splitFixedLengthWithLineBreakCodeAndPeriod(
            "このプログラムは、文字列を指定された幅で改行するサンプルプログラムです。",
            6
        );
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static List<String> splitFixedLengthWithLineBreakCodeAndPeriod(String text,int lineLength) {
        String processedText = StringsMoreSplitter.processing(text);
        List<String> lines = StringsSplitter.splitWithLineBreakCode(processedText);
        splitLength(lines,lineLength);
        return lines;
    }

    public static void splitLength(List<String> lines, int lineLength) {
        int listIndex = 0;
        while(canGetLine(lines,listIndex)){
            if(overLength(lines.get(listIndex),lineLength)){
                cutLineAfterLength(lines,listIndex,lineLength);
            }
            listIndex++;
        }
    }

    private static void cutLineAfterLength(List<String> lines, int listIndex,int lineLength) {
        StringBuilder text = new StringBuilder(lines.get(listIndex));
        String afterLengthText = text.substring(lineLength,text.length());
        String beforLengthText = text.substring(FIRST_INDEX,lineLength);
        lines.set(listIndex,beforLengthText);
        lines.add(listIndex + 1,afterLengthText);
    }

    public static boolean canGetLine(List<String> lines, int listIndex){
        if(lines.size() <= listIndex){
            return false;
        }
        return true;
    }

    public static boolean overLength(String text ,int length){
        if(text.length() < length){
            return false;
        }
        return true;
    } 
}