package com.wellch4n.crawler.selenium.driver.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

/**
 * @author wellCh4n
 * @date 2022/11/26
 */
public class SeleniumPoolFactory implements PooledObjectFactory<WebDriver> {

    private final AbstractDriverOptions options;

    public SeleniumPoolFactory(AbstractDriverOptions options) {
        this.options = options;
    }

    @Override
    public void activateObject(PooledObject<WebDriver> pooledObject) throws Exception {

    }

    @Override
    public void destroyObject(PooledObject<WebDriver> pooledObject) throws Exception {
        pooledObject.getObject().quit();
    }

    @Override
    public PooledObject<WebDriver> makeObject() throws Exception {
        WebDriver webDriver = SeleniumFactory.newInstance(options);
        return new DefaultPooledObject<>(webDriver);
    }

    @Override
    public void passivateObject(PooledObject<WebDriver> pooledObject) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<WebDriver> pooledObject) {
        return true;
    }
}
