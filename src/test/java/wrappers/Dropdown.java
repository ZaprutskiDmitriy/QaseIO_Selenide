package wrappers;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    String label;
    String dropdown = "//*[@id='%sGroup']/div/div/div";

    public Dropdown(String label) {
        this.label = label;
    }

    public void select(String option) {
        $(By.xpath(String.format(dropdown, label))).click();
        $(By.xpath(String.format("//div[text()='%s']", option))).click();
    }
}
