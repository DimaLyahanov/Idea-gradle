package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920х1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Dima");
        $("[id=userEmail]").setValue("dimatest@mail.com");
        $("[id=currentAddress]").setValue("LenKoma");
        $("[id=permanentAddress]").setValue("GeyKoma");
        $("[id=submit]").click();

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
