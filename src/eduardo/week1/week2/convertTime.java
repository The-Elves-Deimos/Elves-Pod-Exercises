//Write a function that receives the time in 12-hour AM/PM format and returns a string representation of the time in military (24-hour) format.
//Notes
//        Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
//        Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
package eduardo.week1.week2;

import java.util.Arrays;

public class convertTime {
    public static String ConvertTime(String s){
        String[] separate = s.split(":");
        boolean afterNoon = s.endsWith("PM");
        separate[2] = separate[2].substring(0, separate[2].length() - 2);
        String twentyFourHrFormat = "";

        if(afterNoon){
            if(Integer.parseInt(separate[0]) >= 1 && Integer.parseInt(separate[0]) <= 11) {
                separate[0] = Integer.toString(Integer.parseInt(separate[0]) + 12);
            }
            twentyFourHrFormat = separate[0] + " : " + separate[1] + " : "  + separate[2];
        }else{
            if(separate[0].equals("12")){
                separate[0] = "00";
            }
            twentyFourHrFormat = separate[0] + " : " + separate[1] + " : "  + separate[2];
        }
        return twentyFourHrFormat;
    }

    public static void main(String[] args){
        System.out.println(ConvertTime("07:05:45PM"));
        System.out.println(ConvertTime("12:40:22AM"));
        System.out.println(ConvertTime("12:45:54PM"));
        System.out.println(ConvertTime("05:32:33PM"));
        System.out.println(ConvertTime("11:59:59PM"));
        System.out.println(ConvertTime("11:59:59AM"));
        System.out.println(ConvertTime("06:00:19AM"));
    }
}
