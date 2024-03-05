package java;


/*
 * FINDINGS: the @Override annotation doesn't do much, it is defining a method with the same signature that does everything
 */

public class MyOverrideClass {
    public static void main(String[] args) {
        MySuperClass superClass = new MySubClass();
        MySubClass subClass = new MySubClass();
        MySuperClass actuallSuperClass = new MySuperClass();

        ((MySuperClass)superClass).notOverridden();
        subClass.notOverridden();
        actuallSuperClass.notOverridden();
        superClass.myOverriddenFunction();
    }
}

class MySuperClass{
    void notOverridden(){
        System.out.println("notOverriden in superclass");
    }

    public String myOverriddenFunction(){
        System.out.println("overriden in superclass");
        return "";
    }
}

class MySubClass extends MySuperClass{
    void notOverridden() {
        System.out.println("notOverriden in subclass");
    }

    @Override
    public String myOverriddenFunction() {
        System.out.println("overriden in subclass");
        return "";
    }
}
