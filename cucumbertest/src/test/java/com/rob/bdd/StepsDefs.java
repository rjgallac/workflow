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

    @Given("^I wait$")
    public void I_wait() throws InterruptedException {
        browser.wait();
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
    @Then("I see google")
    public void assert_google(){
        assertEquals("Google", browser.getTitle());
    }

    @When("^I click the course menu link$")
    public void I_click_course_menu() {

        browser.findElement(By.id("coursemenu")).click();

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
