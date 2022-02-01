package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Добавление товара в корзине")
public class CaseAddChooseProduct extends BaseTest {

    @Test
    @DisplayName("Товар в корзине - позитивный")
    void successfulAddProduct() {

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//div[@href='#catalog-dropdown']")).click();
        webDriver.findElement(By.xpath("//a[@href='/catalog/dlya-doma/']")).click();
        webDriver.findElement(By.xpath("//span[@data-id='236593']")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Добавить в корзину')]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='order-total-title__text']//b[contains(text(),'1 товар')]")));

        assertThat(webDriver.findElement(By.xpath("//div[@class='order-product__name']//a[@href='/product/5069297/']")).getText())
                .as("Название продукта в корзине должно быть " + "Ящик хозяйственный, 18 л")
                .isEqualTo("Ящик хозяйственный, 18 л");
    }
}
