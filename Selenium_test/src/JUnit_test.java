
import static org.junit.Assert.*;

import javax.swing.JOptionPane;
import mx4j.tools.config.DefaultConfigurationBuilder.New;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class JUnit_test{
	//SetText_firstTapTest testMakeApp;
	/*driver, �� �̸�, ����ȸ��, ����, �̸����� ���� ���ΰ�(true or false), �����ּ�, ��ȭ�� ���� ���ΰ�(true or false), ��ȭ��ȣ ����,��ȭ ��,��ȭ ��*/
	//SetRSS testRss;
	/*driver, url�ּ� */
	//SetMC testMC;
	/*driver , ����Ʈ ���̵�, ����Ʈ �н�����, ���� ���̵�, ���� ���*/
	//SetMap testMap;
	/*driver, ������ ���� �̸�, �� ��ġ�� �� �ּ�(integer), �� ��ġ�� �ΰ����� �ּ�(String), ���� �ּ�(String), �� ��¥ ����(true or false), �⵵(4), ��(2), ��(2), �ð�(2), ��(2)*/
	//SetLink testLink;
	/*driver, ��ũ �̸�, ��ũ �ּ�, ���� ���� (true or false), �⵵(4), ��(2), ��(2), ��(2), ��(2)*/
	/*
	public JUnit_test(){
		testEX();
		//testTab();
		Login login = new Login(driver);
	}
	*/
	/*
	public void testEX(){
		String WhatEX = JOptionPane.showInputDialog("i.e. : i, chrome : ch");
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
	*/
	public void testTab(){
		String WhatTab = JOptionPane.showInputDialog("rss,link,mc,map,twitter");
		switch (WhatTab) {
		case "rss":
			break;
		case "link":
			break;
		case "mc":
			break;
		case "twitter":
			break;
		case "map":
			break;
		default:
			break;
		}
	}
	/*
	@Test
	public void test1(){
		//SetLink a =new SetLink(driver,"dsfasdfsafsafasfasfdasfsadfasdfasfasfasdfsafddasfsaffsafasfddfasdfkasjhfkhekjsahfhasjhfasashlasjhdkfasdhlsadhflkasdfjhlaskjhdflasasfsafdasfdasfsadfsafsadf", "http://naver.com", true, 2012, 10, 30, 4, 5);
		//assertEquals("","");
		SetMap a =new SetMap(driver, "�츮��%��¥�̻�1", 41, "�ֿ�", "�츮��dfas@$��dkgkgk", true, 2013,12, 1,4, 3);
		a = new SetMap(driver, "�츮��%��¥�̻�2", 41, "�ֿ�", "�츮��dfas@$��dkgkgk", true, 2014,11, 2,5, 14);
		a = new SetMap(driver, "�츮��%��¥�̻�3", 41, "�ֿ�", "�츮��dfas@$��dkgkgk", true, 2015,10, 3,6, 25);
		a = new SetMap(driver, "�츮��%��¥�̻�4", 41, "�ֿ�", "�츮��dfas@$��dkgkgk", true, 2015,10, 3,6, 25);
	}*//*
	@Test
	public void test2(){
		SetHomeThema1tab a = new SetHomeThema1tab(driver, "C:/Program Files/eclipse/workspaceSelenium/image2.png", 2);
		a.delete();
	}*/
}

/* ���� ��� ��
new SetRSS(driver, "http://naver.com");	
new SetRSS(driver, "http://kr.rss.news.yahoo.com/");
new SetTwitter(driver, "");
new SetLink(driver, "dsfasdfsafsafasfasfdasfsadfasdfasfasfasdfsafddasfsaffsafasfddfasdfkasjhfkhekjsahfhasjhfasashlasjhdkfasdhlsadhflkasdfjhlaskjhdflasasfsafdasfdasfsadfsafsadf", "http://naver.com", true, 2012, 10, 30, 4, 5);
 */