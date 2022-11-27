package com.wellch4n.crawler.selenium.driver.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author wellCh4n
 * @date 2022/11/27
 */
public class SeleniumExecutorTest {

    private SeleniumPool seleniumPool;

    @Before
    public void setUp() throws Exception {
        SeleniumFactory.setWebDriverPath("/Users/wellch4n/Env/chromedriver");

        GenericObjectPoolConfig<WebDriver> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(2);
        ChromeOptions chromeOptions = new ChromeOptions();
        SeleniumPool seleniumPool = new SeleniumPool(new SeleniumPoolFactory(chromeOptions));
        seleniumPool.addObjects(2);
        this.seleniumPool = seleniumPool;
    }

    @After
    public void close() {
        seleniumPool.close();
    }

    @Test
    public void testExecute() throws Exception {
        String title = new BaiDuSeleniumExecutor(seleniumPool).run();
        boolean containsKeyword = title.contains("百度");
        Assert.assertTrue(containsKeyword);
    }

    public static class BaiDuSeleniumExecutor extends SeleniumExecutor<String> {
        public BaiDuSeleniumExecutor(SeleniumPool seleniumPool) {
            super(seleniumPool);
        }

        @Override
        public String execute(WebDriver webDriver) {
            webDriver.get("https://www.baidu.com");
            return webDriver.getTitle();
        }
    }
}
