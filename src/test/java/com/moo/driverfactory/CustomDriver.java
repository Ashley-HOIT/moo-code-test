package com.moo.driverfactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class CustomDriver {

    private WebDriver driver;

    public WebDriver newDriver() {
        setupChromeDriver();
        return driver;
    }


    private void setupChromeDriver() {
        DriverConfiguration driverConfiguration = new DriverConfiguration();
        driver = driverConfiguration.returnChromeDriver();
    }

    private class DriverConfiguration {

        WebDriver returnChromeDriver() {
            getChromeDriverInstance();
            return new ChromeDriver();
        }

        private void getChromeDriverInstance() {
            ChromeDriverManager.getInstance().setup();
        }

    }

}
