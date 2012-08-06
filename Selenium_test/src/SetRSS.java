import javax.swing.JOptionPane;

import org.apache.regexp.recompile;
import org.openqa.selenium.WebDriver;


public class SetRSS extends CheckMethod implements ActionsCheck{
	private String url;
	private WebDriver driver;
	private String empty_url_error;
	private String Rss_error;
	private boolean checkResult;
	public SetRSS(WebDriver startdr,String URL){
		url = URL;
		driver = startdr;
		checkResult = false;
		empty_url_error = "未入力または入力内容に誤りがあります。";
		Rss_error = "未入力または入力内容に誤りがあります。ご確認のうえ、保存し直してください。";
		start();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		clickAppXpath("//a[@href='/apps/build/rss/?app_id=323']",driver);
		deleteAppId("id_url",driver);
		makeAppId("id_url", url,driver);
		clickAppXpath("//input[@onclick='javascript:showPreview();']",driver);
		clickAppXpath("//input[@type='submit']",driver);
	//	JOptionPane.showMessageDialog(null, checkError()+" error detected : "+checkResult);
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public String checkError() {
		String Result = "Another error : ";
		if(url.length()==0)
			if(empty_url_error.equals(checkAppXpath("//p[@id = 'invalid_url']/span", driver)))
				checkResult = true;
			else
				Result += "rss_error";
		// TODO Auto-generated method stub
		return Result;
	}
}
 