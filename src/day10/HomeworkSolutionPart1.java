package day10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeworkSolutionPart1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://test.campus.techno.study/" );
        driver.findElement(By.cssSelector("input[data-placeholder=\"Username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.cssSelector("input[data-placeholder=\"Password\"]")).sendKeys("TechnoStudy123@");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("svg[data-icon=\"bars\"]")));
            System.out.println("Logged in!");
        } catch (Exception e) {
            System.out.println("Not logged in!");
        }

        String parentMenu = ".group-items > :nth-child(5)";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(parentMenu)));
        driver.findElement(By.cssSelector(parentMenu)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentMenu + " > .children > :nth-child(1)")));
        driver.findElement(By.cssSelector(parentMenu + " > .children > :nth-child(1)")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentMenu + " > .children > :nth-child(1) > .children > :nth-child(1)")));
        driver.findElement(By.cssSelector(parentMenu + " > .children > :nth-child(1) > .children > :nth-child(1)")).click();
    }
}
