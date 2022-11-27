package com.wellch4n.crawler.selenium.driver.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.openqa.selenium.WebDriver;

/**
 * @author wellCh4n
 * @date 2022/11/26
 */
public class SeleniumPool extends GenericObjectPool<WebDriver> {


    public SeleniumPool(PooledObjectFactory<WebDriver> factory) {
        super(factory);
    }
}
