package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.*;

public class RegistrationFormWithRandomUtilsTests extends TestBase {



    @Test
    void successfulTest() {


        String fileName = "Toolsqa.jpg";
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
        registrationFormPage.uploadFile(fileName);
        registrationFormPage.setAddress(address);
        registrationFormPage.setState(stateAndCity[0],stateAndCity[1]);


         registrationFormPage.checkTable("Student Name", firstName+' '+lastName);
         registrationFormPage.checkTable("Student Email", email);
         registrationFormPage.checkTable("Gender", gender);
         registrationFormPage.checkTable("Mobile", phone);
         registrationFormPage.checkTable("Date of Birth", dateOfBirth[0]+" "+dateOfBirth[1]+","+dateOfBirth[2]);
         registrationFormPage.checkTable("Subjects", inputSubject[1]);
         registrationFormPage.checkTable("Hobbies", hobby);
         registrationFormPage.checkTable("Picture", fileName);
         registrationFormPage.checkTable("Address", address);
         registrationFormPage.checkTable("State and City", stateAndCity[0]+" "+stateAndCity[1]);

    }


}
