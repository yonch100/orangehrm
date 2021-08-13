package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class metodosComunes {
	
	
	//VARIABLES DE CLASE
		WebDriver driver;
		
		
		

		  public void inicializarChrome(String url, String explorador) {	  
			  
			  switch (explorador) {
			  
			  
			  
			  case "chrome":
				  
				//Web Driver
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
				
				//Se crea objeto driver1 de la clase chromedriver
				ChromeOptions option = new ChromeOptions();
				
				option.addArguments("--incognito");
				option.addArguments("--start-maximized");
				driver = new ChromeDriver(option);
				driver.get(url);

				  
				break; //Cierra el CASE1
				  
				//----------------------------------------------------------------------------------------------
			
			  case "gecko":
				
				
				  break;
				
				//----------------------------------------------------------------------------------------------
				  
			  case "edge":
					
					
				  break;
			  
			  }
			  
			  
			//Web Driver
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Yonch100\\Documents\\zzz_Proyectos_eclipse\\Librerias\\chromedriver.exe");
					
			//Se crea objeto driver1 de la clase chromedriver
				chromeDriver = new ChromeDriver();
						
			//variable que almacenla una pagina web
			//String baseUrl = "http://demo.guru99.com/test/newtours/";
				String baseUrl = "https://www.google.com/";
				chromeDriver.get(baseUrl);
			  
		  } // llave del primero metodo
		
		
		

		  public void inicializarFireFox() {	  
			  
			//Web Driver
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Yonch100\\Documents\\zzz_Proyectos_eclipse\\Librerias\\geckodriver.exe");
					
			//Se crea objeto driver1 de la clase chromedriver
				geckoDriver = new ChromeDriver();
						
			//variable que almacenla una pagina web
			//String baseUrl = "http://demo.guru99.com/test/newtours/";
				String baseUrl = "https://www.google.com/";
				geckoDriver.get(baseUrl);
			  
		  } // llave del primero metodo
	
	

}
