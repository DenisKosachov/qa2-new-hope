package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

import java.util.List;

public class DelfiArticleCommentsTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private WebDriver driver;

    @Test
    public void titleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages.");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        //--------------- Home Page --------------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
    }
}



 /*
        List<WebElement> articles = driver.findElements(HOME_PAGE_ARTICLE);
        WebElement article = articles.get(4);

        String homePageTitle = article.findElement(HOME_PAGE_TITLE).getText();
        int homePageCommentsCount = getCommentsCount(article, HOME_PAGE_COMMENTS);

        article.findElement(HOME_PAGE_TITLE).click();

        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        int articlePageCommentsCount = getCommentsCount(ARTICLE_PAGE_COMMENTS);
        LOGGER.info("Title is: " + homePageTitle + " and comments count is: " + homePageCommentsCount);

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count!");
    }

    private int getCommentsCount(By locator) {
        int commentsCount = 0;
        if (!driver.findElements(locator).isEmpty()) {
            commentsCount = removeBrackets(driver.findElement(locator));
        }
        return commentsCount;
    }

    private int getCommentsCount(WebElement we, By locator) {
        int commentsCount = 0;
        if (!we.findElements(locator).isEmpty()) {
            commentsCount = removeBrackets(we.findElement(locator));
        }
        return commentsCount;
    }

    private int removeBrackets(WebElement we) {
        String commentsCountText = we.getText();
        commentsCountText = commentsCountText.substring(1, commentsCountText.length() - 1);
        return Integer.parseInt(commentsCountText);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }


}
*/

/*        // for
        for (int i = 0; i < titles.size(); i++) {
            if (!titles.get(i).getText().isEmpty()) {
                System.out.println(i + ": " + titles.get(i).getText());
            }
        }

        //foreach
        for (WebElement we : titles) {
//            if (!we.getText().isEmpty()) {
//                System.out.println(we.getText());
//            } else {
//                System.out.println("-----------------");
//            }
            // условие ? true : false (else)
            System.out.println(we.getText().isEmpty() ? "----------------" : we.getText());
        }
*/