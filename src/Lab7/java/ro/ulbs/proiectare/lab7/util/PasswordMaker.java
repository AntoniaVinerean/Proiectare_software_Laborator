package ro.ulbs.proiectare.lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;
    private String name;

    // Singleton: instanța unică [cite: 91]
    private static PasswordMaker instance = null;

    // Contor pentru apeluri (7.6.2 c) [cite: 167]
    private static int callingCounts = 0;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
    }

    // Constructor PRIVAT (7.6.2 a) [cite: 92]
    private PasswordMaker(String name) {
        this.name = name;
    }

    // Metoda getInstance (7.6.2 a) [cite: 97]
    public static PasswordMaker getInstance() {
        callingCounts++; // Incrementăm la fiecare apel [cite: 167]
        if (instance == null) {
            instance = new PasswordMaker("StandardUser"); // [cite: 99]
        }
        return instance;
    }

    // Schimbă numele din getMagicNumber în getCallingCounts pentru a se potrivi cu Main
    public static int getCallingCounts() {
        return callingCounts;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}