package vo.hotelinfoVO;

import java.util.ArrayList;

import Enum.Star;

public class HotelinfoVO {
	//酒店名称
	private String name;
	//酒店地址
	private String address;
	//酒店所在商圈
	private String area;
	//酒店电话
	private String tel;
	//酒店所包含的房间类型和数量 arraylist里面每一个元素的表示形式，如“标准双人间2”表示有2个可用的标准双人间
	private ArrayList<String> roomTypeandNum;
	//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
	private Star star;
	//酒店评价
	private ArrayList<String> remark;
	//酒店简介
	private String introduction;
	//酒店ＩＤ
	private String hotelID;
	
	
}
