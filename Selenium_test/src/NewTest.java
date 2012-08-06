

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.TestException;

public class NewTest {
	static WebDriver driver;
	public static void main(String[] args) {
		testEX();
		new TestFrame(driver);
	}
	public static void testEX(){
		String WhatEX = JOptionPane.showInputDialog("i.e. : i, chrome : ch");
		if(WhatEX.equals("i")||WhatEX.equals("ch")){
			switch(WhatEX){
			case "i":
				driver = new InternetExplorerDriver();
				break;
			case "ch":
				driver = new ChromeDriver();
				break;
			default:
				break;
			}
		}
		else
			JOptionPane.showMessageDialog(null, "정확이 입력하세요");
	}
}