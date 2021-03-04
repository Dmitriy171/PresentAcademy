import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Registration extends ConditionsTest{


    @Test
    public void registration() {
        open("");
        createAccount
                .signInPage()
                .inputEmail()
                .data()
                .checkTitleData();
    }
}
