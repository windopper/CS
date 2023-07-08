public class Singleton {
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        Thread threadFoo = new Thread(() -> {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        });

        Thread threadBar = new Thread(() -> {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        });

        threadFoo.start();
        threadBar.start();
    }
}