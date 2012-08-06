import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class SetText_firstTap extends CheckMethod implements ActionsCheck{

	private WebDriver driver;
	private static String length_error;
	private static String empty_error;
	private static String limit_error;
	private static String etc_error;
	private String name;
	private String copyright;
	private String desc;
	private String email;
	private String phone0;
	private String phone1;
	private String phone2;
	private boolean checkEmail;
	private boolean checkPhone;
	private boolean checkResult;
	public SetText_firstTap(WebDriver startdr,String name,String copyright,String desc,boolean check_email,String email,boolean check_phone,String phone0,String phone1,String phone2){	
		driver = startdr;
		this.name = name;
		this.copyright = copyright;
		this.desc = desc;
		this.email = email;
		this.phone0 = phone0;
		this.phone1 = phone1;
		this.phone2 = phone2;
		checkResult = false;
		checkEmail = check_email;
		checkPhone = check_phone;
		length_error = "未入力または入力内容に誤りがあります。";
		empty_error = "未入力または入力内容に誤りがあります。";
		etc_error = "未入力または入力内容に誤りがあります。ご確認のうえ、保存し直してください。";
		start();
	}
	@Override
	public void start() {
		clickAppId("info_left_menu", driver);
		// TODO Auto-generated method stub
		/*************************내용 적기**************************/
		deleteAppId("name", driver);
		makeAppId("name",name,driver);
		deleteAppId("copyright", driver);
		makeAppId("copyright",copyright,driver);
		deleteAppId("description", driver);
		makeAppId("description",desc,driver);
	
		
		try{
			WebElement m = driver.findElement(By.xpath("//input[@name='use_info_email']||//input[@CHECKED='']"));
			m.click();
		}catch(Exception e){}
		try{
			WebElement m = driver.findElement(By.xpath("//input[@name='use_info_tel']||//input[@CHECKED='']"));
			m.click();
		}
		catch(Exception e){}
		
	
		if(checkEmail)
			clickAppId("info_email",driver);
		deleteAppXpath("//input[@class='w280']", driver);
		makeAppXpath("//input[@class='w280']",email,driver);

		
		
		if(checkPhone)
			clickAppId("info_tel",driver);
		deleteAppId("tel0", driver);
		deleteAppId("tel1", driver);
		deleteAppId("tel3", driver);
		makeAppId("tel0",phone0,driver);
		makeAppId("tel1",phone1,driver);
		makeAppId("tel3",phone2,driver);

		/****************************실행****************************/

		//makeAppXpath("//input[@onclick='javascript:preview();']");

		try {Thread.sleep(mTime);}catch (InterruptedException e) {}
		clickAppXpath("//input[@type='submit']",driver);
		try {Thread.sleep(mTime);}catch (InterruptedException e) {}
		/****************************끝내고 지우기****************************/
//		JOptionPane.showMessageDialog(null, checkError()+" error detected : "+checkResult);
	}


	@Override
	public void delete() {
		driver.close();
	}


	@Override
	public String checkError() {
		String Result="Another error : ";
		checkResult = false;
		if(name.length()>12){
			if(length_error.equals(checkAppXpath("//p[@class='invalid_name error_subject']/span", driver)/*checkAppId("invalid_name", driver)*/))
				checkResult = true;
			else
				Result += "name_err    ";}
		if(name.length()==0){
			if(empty_error.equals(checkAppXpath("//p[@class='invalid_name error_subject']/span", driver)/*checkAppId("invalid_name", driver)*/))
				checkResult = true;
			else
				Result += "name_err    ";}
		if(copyright.length()==0){
			if(empty_error.equals(checkAppXpath("//p[@class='invalid_copyright error_subject']/span", driver)/*checkAppId("invalid_copyright", driver)*/))
				checkResult = true;
			else
				Result += "copy_right_err    ";}
		if(desc.length()==0){
			if(empty_error.equals(checkAppXpath("//p[@class='invalid_description error_subject']/span", driver)/*checkAppId("invalid_description", driver)*/))
				checkResult = true;
			else
				Result += "desc_err    ";}
		if(checkEmail==true&&email.equals("")){
			if(empty_error.equals(checkAppXpath("//p[@class='invalid_info_email error_subject']/span", driver)/*checkAppId("invalid_info_email", driver)*/))
				checkResult = true;
			else
				Result += "email_err    ";}
		if(checkPhone==true&&phone0.equals("")||checkPhone==true&&phone1.equals("")||checkPhone==true&&phone2.equals("")){
			if(empty_error.equals(checkAppXpath("//p[@class='invalid_info_tel error_subject']/span", driver)/*checkAppId("invalid_info_tel", driver)*/))
				checkResult = true;
			else
				Result += "phone_err    ";}
		if(!email.equals("")){
			if(!email.matches("@")&&!email.matches("."))
				checkResult = true;
			else
				Result += "email_syntex";}
		return Result+" and ";
	}
}

