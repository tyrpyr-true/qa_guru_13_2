package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    public void setFirstName(String value)  {
        $("#firstName").setValue(value);
    }

    public void setLastName(String value)  {
        $("#lastName").setValue(value);
    }

     public void setEmail(String value)  {
        $("#userEmail").setValue(value);
    }

     public void setGender(String value)  {
         $("#genterWrapper").$(byText(value)).click();
    }


     public void setNumber(String value)  {
         $("#userNumber").setValue(value);
    }

     public void setDateOfBirth(String value)  {
         $("#dateOfBirthInput").click();
         $(".react-datepicker__month-select").selectOption("March");
         $(".react-datepicker__year-select").selectOption("1996");
         $(".react-datepicker__day--021").click();
    }

    public void setInput(String value)  {
        $("#subjectsInput").sendKeys(value);
        $(byText("Arts")).click();
    }


    public void setHobbies(String value)  {
        $("#hobbiesWrapper").$(byText(value)).click();
    }





}
