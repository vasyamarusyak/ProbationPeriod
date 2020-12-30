package com.test;
import com.framework.ToDo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class ToDoTests {
    protected RemoteWebDriver driver = null;
    public ToDo toDo;

    @BeforeMethod
    public void  setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// неявне очікування
        driver.manage().window().maximize();
        driver.get("http://todomvc.com/examples/vue/");
        toDo = new ToDo(driver);
    }

    @Test
    public void addElements(){
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        System.out.println("addItemsTodo method");
    }

    @Test
    public void checkItemsQuantity(){
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        toDo.getQuantityOfList();
    }

    @Test
    public void deleteTheElement(){
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        toDo.getQuantityOfList();
        toDo.getDeleteButton();
        toDo.getQuantityOfList();
    }

    @Test
    public void compareQuantity(){
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        toDo.addItemsToDo();
        if((toDo.getQuantityOfList()) != (toDo.getQuantity())){
            System.out.println("Quantity is not equal");
        }
        System.out.println("Everything is OK");

    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



