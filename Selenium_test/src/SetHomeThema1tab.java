import java.io.File;
import java.net.URL;

import javax.swing.JOptionPane;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.server.handler.UploadFile;

import com.thoughtworks.selenium.Selenium;

public class SetHomeThema1tab extends CheckMethod implements ActionsCheck{
	private WebDriver driver;
	private String img_add;
	private int app_type;
	private int app_type_limit;
	private int stepcase;
	private File file ;
	private boolean infile;
	private String image_error;
	private boolean checkResult;
	public SetHomeThema1tab(WebDriver startdr,int step,boolean inputfile,String imgAddress){
		image_error = "アップロードした画像は、ファイル形式または画像サイズに誤りがある、あるいは壊れています。";
		driver = startdr;
		stepcase = step%3;
		infile = inputfile;
		checkResult = false;
		img_add = imgAddress;
		file = new File(img_add);
		start();
	}
	public SetHomeThema1tab(WebDriver startdr,int step,int type){
		image_error = "アップロードした画像は、ファイル形式または画像サイズに誤りがある、あるいは壊れています。";
		driver = startdr;
		app_type_limit = 5;
		app_type = type % 5;
		if(app_type==0)
			app_type=1;

		stepcase = step%3;
		checkResult = false;
		start();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		clickAppId("home_left_menu", driver);
		switch(stepcase)
		{
		case 0:
			break;
		case 1:
			if(infile==true)			
				clickAppXpath("//input[@name='icon512']", driver);
			fileupLoadxpath(file, "//input[@name='icon512']", driver);
			//makeAppXpath("//input[@name='icon512']", img_add, driver);
			clickAppXpath("//input[@class='w100 tcenter btn busy-right']", driver);
			break;
		case 2:
			switch (app_type) {
			case 1:
				clickAppXpath("//img[@src='https://www.misterpark.jp/site_media/dp/images/single.png']", driver);			
				break;
			case 2:
				clickAppXpath("//img[@src='https://www.misterpark.jp/site_media/dp/images/multi.png']", driver);			
				break;
			case 3:
				clickAppXpath("//img[@src='https://www.misterpark.jp/site_media/dp/images/mypage/home_layout/001s.jpg']", driver);			
				break;
			case 4:
				clickAppXpath("//img[@src='https://www.misterpark.jp/site_media/dp/images/mypage/home_layout/003s.jpg']", driver);			
				break;
			default:
				break;
			}
			clickAppXpath("//input[@class='w100 tcenter btn']", driver);
			break;
		}
		JOptionPane.showMessageDialog(null, checkError()+" error detected : "+checkResult);
	}

	@Override
	public void delete() {
		driver.close();
	}

	@Override
	public String checkError() {
		String Result="Another error : ";
		if(stepcase==1){
			if(infile==false){
				if(checkAppId("icon512_error", driver).equals(image_error))
					checkResult = true;
				else
					Result += "image_empty";
			}	
		}
		// TODO Auto-generated method stub
		return Result+" and ";
	}
}
