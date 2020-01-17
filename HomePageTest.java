package com.seleniumProj;

import java.awt.*;

public class HomePageTest {
    private SeleniumInfraStructure seleniumInfra;
    private HomePage homePage;

    public HomePageTest()
    {
        this.seleniumInfra = new BaseClass().selenium;
        this.homePage = new HomePage(this.seleniumInfra);
        this.homePage.openWebSite();
    }

    public void navigateToHomePageTest()
    {
        this.homePage.navigateToHomePage();
        if(this.homePage.validateNavigateToHomePage())
        {
            System.out.println("Navigate To HomePage test => has passed");
        }
        else
        {
            System.out.println("Navigate To HomePage test => has failed");
        }

    }

    public Boolean searchTest()
    {
        this.homePage.search("Dress");
        if(this.homePage.validateSearch("Dress"))
        {
            System.out.println("validate search test has passed");
            return true;
        }
        else
        {
            System.out.println("validate search test has failed");
            return false;
        }
    }

    public void stabilitySearchTest() {
        int i = 0;
        Boolean flag = true;

        while (i < 10 && flag) {
            if (!this.searchTest()) {
                flag = false;
            }
            i++;
        }
        if (!flag)
        {
            System.out.println("Search Stability test => has Failed");

        }
        else
        {
            System.out.println("Search Stability test => has Passed");
        }

    }

}