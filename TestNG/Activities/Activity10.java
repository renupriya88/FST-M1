import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://v1.training-support.net/selenium/simple-form");
        System.out.println("Title of the page is : " + driver.getTitle());
    }

    public static List<List<Object>> readExcel(String filepath){
        List<List<Object>> data = new ArrayList<>();
        try{
            File file = new File(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            DataFormatter dataFormatter = new DataFormatter();

            for (Row row : sheet)
            {
                List<Object> rowData = new ArrayList<>();
                for(Cell cell : row)
                {
                    if (cell != null)
                    {
                        switch (cell.getCellType())
                        {
                            case STRING:
                                rowData.add(cell.getStringCellValue()); break;
                            case NUMERIC:
                                rowData.add(dataFormatter.formatCellValue(cell)); break;
                            case BOOLEAN:
                                rowData.add(cell.getBooleanCellValue()); break;

                        }

                    }
                }data.add(rowData);

            }
            workbook.close();

        }catch (IOException | InvalidFormatException e){
            throw new RuntimeException(e);
        }
        return data;
    }



    @DataProvider(name = "Excel")
    public static Object[][] excelData()
    {
        List<List<Object>> data = readExcel("C:\\Users\\02054I744\\Desktop\\Activity10.xlsx");
        return new Object[][]{{data.get(1)},
                {data.get(2)},
                {data.get(3)}};
    }

    @Test(dataProvider = "Excel")
    public void test1(List<Object> rows){
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement contactNumber = driver.findElement(By.xpath("//*[@id=\"number\"]"));

        firstName.clear();
        lastName.clear();
        email.clear();
        contactNumber.clear();

        firstName.sendKeys(rows.get(1).toString());
        lastName.sendKeys(rows.get(2).toString());
        email.sendKeys(rows.get(3).toString());
        contactNumber.sendKeys(rows.get(4).toString());

        driver.findElement(By.xpath("//*[@id=\"simpleForm\"]/div/div[6]/div[1]/input")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        driver.navigate().refresh();

    }




    @AfterClass
    public void close(){
        driver.close();
    }
}
