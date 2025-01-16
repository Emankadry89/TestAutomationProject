package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver.get() == null) {
            String browser = ConfigReader.getProperty("TargetBrowser").toLowerCase();

            switch (browser) {
                case "chrome" -> driver.set(new ChromeDriver());
                case "firefox" -> driver.set(new FirefoxDriver());
                case "seleniumgrid" -> driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions()));
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
