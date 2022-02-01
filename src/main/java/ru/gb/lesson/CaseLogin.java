package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CaseLogin {
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//a[@title='Личный кабинет']")).click();
        webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys("9058506715");
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ss12345678");
        webDriver.findElement(By.xpath("//button[@name='Login']")).click();
        webDriver.findElement(By.xpath("//div[@id='poolLink']/child::button")).click();

        Thread.sleep(5000);
        webDriver.quit();
    }
}
