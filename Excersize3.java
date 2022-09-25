import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Excersize3{
    public static void main(String[] args) {

        int sumDigits = sumDigits("efsi01ug");
        System.out.printf("Sum of digits: %d\n", sumDigits); 

        int[] arrayToBeShifted = {2,23,124,241,5};
        shiftLeft(arrayToBeShifted);
        System.out.println("Shifted array: " + Arrays.toString(arrayToBeShifted));
    }

    public static int sumDigits(String stringContainingDigits){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(stringContainingDigits);
        
        int sum = 0;
        while(matcher.find()){
            sum += Integer.parseInt(matcher.group());
        }

        return sum;
    }

    public static void shiftLeft(int[] array){
        if(array.length == 0) return;

        int firstElem = array[0];
        for(int i = 1; i < array.length; i++){
            array[i-1] = array[i];
        }
        array[array.length -1] = firstElem;
    }

    public static int[] fizzArray3(int start, int end){
        int[] res = new int[end-start];
        for (int i = start; i < end; i++){

        }
    } 
}