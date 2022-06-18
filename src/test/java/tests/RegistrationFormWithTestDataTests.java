package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.FIRST_NAME;
import static tests.TestData.LAST_NAME;

public class RegistrationFormWithTestDataTests extends TestBase {



    @Test
    void successfulTest() {

        registrationFormPage.openPage();


        registrationFormPage.setFirstName(FIRST_NAME);
        registrationFormPage.setLastName(LAST_NAME);
        registrationFormPage.setEmail("Alex@Egorov.ru");
        registrationFormPage.setGender("Male");
        registrationFormPage.setNumber("0123456789");
        registrationFormPage.setDateOfBirth("21", "March", "1996");
        registrationFormPage.setInput("A");
        registrationFormPage.setHobbies("Sports");
        registrationFormPage.uploadFile("Toolsqa.jpg");
        registrationFormPage.setAddress("Address 1");
        registrationFormPage.setState("NCR","Delhi");


        checkTable("Student Name", FIRST_NAME+" "+LAST_NAME);
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
