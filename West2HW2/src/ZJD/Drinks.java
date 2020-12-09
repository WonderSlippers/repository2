package ZJD;

import java.time.LocalDate;

public abstract class Drinks {
	protected String name;
	protected double cost;
	protected LocalDate produceDate;
	protected int qualityPeriod;

	public boolean ifOutDate() {
		
		boolean ifOutdate=produceDate.isAfter(produceDate.plusDays(qualityPeriod));
		return ifOutdate; 
		 
		 
		 
	 }

	abstract String tosString();

	public Drinks(String name, double cost, LocalDate produceDate, int qualityPeriod) {
		super();
		this.name = name;
		this.cost = cost;
		this.produceDate = produceDate;
		this.qualityPeriod = qualityPeriod;
	}

	public double getCost() {
		return cost;
	}


}
