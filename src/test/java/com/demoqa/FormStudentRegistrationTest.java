package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormStudentRegistrationTest {
    /*
    Привет!
Необходимо доработать тест:
1. Заполнение всех полей - Student Email, Subjects, Hobbies, Picture (добавить файл в код и загрузить в тесте), Address, State and City
2. Сделать проверки на то, что форма содержит все введенные значения (можно через .shouldHave).
     */
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1700x1200";

    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("TestLastName");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select>option:nth-child(1)").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select>option:nth-child(91)").click();
        $("[aria-label=\"Choose Monday, January 1st, 1990\"]").click();
        $("#userNumber").setValue("1111111111");
        $("#subjectsInput").setValue("M").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        File file = new File("src/test/resources/pictures/Screenshot_1.png");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Test");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
// new string
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Test TestLastName"));
        $(".table-responsive").shouldHave(text("test@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1111111111"));
        $(".table-responsive").shouldHave(text("01 January,1990"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Screenshot_1.png"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

}
