package businesslogic.strategybl;

public class CalculateMaterial {
	private double discount;

	public CalculateMaterial(double discount){//marketingperiod
		this.setDiscount(discount);
	}

	public CalculateMaterial(){//marketingspecial

	}


/*	public CalculateMaterial(){

	}

	public CalculateMaterial(){

	}

	public CalculateMaterial(){

	}

	public CalculateMaterial(){

	}

	public CalculateMaterial(){

	}
*/
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
