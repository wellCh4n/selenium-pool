package com.wellch4n.crawler.selenium.driver.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author wellCh4n
 * @date 2022/11/27
 */
public class SeleniumPoolFactoryTest {

    @Test
    public void test() throws Exception {
        SeleniumFactory.setWebDriverPath("/Users/wellch4n/Env/chromedriver");

        GenericObjectPoolConfig<WebDriver> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(2);
        ChromeOptions chromeOptions = new ChromeOptions();
        SeleniumPool seleniumPool = new SeleniumPool(new SeleniumPoolFactory(chromeOptions));
        seleniumPool.addObjects(2);
        Assert.assertEquals(2, seleniumPool.listAllObjects().size());

        seleniumPool.close();
    }
}
