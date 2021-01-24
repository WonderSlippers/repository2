package ZJD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
	double balance = 50;
	private ArrayList<Beer> beer = new ArrayList<Beer>();// Arraylist查找速度快
	private ArrayList<Juice> juice = new ArrayList<Juice>();
	static ArrayList<SetMeal> meals = new ArrayList<SetMeal>();
	static Beer 雪花 = new Beer("雪花", 5, LocalDate.of(2020, 11, 11), 360, 5);
	static Juice 橙汁 = new Juice("鲜橙多", 3, LocalDate.of(2020, 12, 12), 365);
	public static SetMeal meal1 = new SetMeal("套餐1", 25, "好好吃啊", 雪花);
	public static SetMeal meal2 = new SetMeal("套餐2", 100, "jqgg大鸡腿", 橙汁);
	static {

		meals.add(meal1);
		meals.add(meal2);

	}

//售賣方法
	@Override
	public void sellMeal(String mealname) {
		for (int i = 0; i < meals.size(); i++) {
			if (meals.get(i).getMealname().equals(mealname)) {
				SetMeal meal0 = meals.get(i);

				Drinks temp = meal0.getDrinks();
				if (temp instanceof Beer) {
					use((Beer) temp);

					balance += meal0.getPrice();
				} else {
					use((Juice) temp);//////////// 售卖套餐
					balance += meal0.getPrice();
				}break;
			}
		}
	}
//toString
public void tostring() {
		System.out.println( "West2FriedChickenRestauran [balance=" + balance + ", beer=" + beer + ", juice=" + juice + "]");
	}

	//進貨方法
	@Override
	public void bulkPurchase(int beernum,int juicenum) {
		System.out.println("你想进__啤酒?");
		Scanner n1=new Scanner(System.in);
		int sr=n1.nextInt();
		beernum=sr;
		for(int i=0;i<beernum;i++) {
			beer.add(雪花);
		}
		System.out.println("你想进__果汁");
		Scanner n2=new Scanner(System.in);
		int src=n2.nextInt();
		juicenum=src; 
		for(int i=0;i<juicenum;i++) {
			this.juice.add(橙汁);
		}
		
		
		double percost = 雪花.getCost() * beernum + 橙汁.getCost() * juicenum;
		double own = percost - balance;
		if (balance < percost) {
			throw new OverdraftBalanceException("没钱辣，进不了货,还差" + own + "元");
		}
		balance-=percost;
	}

	private void use(Beer somekind) throws IngredientSortOutException {
		int num = beer.indexOf(somekind);// 从头开始找
		if (num == -1) {
			throw new IngredientSortOutException("啤酒卖完辣");
		} else
			beer.remove(num);
	}// 使用啤酒

	private void use(Juice somekind) throws IngredientSortOutException {
		int num = juice.indexOf(somekind);// 从头开始找
		if (num == -1) {
			throw new IngredientSortOutException("橙汁卖完辣");
		} else if (!somekind.ifOutDate())
			juice.remove(num);
		// 使用果汁

	}
}
