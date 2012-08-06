import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
public class TestFrame extends CheckMethod{
	WebDriver driver;
	public TestFrame(WebDriver startdr)
	{

		driver = startdr;	 
		new Login(driver);
		try {Thread.sleep(mTime);}catch (InterruptedException e) {}
		mTime = Integer.parseInt(JOptionPane.showInputDialog("Delay는 얼마로 할까요?(100~300)"));
		try {
			Thread.sleep(mTime);
			String check = JOptionPane.showInputDialog("아무키나 눌러주세요(그만두려면 F 를 입력)");
			Thread.sleep(mTime);

			while(!check.equals("F")&&!check.equals("f")){
				switch(JOptionPane.showInputDialog("어떤 페이지 검사?(make,link,map,thema1,thema2,thema3,thema5)")){
				case "make":
					Thread.sleep(mTime);
					firstTap();
					break;
				case "link":
					Thread.sleep(mTime);
					linkPage();
					break;
				case "map":
					Thread.sleep(mTime);
					mapPage();
					break;
				case "thema1":
					Thread.sleep(mTime);
					homethemaPage1();
					break;
				case "thema2":
					Thread.sleep(mTime);
					homethemaPage2();
					break;
				case "thema3":
					Thread.sleep(mTime);
					homethemaPage3();
					break;
				case "thema5":
					Thread.sleep(mTime);
					homethemaPage5();
					break;
				default:
					delDriver();
					break;
				}
				check = JOptionPane.showInputDialog("아무키나 눌러주세요(그만두려면 F 를 입력)");
				if(check.equals("F")||check.equals("f")){
					delDriver();
					break;}
			}
		}catch(Exception e)
		{JOptionPane.showMessageDialog(null, e);}
	}
	public void firstTap(){
		clickAppId("info_left_menu", driver);
		SetText_firstTap tap = new SetText_firstTap(driver, stringPane("제목"), stringPane("회사명"), stringPane("설명"), boolPane("이메일 설정"), stringPane("이메일"), boolPane("전화번호 공개"), stringPane("지역번호"), stringPane("번호앞자리"), stringPane("번호뒷자리"));
		//		tap.delete();
	}
	public void linkPage(){
		SetLink link;
		if(boolPane("공개일자를 설정할까요?"))
			link = new SetLink(driver, stringPane("link의 제목입력"), stringPane("link주소 입력"),true, integerPane("년(4자리 2012부터 2021까지)"), integerPane("월"), integerPane("일"), integerPane("시"), integerPane("분"));
		else
			link = new SetLink(driver, stringPane("link의 제목입력"), stringPane("link주소 입력"), false);
		
		clickAppXpath("//a[@href='/apps/build/link/?app_id=323']",driver);
		
		//		link.delete();
	}
	public void rssPage(){
		clickAppXpath("//a[@href='/apps/build/rss/?app_id=323']",driver);
		SetRSS rss = new SetRSS(driver, stringPane("rss주소(http://붙여서)"));
		//		rss.delete();
	}
	public void mapPage(){
		clickAppXpath("//a[@href='/apps/build/map/?app_id=323']",driver);
		SetMap map = new SetMap(driver, stringPane("맵 이름"), integerPane("맵 번호"), stringPane("부가 주소"), stringPane("추가적인 주소"), boolPane("맵 공개 날짜"), integerPane("년(4자리 2012부터 2021까지)"), integerPane("월"), integerPane("일"), integerPane("시"), integerPane("분"));
		//		map.delete();
	}
	public void mcPage(){
		clickAppXpath("//a[@href='/apps/build/mc/?app_id=323']",driver);
		SetMC mc =  new SetMC(driver, stringPane("Site ID"), stringPane("Site Passward"), stringPane("Market ID"), stringPane("Market Passward"));
		//		mc.delete();
	}
	public void homethemaPage1(){
		clickAppXpath("//input[@name='icon512']", driver);
		int ccase = 3; 
		SetHomeThema1tab thema;
		switch (ccase = integerPane("몇번째 step을 하시겠습니까? 1 or 2")) {
		case 1:
			thema = new SetHomeThema1tab(driver, ccase, boolPane("이미지를 넣을까요?"), "C:/Program Files/eclipse/workspaceSelenium/image2.png");		
			break;
		case 2:
			thema = new SetHomeThema1tab(driver, ccase, integerPane("step2의 1~4type중 하나 선택"));
			break;
		default:
			break;
		}
	}
	public void homethemaPage2(){
		clickAppId("home_left_menu", driver);
		int ccase = 4; 
		SetHomeThema2tab thema;
		switch (ccase = integerPane("몇번째 step을 하시겠습니까? 1 ~ 3")) {
		case 1:
			thema = new SetHomeThema2tab(driver, ccase, boolPane("파일을 올릴까요?"),"C:/Program Files/eclipse/workspaceSelenium/image2.png");
			break;
		case 2:
			thema = new SetHomeThema2tab(driver, ccase, integerPane("appDesign 1~9"));
			break;
		case 3:
			thema = new SetHomeThema2tab(driver, ccase, integerPane("H"), integerPane("S"), integerPane("V"), integerPane("R"), integerPane("G"), integerPane("B"));

			break;
		default:
			break;
		}
	}
	public void homethemaPage3(){
		clickAppId("home_left_menu", driver);
		int ccase=4;
		SetHomeThema3tab thema;
		switch (ccase= integerPane("몇번째 step을 하시겠습니까? 1 ~ 3")) {
		case 1:
			thema = new SetHomeThema3tab(driver, ccase, integerPane("버튼의 모양은?(1 ~ 4)"), integerPane("버튼의 아이콘 액자는?(1 ~ 7)"));
			break;
		case 2:
			break;
		case 3:
			thema = new SetHomeThema3tab(driver, ccase, "C:/Program Files/eclipse/workspaceSelenium/image5.png");
			break;
		default:
			break;
		}
	}
	public void homethemaPage5()
	{
		clickAppId("home_left_menu", driver);
		SetHomeThema5tab thema = new SetHomeThema5tab(driver);
	}
	
	public void delDriver(){
		driver.close();
	}


	public String stringPane(String q){
		try{Thread.sleep(500);
		return JOptionPane.showInputDialog(q);
		}catch(Exception e){
			return "";
		}
	}
	public int integerPane(String q){
		try{Thread.sleep(500);
		return Integer.parseInt(JOptionPane.showInputDialog(q));}
		catch(Exception e){return 1;}

	}

	public boolean boolPane(String q){
		try{Thread.sleep(500);
		if(JOptionPane.showInputDialog(q+" (T or F)").equals("T")||JOptionPane.showInputDialog(q+" (T or F)").equals("t"))
			return true;
		else if(JOptionPane.showInputDialog(q+" (T or F)").equals("F")||JOptionPane.showInputDialog(q+" (T or F)").equals("f"))
			return false;
		else
			return false;
		}catch(Exception e){return false;}
	}
}
