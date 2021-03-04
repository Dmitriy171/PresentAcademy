import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class Search {
    SelenideElement search = $(By.id("search_query_top"));
    SelenideElement buttonSearch = $(By.xpath("//button[@name='submit_search']"));


    public Search product (String strProduct) {
        $(search).setValue(strProduct);
        $(buttonSearch).click();

        return this;
    }
    public Search titlePage () {
        String title = "Search - My Store";
        Selenide.title();
        assertEquals(Selenide.title(), title);
        return this;
    }



}

