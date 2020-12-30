package com.framework;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ToDo{

    private WebDriver driver;

    public ToDo(WebDriver driver) {
        this.driver = driver;
    }
    private By addingField = By.xpath("//input[@class='new-todo']");
    private By listElements = By.xpath("//ul[@class='todo-list']/li");
    private By deleteButton = By.xpath("//button[@class='destroy']");
    private By quantityOfElements = By.xpath("//span[@class='todo-count']/strong");


    public ToDo addItemsToDo(){
        driver.findElement(addingField).sendKeys("Task 1" );
        driver.findElement(addingField).sendKeys(Keys.ENTER);
        return new ToDo(driver);
    }

    public int getQuantityOfList(){
        List<WebElement> results = driver.findElements(listElements);
        System.out.println(results.size());
        return (results.size());
    }

    public ToDo getDeleteButton(){
        WebElement field = driver.findElement(By.xpath("//ul[@class='todo-list']/li"));
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(field);
        driver.findElement(deleteButton).click();
        return new ToDo(driver);
    }

    public int getQuantity(){
        String quantity = driver.findElement(quantityOfElements).getText();
        int i = Integer.parseInt(quantity);
        return (i);
    }


}

