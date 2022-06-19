package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.*;

public class RegistrationFormWithRandomUtilsTests extends TestBase {



    @Test
    void successfulTest() {

        String firstName =  getRandomString(10);
        String lastName =  getRandomString(10);
        String email= getRandomEmail();
        String gender = getRandomGender();
        String phone = getRandomPhone();
        String[] dateOfBirth = new String[3];
        dateOfBirth=getRandomDateOfBirth();
        String[] inputSubject = new String[2];
        inputSubject=getRandomSubject();
        String hobby= getRandomHobby();
        String address= getRandomMessage(10,30);
        String[] stateAndCity = new String[2];
        stateAndCity= getRandomStateCity();
        registrationFormPage.openPage();
        registrationFormPage.setFirstName(firstName);
        registrationFormPage.setLastName(lastName);
        registrationFormPage.setEmail(email);
        registrationFormPage.setGender(gender);
        registrationFormPage.setNumber(phone);
        registrationFormPage.setDateOfBirth(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2]);
        registrationFormPage.setInput(inputSubject[0], inputSubject[1]);
        registrationFormPage.setHobbies(hobby);
        registrationFormPage.uploadFile("Toolsqa.jpg");
        registrationFormPage.setAddress(address);
        registrationFormPage.setState(stateAndCity[0],stateAndCity[1]);


        checkTable("Student Name", firstName+' '+lastName);
        checkTable("Student Email", email);
        checkTable("Gender", gender);
        checkTable("Mobile", phone);
        checkTable("Date of Birth", dateOfBirth[0]+" "+dateOfBirth[1]+","+dateOfBirth[2]);
        checkTable("Subjects", inputSubject[1]);
        checkTable("Hobbies", hobby);
        checkTable("Picture", "Toolsqa.jpg");
        checkTable("Address", address);
        checkTable("State and City", stateAndCity[0]+" "+stateAndCity[1]);

    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
    }

}
