package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.getProperty("TargetBrowser").toLowerCase();

            switch (browser) {
                case "chrome" -> driver.set(new ChromeDriver());
                case "firefox" -> driver.set(new FirefoxDriver());
                default ->
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
