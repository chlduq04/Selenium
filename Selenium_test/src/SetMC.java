import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;


public class SetMC extends CheckMethod implements ActionsCheck{

	private String siteid,sitepass,marketid,marketpass;
	private WebDriver driver;
	private boolean checkResult = false;
	private String market_error;
	private String site_error;
	public SetMC(WebDriver startdr,String siteId,String sitePass,String marketId,String marketPass){
		driver = startdr;
		siteid=siteId;
		sitepass = sitePass;
		marketid = marketId;
		marketpass = marketPass;
		market_error = "未入力または入力内容に誤りがあります。";
		site_error = "未入力または入力内容に誤りがあります。";
		start();
	}
	@Override
	public void start(){
		clickAppXpath("//a[@href='/apps/build/mc/?app_id=323']",driver);
		makeAppName("site_id",siteid ,driver);
		makeAppName("site_pass", sitepass,driver);
		makeAppName("shop_id",marketid,driver);
		makeAppName("shop_pass",marketpass,driver);
		clickAppXpath("//input[@type='submit']",driver);	
	//	JOptionPane.showMessageDialog(null, checkError()+" error id detected : "+checkResult);

	}
	@Override
	public void delete() {
		driver.close();
		// TODO Auto-generated method stub

	}
	@Override
	public String checkError() {
		// TODO Auto-generated method stub
		String Result="";
		checkResult = false;
//		if(name.length()>12)
//			if(length_error.equals(checkAppXpath("//p[@class='invalid_name error_subject']/span", driver)/*checkAppId("invalid_name", driver)*/))
//				checkResult = true;
//			else
//				Result += "name_err    ";
//		if(name.length()==0)
//			if(empty_error.equals(checkAppXpath("//p[@class='invalid_name error_subject']/span", driver)/*checkAppId("invalid_name", driver)*/))
//				checkResult = true;
//			else
//				Result += "name_err    ";
//		if(name.length()>12)
//			if(length_error.equals(checkAppXpath("//p[@class='invalid_name error_subject']/span", driver)/*checkAppId("invalid_name", driver)*/))
//				checkResult = true;
//			else
//				Result += "name_err    ";
//		if(name.length()==0)
//			if(empty_error.equals(checkAppXpath("//p[@class='invalid_name error_subject']/span", driver)/*checkAppId("invalid_name", driver)*/))
//				checkResult = true;
//			else
//				Result += "name_err    ";

		return Result;
	}
}
