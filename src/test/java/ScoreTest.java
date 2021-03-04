
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;


public class ScoreTest extends ConditionsTest {

    @Test(priority = 1)
    public void Authorization() {
        open("/index.php?controller=authentication&back=my-account");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).setValue("corona@virus.net");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/span[1]/input[1]")).setValue("corona@virus.net");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")).click();
        assertEquals(Selenide.title(), "My account - My Store");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")).click();

    }

    @Test(priority = 3)
    public void addBasketRandProduct() {
        open("");
        new BuyRandProduct()
                .chooseProduct();

    }


    @Test(priority = 2)
    public void signIn() {
        open("");
        new CreateAccount()
                .signInPage()
                .inputEmail()
                .data()
                .checkTitleData();
    }

    @Test(priority = 4)
    public void addBasketDress() {
        open("");
        new AddBasketDress()
                .chooseDress()
                .addToCart();
//        new CreateAccount()
//                .signInPage()
//                .inputEmail()
//                .data();
        new AddBasketDress()
                .continueaddToCart();
    }

    @Test(priority = 5)
    public void searchNotResults() {
        open("");
        $(By.id("search_query_top")).setValue("meat");
        $(By.xpath("//button[@name='submit_search']")).click();
        $(By.xpath("//p[@class='alert alert-warning']")).getText().contains("No results were found for your search \"meat\"");
    }

    @Test(priority = 6)
    public void cartEmpty() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]/b[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[1]")).getText().contains("Your shopping cart is empty.");
    }

    @Test(priority = 7)
    public void TshirtsPage() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]")).click();
        assertEquals(Selenide.title(), "T-shirts - My Store");

    }

    @Test(priority = 8)
    public void DressesPage() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
        assertEquals(Selenide.title(), "Dresses - My Store");

    }

    @Test(priority = 9)
    public void EveningDressesPage() {
        open("");
        actions().moveToElement($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"))).click($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[2]/a[1]"))).build().perform();
        assertEquals(Selenide.title(), "Evening Dresses - My Store");

    }

    @Test(priority = 10)
    public void CasualDressesPage() {
        open("");
        actions().moveToElement($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"))).click($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[1]/a[1]"))).build().perform();
        assertEquals(Selenide.title(), "Casual Dresses - My Store");

    }

    @Test(priority = 11)
    public void SummerDressesPage() {
        open("");
        actions().moveToElement($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"))).click($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]"))).build().perform();
        assertEquals(Selenide.title(), "Summer Dresses - My Store");

    }

    @Test(priority = 12)
    public void SummerDressesPageDelivery() {
        open("");
        actions().moveToElement($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"))).click($(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]"))).build().perform();
        assertEquals(Selenide.title(), "Summer Dresses - My Store");
        $(By.xpath("//html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/div[1]/ul[1]/li[1]/a[1]")).click();
        assertEquals(Selenide.title(), "Delivery - My Store");
    }

    @Test(priority = 13)
    public void AboutUsPage() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[3]/footer[1]/div[1]/section[3]/ul[1]/li[7]/a[1]")).click();
        assertEquals(Selenide.title(), "About us - My Store");
    }

    @Test(priority = 14)
    public void EveningPage() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        assertEquals(Selenide.title(), "Evening Dresses - My Store");
    }

    @Test(priority = 15)
    public void CasualPage() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
        assertEquals(Selenide.title(), "Casual Dresses - My Store");
    }

    @Test(priority = 16)
    public void SummerPage() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
        assertEquals(Selenide.title(), "Summer Dresses - My Store");
    }

    @Test(priority = 17)
    public void OurStoreError() {
        open("");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/div[1]/ul[1]/li[6]/a[1]")).click();
        assertEquals(Selenide.title(), "Stores - My Store");
        $("#radiusSelect").selectOptionByValue("25");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[3]/button[1]/span[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")).getText().contains("Address, zip / postal code, city, state or country Not found");
    }


    @Test(priority = 18)
    public void checkSearch() {
        open("");
        new Search()
                .product("Blouse")
                .titlePage();
    }

    @Test(priority = 19)
    public void searchBtn() {
        open("");
        $(By.xpath("//button[@name='submit_search']")).click();
        $(By.xpath("//p[@class='alert alert-warning']")).getText().contains("Please enter a search keyword");
    }

    @Test(priority = 20)
    public void searchPageCategories() {
        open("");
        $(By.xpath("//button[@name='submit_search']")).click();
        $(By.xpath("//p[@class='alert alert-warning']")).getText().contains("Please enter a search keyword");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]")).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]")).click();
        assertEquals(Selenide.title(), "Dresses - My Store");
    }

}
