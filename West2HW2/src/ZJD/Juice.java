package ZJD;

import java.time.LocalDate;

public class Juice extends Drinks {

	public Juice(String name, double cost, LocalDate produceDate, int qualityPeriod) {
		super(name, cost, produceDate, qualityPeriod=2);
	}

	@Override
	String tosString() {
		return "name:" +name+" cost:"+cost+" produceDate:"+produceDate+" qualityPeriod"+qualityPeriod;
	}

	
}
