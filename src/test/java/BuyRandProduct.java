import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BuyRandProduct {
    Random rand = new Random();
    int product1 = rand.nextInt(7) + 1;
    int product2= rand.nextInt(7) + 1;
    SelenideElement productCart1 = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li["+ (product1) + "]/div[1]/div[1]/div[1]/a[1]/img[1]"));
    SelenideElement productCart2 = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li["+ (product2) + "]/div[1]/div[1]/div[1]/a[1]/img[1]"));
    SelenideElement btnAddCart1 = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li["+ (product1) + "]/div[1]/div[2]/div[2]/a[1]/span[1]"));
    SelenideElement btnAddCart2 = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li["+ (product2) + "]/div[1]/div[2]/div[2]/a[1]/span[1]"));
    SelenideElement stepOrder = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/h1[1]"));
    SelenideElement btnByStep = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]"));

    public BuyRandProduct chooseProduct() {
        actions().moveToElement(productCart1).click(btnAddCart1).build().perform();
        $(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']//span[1]")).click();
        actions().moveToElement(productCart2).click(btnAddCart2).build().perform();
        $(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
//        CreateAccount createAcc = new CreateAccount();
//        createAcc.signInPage();
//        createAcc.inputEmail();
//        createAcc.data();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();
        $(stepOrder).shouldHave(text("Addresses"));
        $(btnByStep).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/h1[1]")).shouldHave(text("Shipping"));
        $("input[type=\"checkbox\"]").parent().click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
        $(stepOrder).shouldHave(text("Please choose your payment method"));
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")).click();
        $(stepOrder).shouldHave(text("Order summary"));
        $(btnByStep).click();
        $(stepOrder).shouldHave(text("Order confirmation"));
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]/strong[1]")).shouldHave(text("Your order on My Store is complete."));
        return this;
    }


}




