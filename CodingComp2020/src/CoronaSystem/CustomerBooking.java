package CoronaSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerBooking extends JPanel{
	JComboBox shopjc = new JComboBox();
	JComboBox timeslotjc = new JComboBox();
	JLabel lblshop, lblslot, lblcode, lblname, lblnote;
	JTextField txtcode, txtname;
	JButton submit;
	JPanel a,b,c,d;
	
	String timeslots,servicecode, shopname;
	int shopid;
	ArrayList<String> timeslotslist = new ArrayList<String>();
	ArrayList<String> servicecodelist = new ArrayList<String>();
	ArrayList<String> shopnamelist = new ArrayList<String>();
	ArrayList<Integer> shopidlist = new ArrayList<Integer>();
	
	Connection conn= DatabaseConnect.getConnection();
	
	public CustomerBooking() {
		setVisible(true);
		setSize(500,500);
		setLayout(new FlowLayout());
		positioning();
		actionEvent();
	}
	
	public void positioning() {
		a=new JPanel();
		b=new JPanel();
		c=new JPanel();
		d=new JPanel();
		a.setLayout(new GridLayout(1,2,20,20));
		b.setLayout(new GridLayout(1,2,20,20));
		c.setLayout(new GridLayout(2,2,20,20));
		d.setLayout(new FlowLayout(FlowLayout.CENTER));
		lblshop= new JLabel("Choose a shop/supermarket");
		lblslot= new JLabel("Choose a timeslot");
		lblcode= new JLabel("Your Service Code");
		lblname= new JLabel("Insert Your Full Name");
		lblnote= new JLabel("You are requested to present your service code at the shop/supermarket");
		txtcode= new JTextField();
		txtcode.setPreferredSize(new Dimension(175,30));
		txtcode.setEditable(false);
		txtname= new JTextField();
		submit=new JButton("Book");
		submit.setPreferredSize(new Dimension(200,50));
		a.add(lblshop);
		a.add(shopjc);
		b.add(lblslot);
		b.add(timeslotjc);
		c.add(lblcode);
		c.add(txtcode);
		c.add(lblname);
		c.add(txtname);
		d.add(submit);
		
		add(a);
		add(b);
		add(c);
		add(d);	
		add(lblnote);
	}
	
	public void actionEvent(){
		try {
			Statement stt = conn.createStatement();
			stt.execute("SELECT shopName,shopId FROM Supermarket");
			ResultSet rs = stt.getResultSet();
    		int i =0;
    		
    		if( rs != null) {	
    			while(rs.next()) {
    				shopname=rs.getString("shopName");
    				shopnamelist.add(shopname);
    				shopid=rs.getInt("shopId");
    				shopidlist.add(shopid);
    				
    				shopjc.addItem(shopnamelist.get(i)); //adding type to the JtextField
    				
    				i++;
    			}
    			shopjc.setSelectedIndex(-1);
    		}
    		
    		shopjc.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent ie) {
					int typeindex=shopjc.getSelectedIndex();
					int currentshopid= shopidlist.get(typeindex);

					//JOptionPane.showMessageDialog(null, typeindex);
					String timeslotsql="SELECT slots, servicecode "
									+ "FROM dailyTimeslots WHERE customername ='' AND shopId="+currentshopid;
					try {
						stt.execute(timeslotsql);
						ResultSet rs2 = stt.getResultSet();
						int j=0;
						if( rs2 != null) {	
			    			while(rs2.next()) {
			    				timeslots=rs2.getString("slots");
			    				timeslotslist.add(timeslots);
			    				servicecode=rs2.getString("servicecode");
			    				servicecodelist.add(servicecode);			    				
			    				timeslotjc.addItem(timeslotslist.get(j)); //adding type to the JtextField
			    				j++;
			    			}
			    			timeslotjc.setSelectedIndex(0);
			    		}
					} catch (SQLException e) {
						e.printStackTrace();
					}				
				}		
    		});
    		
			timeslotjc.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent ie) {
					int typeindex=timeslotjc.getSelectedIndex();
					txtcode.setText(servicecodelist.get(typeindex));
				}
			});
			
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtname.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Input Your Name");
					else {
						String updateslot="UPDATE dailyTimeslots SET customername=? WHERE servicecode=?";
						try {
							PreparedStatement prep = conn.prepareStatement(updateslot);
							prep.setString(1, txtname.getText());
							prep.setString(2, txtcode.getText());
							prep.execute();
							JOptionPane.showMessageDialog(null, "Time Booked:"+timeslotslist.get(timeslotjc.getSelectedIndex())+". Service code:"+txtcode.getText());
							txtname.setText("");
							txtcode.setText("");
							shopjc.setSelectedIndex(0);
							timeslotjc.setSelectedIndex(0);
							main.frameSplit.setRightComponent(new CustomerBooking());
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}   
					}
					
				}
			});
    		
		}catch(Exception e1) {
    		e1.printStackTrace();
    		JOptionPane.showMessageDialog(null,e1.toString(),"FATAL ERROR!",JOptionPane.PLAIN_MESSAGE);
    	}
	}
	
//	public static void main(String[] args) {
//		CustomerBooking a= new CustomerBooking();
//	}
}
