package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Поиск товара и добавление в корзину")
public class CaseSearchProduct extends BaseTest {

    @Test
    @DisplayName("Поиск и добавление в корзину товара")
    void successfulChangeCity(){

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("нож");
        webDriver.findElement(By.xpath("//form[@id='search']//button[@class='header-search__btn']")).click();
        webDriver.findElement(By.xpath("//span[@href='#' and @data-id='573485']")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Добавить в корзину')]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='order-total-title__text']//b[contains(text(),'1 товар')]")));

        assertThat(webDriver.findElement(By.xpath("//div[@class='order-product__name']//a[@href='/product/5021333/']")).getText())
                .as("Название продукта в корзине должно быть " + "Нож для фруктов, 19 см")
                .isEqualTo("Нож для фруктов, 19 см");
    }
}
