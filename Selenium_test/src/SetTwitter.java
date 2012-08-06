import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;


public class SetTwitter extends CheckMethod implements ActionsCheck{
	private String twitterid;
	private WebDriver driver;
	private boolean checkResult;
	private String Twitter_name_error;
	public SetTwitter(WebDriver startdr,String TwitterId){
		driver = startdr;
		twitterid = TwitterId;
		checkResult = false;
		Twitter_name_error = "未入力または入力内容に誤りがあります。";
		start();
	}
	@Override
	public void start(){
		clickAppXpath("//a[@href='/apps/build/twitter/?app_id=323']",driver);
		deleteAppId("twitter_id",driver);
		makeAppId("twitter_id", twitterid,driver);
		clickAppXpath("//input[@onclick='javascript:getTwitter();']",driver);
		clickAppXpath("//input[@type='submit']",driver);
		
		//JOptionPane.showMessageDialog(null, checkError()+"error detected"+checkResult);
	}
	@Override
	public void delete(){
		driver.close();
	}
	
	@Override
	public String checkError() {
		String Result = "Another error : ";
		// TODO Auto-generated method stub
		if(Twitter_name_error.equals(checkAppXpath("//p[@id='invalid_twitter']/span", driver)))
			checkResult = true;
		else
			Result += "twitter_name";
		return Result;
	}
}
