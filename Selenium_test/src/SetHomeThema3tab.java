import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.UploadFile;

import com.google.common.eventbus.DeadEvent;


public class SetHomeThema3tab extends CheckMethod implements ActionsCheck {
	private WebDriver driver;
	private int stepcase;
	private int type;
	private int shape;
	private File file;
	//step1
	public SetHomeThema3tab(WebDriver startdr,int step,int iconType,int iconShape){
		driver = startdr;
		stepcase = step;
		type = iconType%5;
		shape = iconShape%8;
		start();
	}
	//step2
	public SetHomeThema3tab(WebDriver startdr,int step){

		driver = startdr;
		stepcase = step;
		start();
	}
	//step3
	public SetHomeThema3tab(WebDriver startdr,int step,String iconAddress){
		driver = startdr;
		stepcase = step;
		file = new File(iconAddress);
		start();
	}

	@Override
	public void start() {
		clickAppId("home_left_menu", driver);
		clickAppXpath("//li[@id='home_icon']/a[@href='javascript:void(0);']", driver);		
		switch (stepcase) {
		case 1:

			if(type!=0)
				clickAppId("icon_set_set"+type, driver);
			clickAppXpath("//div[@id='home_icon_image_temp']//input[@type='submit']", driver);
			clickAppXpath("//img[@alt='"+shape+"']", driver);
			clickAppXpath("//div[@id='home_icon_base_temp']//input[@type='submit']", driver);				
			break;
		case 2:
			nowLoading();
			break;
		case 3:
			clickAppId("btn_arbitrary_graphic", driver);
			String uploadlist = "start";
			String deletelist = "start";
			boolean end = false;
			while(!end){
				JOptionPane.showMessageDialog(null, "올릴 곳을 고르시오");
				uploadlist = JOptionPane.showInputDialog("end(끝),del(삭제),board,album,punch,coupon,youtube,link,twitter,rss,guestbook,info,push,map,catalog");
				while(!uploadlist.equals("del")&&!uploadlist.equals("end"))
				{
					upload(uploadlist);
					JOptionPane.showMessageDialog(null, "올릴 곳을 고르시오");
					uploadlist = JOptionPane.showInputDialog("end(끝),del(삭제),board,album,punch,coupon,youtube,link,twitter,rss,guestbook,info,push,map,catalog");					
					if(uploadlist.equals("end")||uploadlist.equals("del")){
						deletelist = "start";
						break;
					}
				}
				if(uploadlist.equals("end")||deletelist.equals("end"))
					break;
				try {Thread.sleep(1500);} catch (InterruptedException e) {break;}
				JOptionPane.showMessageDialog(null, "삭제할 곳을 고르시오");
				deletelist = JOptionPane.showInputDialog("end(끝),up(삭제),board,album,punch,coupon,youtube,link,twitter,rss,guestbook,info,push,map,catalog");
				while(!deletelist.equals("up")||!deletelist.endsWith("end"))
				{
					del(deletelist);
					JOptionPane.showMessageDialog(null, "삭제할 곳을 고르시오");
					deletelist = JOptionPane.showInputDialog("end(끝),up(수정),board,album,punch,coupon,youtube,link,twitter,rss,guestbook,info,push,map,catalog");
					if(deletelist.equals("end")||deletelist.equals("up")){
						uploadlist = "start";
						break;}
				}
				if(uploadlist.equals("end")||deletelist.equals("end"))
					break;
			}


			//	clickAppXpath(xpath, driver)
			break;
		default:
			break;
		}
	}
	public void upload(String input){//board, album, punch, coupon, youtube, link, twitter, rss, guestbook, info, push, map, catalog
		fileupLoadxpath(file, "//form[@action='/apps/post/custom_icon/?app_id=323&type="+input+"']//input[@name='image']", driver);
		clickAppXpath("//form[@action='/apps/post/custom_icon/?app_id=323&type="+input+"']//td[@class='sppl10 vmiddle']", driver);
		try {Thread.sleep(2000);} 
		catch (InterruptedException e){}
	}
	public void del(String input){
		clickAppXpath("//form[@action='/apps/post/custom_icon/?app_id=323&type="+input+"']//input[@class='w50 tcenter btn busy-right']", driver);
		try {
			Thread.sleep(1500);
			Robot enter = new Robot();
			enter.keyPress(KeyEvent.VK_ENTER);
		} 
		catch (InterruptedException e){}
		catch(AWTException e1){}
	}		//
	@Override
	public void delete() {
		driver.close();
	}

	@Override
	public String checkError() {
		String Result = "Another error : ";
		return Result;
	}
}
