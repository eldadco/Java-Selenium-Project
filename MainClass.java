package com.seleniumProj;

import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[]args) {
        HomePageTest homeTest = new HomePageTest();
        homeTest.searchTest("Dress");
        homeTest.navigateToHomePageTest();
        homeTest.negativeSearchTest();
//        homeTest.stabilitySearchTest();

    }
}
