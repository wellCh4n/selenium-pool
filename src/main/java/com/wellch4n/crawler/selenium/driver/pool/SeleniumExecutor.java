package com.wellch4n.crawler.selenium.driver.pool;

import org.openqa.selenium.WebDriver;

/**
 * @author wellCh4n
 * @date 2022/11/27
 */
public abstract class SeleniumExecutor<T> {

    private final SeleniumPool seleniumPool;

    public SeleniumExecutor(SeleniumPool seleniumPool) {
        this.seleniumPool = seleniumPool;
    }

    public abstract T execute(WebDriver webDriver);

    public T run() throws Exception {
        WebDriver webDriver = seleniumPool.borrowObject();
        T t;
        try {
            t = execute(webDriver);
        } finally {
            seleniumPool.returnObject(webDriver);
        }
        return t;
    }
}
