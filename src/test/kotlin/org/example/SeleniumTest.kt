package org.example

import com.codeborne.selenide.WebDriverRunner
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import kotlin.test.assertTrue

class SeleniumTest {
    @Test
    fun seleniumTest() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe")
        val driver: WebDriver = FirefoxDriver()
        val baseUrl = "https://google.com/ncr"

        driver.get(baseUrl)

        val element = driver.findElement(By.cssSelector(".links > #input[name='username']"))
        element.sendKeys("selenium")
        element.sendKeys(Keys.ENTER)

        val links = driver.findElements(By.cssSelector("#res .g"))
        assertTrue(links.size > 5)
        assertTrue(links.any { link -> link.text == "concise ui tests in Java" })

        driver.close()
    }
}
