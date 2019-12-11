//Create a function that takes an Arabic number and converts it into a
// Roman number.
//All roman numerals should be returned as uppercase.
//The largest number that can be represented in this notation is 3,999
//Level Very Hard on edabit
package eduardo;

public class RomanNumeralConverter {

    public static String convertToRoman(int num) {
        String[] ones ={"", "I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens ={"", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds ={"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousands ={"", "M", "MM", "MMM"};

        String[] numbers = Integer.toString(num).split("");
        String result = "";

        switch(numbers.length){
            case 4:
                result = thousands[Integer.parseInt(numbers[0])] + hundreds[Integer.parseInt(numbers[1])] + tens[Integer.parseInt(numbers[2])]+ones[Integer.parseInt(numbers[3])];
                break;
            case 3:
                result = hundreds[Integer.parseInt(numbers[0])] + tens[Integer.parseInt(numbers[1])]+ones[Integer.parseInt(numbers[2])];
                break;
            case 2:
                result = tens[Integer.parseInt(numbers[0])]+ones[Integer.parseInt(numbers[1])];
                break;
            case 1:
                result = ones[Integer.parseInt(numbers[0])];
                break;
        }


        return result;
    }

    public static void main(String[] args){
        System.out.println("Expected II: " + convertToRoman(2));
        System.out.println("Expected XII: " + convertToRoman(12));
        System.out.println("Expected XVI: " + convertToRoman(16));
        System.out.println("Expected CD: " + convertToRoman(400));
        System.out.println("Expected DCCXCVIII: " + convertToRoman(798));
        System.out.println("Expected M: " + convertToRoman(1000));
        System.out.println("Expected MMMCMXCIX: " + convertToRoman(3999));
        System.out.println("Expected DCXLIX: " + convertToRoman(649));
        System.out.println("Expected XLIV: " + convertToRoman(44));
        System.out.println("Expected LXVIII: " + convertToRoman(68));
    }

}
