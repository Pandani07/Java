import java.util.*;
class bookkeep implements Comparable<bookkeep>{
	String title,author,publisher;
	int  price,id;
	bookkeep(String t,String a,String p,int price,int id){
		title=t;
		author=a;
		publisher=p;
		this.price=price;
		this.id=id;
	}
	public int compareTo(bookkeep b) {
		return this.price-b.price;
	}
	public String toString() {
		return "Title: "+title+"\tAuthor: "+author+"\tPublisher: "+publisher+"\tPrice: "+price;
	}
}
public class book {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		ArrayList<bookkeep> book=new ArrayList<bookkeep>();
		book.add(new bookkeep("Deathly Hallows","Rowling","Bloomsbury Publishing",2000,0));
		book.add(new bookkeep("Dance of the Dragons","GRR Martin","Voyager Books",1900,1));
		book.add(new bookkeep("Man Eaters of Kumaon","Jim Corbett","Oxford Press",1500,2));
		book.add(new bookkeep("Divergent","Veronica Roth","Katherine Tegen Books",1800,3));
		book.add(new bookkeep("Half Blood Prince","Rowling","Bloomsbury Publishing",2000,4));
		Collections.sort(book);
		System.out.println("Enter the author name:\n");
		String name=sc.nextLine();
		ListIterator<bookkeep> itr=book.listIterator();
		while(itr.hasNext()) {
			bookkeep b=itr.next();
			if(b.author.contains(name)) {
				System.out.println(b);
			}
		}
		ArrayList<bookkeep> pricelist=new ArrayList<bookkeep>();
		int uprice=1600;
		itr=book.listIterator();
		while(itr.hasNext()) {
			bookkeep b2=itr.next();
			if(b2.price>uprice) {
				pricelist.add(b2);
			}
		}
		System.out.println("Enter the full name of the book or  a substring:\n");
		String sub=sc.nextLine();
		itr=book.listIterator();
		while(itr.hasNext()) {
			bookkeep b3=itr.next();
			String bt=b3.title;
			if(bt.contains(sub)) {
				System.out.println(b3);
			}
		}
		System.out.println("Enter publisher name:\n");
		String pub=sc.nextLine();
		itr=book.listIterator();
		while(itr.hasNext()) {
			bookkeep b4=itr.next();
			if(b4.publisher.contains(pub)) {
				System.out.println(b4);
			}
		}
		
	}
}
