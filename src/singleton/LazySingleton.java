package singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    /*
     *   Problem thread safety
     *       1. Synchronized method
     *       2. Synchronized block - double-checked locking
     * */
    public static /*synchronized*/ LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}

class LazySingletonDemo {

    public static void main(String[] args) {

    }

}
