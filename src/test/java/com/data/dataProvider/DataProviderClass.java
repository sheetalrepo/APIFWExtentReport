package com.data.dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Data Provider class
 * 1. Will only be used when we are not reading data from csv file
 * 2. In case similar type of data required in bulk for a particular TC
 *
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class DataProviderClass {

    @DataProvider(name = "listOfUserPassword")
    public Object[][] listOfUserPasswordDP() {
        return new Object[][] {
                new Object[] { "user1@gmail.com", "Password#123" },
                new Object[] { "user2@gmail.com", "Password#123" },
                new Object[] { "user3@gmail.com", "Password#123" }
        };
    }

}
