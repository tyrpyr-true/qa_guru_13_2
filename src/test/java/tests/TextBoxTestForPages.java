package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestForPages  extends TestBase {



    @Test
    void successfulTest() {

        registrationFormPage.openPage();

        //$("#firstName").setValue("Alex");
        registrationFormPage.setFirstName("Alex");
        //$("#lastName").setValue("Egorov");
        registrationFormPage.setLastName("Egorov");
        //$("#userEmail").setValue("Alex@Egorov.ru");
        registrationFormPage.setEmail("Alex@Egorov.ru");
        //$("#genterWrapper").$(byText("Male")).click();
        registrationFormPage.setGender("Male");
        //$("#userNumber").setValue("0123456789");
        registrationFormPage.setNumber("0123456789");
        //$("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").selectOption("March");
        //$(".react-datepicker__year-select").selectOption("1996");
        //$(".react-datepicker__day--021").click();
        registrationFormPage.setDateOfBirth("21", "March", "1996");
        //$("#subjectsInput").sendKeys("A");
        //$(byText("Arts")).click();
        registrationFormPage.setInput("A");
        //$("#hobbiesWrapper").$(byText("Sports")).click();
        registrationFormPage.setHobbies("Sports");
        //$("#uploadPicture").uploadFromClasspath("Toolsqa.jpg");
        registrationFormPage.uploadFile("Toolsqa.jpg");
       // $("#currentAddress").setValue("Address 1");
        registrationFormPage.setAddress("Address 1");
        //$("#react-select-3-input").setValue("NCR").pressEnter();
        //$("#react-select-4-input").setValue("Delhi").pressEnter();
        //$("#submit").click();
        registrationFormPage.setState("NCR","Delhi");


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
