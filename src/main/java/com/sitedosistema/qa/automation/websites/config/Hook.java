package com.sitedosistema.qa.automation.websites.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hook {
    private static WebDriver driver;

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void quit(){
        driver.quit();
    }

    public static WebDriver driver(){
        return driver;
    }
}
