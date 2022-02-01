package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DisplayName("Авторизация")
public class CaseAuth extends BaseTest {

    @Test
    @DisplayName("Авторизация - позитивный")
    void successfulAuthTest() {

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//a[@title='Личный кабинет']")).click();
        webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys("9058506715");
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ss12345678");
        webDriver.findElement(By.xpath("//button[@name='Login']")).click();
        webDriver.findElement(By.xpath("//div[@id='poolLink']/child::button")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Выйти']")));
    }

    @Test
    @DisplayName("Авторизация: некорректный логин - негативный")
    void incorrectLoginFailedAuthTest() {

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//a[@title='Личный кабинет']")).click();
        webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys("9999999999");
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ss12345678");
        webDriver.findElement(By.xpath("//button[@name='Login']")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Пользователь с таким логином и паролем не найден.']")));
    }
}
