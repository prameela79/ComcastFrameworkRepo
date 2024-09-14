package pactrice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
		driver.findElement(By.id("nav-search-submit-button")).click();

		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\al.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("amazon4");

		List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//wb.close();

		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		for (int i = 0; i < productNames.size(); i++) 
		{
			sh.createRow(i).createCell(0).setCellValue(productNames.get(i).getText());
			System.out.println(productNames.get(i).getText()+"\t"+prices.get(i).getText());
			sh.getRow(i).createCell(1).setCellValue(prices.get(i).getText());
	        
		}
		Sheet sh1 = wb.getSheet("amazon4"); 
		int rowcount = 0;
		Sheet sh2 = wb.createSheet("amazon5");
		try {
		for (int i = 0; i < productNames.size(); i++) {
            String price = prices.get(i).getText();
            int priceint = Integer.parseInt(price.replace(",", ""));
            if (priceint > 30000) {
            	sh2.createRow(rowcount).createCell(0).setCellValue(productNames.get(i).getText());
    			System.out.println(productNames.get(i).getText()+"\t"+prices.get(i).getText());
    			sh2.getRow(rowcount).createCell(1).setCellValue(prices.get(i).getText());
    			rowcount++;
            }
            }
        }
		catch(Exception e) {}
        
		FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\Desktop\\al.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();

	}


	

	}


