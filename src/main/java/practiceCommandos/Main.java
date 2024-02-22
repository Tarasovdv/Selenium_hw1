package practiceCommandos;

import com.codeborne.selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Main {
    public static void main(String[] args) {
        Configuration.headless = false;

        open("https://store.steampowered.com/");
//        WebDriverRunner.getWebDriver().findElement(By.xpath("//div[contains(@class,'content_hub_carousel')]/div[@class='title']"));


        SelenideElement selenideElement = $x("//div[contains(@class,'content_hub_carousel')]/div[@class='title']")
                .should(visible, Duration.ofSeconds(10));

        ElementsCollection selenideElements = $$x("//div[@class='marketingmessage_container responsive_scroll_snap_ctn']/a");
        selenideElements.should(CollectionCondition.sizeGreaterThan(0));
        System.out.println("selenideElements.size() = " + selenideElements.size());



//        System.out.println("selenideElement.isDisplayed() = " + selenideElement.isDisplayed());
//        System.out.println("selenideElement.getSize() = " + selenideElement.getSize());
//        SelenideElement selenideElement1 = Selenide.$x("//div[contains(@class,'_hub')]/div[@class='title_123']");
//        selenideElement1.click();
    }
}