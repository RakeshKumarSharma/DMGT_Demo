package com.mailtravel.utilities;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Setup extends DriverFactory {

    public static DriverFactory driver = new DriverFactory();

    @BeforeClass
    public static void setupDriver(){
        driver.initialiseDriver();
    }

    @AfterClass
    public static void destroyDriver(){
        if(DriverFactory.driver != null){
            DriverFactory.driver.quit();
            DriverFactory.driver = null;
        }
    }

}