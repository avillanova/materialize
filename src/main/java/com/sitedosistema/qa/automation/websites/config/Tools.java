package com.sitedosistema.qa.automation.websites.config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sitedosistema.qa.automation.websites.config.Hook.driver;

public class Tools {
    public static WebElement waitBy(WebElement element) {
        try {
            new WebDriverWait( driver(), 40 )
                    .until(  ExpectedConditions.visibilityOf( element ));
        }catch(Exception e){
            System.err.println(element+" Não encontrado....");
        }
        return element;
    }

    public static void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
