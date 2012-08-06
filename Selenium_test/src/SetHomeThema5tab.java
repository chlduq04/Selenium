import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SetHomeThema5tab extends CheckMethod implements ActionsCheck{
	private WebDriver driver;
	private String[] index = {"home","board","album","punch","coupon","youtube","link","twitter","rss","guestbook","info","map","catalog"};
	private String list;

	private String addlist;
	private int checkIndex;
	private int checkAddItem;
	public SetHomeThema5tab(WebDriver startdr){
		driver = startdr;
		list = "";
		addlist = "";
		checkIndex = 0;
		checkAddItem = 0;
		start();
	}
	public String checkIndex(boolean nowInfo){
		int count=0;
		checkIndex=0;
		checkAddItem=0;
		list = "";
		addlist="";
		Vector<String> addItem = new Vector<String>(0,3);
		Vector<String> nowIndex = new Vector<String>(0,3);

		while(count<13){
			try{
				WebDriver ele = driver;
				ele.findElement(By.xpath("//input[@name='"+index[count]+"']"));
				nowIndex.add(index[count]);
				count++;
				checkIndex++;
			}
			catch(Exception e){
				addItem.add(index[count]);
				count++;
				checkAddItem++;
			}
		}

		for(int i=0;i<checkIndex;i++){
			list+=", "+nowIndex.elementAt(i);
		}
		for(int i=0;i<checkAddItem;i++){
			addlist += ", "+addItem.elementAt(i);
		}

		if(nowInfo)
			return list;
		else
			return addlist;
	}
	@Override
	public void start() {		
		clickAppId("home_menu",driver);
		String uploadlist = "";
		String uploadtext = "";
		String deletelist = "";
		String changelist = "start";
		String changetext= "";
		boolean end = false;
		while(!end){
			if(changelist.equals("start")){
				JOptionPane.showMessageDialog(null, "수정할 곳을 고르시오");
				changelist = JOptionPane.showInputDialog("end(끝),del(삭제),up(추가)"+checkIndex(true));
				if(changelist.equals("del")){
					deletelist="start";
					uploadlist="";
				}
				if(changelist.equals("up")){
					uploadlist = "start";
					deletelist="";
				}

				while(!changelist.equals("del")&&!changelist.equals("end")&&!changelist.equals("up"))
				{
					try {Thread.sleep(1000);} catch (InterruptedException e) {break;}
					changetext = JOptionPane.showInputDialog(uploadlist+"를 무엇으로 바꿀까요?");
					changeName(changelist,changetext);

					JOptionPane.showMessageDialog(null, "수정할 곳을 고르시오");
					changelist = JOptionPane.showInputDialog("end(끝),del(삭제),up(추가)"+checkIndex(true));					
					if(changelist.equals("end")||changelist.equals("del")){
						deletelist="start";
						uploadlist="";
						break;
					}
					if(changelist.equals("up")||changelist.equals("end")){
						uploadlist = "start";
						deletelist="";
						break;
					}
				}
			}

			if(uploadlist.equals("end")||deletelist.equals("end")||changelist.equals("end"))
				break;

			if(deletelist.equals("start")){
				try {Thread.sleep(1500);} catch (InterruptedException e) {break;}
				JOptionPane.showMessageDialog(null, "삭제할 곳을 고르시오");
				deletelist = JOptionPane.showInputDialog("end(끝),change(수정),up(추가)"+checkIndex(true));
				if(deletelist.equals("up")){
					uploadlist = "start";
					changelist="";
				}
				if(deletelist.equals("change")){
					changelist = "start";
					uploadlist="";
				}

				while(!deletelist.equals("up")||!deletelist.equals("end")||deletelist.equals("change"))
				{
					delName(deletelist);
					JOptionPane.showMessageDialog(null, "삭제할 곳을 고르시오");
					deletelist = JOptionPane.showInputDialog("end(끝),change(수정),up(추가)"+checkIndex(true));
					if(deletelist.equals("end")||deletelist.equals("up")){
						uploadlist = "start";
						changelist="";
						break;
					}
					if(deletelist.equals("end")||deletelist.equals("change")){
						changelist = "start";
						uploadlist="";
						break;
					}
				}
			}
			if(uploadlist.equals("end")||deletelist.equals("end")||changelist.equals("end"))
				break;

			if(uploadlist.equals("start")){
				String m = checkIndex(false);
				try {Thread.sleep(500);} catch (InterruptedException e) {break;}
				clickAppXpath("//a[@href='/apps/rest_components/?app_id=323']", driver);
				uploadlist = JOptionPane.showInputDialog("end(끝),change(수정),del(삭제)"+m);
				if(uploadlist.equals("del")){
					deletelist= "start";
					changelist="";
				}
				if(uploadlist.equals("change")){
					changelist = "start";
					deletelist = "";
				}

				while(!uploadlist.equals("up")||!uploadlist.equals("end")||uploadlist.equals("change"))
				{
					addName(uploadlist);
					m = checkIndex(false);
					try {Thread.sleep(500);} catch (InterruptedException e) {break;}
					uploadlist = JOptionPane.showInputDialog("end(끝),change(수정),del(삭제)"+m);
					if(uploadlist.equals("end")||uploadlist.equals("del")){
						deletelist= "start";
						changelist="";
						break;
					}
					if(uploadlist.equals("end")||uploadlist.equals("change")){
						changelist = "start";
						deletelist = "";
						break;
					}
					clickAppXpath("//a[@href='/apps/rest_components/?app_id=323']", driver);
				}
			}

			if(uploadlist.equals("end")||deletelist.equals("end")||changelist.equals("end"))
				break;
		}
		try {Thread.sleep(500);} catch (InterruptedException e) {}
		if(JOptionPane.showInputDialog("저장하시겠습니까?(Y or N)").equals("Y"))
			clickAppXpath("//form[@action='/apps/post/my_components/?app_id=323&target=components']//p[@class='sppt10']/input[@type='submit']", driver);
			
	}

	public void changeName(String arge,String text){
		deleteAppXpath("//input[@name='"+arge+"']", driver);
		makeAppXpath("//input[@name='"+arge+"']", text, driver);
	}
	public void delName(String arge){
		clickAppXpath("//li[@id='menu-"+arge+"']//td[@class='home_menu_delete']/a", driver);
		try {
			Thread.sleep(1000);
			Robot enter = new Robot();
			enter.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
		} catch (Exception e) {}
	}

	public void addName(String arge){
		clickAppXpath("//div[@id ='fancybox-content']//input[@name='"+arge+"']", driver);
		clickAppXpath("//div[@id ='fancybox-content']//p[@class='tright']/input[@onclick='javascript:add_components();']", driver);
	}
	@Override
	public void delete() {		
	}

	@Override
	public String checkError() {
		return null;
	}
}
