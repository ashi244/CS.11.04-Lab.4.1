import java.util.Scanner;
public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                count ++;
            }
            else{
                count --;
            }
        }
        if (count != 0){
            return false;
        }
        return true;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num){
        String result = "";
        String str = "" + num;
        for (int i = str.length() - 1; i >= 0; i--){
            result = result + str.charAt(i);
        }
        return result;
    }

    // 3. encryptThis
    public static String encryptThis(String str){
        String result = "";
        boolean word = false;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                if (word){
                    word = false;
                    result = result + " ";
                }
            }
            else{
                if (!(word)){
                    word = true;
                    result = result + (int)str.charAt(i);
                }
                else{
                    if (((i > 1) && (str.charAt(i - 2) == ' ')) || (i == 1)){
                       for (int j = i; j < str.length(); j++){
                           if ((j < str.length() - 1) && (str.charAt(j + 1) == ' ')){
                               result = result + str.charAt(j);
                               break;
                           }
                           else if (j == str.length() - 1){
                               result = result + str.charAt(j);
                               break;
                           }
                       }
                    }
                    else if (((i < str.length() - 1) && (str.charAt(i + 1) == ' ')) || (i == str.length() - 1)){
                        for (int j = i; j >= 0; j--){
                            if ((j >= 2) && (str.charAt(j - 2) == ' ')){
                                result = result + str.charAt(j);
                                break;
                            }
                            else if (j == 1){
                                result = result + str.charAt(j);
                                break;
                            }
                        }
                    }
                    else{
                        result = result + str.charAt(i);
                    }
                }
            }
        }
        return result;
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        String result = "";
        Scanner scanner = new Scanner(str);
        int numEndIndex = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            String charCode = "";
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) {
                    charCode += word.charAt(i);
                } else {
                    numEndIndex = i;
                    break;
                }
            }
            result += (char) Integer.parseInt(charCode);
            if (numEndIndex < word.length() - 1) {
                char second = word.charAt(1);
                char last = word.charAt(word.length() - 1);
                if (second != last) {
                    result += last;
                } else {
                    result += second;
                }
                for (int i = numEndIndex + 1; i < word.length() - 1; i++) {
                    result += word.charAt(i);
                }
                result += word.charAt(numEndIndex);
            }
            else{
                result += word.charAt(word.length() - 1);
            }
            result += " ";
        }
        scanner.close();
        return result.stripTrailing();
    }
}