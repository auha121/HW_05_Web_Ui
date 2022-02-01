package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Адреса магазинов")
public class CaseAdress extends BaseTest{

    @Test
    @DisplayName("Адреса магазинов")
    void successfulAdressTest() {

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//a[contains(text(),'Адреса магазинов')]")).click();
        webDriver.findElement(By.xpath("//form[@id='search-location']//input[@name='q']")).sendKeys("Верхняя Пышма");
        webDriver.findElement(By.xpath("//form[@id='search-location']//button[@class='search-form__submit']")).click();

        assertThat(webDriver.findElement(By.xpath("//div[@class='shops-table-item__address']")).getText())
                .as("Адрес магазина должен быть " + "г.Верхняя Пышма, ул.Уральских рабочих, д.42А")
                .isEqualTo("г.Верхняя Пышма, ул.Уральских рабочих, д.42А");
    }
}
