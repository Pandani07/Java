package brickbreaker;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class item{
	String name;
	int price;
	item(String name,int price){
		this.name=name;
		this.price=price;
	}
	public String toString(){
		return "Item name: "+name;
	}
}

public class customer {
	static HashMap<Long,String> custdetails=new HashMap<Long,String>();
	static ArrayList<item> items=new ArrayList<item>();

	public static boolean checkdetails(){
		String username=JOptionPane.showInputDialog(null,"Enter username","Username");
		String correctu="anirudh",correctpass="sike";
		if(username.equals(correctu)){
			String password=JOptionPane.showInputDialog(null,"Enter password","Password");
			if(password.equals(correctpass))
				return true;
			else {
				JOptionPane.showMessageDialog(null, "Wrong password");
				return false;
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Wrong username");
		return false;
	}
	public static void customerform(){
		JFrame mainframe=new JFrame("Customer Validation");
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JLabel customerno=new JLabel("Enter customer number");
		JTextField custtxt=new JTextField(20);
		JTextArea display=new JTextArea(1,1);
		JButton check=new JButton("Check");
		
		JFrame itemframe=new JFrame("Item Selection");		
		DefaultListModel<String> l1 = new DefaultListModel<>();  
		          l1.addElement("Basketball: 700Rs");  
		          l1.addElement("Football: 600Rs");  
		          l1.addElement("Tennis Ball x 3: 30Rs");  
		          l1.addElement("NBA Jersey: 1700Rs");
		          JList<String> list = new JList<>(l1);  
		          list.setBounds(100,100, 75,75);  
		          itemframe.add(list);  
		
		JLabel itemname=new JLabel("Enter item name");
		JTextField itemtxt=new JTextField(20);
		JLabel itemq=new JLabel("Enter the quantity");
		JTextField itemqtxt=new JTextField(20);
		JButton buy=new JButton("Buy");
		
		check.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				long phno=Long.parseLong(custtxt.getText());
				if(custdetails.containsKey(phno)){
					display.setText(custdetails.get(phno));
					JLabel show=new JLabel("Customer id:");
					mainframe.setVisible(false);
					itemframe.setVisible(true);
				}
			}
		});
		
		jp1.add(customerno);
		jp1.add(custtxt);
		jp1.add(check);
		
		mainframe.add(jp1);
		mainframe.add(jp2);
		mainframe.setSize(300,300);
		mainframe.setLayout(new GridLayout(2,1));
		mainframe.setVisible(true);
	
		
		
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemn=itemtxt.getText();
				String []discount= {"10","20","30"};
				int quantity=Integer.parseInt(itemqtxt.getText());
				int pp=JOptionPane.showOptionDialog(null, "Select Discount", "Dicsount", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, discount, discount[0]);
				int incost=0;
				double total=0;
				Iterator<item>itr=items.listIterator();
				while(itr.hasNext()){
					item i=itr.next();
					if(i.name.equalsIgnoreCase(itemn)) {
						incost=quantity*i.price;
						if(pp==0)
							total=incost-0.1*incost;
						else if(pp==1)
							total=incost-0.2*incost;
						else if(pp==2)
							total=incost-0.3*incost;
						JOptionPane.showMessageDialog(null, "Total bill: "+total);
						itemframe.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Item");
				}
			}
		
		});
		JPanel new2=new JPanel();
		new2.add(itemname);
		new2.add(itemtxt);
		new2.add(itemq);
		new2.add(itemqtxt);
		itemframe.add(new2);
		JPanel new1=new JPanel();
		new1.add(buy);
		itemframe.add(new1,SwingConstants.CENTER);
		itemframe.setSize(800,800);
		itemframe.setLayout(new GridLayout(10,3));
		itemframe.setVisible(false);
	}
	
	public static void main(String args[]){
		if(checkdetails()){
			custdetails.put((long) 810512764,"IS024");
			custdetails.put((long) 968668116,"MES19");
			custdetails.put((long) 990276111,"SJV16");
			custdetails.put((long) 984506904,"INFY101");
			custdetails.put((long) 963281905,"DHR26");
			custdetails.put((long) 914832532,"BT043");
			items.add(new item("Basketball",700));
			items.add(new item("Football",600));
			items.add(new item("Tennis Ball ",30));
			items.add(new item("Cork Ball ",100));
			items.add(new item("NBA Jersey",1700));
			customerform();
			
		}
	}
}
	
