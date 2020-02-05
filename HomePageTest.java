package com.seleniumProj;

import java.awt.*;

public class HomePageTest extends BaseClass {
    private HomePage homePage;

    public HomePageTest ()
    {

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

    public Boolean searchTest(String item)
    {
        this.homePage.search(item);
        if(this.homePage.validateSearch(item))
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

    public void negativeSearchTest() {
        if (!this.searchTest(" "))
        {
            System.out.println("Negative search test => has passed");

        }
        else
        {
            System.out.println("Negative search test => has failed");
        }

    }
    public void stabilitySearchTest() {
        int i = 0;
        Boolean flag = true;

        while (i < 10 && flag) {
            if (!this.searchTest("Dress")) {
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