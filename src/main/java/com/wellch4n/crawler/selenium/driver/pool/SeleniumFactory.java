package com.wellch4n.crawler.selenium.driver.pool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

/**
 * @author wellCh4n
 * @date 2022/11/26
 */
public class SeleniumFactory {

    public static String webDriverPath;

    public static void setWebDriverPath(String webDriverPath) {
        SeleniumFactory.webDriverPath = webDriverPath;
    }

    public static WebDriver newInstance(AbstractDriverOptions options) {
        if (webDriverPath == null || webDriverPath.isEmpty()) {
            throw  new RuntimeException("Web Driver Path is null or empty!");
        }
        if (options instanceof ChromeOptions) {
            System.setProperty("webdriver.chrome.driver", webDriverPath);
            ChromeOptions chromeOptions = (ChromeOptions) options;
            return new ChromeDriver(chromeOptions);
        }
        return null;
    }
}
