package com.giva.utils;

import com.giva.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Utility extends BasePage {


    public static void failedTest(String failcase) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\DELL\\IdeaProjects\\GivaPageDesign\\Screenshots\\" +failcase+ ".png");
        FileHandler.copy(srcFile, destFile);
    }



}
