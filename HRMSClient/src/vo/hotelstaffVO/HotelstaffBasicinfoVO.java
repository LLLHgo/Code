package vo.hotelstaffVO;

public class HotelstaffBasicinfoVO {
	String password;
	
	public HotelstaffBasicinfoVO(){
		
	}
	
	public HotelstaffBasicinfoVO(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
