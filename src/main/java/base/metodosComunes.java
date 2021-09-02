package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class metodosComunes {
	
	
	//VARIABLES DE CLASE
		WebDriver driver;
		WebElement element, element1;
		
		
		
		/**
		 * @Descripcion_Del_Metodo Este metodo abre 1 explorador entre Chrome, Firefox o Edge
		 * @Autor Jorge omar Hernandez Flores - Yonch100
		 * @Fecha de creacion: Martes 31 Agosto 2021
		 * 
		 * @param url
		 * @param explorador
		 * @return driver
		 * @exception NA
		 * 
		 */
		  public WebDriver inicializarExplorador(String url, String explorador) {	  
			  
			  switch (explorador) {

			  case "chrome":

				//Web Driver
				JOptionPane.showMessageDialog(null, "Se abrira Chrome");
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
				
				//Se crea objeto driver1 de la clase chromedriver
				ChromeOptions chromeOption = new ChromeOptions();
				
				chromeOption.addArguments("--incognito");
				//chromeOption.addArguments("--start-maximized");
				driver = new ChromeDriver(chromeOption);
				driver.get(url);
				  
				break; //Cierra el CASE1
				  
				//----------------------------------------------------------------------------------------------
			
			  case "gecko":
				
				//Web Driver
				JOptionPane.showMessageDialog(null, "Se abrira Firefox");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver\\geckodriver.exe");
					
				//Se crea objeto driver1 de la clase chromedriver
				FirefoxOptions fireFoxOption = new FirefoxOptions();
								
				fireFoxOption.addArguments("--incognito");
				fireFoxOption.addArguments("--start-maximized");
				driver = new FirefoxDriver(fireFoxOption);
				driver.get(url);
				
				  break;
				
				//----------------------------------------------------------------------------------------------
				  
			  case "edge":
					
				JOptionPane.showMessageDialog(null, "Se abrira edge");
				//Web Driver
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\msndgedriver\\msndgedriver.exe");
						
				//Se crea objeto driver1 de la clase chromedriver
				EdgeOptions edgeOption = new EdgeOptions();
					
				edgeOption.addArguments("--incognito");
				edgeOption.addArguments("--start-maximized");
				driver = new EdgeDriver(edgeOption);
				driver.get(url);
					
				  break;
			  
			  }//Cierre del switch
			    
			  setDriver(driver);
			  
			  return driver;
			
		  } // llave del primero metodo
		
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Realiza un scroll por medio de la clase Action
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement
			 * @return NA
			 * @exception NA
			 *
			 */
		  public void scroll1(WebElement element) {

			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("->")[1] +"</b>", true);
			 
		  }
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo realiza un scroll por medio de Javascript
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param Webelement
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void scrollJS(WebElement element) {
			  JavascriptExecutor JSE = (JavascriptExecutor) driver;
			  JSE.executeScript("arguments[0].scrollIntoView(true);", element);
			  
			  //En caso de encontrar o no el web element mostrara en NEGRITAS el XPATH o el locator
			  Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("->")[1] +"</b>", true);
			  //Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("By.")[0]+"</b>", true);
		  }
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo ingresa texto a un textbox
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @param String 
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void ingresarTexto(WebElement element, String texto) {
			  
			  element.clear();
			  scroll1(element);
			  element.sendKeys(texto);
			  Reporter.log("El texto a ingresar es: " + texto, true); //Linea para que sea visible en el reporte de ejecucion
		  }
		  

		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo valida si un elemento existe o no
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public boolean validarElementoExistente (WebElement element) {
			  
			  try {
				  element.getSize();
				  return true;
				  
			  } catch (NoSuchElementException e) {
				  return false;
			  }
		  
		  } //termina metodo validarElementoExistnte
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo muestra un nombre aleatoreamente de una lista
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param NA 
			 * @return String
			 * @exception NA
			 * 
			 */
		  public String textoAleatorio(){
				
				//Se crea un arreglo 
				String[] arregloString = new String[] {"Sergio", "Jesica", "Omar", "Irving", "carlos"};
				List <String> listaDeNombres = Arrays.asList(arregloString);
				
				Collections.shuffle(listaDeNombres);
				
				int index = new Random().nextInt(listaDeNombres.size() );
				
				String nombre = listaDeNombres.get(index);
				return nombre;
			}
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo genera un numero entero aleatorio
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param Int size
			 * @return String
			 * @exception NA
			 * 
			 */
		  public String numeroRandom (int size) {
			  
			  Random numeroRandom = new Random();
			  int numeroTemp = 0;
			  boolean flag = true;
			  
			  while (flag) {
				  numeroTemp = numeroRandom.nextInt();
				  
				  if(Integer.toString(numeroTemp).length() == size &&! Integer.toBinaryString(numeroTemp).startsWith("-") ) {
					 flag = false;
					 
				  } //fin del if
					  
			  }//fin del while
			  
			  return String.valueOf(numeroRandom);
			  
		  }

		  
		  

		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo genera un numero entero aleatorio
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param Int size
			 * @return String
			 * @exception NA
			 * 
			 */
		  public String numeroRandom2 (int size) {
			  
			  Random numeroRandom = new Random();
			  StringBuilder strbld = new StringBuilder();
			  
			  for (int i=0; i<size; i++) {
				  strbld.append(numeroRandom.nextInt(size) );
			  }//cierra for
			  
			  return strbld.toString();
			  
		  }//cierra metodo
		  
		  
		  
		  
		  
		  /**
		   * 
		   * @Descripcion_Del_Metodo Este metodo genera una fecha
		   * @Autor Jorge omar Hernandez Flores - Yonch100
		   * @Fecha de creacion: Martes 31 Agosto 2021
		   * 
		   * @param Int cantidadDias
		   * @return String fecha
		   * @exception NA
		   * 
		   */
		  public String generarFecha(int cantidadDias) {
			  
			  Date miFecha = new Date(); //Genera la fecha actual
			  DateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
			  Calendar calendario = Calendar.getInstance();
			  
			  
			  calendario.setTime(miFecha);
			  calendario.add(Calendar.DATE, cantidadDias);
			  miFecha = calendario.getTime();
			  
			  String fecha = formatoFecha.format(miFecha);
			  
			  return fecha;
		  }//cierra el metodo generarFecha
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo genera un screenshot para la evidencia del reporte mailable
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param NA
			 * @return NA
			 * @exception IOException
			 * 
			 */
		  public void takeScreenshot() throws IOException {
			  String path = System.getProperty("user.dir") + "\\test-output\\screenshot\\" + "screen.png";
			  
			  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(srcFile, new File(path) );
			  
			  Reporter.log("<br> <img src ='" + path +  "' height = '400' width = '400' /> </br>");
			  
		  }
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar un clic a un elemento web
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void clicBoton (WebElement element) {
			  	element.click();
		  }
		  
		  
		  
		  
		  
		 
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar un clic a un elemento web por medio de JS
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void clicJS (WebElement element) {
			  JavascriptExecutor JSE = (JavascriptExecutor) driver;
			  JSE.executeScript("arguments[0].click();", element);
			  Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("->")[1] +"</b>", true);
			
		  } //Cierra clic
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar un clic a un elemento web
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param String url
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void navegarURL(String url) {
			  driver.navigate().to(url);
			  
			  //Linea para saber que url fue abierta por medio de reporter
			  Reporter.log("El url fue abierta correctaemnte [ "+url+" ] ", true);
		  }
		  
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para setear un valor a la variable driver
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebDriver driver
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void setDriver(WebDriver driver) {
			  this.driver = driver;
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
} //Fin de la clase
