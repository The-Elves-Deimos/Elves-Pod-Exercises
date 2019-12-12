//Pig latin has two very simple rules:
//
//        If a word starts with a consonant move the first letter(s) of the word, till you reach a vowel, to the end of the word and add "ay" to the end.
//        have ➞ avehay
//        cram ➞ amcray
//        take ➞ aketay
//        cat ➞ atcay
//        shrimp ➞ impshray
//        trebuchet ➞ ebuchettray
//        If a word starts with a vowel add "yay" to the end of the word.
//        ate ➞ ateyay
//        apple ➞ appleyay
//        oaken ➞ oakenyay
//        eagle ➞ eagleyay
//        Write two functions to make an English to pig latin translator. The first function translateWord(word) takes a single word and returns that word translated into pig latin. The second function translateSentence(sentence) takes an English sentince and returns that sentence translated into pig latin.

//level expert in edabit

package eduardo;

import java.util.Arrays;

public class EnglishToPigLatinTranslator {

    public static boolean checkUpperCase(String word){
        char first = word.charAt(0);
        int asciiValue = first;

        return asciiValue >= 65 && asciiValue <= 90;
    }

    public static String translateWord(String word) {
        if(word.length() > 0){
            String first = word.substring(0,1).toLowerCase();

            if(first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u")){
                return word + "yay";
            }else{
                String[] separate = word.split("");
                String firstPart = "";
                String lastPart = "";
                String characters = "";
                int vowelEncounter = 0;

                for (String letter: separate){
                    char compare = letter.charAt(0);
                    int asciiValue = compare;

                    if(asciiValue >= 33 && asciiValue <= 64){
                        characters += letter;
                        continue;
                    }

                    if(vowelEncounter == 0){
                        if(!letter.equalsIgnoreCase("a")  && !letter.equalsIgnoreCase("e") && !letter.equalsIgnoreCase("i") && !letter.equalsIgnoreCase("o") && !letter.equalsIgnoreCase("u")){
                            lastPart += letter;
                        }else {
                            vowelEncounter = 1;
                            firstPart += letter;
                        }
                    }else{
                        firstPart += letter;
                    }

                }

                String completeWord = firstPart.toLowerCase() + lastPart.toLowerCase() + "ay" + characters;

                if(checkUpperCase(separate[0])){
                    completeWord = completeWord.substring(0,1).toUpperCase() + completeWord.substring(1, completeWord.length());
                }

                return completeWord.trim();
            }
        }else {
            return "";
        }

    }

    public static String translateSentence(String sentence) {
        if(sentence.length() > 0){
            String[] words = sentence.split(" ");
            String result = "";

            for(String word : words){
                result += translateWord(word) + " ";
            }

            return result.trim();

        }else{
            return "";
        }
    }

    public static void main(String[] args){

        System.out.println("Expect avehay: " + translateWord("have?/"));
        System.out.println("Expect amcray: " + translateWord("cram"));
        System.out.println("Expect aketay: " + translateWord("take"));
        System.out.println("Expect Impshray: " + translateWord("Shrimp"));
        System.out.println("Expect ebuchettray: " + translateWord("trebuchet"));
        System.out.println("Expect ateyay: " + translateWord("ate"));
        System.out.println("Expect Appleyay: " + translateWord("Apple"));
        System.out.println("Expect oakenyay: " + translateWord("oaken"));
        System.out.println("Expect eagleyay: " + translateWord("eagle"));
        System.out.println("Expect inkyay: " + translateWord("ink"));
        System.out.println("Expect unicornyay: " + translateWord("unicorn"));
        System.out.println("Expect \" \": " + translateWord(""));
        System.out.println("Iyay ikelay otay eatyay oneyhay afflesway" + ":" + translateSentence("I like to eat honey waffles"));
        System.out.println("Oday ouyay inkthay ityay isyay oinggay otay ainray odaytay?" + ":" + translateSentence("Do you think it is going to rain today?"));
        System.out.println(" :" + translateSentence(" "));
    }
}
