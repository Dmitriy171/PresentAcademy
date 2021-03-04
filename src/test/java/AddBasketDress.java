import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class AddBasketDress {
    SelenideElement dress = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/a[1]/img[1]"));
    SelenideElement stepOrder = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/h1[1]"));
    SelenideElement btnByStep = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]"));

    public AddBasketDress chooseDress() {
        $(dress).click();
        assertEquals(Selenide.title(), "Printed Dress - My Store");
        $("#our_price_display").shouldHave(text("$26.00"));
        return this;

    }

    public AddBasketDress addToCart() {
        $("#group_1").selectOptionByValue("2");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[3]/div[1]/p[1]/button[1]/span[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]")).shouldHave(text("Product successfully added to your shopping cart"));
        $("#layer_cart_product_attributes").shouldHave(text("Orange, M"));
        $("#layer_cart_product_price").shouldHave(text("$26.00"));
        $(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
        assertEquals(Selenide.title(), "Order - My Store");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();
        return this;

    }

    public AddBasketDress continueaddToCart() {
//        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();
        $(stepOrder).shouldHave(text("Addresses"));
        $(btnByStep).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/h1[1]")).shouldHave(text("Shipping"));
        $("input[type=\"checkbox\"]").parent().click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
        $(stepOrder).shouldHave(text("Please choose your payment method"));
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/table[1]/tfoot[1]/tr[5]/td[2]/span[1]")).shouldHave(text("$28.00"));
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")).click();
        $(stepOrder).shouldHave(text("Order summary"));
        $(btnByStep).click();
        $(stepOrder).shouldHave(text("Order confirmation"));
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]/strong[1]")).shouldHave(text("Your order on My Store is complete."));
        return this;

    }


}
