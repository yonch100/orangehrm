package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PruebaNG {
  
	
	
	//Se inicializan variables en la clase 
			//String url = "https://www.facebook.com/";
			String url = "https://opensource-demo.orangehrmlive.com/";
			String explorador = "chrome";
			
			WebDriver driver;
		
		//Creacion del objeto de la clase "metodosComunes.java"
			metodosComunes metodoComun1 = new metodosComunes();
		
	  
			
			
			
			
			
			
		@BeforeTest
	  public void abrirExplorador() {
			
		//Se llama al metodo inicializarExplorador del objeto metodocomun1 de la clase metodo comun, pasandole las variables url y explorador
		 driver = metodoComun1.inicializarExplorador(url, explorador);
			
	  }//Cierra @Test
  

		
		
		
		
		
		@Test
		public void metodosJS(){
			
			//ingresa texto en los textboxes
			WebElement txt_userName = driver.findElement(By.id("txtUsername"));
			metodoComun1.ingresarTexto(txt_userName, "Admin");
			
			WebElement txt_password = driver.findElement(By.id("txtPassword"));
			metodoComun1.ingresarTexto(txt_password, "admin123");
			
			//Da clic en el boton login
			WebElement boton1 = driver.findElement(By.id("btnLogin"));
			metodoComun1.clicBoton(boton1);
		}
  
  
  
  
}
