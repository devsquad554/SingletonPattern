class DatabaseConnection {
    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        System.out.println("Database connection established.");
    }

    // Static inner class to hold the singleton instance
    private static class SingletonHelper {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    // Public method to provide access to the instance
    public static DatabaseConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

public class MainApp {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.query("SELECT * FROM Stocks");

        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.query("UPDATE Stocks SET price=1000 WHERE id=1");

        // Both db1 and db2 are the same instance
        System.out.println("db1 and db2 are the same instance: " + (db1 == db2)); // true
    }
}
