import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;


public class SetLink extends CheckMethod implements ActionsCheck{
	private String link,link_title;
	private String Dmonth,Dyear,Dday,Dhour,Dminute;
	private boolean check_date;
	private WebDriver driver;
	private String url_name_error;
	private String url_error;
	private String open_date_error;
	private boolean checkResult;
	public SetLink
	(WebDriver startdr ,String linkTitle,String link,boolean checkDate,int year,int month,int day,int hour,int minute){
		driver = startdr;
		this.link = link;
		link_title = linkTitle;
		check_date = checkDate;
		Dmonth = String.format("%02d",month);
		Dyear = ""+year;
		Dday = String.format("%02d", day);
		Dhour = String.format("%02d", hour);
		Dminute = String.format("%02d", minute);
		url_name_error = "未入力または入力内容に誤りがあります。";
		url_error = "未入力または入力内容に誤りがあります。";
		open_date_error = "未入力または入力内容に誤りがあります。";
		checkResult = false;
		start();
	}
	public SetLink(WebDriver startdr ,String linkTitle,String link,boolean checkDate){
		driver = startdr;
		this.link = link;
		link_title = linkTitle;
		check_date = checkDate;
		url_name_error = "未入力または入力内容に誤りがあります。";
		url_error = "未入力または入力内容に誤りがあります。";
		open_date_error = "未入力または入力内容に誤りがあります。";
		checkResult = false;
		start();		
	}

	@Override
	public void delete() {
		driver.close();
	}

	@Override
	public void start() {
		clickAppXpath("//a[@href='/apps/build/link/?app_id=323']",driver);
		clickAppXpath("//a[@href='javascript:void(0);']",driver);
		deleteAppXpath("//input[@class='w300']",driver);
		makeAppXpath("//input[@class='w300']", link_title,driver);
		deleteAppId("id_url",driver);
		makeAppId("id_url", link,driver);
		//clickAppXpath("//a[@href='/apps/build/link/?app_id=323']");
		if(check_date)
			clickAppId("open",driver);
		clickAppXpath("//select[@id = 'release_year']/option[@value='"+Dyear+"']",driver);
		clickAppXpath("//select[@id = 'release_month']/option[@value='"+Dmonth+"']",driver);
		clickAppXpath("//select[@id = 'release_day']/option[@value='"+Dday+"']",driver);
		clickAppXpath("//select[@id = 'release_hour']/option[@value='"+Dhour+"']",driver);
		clickAppXpath("//select[@id='release_minute']/option[@value='"+Dminute+"']",driver);
		clickAppId("btn_link_save",driver);
		
	//	JOptionPane.showMessageDialog(null, checkError()+" error detected : "+checkResult);
	}

	@Override
	public String checkError() {
		String result = "Another error : ";
		// TODO Auto-generated method stub
		if(link_title.equals("")){
			if(url_name_error.equals(checkAppXpath("//p[@id='invalid_title']/span", driver)))
				checkResult = true;
			else
				result += "url_name";
		}
		if(link.equals("")){
			if(url_error.equals(checkAppXpath("//p[@id='invalid_url']/span", driver)))
				checkResult = true;
			else
				result += "url";
		}
		if(check_date==true){
			if(Dyear.equals("")||Dmonth.equals("")||Dday.equals("")||Dhour.equals("")||Dminute.equals(""))
				if(checkAppXpath("//p[@id='invalid_date']/span", driver).equals(open_date_error))
					checkResult = true;
				else
					result += "date";
		}
		return result+" and ";
	}
}
