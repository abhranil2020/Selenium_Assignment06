package assignment.java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Webpagescreenshot {
		
	WebDriver driver;	
	
    @Parameters("Path")
	@Test
	public void Webelementscreenshot(String Path) throws IOException
	{
		 		
		 List <WebElement> listofItems = driver.findElements(By.xpath(".//img[starts-with(@class,'image')]"));
		 URL imageURL = null;
		 String imageName = "Image";		        
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 		     
		 
		        for(int i = 0; i < listofItems.size(); i++){
		            try {		              	                
		                String j = listofItems.get(i).getAttribute("src");                
		                System.out.println("link  :"+i+ "  " +listofItems.get(i).getAttribute("src"));	
		                
		                imageURL = new URL(j);	                
		                BufferedImage saveImage = ImageIO.read(imageURL);

		                //download image to the workspace where the project is, save picture as picture.png (can be changed)		               		                		               		                
		                File outputfile = new File( Path + imageName + i + dateName + ".png");		        
		                ImageIO.write(saveImage, "png",outputfile);
		                
		            } catch (IOException e) {
		                e.printStackTrace();
		
		            }
		        }
				 
	}
	

    @Parameters("Url")
	@BeforeMethod
	public void setUp(String Url)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium_Assignment6\\Driver\\chromedriver.exe");
		driver  = new ChromeDriver();			
		driver.get(Url);
		driver.manage().window().maximize();		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
    }
		
}	
	



