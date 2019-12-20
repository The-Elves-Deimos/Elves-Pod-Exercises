package eduardo.week2;

public class Card {
    public static boolean validateCard(long num){
        if(Long.toString(num).length() >= 14 && Long.toString(num).length() <= 19){
            String[] card = Long.toString(num).split("");
            int checkDigit = Integer.parseInt(card[card.length - 1]);

            card = reverseArray(card);

            int totalSum = 0;

            for(int x = 0; x < card.length; x++){
                if(x % 2 == 0){
                    int temp = Integer.parseInt(card[x]) * 2;
                    card[x] = Integer.toString(convertToDigit(temp));
                }

            }

            for(int x = 0; x < card.length; x++){
                totalSum += Integer.parseInt(card[x]);
            }

            String[] totalSumRes = Integer.toString(totalSum).split("");

            int secondCheck = 10 - Integer.parseInt(totalSumRes[totalSumRes.length - 1]);

            return checkDigit == secondCheck;

        }else {
            return false;
        }
    }

    public static int convertToDigit(int num){
        int result = 0;
        if(Integer.toString(num).length() >= 2){
            String[] digits = Integer.toString(num).split("");

            for (int z = 0; z < digits.length; z++){
                result += Integer.parseInt(digits[z]);
            }

            return result;

        }else{
            return num;
        }
    }

    public static String[] reverseArray(String[] arr){
        String[] result = new String[arr.length - 1];
        int y = 0;
        for(int x = arr.length - 2; x >= 0; x--){
            result[y] = arr[x];
            y++;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(validateCard(1234567890123456L) + "false");
        System.out.println(validateCard(1234567890123452L) + "true");
        System.out.println("false" + validateCard(79927398714L));
        System.out.println("false" + validateCard(79927398713L));
        System.out.println("true" + validateCard(709092739800713L));
        System.out.println("false" + validateCard(1234567890123456L));
        System.out.println("true" + validateCard(12345678901237L));
        System.out.println("true" + validateCard(5496683867445267L));
        System.out.println("false" + validateCard(4508793361140566L));
        System.out.println("true" + validateCard(376785877526048L));
        System.out.println("false" + validateCard(36717601781975L));

    }
}
