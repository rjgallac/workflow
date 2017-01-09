package com.rob.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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
//    private WebDriver browser = new FirefoxDriver();

    public StepsDefs() throws MalformedURLException {
//        browser = new RemoteWebDriver(new URL("http://127.0.0.1:8910"), DesiredCapabilities.phantomjs());
//        browser.manage().window().setSize(new Dimension(1920,1080));

//        Map<String, Object> chromeOptions = new HashMap();
//        chromeOptions.put("binary", "/home/bob/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/home/bob/chromedriver");

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        browser = new ChromeDriver(capabilities);
        browser = new ChromeDriver();
    }

    @Given("^I am on the home page$")
    public void I_am_on_the_home_page() throws Throwable {
        browser.get("http://127.0.0.1:8080/");
        System.out.println(browser.getCurrentUrl());
    }



    @When("^I enter the \"([^\"]*)\"$")
    public void I_enter_(String text) {

        browser.findElement(By.name("q")).sendKeys(text);

    }

    @Then("I see homepage")
    public void assert_homepage(){
        assertEquals("workflow", browser.getTitle());
    }
    @Given("^I am on google$")
    public void I_am_on_google() throws Throwable {
        browser.get("http://google.co.uk/");
        System.out.println(browser.getCurrentUrl());
    }
    @When("I wait")
    public void iWait(){
        try {
            browser.wait(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("I see google")
    public void assert_google(){
        assertEquals("Google", browser.getTitle());
    }

    @When("^I click the course menu link$")
    public void I_click_course_menu() {

        browser.findElement(By.id("coursemenu")).click();

    }
    @When("^I click the jobsaccord$")
    public void I_click_jobsaccord() {
        browser.findElement(By.id("jobsaccord")).click();
    }
    @When("^I click the job menu$")
    public void I_click_job_menu() {
        browser.findElement(By.id("jobmenu")).click();
    }
    @When("^I enter the job \"([^\"]*)\"$")
    public void I_enter_job(String text) {
        browser.findElement(By.id("job")).sendKeys(text);
    }
    @When("^I click the add job$")
    public void I_click_add_job_menu() {
        browser.findElement(By.id("addjob")).click();
    }

    @When("^I click the applicantaccord$")
    public void I_click_applicantaccord() {
        browser.findElement(By.id("applicantaccord$")).click();
    }
    @When("^I click the applicant menu$")
    public void I_click_applicant_menu() {
        browser.findElement(By.id("applicantform")).click();
    }
    @When("^I enter the applicant \"([^\"]*)\"$")
    public void I_enter_applicant(String text) {
        browser.findElement(By.id("applicantinput")).sendKeys(text);
    }
    @When("^I click the add applicant$")
    public void I_click_add_applicant() {
        browser.findElement(By.id("addapplicant")).click();
    }


    @When("^I click the applicationAccord$")
    public void I_click_applicationAccord() {
        browser.findElement(By.id("applicationAccord")).click();
    }
    @When("^I click the appmenu$")
    public void I_click_appmenu() {
        browser.findElement(By.id("appmenu")).click();
    }
    @When("^I enter the appname \"([^\"]*)\"$")
    public void I_enter_appname(String text) {
        browser.findElement(By.id("appname")).sendKeys(text);
    }

    @When("^I select job$")
    public void selectJob(){
        Select select = new Select(browser.findElement(By.id("jobselect")));
        select.selectByIndex(0);
    }
    @When("^I select applicant$")
    public void selectApplicant(){
        Select select = new Select(browser.findElement(By.id("applicantselect")));
        select.selectByIndex(0);
    }

    @When("^I click the addapp$")
    public void I_click_addapp() {
        browser.findElement(By.id("addapp")).click();
    }


    @When("^I enter the coursename \"([^\"]*)\"$")
    public void I_enter_coursename(String text) {

        browser.findElement(By.id("coursename")).sendKeys(text);

    }

    @When("^I submit course$")
    public void I_submit_course() {

        browser.findElement(By.id("addcourse")).click();

    }

    @Then("^I see the title \"([^\"]*)\"$")
    public void I_see_as_munged_text(String text) {

        assertEquals(text, browser.getTitle());

    }
}
