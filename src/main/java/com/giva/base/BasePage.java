package com.giva.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;;

public class BasePage {
    public static WebDriver driver;
    public static Properties properties;


   public static Logger logger= Logger.getLogger(BasePage.class);

    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\DELL\\IdeaProjects\\GivaPageDesign\\test_output\\ExtentReport.html");

    public BasePage (){
        this.driver = driver;
        PageFactory.initElements(driver,this);

        PropertyConfigurator.configure("C:\\Users\\DELL\\IdeaProjects\\GivaPageDesign\\resources\\Log4j.properties");

        try {

            properties = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\DELL\\IdeaProjects\\GivaPageDesign\\src\\main\\java\\com\\giva\\config\\Config.properties");
            properties.load(file);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }




    public void initialize(){
        logger.info("Browser Name: " + properties.getProperty("browser"));
        String browserName= properties.getProperty("browser");

        driver = getDriver();
        logger.info("Application URL : "+ properties.getProperty("url"));
        logger.warn("This Log4j not support fatal,error methods.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }



    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }




}
