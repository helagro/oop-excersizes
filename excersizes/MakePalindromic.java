package excersizes;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakePalindromic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line1);
        matcher.find();
        matcher.find();

        int k = Integer.parseInt(matcher.group());
        String inputNumber = scanner.nextLine();
        System.out.printf("Inputnumber is %s, and k is %d\n", inputNumber, k);
        int lastIndex = inputNumber.length() -1;

        for(int i = 0; i <= lastIndex; i++){
            if(Character.getNumericValue(inputNumber.charAt(i)) > Character.getNumericValue(inputNumber.charAt(lastIndex - i))){
                System.out.println("dwa" + inputNumber.charAt(i) + "dawfea" + inputNumber.charAt(lastIndex - i));
            } else {

            }
        }
        scanner.close();
    }
}

