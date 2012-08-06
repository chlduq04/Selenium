import java.io.File;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckMethod {
	int mTime = 300;

	//WebDriver driver = new InternetExplorerDriver();

	public boolean equalCheck(String arge0,String arge1)
	{
		if(arge0.equals(arge1))
			return true;
		else
			return false;
	}
	public void fileupLoadxpath(File file,String xpath,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebDriverWait a = new WebDriverWait(driver, 4);
			WebElement ele = driver.findElement(By.xpath(xpath));
			ele.click();
			Thread.sleep(2500
					
					);
			ele.sendKeys(file.getAbsolutePath());
			a = new WebDriverWait(driver, 3);
		}catch(Exception e){}
	}

	public void clickAppXpath(String xpath,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.xpath(xpath));
			ele.click();
		}catch(Exception e){}
	}
	public void makeAppXpath(String xpath,String text,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.xpath(xpath));
			ele.sendKeys(text);
		}catch(Exception e){}
	}
	public String checkAppXpath(String xpath,WebDriver driver){
		try{ Thread.sleep(mTime);

			WebElement ele = driver.findElement(By.xpath(xpath));
			return ele.getText();
		}catch(Exception e){//JOptionPane.showMessageDialog(null, e);
		return "";}
	}
	public void deleteAppXpath(String xpath,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.xpath(xpath));
			ele.clear();
		}catch(Exception e){}
	}

	public void clickAppId(String id,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.id(id));
			ele.click();
		}catch(Exception e){}

	}
	public void makeAppId(String id,String text,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.id(id));
			ele.sendKeys(text);
		}catch(Exception e){}
	}
	public String checkAppId(String id,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.id(id));
			return ele.getText();
		}catch(Exception e){//JOptionPane.showMessageDialog(null, e);
		return "";}
	}
	public void deleteAppId(String id,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.id(id));
			ele.clear();
		}catch(Exception e){}
	}

	public void clickAppTag(String tag,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			ele.click();
		}catch(Exception e){}
	}
	public void makeAppTag(String tag,String text,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			ele.sendKeys(text);
		}catch(Exception e){}
	}
	public String checkAppTag(String tag,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			return ele.getText();
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, e);
		return "";}
	}
	public void deleteAppTag(String tag,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			ele.clear();
		}catch(Exception e){}
	}


	public void clickAppClass(String tag,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			ele.click();	
		}catch(Exception e){}
	}	
	public void makeAppClass(String tag,String text,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			ele.sendKeys(text);
		}catch(Exception e){}
	}
	public String checkAppClass(String tag,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			return ele.getText();
		}catch(Exception e){//JOptionPane.showMessageDialog(null, e);
		return "";}
	}
	public void deleteAppClass(String tag,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.tagName(tag));
			ele.clear();
		}catch(Exception e){}
	}

	public void clickAppName(String name,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.name(name));
			ele.click();
		}catch(Exception e){}
	}	
	public void makeAppName(String name,String text,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.name(name));
			ele.sendKeys(text);
		}catch(Exception e){}
	}
	public String checkAppName(String name,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.name(name));
			return ele.getText();
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}
	public void deleteAppName(String name,WebDriver driver){
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.name(name));
			ele.clear();
		}catch(Exception e){}
	}



	public String errDetectionId(String id,WebDriver driver)
	{
		try{ Thread.sleep(mTime);
			WebElement ele = driver.findElement(By.id(id));
			return ele.getText();
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, e);
		return "";
		}
	}
	public void nowLoading(){
		JOptionPane.showMessageDialog(null, "현재 준비중입니다.");
	}
	/*
	public ExpectedCondition<WebElement> textIsPresent(final String text){
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver){
				List<WebElement> allLinks = driver.findElements(By.tagName("a"));
				for(WebElement link : allLinks){
					if(link.getText().contains(text)){
						return link;
					}
				}
				return null;
			}
		};
	}
	 */
}
