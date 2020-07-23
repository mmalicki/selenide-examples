package org.example

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class SelenideTest {
    @Test
    fun test() {
//        Configuration.browser = "chrome"
//        Configuration.baseUrl = "http://localhost:9000"
//        Configuration.headless = true
//        Configuration.timeout = 5000
//        Configuration.browserVersion = "72"

        System.setProperty("selenide.browser", "firefox")
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
        element(By.name("q")).waitUntil(appears, 5000)
        element(By.name("q")).should(appear)
    }
}
