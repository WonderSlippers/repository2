package ZJD;

public class SetMeal {
	private String mealname;
	private double price;
	private String chickenname;
	private Drinks drinks;
	public SetMeal(String mealname, double price, String chickenname, Drinks drinks) {
		
		this.mealname = mealname;
		this.price = price;
		this.chickenname = chickenname;
		this.drinks = drinks;
	}
	public Drinks getDrinks() {
		return drinks;
	}

	public String getMealname() {
		return mealname;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SetMeal [mealname=" + mealname + ", price=" + price + ", chickenname=" + chickenname + ", drinks="
				+ drinks + "]";
	}
	
}
