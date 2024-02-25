package com.globant.data;

import org.testng.annotations.DataProvider;

public class data {

    @DataProvider(name ="translateHello")
    public static Object [] [] inputData(){
        return new Object[][] {{"Hello"}, {"Hola"},{"Cia"}};
    }

    @DataProvider(name= "validUsers")
    public static Object [][] validUsers() {
        return new Object[][]{
                {"Hi", "3423432"}
        };
    }
}
