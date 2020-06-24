package UpGrad;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpellChecker {

    public static final int EDIT_DISTANCE_THRESHOLD = 1;

    private final HashMap<String,Integer> dict = new HashMap<>();

    public SpellChecker(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        Pattern p = Pattern.compile("\\w+");
        for(String temp="";temp!=null;temp=in.readLine()){
            Matcher m = p.matcher(temp.toLowerCase());
            while(m.find()){
                String key = m.group();
                Integer value = dict.containsKey(key)? dict.get(key)+1 : 1;
                dict.put(key, value);
            }
        }
        in.close();
    }

    private void checkWord(String word){
        if(dict.containsKey(word)){
            System.out.println(word+" is a valid word");
        }else{
            List<String> corrections = probableCorrections(word);
            for(String correction: corrections){
                System.out.println(correction);
            }
        }
    }

    public List<String> probableCorrections(String misspelledWord){
        int misspelledLength = misspelledWord.length();
        List<String> corrections = new ArrayList<>();
        for(String word: dict.keySet()){
            if(word.length() <= misspelledLength + EDIT_DISTANCE_THRESHOLD && word.length()>= misspelledLength-EDIT_DISTANCE_THRESHOLD){
                if(damerauLevenshteinEditDistance(misspelledWord, word)<=EDIT_DISTANCE_THRESHOLD){
                    corrections.add(word);
                }
            }
        }
        Collections.sort(corrections, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dict.get(o1) - dict.get(o2);
            }
        });

        return corrections;
    }

    public int damerauLevenshteinEditDistance(String source, String target){
        if(source==null || target==null){
            throw new IllegalArgumentException("Cannot be null");
        }
        int sourceLength = source.length();
        int targetLength = target.length();
        int[][] matrix = new int[sourceLength+1][targetLength+1];
        for(int i=0;i<=targetLength;i++){
            matrix[0][i] = i;
        }
        for(int i=0;i<=sourceLength;i++){
            matrix[i][0] = i;
        }
        for(int i=1;i<=sourceLength;i++){
            for(int j=1;j<=targetLength;j++){
                int cost = 1;
                if(source.charAt(i-1)==target.charAt(j-1)){
                    cost = 0;
                }
                matrix[i][j] = Math.min(cost+matrix[i-1][j-1], Math.min(1+matrix[i-1][j], 1+matrix[i][j-1]));
                if(i>1 && j>1 && source.charAt(i-1)==target.charAt(j-2) && source.charAt(i-2)==target.charAt(j-1)){
                    matrix[i][j] = Math.min(matrix[i][j], 1+matrix[i-2][j-2]);
                }
            }
        }
        return matrix[sourceLength][targetLength];
    }

    public static void main(String[] args) {
        try{
            SpellChecker spellChecker = new SpellChecker("./src/UpGrad/SherlockHolmes.txt");
            spellChecker.checkWord("manage");
            spellChecker.checkWord("stroes");
            spellChecker.checkWord("primise");
            //spellChecker.damerauLevenshteinEditDistance("presidential", "presidentail");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
