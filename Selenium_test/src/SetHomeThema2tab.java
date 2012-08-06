import java.io.File;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;


public class SetHomeThema2tab extends CheckMethod implements ActionsCheck{
	private WebDriver driver;
	private int app_design_limit;
	private int app_design;
	private File file ;
	private String H,S,V,R,G,B;
	private boolean checkResult;
	private int stepcase;
	private boolean infile;
	private String image_empty_error;
	public SetHomeThema2tab(WebDriver startdr,int step,boolean inputfile,String appAddress){
		image_empty_error = "アップロードした画像は、ファイル形式または画像サイズに誤りがある、あるいは壊れています。";
		checkResult = false;
		stepcase = step;
		driver = startdr;
		infile = inputfile;
		file = new File(appAddress);
		start();
	}
	public SetHomeThema2tab(WebDriver startdr,int step, int appDesign){
		image_empty_error = "アップロードした画像は、ファイル形式または画像サイズに誤りがある、あるいは壊れています。";
		driver = startdr;
		checkResult = false;		
		stepcase = step;
		app_design_limit = 10;
		app_design = appDesign%app_design_limit;
		if(app_design==0)
			app_design=1;

		start();

	}
	public SetHomeThema2tab(WebDriver startdr,int step,int H,int S,int V,int R,int G,int B){
		image_empty_error = "アップロードした画像は、ファイル形式または画像サイズに誤りがある、あるいは壊れています。";
		driver = startdr;
		checkResult = false;
		stepcase = step;

		this.H = ""+H;
		this.S = ""+S;
		this.V = ""+V;
		this.R = ""+R;
		this.G = ""+G;
		this.B = ""+B;
		start();		
	}

	@Override
	public void start() {
		try {
			clickAppId("home_left_menu", driver);
			clickAppXpath("//li[@id='home_main']/a[@href='javascript:void(0);']", driver);		
		} catch (Exception e)
		{JOptionPane.showMessageDialog(null, e);}
		switch(stepcase)
		{
		case 1:
			clickAppXpath("//li[@id='home_main']/a[@href='javascript:void(0);']", driver);				
			fileupLoadxpath(file, "//input[@id='id_bg512']", driver);

			clickAppXpath("//form[@action='/apps/upload/home/?app_id=323&target=home']/table[@class='spb15']//input[@class='w100 tcenter btn busy-right']", driver);
			break;
		case 2:
			clickAppXpath("//img[@alt='"+app_design+"']", driver);
			clickAppXpath("//p[@class='home_temp_btn']/input[@class='w100 tcenter btn busy-right']", driver);
			//		clickAppXpath("//input[@type='submit']", driver);
			break;
		case 3:

			clickAppXpath("//input[@type='button']", driver);
			deleteAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Hue']/td[@class='Text']/input[@title='Enter A “Hue” Value (0-360°)']", driver);
			makeAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Hue']/td[@class='Text']/input[@title='Enter A “Hue” Value (0-360°)']",H,driver);
			deleteAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Saturation']/td[@class='Text']/input[@title='Enter A “Saturation” Value (0-100%)']", driver);
			makeAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Saturation']/td[@class='Text']/input[@title='Enter A “Saturation” Value (0-100%)']",S,driver);
			deleteAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Value']/td[@class='Text']/input[@title='Enter A “Value” Value (0-100%)']", driver);
			makeAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Value']/td[@class='Text']/input[@title='Enter A “Value” Value (0-100%)']",V,driver);
			deleteAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Red']/td[@class='Text']/input[@title='Enter A “Red” Value (0-255)']", driver);
			makeAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Red']/td[@class='Text']/input[@title='Enter A “Red” Value (0-255)']",R,driver);
			deleteAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Green']/td[@class='Text']/input[@title='Enter A “Green” Value (0-255)']", driver);
			makeAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Green']/td[@class='Text']/input[@title='Enter A “Green” Value (0-255)']",G,driver);
			deleteAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Blue']/td[@class='Text']/input[@title='Enter A “Blue” Value (0-255)']", driver);	
			makeAppXpath("//div[@id='fancybox-content']//table[@class='jPicker']//tr[@class='Blue']/td[@class='Text']/input[@title='Enter A “Blue” Value (0-255)']",B,driver);		
			clickAppXpath("//td[@id='mypage_bg_color_palette_left']/div[@class='color_palette jPicker Container']/table[@class='jPicker']//td[@class='Button']/input[@title='Commit To This Color Selection']", driver);			
			clickAppXpath("//table[@cellSpacing='0']//td[@class='vbottom']/input[@onclick='javascript:save_home_bg_color();']", driver);


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
		String result = "Another error : ";
		if(stepcase == 1){
			if(infile == false){
				if(checkAppId("invalid_home_image", driver).equals(image_empty_error))
					checkResult = true;
				else
					result += "image_error";
			}
		}
		else if(stepcase == 2){

		}
		else if(stepcase == 3){

		}
		return result + " and ";
	}
}
