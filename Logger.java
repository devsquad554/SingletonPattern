class Logger {
    private Logger() {
        System.out.println("Logger initialized.");
    }

    private static class SingletonHelper {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class MainApp {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("User logged in.");

        Logger logger2 = Logger.getInstance();
        logger2.log("User made a payment.");

        // Both logger1 and logger2 are the same instance
        System.out.println("logger1 and logger2 are the same instance: " + (logger1 == logger2)); // true
    }
}
