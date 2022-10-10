package smalltests;

public class FinalParameter {
    public static void main(String[] args) {
        String normalString = "cold water";
        normalString = "accountable";
        iWantAFinalParameter(normalString);
        System.out.println(normalString + " gucci guy");
    }

    public static void iWantAFinalParameter(final String finalParam){
        System.out.println(finalParam);
    }
}
