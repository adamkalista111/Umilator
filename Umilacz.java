package umilatorr;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;


public class Umilacz {


	String ErrCode=null;
	String imie;
	String nazwisko;
	String telefon;
	String mail;
	String status;
	String element;

	
	
	public String generateXPATH(WebElement childElement, String current) {
	    String childTag = childElement.getTagName();
	    if(childTag.equals("html")) {
	        return "/html[1]"+current;
	    }
	    WebElement parentElement = childElement.findElement(By.xpath("..")); 
	    List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
	    int count = 0;
	    for(int i=0;i<childrenElements.size(); i++) {
	        WebElement childrenElement = childrenElements.get(i);
	        String childrenElementTag = childrenElement.getTagName();
	        if(childTag.equals(childrenElementTag)) {
	            count++;
	        }
	        if(childElement.equals(childrenElement)) {
	            return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
	        }
	    }
	    return null;
	    
	    
	    
	    
	    
	    
	}
	public void  umilacz(ChromeDriver driver,String Alias,int Radio_Stan,boolean sprawdzanko) throws InterruptedException{	
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		driver.switchTo().defaultContent(); 
		wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-108")));
		driver.findElement(By.id("uifw-megamenu-108")).click();
		String zalogowanyjako = driver.findElement(By.className("switch")).getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-108-9081-9090")));
		driver.findElement(By.id("sitemap-108-9081-9090")).click();
		driver.switchTo().frame("idashboard"); 

		//wybranie aliasu 


		//wpisanie aliasu 

		
		
		
		
		
		
		if(Radio_Stan == 1) {		
			ErrCode="";
			wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_clearall")));	
			driver.findElement(By.id("lbl_CriteriaRadioOption10_GlobalUser_Option0")).click();
			System.out.println("alias");		
			driver.findElement(By.id("Criteria_Row10_UserIDUserAlias")).sendKeys(Alias);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("BottomSave")));
			driver.findElement(By.id("BottomSave")).click();		
			
			
		
			wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));	
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_Results")));
			
			
			try {					
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[aria-describedby='Results_Client_Definition']")));
				element = driver.findElement(By.cssSelector("td[aria-describedby='Results_Client_Definition']")).getText();
				//pobieranie danych uzytkownika
				imie = driver.findElement(By.cssSelector("td[aria-describedby='Results_First_Name']")).getText();
				nazwisko = driver.findElement(By.cssSelector("td[aria-describedby='Results_Last_Name']")).getText();
				telefon = driver.findElement(By.cssSelector("td[aria-describedby='Results_Telephone']")).getText();
				mail = driver.findElement(By.cssSelector("td[aria-describedby='Results_Email']")).getText();
				status = driver.findElement(By.cssSelector("td[aria-describedby='Results_User_Status_in_CAS']")).getText();

				if(element.equals(zalogowanyjako)) {
					ErrCode ="jestes juz tu zalogowany";
					System.out.println("jestes juz zalogowany");
					
					wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));
					driver.findElement(By.id("iconSpan_ReturntoServiceLookup")).click();			
					
					driver.switchTo().defaultContent();
				}
				else {
					driver.switchTo().defaultContent();


					wait.until(ExpectedConditions.elementToBeClickable(By.className("switch")));
					driver.findElement(By.className("switch")).click();

					driver.switchTo().frame("PopupWindow-iframe");

					TimeUnit.SECONDS.sleep(1);	
					wait.until(ExpectedConditions.elementToBeClickable(By.name("Criteria.ClientName")));
					

					driver.findElement(By.name("Criteria.ClientName")).sendKeys(element);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
					driver.findElement(By.id("Criteria_go")).click();

					wait.until(ExpectedConditions.elementToBeClickable(By.id("key")));
					driver.findElement(By.id("key")).click();
					ErrCode=" ";
					driver.switchTo().defaultContent(); 
					
					
					
					
					
					
					
					
					if(sprawdzanko == true) {
						
						TimeUnit.SECONDS.sleep(6);	
						driver.switchTo().defaultContent(); 		
						wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-108")));
						driver.findElement(By.id("uifw-megamenu-108")).click();
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-108-9009-9035")));
						driver.findElement(By.id("sitemap-108-9009-9035")).click();

						driver.switchTo().frame("idashboard"); 
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row1_LastActivityDate_PredicateDate")));
						driver.findElement(By.id("Criteria_Row1_LastActivityDate_PredicateDate")).clear();
						driver.findElement(By.id("Criteria_Row1_LastActivityDate_PredicateDate")).sendKeys("01/03/9999");
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row2_FirstName_FilterValue")));
						driver.findElement(By.id("Criteria_Row2_FirstName_FilterValue")).sendKeys(imie);
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row2_LastName_FilterValue")));
						driver.findElement(By.id("Criteria_Row2_LastName_FilterValue")).sendKeys(nazwisko);
					
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
						driver.findElement(By.id("Criteria_go")).click();
						
						
						
						
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[aria-describedby='Results_LastActivityDate']")));
						ErrCode = driver.findElement(By.cssSelector("td[aria-describedby='Results_LastActivityDate']")).getText();
						driver.switchTo().defaultContent(); 
						
					}
				
				}
			}

			catch(Exception e) {
				System.out.println(e);	
				ErrCode= "nie znalaz??em aliasu";
				System.out.println("nie znalaz??em aliasu");		
				driver.switchTo().defaultContent(); 




			}



		}		
		if(Radio_Stan == 2) {
			ErrCode="";

			wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_clearall")));	
			driver.findElement(By.id("lbl_CriteriaRadioOption10_GlobalUser_Option0")).click();
			try {
				System.out.println("tokena");				
				driver.findElement(By.id("Criteria_Row10_SafeWordID")).sendKeys(Alias);		
				wait.until(ExpectedConditions.elementToBeClickable(By.id("BottomSave")));
				driver.findElement(By.id("BottomSave")).click();	
				
				TimeUnit.SECONDS.sleep(3);	
				wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));	
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_Results")));
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[aria-describedby='Results_Client_Definition']")));
				element = driver.findElement(By.cssSelector("td[aria-describedby='Results_Client_Definition']")).getText();
				//pobieranie danych uzytkownika
				imie = driver.findElement(By.cssSelector("td[aria-describedby='Results_First_Name']")).getText();
				nazwisko = driver.findElement(By.cssSelector("td[aria-describedby='Results_Last_Name']")).getText();
				telefon = driver.findElement(By.cssSelector("td[aria-describedby='Results_Telephone']")).getText();
				mail = driver.findElement(By.cssSelector("td[aria-describedby='Results_Email']")).getText();
				status = driver.findElement(By.cssSelector("td[aria-describedby='Results_User_Status_in_CAS']")).getText();
				
				if(element.equals(zalogowanyjako)) {
					ErrCode ="jestes juz tu zalogowany";
					System.out.println("jestes juz zalogowany");		
					wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));
					driver.findElement(By.id("iconSpan_ReturntoServiceLookup")).click();			
					driver.switchTo().defaultContent();
				}
				else {
					driver.switchTo().defaultContent();


					wait.until(ExpectedConditions.elementToBeClickable(By.className("switch")));
					driver.findElement(By.className("switch")).click();

					driver.switchTo().frame("PopupWindow-iframe");

					TimeUnit.SECONDS.sleep(2);	
					wait.until(ExpectedConditions.elementToBeClickable(By.name("Criteria.ClientName")));
					


					driver.findElement(By.name("Criteria.ClientName")).sendKeys(element);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
					driver.findElement(By.id("Criteria_go")).click();

					wait.until(ExpectedConditions.elementToBeClickable(By.id("key")));
					driver.findElement(By.id("key")).click();
					ErrCode=" ";
					driver.switchTo().defaultContent(); 
					
					
					
					if(sprawdzanko == true) {
						
						TimeUnit.SECONDS.sleep(6);	
						driver.switchTo().defaultContent(); 		
						wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-108")));
						driver.findElement(By.id("uifw-megamenu-108")).click();
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-108-9009-9035")));
						driver.findElement(By.id("sitemap-108-9009-9035")).click();

						driver.switchTo().frame("idashboard"); 
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row1_LastActivityDate_PredicateDate")));
						driver.findElement(By.id("Criteria_Row1_LastActivityDate_PredicateDate")).clear();
						driver.findElement(By.id("Criteria_Row1_LastActivityDate_PredicateDate")).sendKeys("01/03/9999");
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row2_FirstName_FilterValue")));
						driver.findElement(By.id("Criteria_Row2_FirstName_FilterValue")).sendKeys(imie);
						
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row2_LastName_FilterValue")));
						driver.findElement(By.id("Criteria_Row2_LastName_FilterValue")).sendKeys(nazwisko);
					
						wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
						driver.findElement(By.id("Criteria_go")).click();
						
						
						
						
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[aria-describedby='Results_LastActivityDate']")));
						ErrCode = driver.findElement(By.cssSelector("td[aria-describedby='Results_LastActivityDate']")).getText();
						driver.switchTo().defaultContent(); 
						
					}
			
					
				}

				
				
				
				
				
			}

			catch(Exception b) {

				ErrCode= "nie znalaz??em tokena";
				System.out.println("nie znalaz??em tokena");		
				driver.switchTo().defaultContent(); 


			}
		}		

		if(Radio_Stan == 3) {
			ErrCode="";
			wait.until(ExpectedConditions.elementToBeClickable(By.id("CriteriaRadioOption2_AccountLookup2_Option0")));	
			driver.findElement(By.id("CriteriaRadioOption2_AccountLookup2_Option0")).click();

		try {
				int length = Alias.length();
				System.out.println("bazowka");				
				
				if(length<6) {
					do {			
						String s = Alias;
						s = "0" + s;
						System.out.println(s);
						//Alias = "0"+Alias;
						length++;			
						Alias = s;

						}while(length!=6);
				
				}
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row2_BaseNumber")));
				driver.findElement(By.id("Criteria_Row2_BaseNumber")).sendKeys(Alias);	
				wait.until(ExpectedConditions.elementToBeClickable(By.id("BottomSave")));
				driver.findElement(By.id("BottomSave")).click();			
				TimeUnit.SECONDS.sleep(3);	
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_Results")));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));			
				WebElement chuuj = driver.findElement(By.id("Results"));
				
				

						
				String bierz= "";
				int c=1; 
				
				do {
					
					chuuj = driver.findElement(By.id("Results"));
					c++;
					
					try {
						
					bierz = generateXPATH(chuuj.findElement(By.cssSelector("input[checked='checked']")), ""); 
					System.out.println(bierz);						
					c = 60;
					}
					catch(Exception b) {
						
											
						System.out.println("nie mam");	
						
					}
					
					TimeUnit.SECONDS.sleep(1);
					
				}


				while(c<60);
				
				String nazwa = bierz.replace("td[1]/input[1]", "td[2]"); ;				
				element = driver.findElement(By.xpath(nazwa)).getText();				
				if(element.equals(zalogowanyjako)) {
					ErrCode ="jestes juz tu zalogowany";
					System.out.println("jestes juz zalogowany");		
					
					wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));
					driver.findElement(By.id("iconSpan_ReturntoServiceLookup")).click();			
					
					driver.switchTo().defaultContent();
				}
				else {
					driver.switchTo().defaultContent();


					wait.until(ExpectedConditions.elementToBeClickable(By.className("switch")));
					driver.findElement(By.className("switch")).click();

					driver.switchTo().frame("PopupWindow-iframe");
									
					TimeUnit.SECONDS.sleep(1);	
					wait.until(ExpectedConditions.elementToBeClickable(By.name("Criteria.ClientName")));						
					driver.findElement(By.name("Criteria.ClientName")).sendKeys(element);
					
					wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
					driver.findElement(By.id("Criteria_go")).click();

					wait.until(ExpectedConditions.elementToBeClickable(By.id("key")));
					driver.findElement(By.id("key")).click();
					
					ErrCode=" ";
					driver.switchTo().defaultContent(); 
				}						
				



				driver.switchTo().defaultContent(); 

			}

		catch(Exception b) {
			driver.switchTo().defaultContent(); 
				ErrCode= "nie znalaz??em bazowki";
				System.out.println("nie znalaz??em bazowki");		
				
				}			
		}

		if(Radio_Stan == 4) {
			ErrCode="";
			wait.until(ExpectedConditions.elementToBeClickable(By.id("CriteriaRadioOption2_AccountLookup2_Option0")));	
			driver.findElement(By.id("CriteriaRadioOption2_AccountLookup2_Option0")).click();

			try {
				System.out.println("konto");					
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row2_AccountNumber")));
				
				
				
				if(Alias.length() >= 26)
				{	
					
					
					
				String bezspacji = Alias.replaceAll("\\s", "");
				
				
				
				String zespacjami =bezspacji.substring(0,2) + " " + String.join(" ", bezspacji.substring(2).split("(?<=\\G....)"));
				
				
				
				driver.findElement(By.id("Criteria_Row2_AccountNumber")).sendKeys(zespacjami);						
			}
				
				
				else { 
				
				driver.findElement(By.id("Criteria_Row2_AccountNumber")).sendKeys(Alias);		
				
				}
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("BottomSave")));
				driver.findElement(By.id("BottomSave")).click();	

				
				TimeUnit.SECONDS.sleep(3);										
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_Results")));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));				
				


				WebElement chuuj = driver.findElement(By.id("Results"));
				String bierz= "";
				int c=1; 
				
				do {
					chuuj = driver.findElement(By.id("Results"));
					c++;
					try {					
					bierz = generateXPATH(chuuj.findElement(By.cssSelector("input[checked='checked']")), ""); 
					System.out.println(bierz);						
					c = 60;
					}
					catch(Exception b) {
															
						System.out.println("nie mam");	
					}
					TimeUnit.SECONDS.sleep(1);
				}


				while(c<60);

				String nazwa = bierz.replace("td[1]/input[1]", "td[2]"); ;				
				element = driver.findElement(By.xpath(nazwa)).getText();
				
				if(element.equals(zalogowanyjako)) {
					ErrCode ="jestes juz tu zalogowany";
					
					System.out.println("jestes juz zalogowany");		
					
					wait.until(ExpectedConditions.elementToBeClickable(By.id("iconSpan_ReturntoServiceLookup")));
					driver.findElement(By.id("iconSpan_ReturntoServiceLookup")).click();			
					
					driver.switchTo().defaultContent();
				}
				else {
					driver.switchTo().defaultContent();


					wait.until(ExpectedConditions.elementToBeClickable(By.className("switch")));
					driver.findElement(By.className("switch")).click();

					driver.switchTo().frame("PopupWindow-iframe");

					wait.until(ExpectedConditions.elementToBeClickable(By.name("Criteria.ClientName")));			
					driver.findElement(By.name("Criteria.ClientName")).sendKeys(element);
					
					
					wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
					driver.findElement(By.id("Criteria_go")).click();

					wait.until(ExpectedConditions.elementToBeClickable(By.id("key")));
					driver.findElement(By.id("key")).click();
					
					ErrCode=" ";
					driver.switchTo().defaultContent(); 
				}						
				ErrCode=" ";
				driver.switchTo().defaultContent(); 





			}

		catch(Exception b) {
			driver.switchTo().defaultContent(); 
			System.out.println(b);
				ErrCode= "nie znalaz??em rachunku";
				System.out.println("nie znalaz??em rachunku");
				 }			
		}		
		
		
		
		
		
		
		
		

}
	
	




}