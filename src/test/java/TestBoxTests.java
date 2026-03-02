package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Dima");
        $("[id=userEmail]").setValue("dimatest@mail.com");
        $("[id=currentAddress]").setValue("LenKoma");
        $("[id=permanentAddress]").setValue("GeyKoma");
        $("[id=submit]").click();

        $("#output #name").shouldHave(text("Dima"));
        $("#output #email").shouldHave(text("dimatest@mail.com"));
        $("#output #currentAddress").shouldHave(text("LenKoma"));
        $("#output #permanentAddress").shouldHave(text("GeyKoma"));

    }
}
