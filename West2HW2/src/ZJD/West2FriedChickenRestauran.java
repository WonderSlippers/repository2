package ZJD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
	double balance = 50;
	private ArrayList<Beer> beer = new ArrayList<Beer>();// Arraylist�����ٶȿ�
	private ArrayList<Juice> juice = new ArrayList<Juice>();
	static ArrayList<SetMeal> meals = new ArrayList<SetMeal>();
	static Beer ѩ�� = new Beer("ѩ��", 5, LocalDate.of(2020, 11, 11), 360, 5);
	static Juice ��֭ = new Juice("�ʳȶ�", 3, LocalDate.of(2020, 12, 12), 365);
	public static SetMeal meal1 = new SetMeal("�ײ�1", 25, "�úó԰�", ѩ��);
	public static SetMeal meal2 = new SetMeal("�ײ�2", 100, "jqgg����", ��֭);
	static {

		meals.add(meal1);
		meals.add(meal2);

	}

//���u����
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
					use((Juice) temp);//////////// �����ײ�
					balance += meal0.getPrice();
				}break;
			}
		}
	}
//toString
public void tostring() {
		System.out.println( "West2FriedChickenRestauran [balance=" + balance + ", beer=" + beer + ", juice=" + juice + "]");
	}

	//�M؛����
	@Override
	public void bulkPurchase(int beernum,int juicenum) {
		System.out.println("�����__ơ��?");
		Scanner n1=new Scanner(System.in);
		int sr=n1.nextInt();
		beernum=sr;
		for(int i=0;i<beernum;i++) {
			beer.add(ѩ��);
		}
		System.out.println("�����__��֭");
		Scanner n2=new Scanner(System.in);
		int src=n2.nextInt();
		juicenum=src; 
		for(int i=0;i<juicenum;i++) {
			this.juice.add(��֭);
		}
		
		
		double percost = ѩ��.getCost() * beernum + ��֭.getCost() * juicenum;
		double own = percost - balance;
		if (balance < percost) {
			throw new OverdraftBalanceException("ûǮ���������˻�,����" + own + "Ԫ");
		}
		balance-=percost;
	}

	private void use(Beer somekind) throws IngredientSortOutException {
		int num = beer.indexOf(somekind);// ��ͷ��ʼ��
		if (num == -1) {
			throw new IngredientSortOutException("ơ��������");
		} else
			beer.remove(num);
	}// ʹ��ơ��

	private void use(Juice somekind) throws IngredientSortOutException {
		int num = juice.indexOf(somekind);// ��ͷ��ʼ��
		if (num == -1) {
			throw new IngredientSortOutException("��֭������");
		} else if (!somekind.ifOutDate())
			juice.remove(num);
		// ʹ�ù�֭

	}
}
