package pages;

import pages.components.CalendarComponents;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    public CalendarComponents calendarComponents = new CalendarComponents();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();


    public RegistrationFormPage openPage()  {
        open("/automation-practice-form");
         executeJavaScript("$('footer').remove()");
         executeJavaScript("$('fixedban').remove()");
         return this;
    }

    public RegistrationFormPage setFirstName(String value)  {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value)  {
        $("#lastName").setValue(value);
        return this;
    }

     public RegistrationFormPage setEmail(String value)  {
        $("#userEmail").setValue(value);
         return this;
    }

     public RegistrationFormPage setGender(String value)  {
         $("#genterWrapper").$(byText(value)).click();
         return this;
    }


     public RegistrationFormPage setNumber(String value)  {
         $("#userNumber").setValue(value);
         return this;
    }

     public RegistrationFormPage setDateOfBirth(String day, String month, String year)  {
         $("#dateOfBirthInput").click();
         calendarComponents.setDate(day, month, year);

         return this;
    }

    public RegistrationFormPage setInput(String value1, String value2)  {
        $("#subjectsInput").sendKeys(value1);
        $(byText(value2)).click();
        return this;
    }


    public RegistrationFormPage setHobbies(String value)  {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadFile(String value)  {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setAddress(String value)  {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value1,String value2)  {
        $("#react-select-3-input").setValue(value1).pressEnter();
        $("#react-select-4-input").setValue(value2).pressEnter();
        $("#submit").click();
        return this;
    }



}
