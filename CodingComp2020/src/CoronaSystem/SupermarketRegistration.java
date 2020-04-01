package CoronaSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class SupermarketRegistration extends JPanel{
	JLabel lblname, lbladdress, lblretailspace, lblopening, lblclosing, lblavgtime, lblpasswrd;
	JTextField txtname, txtaddress, txtretailspace, txtopening, txtclosing, txtavgtime,txtpasswd;
	JButton btnregister;
	JPanel btnpanel, itemspanel;
	static int shopid;
	Connection conn= DatabaseConnect.getConnection();
	public static String username;
	public static int lengthofQueue;
	
	public SupermarketRegistration() {
		setVisible(true);
		setLayout(new FlowLayout());
		positioning();
	}
	
	public void positioning() {
		itemspanel= new JPanel();
		itemspanel.setLayout(new GridLayout(7,2,20,20));
		
		lblname= new JLabel("Shop Name");
		lbladdress= new JLabel("Shop Address");
		lblretailspace= new JLabel("Retail Space Area(m^2)");
		lblopening= new JLabel("Opening Time (hh:mm)");
		lblclosing= new JLabel("Closing Time (hh:mm)");
		lblavgtime= new JLabel("Average Service Time (min)");
		lblpasswrd= new JLabel("Password");
		
		txtname= new JTextField();
		txtname.setPreferredSize(new Dimension(200,40));
		txtaddress= new JTextField();
		txtaddress.setPreferredSize(new Dimension(200,40));
		txtretailspace= new JTextField();
		txtretailspace.setPreferredSize(new Dimension(200,40));
		txtopening= new JTextField();
		txtopening.setPreferredSize(new Dimension(200,40));
		txtclosing= new JTextField();
		txtclosing.setPreferredSize(new Dimension(200,40));
		txtavgtime= new JTextField();
		txtavgtime.setPreferredSize(new Dimension(200,40));
		txtpasswd= new JTextField();
		txtpasswd.setPreferredSize(new Dimension(200,40));
		
		itemspanel.add(lblname);
		itemspanel.add(txtname);
		itemspanel.add(lbladdress);
		itemspanel.add(txtaddress);
		itemspanel.add(lblretailspace);		
		itemspanel.add(txtretailspace);
		itemspanel.add(lblopening);
		itemspanel.add(txtopening);
		itemspanel.add(lblclosing);
		itemspanel.add(txtclosing);
		itemspanel.add(lblavgtime);
		itemspanel.add(txtavgtime);
		itemspanel.add(lblpasswrd);
		itemspanel.add(txtpasswd);
		
		btnpanel= new JPanel();
		btnregister= new JButton("Register");
		btnpanel.add(btnregister);
		
		JPanel notepnl= new JPanel();
		JLabel notelbl= new JLabel("Note: Please Read Manual First");
		notepnl.add(notelbl);
		
		add(itemspanel);
		add(btnpanel);
		add(notelbl);
		
		Handler h= new Handler();
		btnregister.addActionListener(h);
		
	}
	public class Handler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnregister) {
				
				try {
					Statement stt = conn.createStatement();
					String insertsql="INSERT INTO Supermarket(shopName,shopAddress,shopRSA,opening,closing,serviceTime,password) VALUES(?,?,?,?,?,?,?)";
					PreparedStatement prep = conn.prepareStatement(insertsql);     
					prep.setString(1, txtname.getText());
                    prep.setString(2, txtaddress.getText());
                    prep.setFloat(3, Float.parseFloat(txtretailspace.getText()));
                    prep.setString(4, txtopening.getText());
                    prep.setString(5, txtclosing.getText());
                    prep.setString(6, txtavgtime.getText());
                    prep.setString(7, txtpasswd.getText());
                    prep.execute();
                                        
                    lengthofQueue=(int)(0.25 *(Float.parseFloat(txtretailspace.getText()) / 4));
                    
                    PreparedStatement sqlfetchshopId=conn.prepareStatement("SELECT shopId FROM Supermarket WHERE shopName=?");
					sqlfetchshopId.setString(1, txtname.getText());
					ResultSet rs = sqlfetchshopId.executeQuery();
					if( rs != null) {
                    	while( rs.next()) {
                    		shopid = rs.getInt("shopId");
                    	}
                    }
					timeslotGenerator();
					SupermarketRegistration.username=txtname.getText();
	            	main.frameMainMenu.dispose();
	            	new ServiceCodeVerifier();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public void timeslotGenerator() throws ParseException {
		int interval=Integer.parseInt(txtavgtime.getText());
		String start=txtopening.getText();
		String end=txtclosing.getText();
		String current=start;
		
			while(true) {
				SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				java.util.Date d = df.parse(current); 
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				cal.add(Calendar.MINUTE, interval);
				String newTime = df.format(cal.getTime());
				
				if(df.parse(newTime).after(df.parse(end)))
					break;	
				else {				
					try {					
						String insertsql2="INSERT INTO dailyTimeslots(shopId,slots,servicecode,customername) VALUES(?,?,?,?)";
						PreparedStatement prep = conn.prepareStatement(insertsql2);     
						prep.setInt(1, shopid);
	                    prep.setString(2, newTime);
	                    prep.setString(3, ServiceCodeGenerator.generateServiceCode());
	                    prep.setString(4, "");
	                    prep.execute();
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					current=newTime;
				}
			}
	}
	
//	public static void main(String[] args) throws ParseException {
//		SupermarketRegistration a=  new SupermarketRegistration();
//		
//	}
}
