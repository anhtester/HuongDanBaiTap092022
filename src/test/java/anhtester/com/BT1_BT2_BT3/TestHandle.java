package anhtester.com.BT1_BT2_BT3;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHandle extends BaseTest {
    @Test
    public void loginCMS() {
        System.out.println("Login");
        driver.get("https://demo.activeitzone.com/ecommerce/login");

        Assert.assertTrue(new WebUI(driver).checkElementExist(By.xpath("//input[@id='email']")), "Element NOT exist."); //Đối tượng By
        //new WebUI(driver).checkElementExist("//input[@id='email']"); //String xpath

        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
