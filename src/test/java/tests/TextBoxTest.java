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
//        System.out.println("Started first test");
        open("/automation-practice-form");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('fixedban').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("Alex@Egorov.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").sendKeys("A");
        $(byText("Arts")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Toolsqa.jpg");
        $("#currentAddress").setValue("Address 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        checkTable("Student Name", "Alex Egorov");
        checkTable("Student Email", "Alex@Egorov.ru");
        checkTable("Gender", "Male");
        checkTable("Mobile", "0123456789");
        checkTable("Date of Birth", "21 March,1996");
        checkTable("Subjects", "Arts");
        checkTable("Hobbies", "Sports");
        checkTable("Picture", "Toolsqa.jpg");
        checkTable("Address", "Address 1");
        checkTable("State and City", "NCR Delhi");

    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
    }

}
