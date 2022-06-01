package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeall() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";

    }

    @Test
    void successfulTest() {
        System.out.println("Started first test");
        open("/automation-practice-form");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('fixedban').remove()");

        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Egorov");
        $("[id=userEmail]").setValue("Alex@Egorov.ru");
        $("label[for=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0123456789");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--021").click();
        $("[id=subjectsInput]").sendKeys("A");
        $(byText("Arts")).click();
        $("label[for=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFile(new File("src\\test\\java\\tests\\Toolsqa.jpg"));
        $("[id=currentAddress]").setValue("Address 1");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        $("[id=submit]").click();

        $(".table-responsive").shouldHave(
                text("Alex Egorov"),
                text("Alex@Egorov.ru"),
                text("Male"),
                text("0123456789"),
                text("21 March,1996"),
                text("Arts"),
                text("Sports"),
                text("Toolsqa.jpg"),
                text("Address 1"),
                text("NCR Delhi")
        );
        System.out.println("Ended first test");
    }
}
