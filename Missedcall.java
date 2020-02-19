import java.time.*;
import java.util.*;

class caller{
	String name;
	long number;
	LocalTime time;
	caller(String name,long n,LocalTime t){
		this.name=name;
		number=n;
		time=t;
	}
	public String  toString() {
		return "Name: "+name+"\tNumber: "+number+"\tTime: "+time+"\t";
	}
}
public class telephone {
	static Scanner sc=new Scanner(System.in);
	static ArrayList<caller> missed=new ArrayList<caller>();
	static HashMap<Long,String> contacts=new HashMap<Long,String>();
	public static void main(String args[]) {
		
		contacts.put((long)810512765,"Anirudh");
		contacts.put((long)968668116,"Rakshith");
		contacts.put((long)990276115,"Rekhu");
		contacts.put((long)98456904,"Mehesh");
		contacts.put((long)963281905,"Sucheta");
		contacts.put((long)823314583,"Kiran B");
		contacts.put((long)823466275,"Anirudh");
		contacts.put((long)914832133,"Sharu");
	
	while(true) {
		System.out.println("1.Call\n2.Check phone\n3.Missed call list\n4.Exit");
		int ch=sc.nextInt();
		switch(ch) {
			case 1:calling();break;
			case 2:inspect();break;
			case 3:System.out.println(missed.size()+" missed calls\n");
				for(caller c: missed)
					System.out.println(c);
			case 4:System.exit(0);
			}	
		}
	}
	public static void calling() {
		System.out.println("Enter name and number\n");
		String name=sc.next();
		long num=sc.nextLong();
		LocalTime tim=java.time.LocalTime.now();
		if(missed.size()<10) {
			storecall(name,num,tim);
		}
		else {
			missed.remove(0);
			storecall(name,num,tim);
			
		}
	}
	public static void inspect() {
		ListIterator<caller> itr=missed.listIterator();
		while(itr.hasNext()) {
			caller c=itr.next();
			System.out.println(c.number);
			System.out.println("1.Delete\n2.Next number\n3.View\n");
			int ch=sc.nextInt();
			switch(ch) {
				case 1:itr.remove();break;
				case 2:break;
				case 3:System.out.println(c);break;
			}
		}
	}
	public static void storecall(String name,long num,LocalTime tim) {
		if(contacts.containsKey(num)) {
			caller called=new caller(name,num,tim);
			missed.add(called);
		}
		else
		{
			name="Private caller";
			caller called=new caller(name,num,tim);
			missed.add(called);
		}
	}
}
