package com.globant;

import com.globant.data.data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AppTest{

    private static final Logger log = LogManager.getLogger(AppTest.class);

    @Test(description = "Example Data Provider", dataProvider = "translateHello", dataProviderClass = data.class)
    public void hello(String data){
        log.info(data);
    }

    @Test
    @Parameters({"param1", "param2"})
    public void testWithParameters(String a, String b) {
        log.info(a);
        log.info(b);
    }

    @Test
    @Parameters({"param1", "param2"})
    public void testParameters(String a, String b){
        Assert.assertEquals(a, "FirstValue");
        Assert.assertEquals(b, "SecondValue");
    }

}