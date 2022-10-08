public class PrivateFieldInSuperclass {
    static private String johnCena = "You can't see me";
    static String jonathanSeenA = "I am hard to spot";
    static protected String joshSenap = "You can sometimes see me";
}

class SubType extends PrivateFieldInSuperclass {
    public static void main(String[] args) {
        System.out.println(johnCena);
        System.out.println(jonathanSeenA);
        System.out.println(joshSenap);
    }
}
