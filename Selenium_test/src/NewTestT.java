import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class NewTestT {

	WebDriver driver;
	public NewTestT(){
		testEX();
		Login login = new Login(driver);
	}
	public void testEX(){
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
	public void testPage()
	{}
	@Test
	public void test3()
	{
		//SetHomeThema2tab a =new SetHomeThema2tab(driver, "C:/Program Files/eclipse/workspaceSelenium/image2.png", 5, 20, 30, 40, 50, 60, 70);
		//a.delete();
		
		SetText_firstTap a = new SetText_firstTap(driver, "", "", "", true, "", true, "", "", "");
		SetText_firstTap b = new SetText_firstTap(driver, "name", "company", "dflkafklasfjaewjfawklfjioadsvjiwaejfivdifja;wefizsdjgoviawjefi;ja;esijfadjsfjlaskjflkaeljaewklfjaskldjfklasjdflkasjdfkljdsfklasjdlfk", true, "", false, "3", "","5");
		a.delete();
		b.delete();
	}
	@Test
	public void test4()
	{
		SetLink a = new SetLink(driver, "", "naver.com", true, 2012, 12, 3, 4, 5);
		SetLink b = new SetLink(driver, "akgkakgkak", "naver.com", true, 2012, 1, 1, 4, 16);
		SetLink c = new SetLink(driver, "title", "naver.com", false, 0, 12, 31, 11, 32);
		a.delete();
		b.delete();
		c.delete();
	}
}
