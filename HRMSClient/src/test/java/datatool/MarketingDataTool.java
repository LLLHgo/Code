package datatool;

import java.awt.Image;

import javax.swing.ImageIcon;

import vo.marketingVO.MarketingVO;

public class MarketingDataTool {
	static Image image1=new ImageIcon("./src/main/resource/picture/marketing/hphoto.png").getImage();

    public static MarketingVO V1=new MarketingVO("Daniel","mypassword","M00000001","13590875643",image1);
    public static MarketingVO V2=new MarketingVO("Melody","123456789","M00000002","15011134226");
    public static MarketingVO V3=new MarketingVO("Rachel","fearlove","M00000004","13783275589");;

}
