package anhtester.com.BT1_BT2_BT3;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_BT1_BT2_BT3 extends BaseTest {

    @BeforeMethod
    public void loginCMS() {
        System.out.println("Login");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test
    public void addCategory() {
        System.out.println("Add Category");
        String CATEGORY_NAME = "Category_2811A4";

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(CATEGORY_NAME);
        //driver.findElement(By.xpath("")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Computer", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div")).click();
        WebUI.sleep(4);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Selenium", Keys.ENTER);
        WebUI.sleep(2);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("4");
        WebUI.sleep(2);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(CATEGORY_NAME, Keys.ENTER);
        WebUI.sleep(2);
        String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println("Get Category Item: " + categoryItem);
        Assert.assertEquals(categoryItem, CATEGORY_NAME);
        WebUI.sleep(1);

    }

}
