package vo.strategyVO;

import java.util.List;

import Enum.PrivilegeWay;
import Enum.VIPType;

public class PrivilegeVO {
    private VIPType type;
    private double discount;
    private PrivilegeWay privilegeWay;
    private List<String> enterprises;

    public PrivilegeVO(){

    }
    public PrivilegeVO(VIPType type,double discount,PrivilegeWay privilegeWay,List<String> enterprises){
    	this.setType(type);
    	this.setDiscount(discount);
    	this.setPrivilegeWay(privilegeWay);
    	this.setEnterprises(enterprises);
    }

	public VIPType getType() {
		return type;
	}

	public void setType(VIPType type) {
		this.type = type;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public PrivilegeWay getPrivilegeWay() {
		return privilegeWay;
	}

	public void setPrivilegeWay(PrivilegeWay privilegeWay) {
		this.privilegeWay = privilegeWay;
	}

	public List<String> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<String> enterprises) {
		this.enterprises = enterprises;
	}
}
