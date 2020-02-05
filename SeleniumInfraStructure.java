package com.seleniumProj;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.openmbean.ArrayType;
import javax.xml.xpath.XPath;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.InvalidSelectorException;
public class SeleniumInfraStructure {

    protected WebDriver driver;
    protected WebDriverWait waitForElems ;
    public SeleniumInfraStructure() {
        System.setProperty("webdriver.chrome.driver", "/home/liran/Documents/Bootcamp/JAVA/chromeDriver/chromedriver");
        this.driver = new ChromeDriver();
        this.waitForElems = new WebDriverWait(this.driver,40);

    }

    public void getUrl(String url) {
        try {
            this.driver.get(url);
            System.out.println("Selenium-infra success message:\t The requested site has opened successfully");
            this.driver.manage().window().maximize();
//            this.waitForElems.until(ExpectedConditions.invisibilityOfAllElements());

        } catch (Exception e) {
            System.out.println("Selenium-infra error : \t" + e.toString());
        }
    }

    public Boolean urlValidation(String url)
    {
        try {
            if (this.driver.getCurrentUrl().contains(url)) {
                System.out.println("SeleniumInfra succsess message : the current url is contain the url-param");
                return true;
            }
            else
            {
                System.out.println("SeleniumInfra failed message : the current url is not contain the url-param");
                return false;
            }

        }
        catch(Exception excep)
        {
            System.out.println("SeleniumInfra exception message : "+excep.toString());
          return false;
        }}




    public WebElement findElem(String locatorType, String locatorValue) {

        try {
            if (locatorType.equals("class")) {

                return this.driver.findElement(By.className(locatorValue));
            } else if (locatorType.equals("id")) {
                return this.driver.findElement(By.id(locatorValue));
            } else if (locatorType.equals("xpath")) {
                return this.driver.findElement(By.xpath(locatorValue));
            } else if (locatorType.equals("css")) {
                return this.driver.findElement(By.cssSelector(locatorValue));
            } else if (locatorType.equals("tag")) {
                return this.driver.findElement(By.tagName(locatorValue));
            } else {
                System.out.println("Selenium-infra error message:\tThe locator type is not correct");
            }
        }
        catch (InvalidSelectorException excep)
        {
            System.out.println("Selenium-infra error : \t"+ "invalid selector exception by locatorType: "+ locatorType + " and locator value : " + locatorValue);
        }
        catch (NoSuchElementException excep)
        {
            System.out.println("Selenium-infra error : No such Element Exception by locatorType: "
                    + locatorType + " and locator value : " + locatorValue);

        }
        catch(ElementNotVisibleException excep)
        {

            System.out.println("Selenium-infra error : element not visible exception by locatorType: "+ locatorType + " and locator value : " + locatorValue);
        }
        return null;

    }

    public List<WebElement> findElementListBy(String locatorType, String locatorValue)
    {

        try{

            if (locatorType.equals("class")) {
                return this.driver.findElements(By.className(locatorValue));
            } else if (locatorType.equals("id")) {
                return this.driver.findElements(By.id(locatorValue));
            } else if (locatorType.equals("xpath")) {
                return this.driver.findElements(By.xpath(locatorValue));
            } else if (locatorType.equals("css")) {
                return this.driver.findElements(By.cssSelector(locatorValue));
            } else if (locatorType.equals("tag")) {
                return this.driver.findElements(By.tagName(locatorValue));
            } else {
                System.out.println("Selenium-infra error message:\tThe locator type is not correct");
            }
        }
        catch (InvalidSelectorException excep)
        {
            System.out.println("Selenium-infra error : \t"+excep.toString());
        }
        catch (NoSuchElementException excep)
        {
            System.out.println("Selenium-infra error : \t"+excep.toString());

        }
        catch(ElementNotVisibleException excep)
        {

            System.out.println("Selenium-infra error : \t"+excep.toString());
        }
        return null;

    }


    public void write(String locatorType, String locatorValue,WebElement elem, String text)
    {
        try{
            if(elem == null) {
                elem = this.findElem(locatorType, locatorValue);
            }

        elem.sendKeys(text);
        System.out.println("Selenium-infra success message:\twriting text to the element");
    }
        catch(ElementNotVisibleException excep)
        {
            System.out.println("Selenium-infra error : \t"+excep.toString());
        }
    }


    public boolean isElementExists(String locatorType,String locatorValue)
    {
        if(this.findElem(locatorType,locatorValue)!=null)
        {
            System.out.println("The element has found successfully");
            return true;
        }
        else
        {
            return false;
        }
    }


    public void clickElement(String locatorType,String locatorValue,WebElement elem)
    {

        try{
            if(elem == null)
            {
                elem = this.findElem(locatorType , locatorValue);
            }
            elem.click();
            System.out.println("Selenium-infra success message:\tThe element was successfully clicked");
        }
        catch(ElementNotVisibleException excep)
        {
            System.out.println("Selenium-infra error : \t"+excep.toString());
        }
        catch(ElementNotSelectableException excep)
        {
            System.out.println("Selenium-infra error : \t"+excep.toString());
        }
    }

    public String getTextFromElement(String locatorType,String locatorValue,WebElement elem) {
        try {
            if (elem == null) {
                elem = this.findElem(locatorType, locatorValue);
            }
            String text = elem.getText();
            return text;
        } catch (Exception excep) {
            System.out.println("seleniumInfra error " + excep.toString());
            return "getTextFromElement function failed";
        }
    }



    public void close()
    {

        this.driver.close();
    }

}
