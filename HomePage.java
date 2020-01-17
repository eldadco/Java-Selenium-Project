package com.seleniumProj;

import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class HomePage {

    private SeleniumInfraStructure seleniumInfra;

    public HomePage(SeleniumInfraStructure selenium)
    {
        this.seleniumInfra = selenium;
    }

    //The function navigate to home page
    public void openWebSite()
    {
        this.seleniumInfra.getUrl("http://automationpractice.com/index.php");

    }
    public void navigateToHomePage()
    {
        this.seleniumInfra.clickElement("xpath","//img[@class='logo img-responsive']",null);
    }

    public boolean validateNavigateToHomePage()
    {
        if(this.seleniumInfra.driver.getCurrentUrl().contains("index.php"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    //The function done search according to the input(item)
    public void search(String item)
    {
        this.seleniumInfra.write("id","search_query_top",null,item);
        this.seleniumInfra.clickElement("xpath","//*[@id='searchbox']//button",null);
    }

    //The funtion will return the results list
    public List<WebElement> getResultsList()
    {
        List<WebElement>resultsList =this.seleniumInfra.findElementListBy("xpath", "//ul[@class='product_list grid row']//div[@class='product-container']");
            return resultsList ;
    }

    // The function will return true if all the results are match to the input and false if not.
    private Boolean isResultsCounterCorrect()
    {
        int numOfResults = this.getResultsList().size();
        String resultsCounter = this.seleniumInfra.getTextFromElement("xpath","//span[@class='heading-counter']",null);
        resultsCounter = resultsCounter.substring(0,1);
        if(Integer.toString(numOfResults).equals(resultsCounter))
        {
            System.out.println("The results counter is correct \n The number of the results is : "+resultsCounter);
            return true;
        }
        else
        {
            System.out.println("The results counter is not correct");
            return false;
        }
    }

    //The function return the search results title
    private String getSearchTitle() {
        try {
            String result = this.seleniumInfra.getTextFromElement("xpath", "//*[@id='center_column']//*[@class='lighter']", null);
            return result;
        }

        catch (Exception excep) {
            System.out.println("Home page exception" + " " + excep.getMessage());
                return " ";
        }
    }

        //The function will return true if all the results are match to the item // ask if it need to be in the page/test?
        private Boolean isResultsContentCorrect(String item)
        {
            List<WebElement> resultsList = this.getResultsList();
            System.out.println(resultsList.size());

            for (WebElement a : resultsList) {
                System.out.println("\n" + a.getText());
                if (a.getText().toLowerCase().contains(item.toLowerCase()))
                {
                    continue;

                }
                else
                {
                   return false;
                }
            }
            return true;

        }


    public Boolean validateSearch(String input)
    {
        int trueCounter=0;
        String item=input;
        input=input.toLowerCase();
        input='"'+input+'"';
        if(input.equals(this.getSearchTitle().toLowerCase()))
        {
            System.out.println(Color.green+"The search results title is match to the input");
            trueCounter++;
        }
        else
        {
            System.out.println(Color.red+"The search results title is not match to the input "+ input +" != "+this.getSearchTitle().toLowerCase());

        }

        if(this.isResultsCounterCorrect())
        {

//            System.out.println(Color.green+"The results counter is correct");
            trueCounter++;
        }
        else
        {
            System.out.println(Color.green+"The results counter is not correct");
        }


        if(this.isResultsContentCorrect(item))
        {

            System.out.println(Color.green+"All the results are correct and match to the input");
            trueCounter++;
        }
        else
        {
            System.out.println(Color.red+"There is results that does not match to the input");

        }


        if(trueCounter == 3)
        {

                return true;
        }
        else
        {
            return false;
        }
    }
}











