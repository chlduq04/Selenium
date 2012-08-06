import javax.swing.JOptionPane;

import org.apache.xerces.impl.dv.xs.DayDV;
import org.openqa.selenium.WebDriver;


public class SetMap extends CheckMethod implements ActionsCheck{

	private String Map_name;
	private int Map_address_main;
	private String Map_address_sub;
	private String My_address;
	private boolean open_check;
	private String Dyear,Dmonth,Dday,Dhour,Dminute;
	private WebDriver driver;
	private String map_name_error = "未入力または入力内容に誤りがあります。ご確認のうえ、保存し直してください。";
	private String day_empty_error = "未入力または入力内容に誤りがあります。";
	private String map_title_error = "未入力または入力内容に誤りがあります。";
	private boolean checkResult;
	public SetMap(WebDriver startdr,String Mapname,int MapaddressMain,String MapaddressSub,String Youraddress,boolean day_open,int year,int month,int day,int hour,int minute){
		checkResult = false;
		driver = startdr;
		Map_name = Mapname;
		Map_address_main = 0;
		Map_address_main = MapaddressMain;
		Map_address_sub = MapaddressSub;
		My_address = Youraddress;
		open_check = day_open;
		Dmonth = String.format("%02d",month);
		Dyear = ""+year;
		Dday = String.format("%02d", day);
		Dhour = String.format("%02d", hour);
		Dminute = String.format("%02d", minute);
		start();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		clickAppXpath("//a[@href='/apps/build/map/?app_id=323']",driver);
		deleteAppXpath("//input[@name='title']",driver);
		makeAppXpath("//input[@name='title']",Map_name,driver);
		//clickAppId("pref",driver);
		clickAppXpath("//select[@name='pref']/option["+Map_address_main+"]",driver);
		deleteAppXpath("//input[@name='address1']",driver);
		makeAppXpath("//input[@name='address1']", Map_address_sub,driver);
		deleteAppXpath("//input[@name='address2']",driver);
		makeAppXpath("//input[@name='address2']", My_address,driver);
		if(open_check)
			clickAppId("open",driver);

		clickAppXpath("//select[@id = 'release_year']/option[@value='"+Dyear+"']",driver);
		clickAppXpath("//select[@id = 'release_month']/option[@value='"+Dmonth+"']",driver);
		clickAppXpath("//select[@id = 'release_day']/option[@value='"+Dday+"']",driver);
		clickAppXpath("//select[@id = 'release_hour']/option[@value='"+Dhour+"']",driver);
		clickAppXpath("//select[@id = 'release_minute']/option[@value='"+Dminute+"']",driver);
		clickAppId("btn_map_save",driver);
	//	JOptionPane.showMessageDialog(null, checkError()+" error id detected : "+checkResult);
	}

	@Override
	public void delete() {
		driver.close();
	}

	@Override
	public String checkError() {
		String result = "Another error : ";
		if(Map_name.equals("")&&Map_address_sub.equals("")){
			if(checkAppId("invalid_location", driver).equals(map_name_error))
				checkResult = true;
			else
				result += "name empty";
		}
		if(open_check==true){
			if(Dyear.equals("")||Dmonth.equals("")||Dday.equals("")||Dhour.equals("")||Dminute.equals("")){
				if(checkAppId("invalid_date", driver).equals(day_empty_error))
					checkResult = true;
				else
					result += "map day empty";
			}
		}
		if(Map_name.equals("")){
			if(checkAppXpath("//p[@id='invalid_title']/span", driver).equals(map_title_error))
				checkResult = true;
			else
				result += "title empty";
		}
		return result+" and ";
	}

}
