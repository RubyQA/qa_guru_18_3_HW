package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormStudentRegistration {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1700x1200";
    }
    @Test
    void FillFormTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Test");
        $("[id=lastName]").setValue("TestLastName");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("1111111111");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#submit").click();
        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);
    }

}
