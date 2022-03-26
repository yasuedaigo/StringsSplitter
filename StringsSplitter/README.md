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