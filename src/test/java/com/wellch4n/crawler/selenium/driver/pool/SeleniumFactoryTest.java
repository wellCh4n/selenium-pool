package com.wellch4n.crawler.selenium.driver.pool;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author wellCh4n
 * @date 2022/11/27
 */
public class SeleniumFactoryTest {

    @Test
    public void testNewInstance() {
        SeleniumFactory.setWebDriverPath("/Users/wellch4n/Env/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver = SeleniumFactory.newInstance(chromeOptions);
        Assert.assertNotNull("no WebDriver return from SeleniumFactory", webDriver);
        webDriver.get("https://www.tianyancha.com/company/3062072644");
        Assert.assertNotNull("no content return from WebDriver", webDriver.getPageSource());
        webDriver.quit();
    }
}
