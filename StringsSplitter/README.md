課題1  

List<String> lines = splitWithLineBreakCode(  
    "１行目。¥n２行目。¥n３行目。¥n４行目。¥n¥n５行目¥n"  
);  
for (String line : lines) {  
    System.out.println(line);  
} 

１行目。  
２行目。  
３行目。  
４行目。 
   
５行目  

課題2  

List<String> lines = splitWithLineBreakCodeAndPeriod(  
    "１行目。２行目。¥n３行目。４行目。¥n¥n５行目。"  
);
for (String line : lines) {  
    System.out.println(line);  
}  

１行目。  
２行目。  
３行目。  
４行目。  
５行目。  


課題3
List<String> lines = splitFixedLengthWithLineBreakCodeAndPeriod(
    "このプログラムは、文字列を指定された幅で改行するサンプルプログラムです。",
    6
);
for (String line : lines) {
    System.out.println(line);
}

このプログラ
ムは、文字列
を指定された
幅で改行する
サンプルプロ
グラムです。

課題4
List<String> lines =
    splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(
        "このプログラムは、句読点を行頭禁則処理するサンプル。¥n"
        + "最後の行です",
        8
    );
for (String line : lines) {
    System.out.println(line);
}

このプログラムは、
句読点を行頭禁則
処理するサンプル。
最後の行です