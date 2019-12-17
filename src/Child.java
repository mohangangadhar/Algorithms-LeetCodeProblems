// Which class gets called first and what is the output
// Output is :
// Base Static
// Child Static
// Base Constructor
// Child Constructor
// Base Constructor
// Child Constructor

class Base {
    static {
        System.out.println("Base Static");
    }

    public Base() {
        System.out.println("Base Constructor");
    }
}

// Child.java
public class Child extends Base {
    static {
        System.out.println("Child Static");
    }

    public Child() {
        System.out.println("Child Constructor");
    }

    public static void main(String[] args) {
        Base child1 = new Child();
        Base child2 = new Child();
    }
}
