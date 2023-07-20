package com.trello.step_definitions;

import com.trello.utilities.ConfigurationReader;
import com.trello.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Hooks {

    @Before ("@wip and not @ignore")
    public void setUp() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().deleteAllCookies();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    /*
    @After("@ui and not @ignore")
    public void tearDown() {
        Driver.closeDriver();
    }

     */

    @Before("@wip")
    public void setUpApi(){
        baseURI = ConfigurationReader.get("baseUri");
    }

    @After("@wip")
    public static void destroy(){
        reset();
    }
}

