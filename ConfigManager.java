import java.util.Properties;

class ConfigManager {
    private Properties config = new Properties();

    // Private constructor to load configurations
    private ConfigManager() {
        System.out.println("Configuration loaded.");
        config.setProperty("resolution", "1080p");
        config.setProperty("theme", "dark");
    }

    private static class SingletonHelper {
        private static final ConfigManager INSTANCE = new ConfigManager();
    }

    public static ConfigManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String getConfig(String key) {
        return config.getProperty(key);
    }
}

public class MainApp {
    public static void main(String[] args) {
        ConfigManager config1 = ConfigManager.getInstance();
        System.out.println("Video resolution: " + config1.getConfig("resolution"));

        ConfigManager config2 = ConfigManager.getInstance();
        System.out.println("Theme: " + config2.getConfig("theme"));

        // Both config1 and config2 are the same instance
        System.out.println("config1 and config2 are the same instance: " + (config1 == config2)); // true
    }
}
