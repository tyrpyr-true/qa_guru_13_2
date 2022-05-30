package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeall() {
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void successfulTest() {
        open("/text-box");
    }
}
