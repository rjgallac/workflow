package com.rob.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepsDefs {


    private WebDriver browser;

    public StepsDefs() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/home/bob/chromedriver");

//        browser = new ChromeDriver();
        browser = new RemoteWebDriver(new URL("http://127.0.0.1:8910"), DesiredCapabilities.phantomjs());
        browser.manage().window().setSize(new Dimension(1920,1080));
    }

    @Given("^I am on the home page$")
    public void I_am_on_the_home_page() throws Throwable {
        browser.get("http://127.0.0.1:8080/");
        System.out.println(browser.getCurrentUrl());
    }
    @Then("I see homepage")
    public void assert_homepage(){
        assertEquals("workflow", browser.getTitle());
    }

    @When("^I click the job menu$")
    public void I_click_job_menu() throws InterruptedException {
        browser.findElement(By.id("jobmenu")).click();
    }

    @When("^I enter the job \"([^\"]*)\" in job box$")
    public void I_enter_job(String text) {
        WebElement jobinput = browser.findElement(By.id("jobinput"));
        jobinput.sendKeys(text);
    }

    @When("^I click the add job$")
    public void I_click_add_job_menu() throws InterruptedException {
        browser.findElement(By.id("addjobbtn")).click();
    }

    @When("^I click the applicant menu$")
    public void I_click_applicant_menu() {
        browser.findElement(By.id("applicantmenu")).click();
    }
    @When("^I enter the applicant \"([^\"]*)\"$")
    public void I_enter_applicant(String text) {
        browser.findElement(By.id("applicantinput")).sendKeys(text);
    }
    @When("^I click the add applicant$")
    public void I_click_add_applicant() {
        browser.findElement(By.id("addapplicant")).click();
    }

    @When("^I click the applications menu$")
    public void I_click_appmenu() throws InterruptedException {

        browser.findElement(By.id("applicationmenu")).click();
        Thread.sleep(500L);
    }
    @When("^I enter the appname \"([^\"]*)\"$")
    public void I_enter_appname(String text) {
        browser.findElement(By.id("appname")).sendKeys(text);
    }

    @When("^I select job$")
    public void selectJob(){
        Select select = new Select(browser.findElement(By.id("jobselect")));
//        select.selectByIndex(0);
//        select.deselectAll();
        select.selectByVisibleText("jobby");
    }
    @When("^I select applicant$")
    public void selectApplicant(){
        Select select = new Select(browser.findElement(By.id("applicantselect")));
//        select.deselectAll();
        select.selectByVisibleText("jobby");
//        select.selectByIndex(0);
    }

    @When("^I click the addapp$")
    public void I_click_addapp() {
        browser.findElement(By.id("addapp")).click();
    }



}
