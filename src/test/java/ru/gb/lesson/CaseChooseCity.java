package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Изменение города")
public class CaseChooseCity extends BaseTest {

    @Test
    @DisplayName("Выбор города")
    void successfulChangeCity() throws InterruptedException {

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//span[@class='header-city__select js-city-dropdown-toggle']")).click();
        webDriver.findElement(By.xpath("//li[text()='г.Остров']")).click();
        webDriver.findElement(By.xpath("//button[@id='button-change-city']")).click();

        Thread.sleep(500);

        assertThat(webDriver.findElement(By.xpath("//span[@class='header-city__select js-city-dropdown-toggle']")).getText())
                .as("Город должен быть " + "г.Остров")
                .isEqualTo("г.Остров");
    }
}
