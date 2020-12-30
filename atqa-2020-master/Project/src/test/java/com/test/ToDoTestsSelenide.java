package com.test;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import org.testng.Assert;

public class ToDoTestsSelenide {
    private By addingField = By.xpath("//input[@class='new-todo']");
    private By listOfTasks = By.xpath("//ul[@class='todo-list']/li");
    private By deleteButton = By.xpath("(//div[@class='view'])[1]/button");
    private By quantityOfElements = By.xpath("//span[@class='todo-count']/strong");
    public int taskNumber = 5;
    public int results;

    @BeforeMethod
    public void setUp() {
        open("http://todomvc.com/examples/vue/");
    }

    @AfterMethod
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void addItemsToDo() {
        //System.out.println("Test 1 is started");
        for(int i=0; i<taskNumber; i++) {
            $(addingField).val("Task " + i ).pressEnter();
        }
       // System.out.println("Tasks are added");
        Assert.assertTrue($(listOfTasks).exists() ,"Element does not exist");
        System.out.println();
    }

    @Test
    public void getQuantityOfTasks() {
        addItemsToDo();
        results = $$(listOfTasks).size();
        //System.out.println("Quantity of tasks is " + results);
        Assert.assertTrue(results > 0,"There are not any tasks");
        System.out.println();
    }

    @Test
    public void deleteTask() {
        //System.out.println("Test 3 is started");
        for(int i=0; i<taskNumber; i++) {
            $(addingField).val("Task " + i ).pressEnter();
        }
        int resultsBeforeDel = $$(listOfTasks).size();
       // System.out.println("Quantity of tasks before deleting are " + results);
        $(listOfTasks).hover();
        $(deleteButton).click();
        int resultsAfterDel = $$(listOfTasks).size();
       // System.out.println("Quantity of tasks after deleting are " + results);
        Assert.assertEquals(resultsBeforeDel-1, resultsAfterDel , "Task is deleted");
        System.out.println();
    }

    @Test
    public void compareQuantity() {
        //System.out.println("Test 4 is started");
        for(int i=0; i<taskNumber; i++) {
            $(addingField).val("Task " + i ).pressEnter();
        }
        results = $$(listOfTasks).size();
        //System.out.println("Quantity of tasks is " + results);
        int quantity = Integer.parseInt($(quantityOfElements).getText());
        Assert.assertTrue(results == quantity, "Quantity is equal");
        System.out.println();
    }


}

