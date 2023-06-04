package com.turborvip.test.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

@Setter
public class CalculatorTest {
    AndroidDriver<?> driver;
    String fileName = "calculator.apk";
    File calculatorApp = new File("/home/turborvip/Appium/" + fileName);
    WebElement number_1;
    WebElement number_2;
    WebElement number_3;
    WebElement number_4;
    WebElement number_5;
    WebElement number_6;
    WebElement number_7;
    WebElement number_8;
    WebElement number_9;
    WebElement button_equal;
    WebElement result;
    WebElement plus;
    WebElement minus;
    WebElement multiply;
    WebElement divider;
    WebElement squareRoot;
    WebElement leftBracket;
    WebElement rightBracket;

    WebElement advanced;


    @BeforeTest
    public void beforeTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", calculatorApp);
        // khai báo platform
        cap.setCapability("platformName", "Android");
        // khai báo deviceName
        cap.setCapability("deviceName", "emulator-5554");
        // Tìm app và cài đặt app
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        this.setNumber_1(driver.findElementById("com.google.android.calculator:id/digit_1"));
        this.setNumber_2(driver.findElementById("com.google.android.calculator:id/digit_2"));
        this.setNumber_3(driver.findElementById("com.google.android.calculator:id/digit_3"));
        this.setNumber_4(driver.findElementById("com.google.android.calculator:id/digit_4"));
        this.setNumber_5(driver.findElementById("com.google.android.calculator:id/digit_5"));
        this.setNumber_6(driver.findElementById("com.google.android.calculator:id/digit_6"));
        this.setNumber_7(driver.findElementById("com.google.android.calculator:id/digit_7"));
        this.setNumber_8(driver.findElementById("com.google.android.calculator:id/digit_8"));
        this.setNumber_9(driver.findElementById("com.google.android.calculator:id/digit_9"));

        this.setPlus(driver.findElementById("com.google.android.calculator:id/op_add"));
        this.setMinus(driver.findElementById("com.google.android.calculator:id/op_sub"));
        this.setMultiply(driver.findElementById("com.google.android.calculator:id/op_mul"));
        this.setDivider(driver.findElementById("com.google.android.calculator:id/op_div"));
        this.setSquareRoot(driver.findElementById("com.google.android.calculator:id/op_mul"));

        this.setLeftBracket(driver.findElementById("com.google.android.calculator:id/lparen"));
        this.setRightBracket(driver.findElementById("com.google.android.calculator:id/rparen"));

        this.setButton_equal(driver.findElementById("com.google.android.calculator:id/eq"));
        this.setResult(driver.findElementById("com.google.android.calculator:id/result"));

        this.setAdvanced(driver.findElementById("com.google.android.calculator:id/pad_advanced"));

        this.number_4.click();
    }
    @Test
    public void plusTest() {

        this.number_2.click();
        this.plus.click();
        this.number_9.click();
        this.button_equal.click();
        // Todo 2+9
        Assert.assertEquals(this.result.getText(), "11");
    }

    @Test
    public void minusTest() {
        this.number_9.click();
        this.minus.click();
        this.number_1.click();
        this.button_equal.click();
        // Todo 9-1
        Assert.assertEquals(this.result.getText(), "8");
    }

    @Test
    public void multiplyTest() {
        this.number_1.click();
        this.number_1.click();
        this.multiply.click();
        this.number_2.click();
        this.button_equal.click();
        // Todo 11*2
        Assert.assertEquals(this.result.getText(), "22");
    }

    @Test
    public void dividerTest() {
        this.number_2.click();
        this.number_5.click();
        this.divider.click();
        this.number_5.click();
        this.button_equal.click();
        // Todo 25/5
        Assert.assertEquals(this.result.getText(), "5");
    }

    @Test
    public void squareRoot() {
        this.advanced.click();
        this.squareRoot.click();
        this.number_4.click();
        this.number_2.click();
        this.number_5.click();
        this.button_equal.click();
        // Todo √25
        Assert.assertEquals(this.result.getText(), "5");
    }

    @Test
    public void expression() {
        this.advanced.click();
        this.squareRoot.click();
        this.leftBracket.click();
        this.leftBracket.click();
        this.number_4.click();
        this.number_6.click();
        this.multiply.click();
        this.advanced.click();
        this.leftBracket.click();
        this.number_4.click();
        this.number_2.click();
        this.plus.click();
        this.number_4.click();
        this.advanced.click();
        this.rightBracket.click();
        this.number_4.click();
        this.divider.click();
        this.number_2.click();
        this.advanced.click();
        this.rightBracket.click();
        this.number_4.click();
        this.plus.click();
        this.number_7.click();
        this.advanced.click();
        this.rightBracket.click();
        this.number_4.click();
        this.button_equal.click();

        // Todo √((6*(2+4)/2)+7)
        Assert.assertEquals(this.result.getText(), "5");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}