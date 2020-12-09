package ZJD;

import java.time.LocalDate;

public class Beer extends Drinks {
	float alcohol;

	public Beer(String name, double cost, LocalDate produceDate, int qualityPeriod, float alcohol) {
		super(name, cost, produceDate, qualityPeriod = 30);
		this.alcohol=alcohol;
	}

	@Override
	String tosString() {
		return "name:" + name + "cost" + cost + "produceDate" + produceDate + "qualityPeriod: " + qualityPeriod
				+ "alcohol: " + alcohol;
	}

}
