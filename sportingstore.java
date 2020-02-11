import java.util.*;
class sportsstore{
	String name,category;
	double price;
	int quantity;
	sportsstore(String name,String category,double price,int quantity){
		this.name=name;
		this.category=category;
		this.price=price;
		this.quantity=quantity;
	}
	void taxcalculate(String country) {
		double tax,total,bill = 0;
		total=quantity*price;
		if(country.equals("India")) {
			tax=0.18*total;
			bill=tax+total;
		}
		else if(country.equals("Canada")) {
			tax=0.15*total;
			bill=tax+total;
		}
		else if(country.equals("Usa")) {
			tax=0.1*total;
			bill=tax+total;
		}
		System.out.println("The bill: "+bill);
	}
}
public class mainclass {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String name,category;
		double price;
		HashMap<String,Double> goods=new HashMap<String,Double>();
		goods.put("ball", (double) 699);
		goods.put("bat",(double)999);
		goods.put("swimsuit",(double)1499);
		goods.put("boots",(double) 2499);
		goods.put("bike",(double)9999);
		System.out.println("Enter the name\n");
		name=sc.nextLine();
		System.out.println("Enter the category\n");
		category=sc.next();
		String ch,region;
		if(goods.containsKey(name)) {
			System.out.println("Available: Enter the quantity\n");
			int quantity=sc.nextInt();
			sportsstore sport=new sportsstore(name,category,goods.get(name),quantity);
			System.out.println("Do you want the bill?\n");
			ch=sc.next();
			if(ch.equals("yes")) {
				System.out.println("Enter your region:\nIndia, Canada or The United States\n");
				region=sc.next();
				sport.taxcalculate(region);
			}
			else
				System.exit(0);
		}
		else
			System.out.println("This item does not exist in our store\n");
	}
}
