package Mock;

import java.util.ArrayList;

import Enum.Star;
import vo.hotelinfoVO.RoominfoVO;

public class MockHotelinfo {
		//酒店名称
		private String name;
		//酒店地址
		private String address;
		//酒店所在商圈
		private String area;
		//酒店电话
		private String tel;
		//酒店所包含的房间
		private ArrayList<MockRoominfo> roominfoList;
		//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
		private Star star;
		//酒店评价
		private ArrayList<String> remark;
		//酒店简介
		private String introduction;
		//酒店ＩＤ
		private String hotelID;
		
		public MockHotelinfo(){
			
		}
		
		public MockHotelinfo(String name,String address,String area,
				String tel,ArrayList<MockRoominfo> roominfoList,Star star,ArrayList<String> remark,
				String introduciton,String hotelID){
			this.name = name;
			this.address = address;
			this.area = area;
			this.tel = tel;
			this.roominfoList = roominfoList;
			this.star = star;
			this.remark = remark;
			this.introduction = introduciton;
			this.hotelID = hotelID;
		}
		
		
}
