package singleton;

public class BasicSingleton {

    private BasicSingleton() {}

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

}

class Demo {

    /*
    *   Problem with basic singleton design :
    *      1. Reflection
    *      2. Serialization
    *   With this techniques multiple instances still can be created
    * */

    public static void main(String[] args) {
        BasicSingleton instance = BasicSingleton.getInstance();
        System.out.println(instance);

        BasicSingleton instance2 = BasicSingleton.getInstance();
        System.out.println(instance2);
    }

}
