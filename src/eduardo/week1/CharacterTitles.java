//Write a function that takes a string and returns a string with the correct case for character titles in the Game of Thrones series.
//
//        The words and, the, of and in should be lowercase.
//        All other words should have the first character as uppercase and the rest lowercase.
//        Punctuation and spaces must remain in their original positions.
//        Hyphenated words are considered separate words.
//        Be careful with words that contain and, the, of or in.

//level very hard on edabit

package eduardo.week1;

import java.util.Arrays;

public class CharacterTitles {

    public static String correctTitle(String str) {
        str = str.toLowerCase();
        String[] words = str.split(" ");
        //System.out.println(Arrays.toString(words));
        String result = "";
        for(int x = 0; x < words.length; x++){
            if(!checkDash(words[x])){
                if(!words[x].equalsIgnoreCase("and") && !words[x].equalsIgnoreCase("the") && !words[x].equalsIgnoreCase("of") && !words[x].equalsIgnoreCase("in")){
                    String temp = words[x].substring(0,1).toUpperCase() + words[x].substring(1, words[x].length());
                    result += temp + " ";
                }else {
                    result += words[x] + " ";
                }

            }else{
                String[] wordDash = words[x].split("-");
                String temp = "";
                for(int y=0; y < wordDash.length; y++){
                    if(!wordDash[y].equalsIgnoreCase("and") && !wordDash[y].equalsIgnoreCase("the") && !wordDash[y].equalsIgnoreCase("of") && !wordDash[y].equalsIgnoreCase("in")){
                        if(y != wordDash.length - 1){
                            temp += wordDash[y].substring(0,1).toUpperCase() + wordDash[y].substring(1, wordDash[y].length()) + "-";
                        }else {
                            temp += wordDash[y].substring(0,1).toUpperCase() + wordDash[y].substring(1, wordDash[y].length());
                        }
                    }else {
                        if(y != wordDash.length - 1){
                            temp += wordDash[y] + "-";
                        }else {
                            temp += wordDash[y];
                        }
                    }

                }
                result += temp + " ";
            }
        }
        return result.trim();
    }

    public static boolean checkDash(String str){
        return str.indexOf("-") != -1;
    }

    public static void main(String[] args){
        System.out.println("Expected: Sansa Stark, Lady of Winterfell.");
        System.out.println(correctTitle("sansa stark, lady of winterfell."));

        System.out.println("\nExpected: Lord Eddard Stark, Hand of the King.");
        System.out.println(correctTitle("lord eddard stark, hand of the king."));

        System.out.println("\nExpected: Jaime Lannister, Lord Commander of the Kingsguard.");
        System.out.println(correctTitle("jaime lannister, lord commander of the kingsguard."));

        System.out.println("\nExpected: Varys, Master of Whisperers.");
        System.out.println(correctTitle("varys, master of whisperers."));

        System.out.println("\nExpected: Doran Martell, Prince of Dorne, Lord of Sunspear.");
        System.out.println(correctTitle("doran martell, prince of dorne, lord of sunspear."));

        System.out.println("\nExpected: Tyrion Lannister, Hand of the Queen.");
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));

        System.out.println("\nExpected: Grand Maester Pycelle.");
        System.out.println(correctTitle("GRAND MAESTER PYCELLE."));

        System.out.println("\nExpected: Euron Greyjoy, King of the Iron Islands, Lord Reaper of Pyke.");
        System.out.println(correctTitle("EURON GREYJOY, KING OF THE IRON ISLANDS, LORD REAPER OF PYKE."));

        System.out.println("\nExpected: Petyr Baelish, Lord Protector of the Vale.");
        System.out.println(correctTitle("PETYR BAELISH, LORD PROTECTOR OF THE VALE."));

        System.out.println("\nExpected: Mance Rayder, King-Beyond-the-Wall.");
        System.out.println(correctTitle("MANCE RAYDER, KING-BEYOND-THE-WALL."));

        System.out.println("\nExpected: Jon Snow, King in the North.");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));

        System.out.println("\nExpected: Jeor Mormont, Lord Commander of the Night's Watch.");
        System.out.println(correctTitle("Jeor MORMONT, Lord COMMANDER of the NIGHT'S WATCH."));

        System.out.println("\nExpected: Cersei Lannister, Queen of the Andals and the First Men, Protector of the Seven Kingdoms.");
        System.out.println(correctTitle("cERSei LANnIStEr, QuEEn Of the aNdals and THE fIRSt men, PROtecTOR OF tHe SEVEN KInGdOmS."));

        System.out.println("\nExpected: Daenerys Stormborn of House Targaryen, the First of Her Name, Queen of the Andals and the First Men, Protector of the Seven Kingdoms, the Mother of Dragons, the Khaleesi of the Great Grass Sea, the Unburnt, the Breaker of Chains.");
        System.out.println(correctTitle("DAeneRYS StOrmboRn oF hOuse TARGARYEn, ThE FirsT OF HER naMe, QUeEn OF The ANdAlS And THe FirsT mEN, PROtECtOr Of tHE SEven KinGDOmS, The MoTHeR of DrAGONS, thE KhALeEsi oF THE GReAt gRAss sEa, The UnburNT, The BReakEr of cHAInS."));
    }
}
