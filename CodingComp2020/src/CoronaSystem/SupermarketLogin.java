package CoronaSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class SupermarketLogin extends JPanel{
	JLabel lblpasswd, lblname;
	JTextField txtpasswd, txtname;
	JButton login;
	JPanel a,b,c;
	Connection conn= DatabaseConnect.getConnection();
	
	public SupermarketLogin() {
		setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		positioning();
	}
	
	public void positioning() {
		lblname=new JLabel("Supermarket Name");
		lblpasswd=new JLabel("Password");
		txtname= new JTextField(15);
		txtname.setPreferredSize(new Dimension(200,40));
		txtpasswd= new JTextField(15);
		txtpasswd.setPreferredSize(new Dimension(200,40));
		login= new JButton("Login");
		a= new JPanel();
		b= new JPanel();
		c= new JPanel();
		a.setLayout(new FlowLayout());
		b.setLayout(new FlowLayout());
		c.setLayout(new FlowLayout());
		a.add(lblname);
		a.add(txtname);
		b.add(lblpasswd);
		b.add(txtpasswd);
		c.add(login);
		add(a);
		add(b);
		add(c);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtname.getText().equals("") || txtpasswd.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Input all the values");
				else {
					try {
						int num=0;
						Statement stt = conn.createStatement();
						PreparedStatement prep = conn.prepareStatement("SELECT shopId FROM Supermarket WHERE shopname = ? and password =?");
	    	            prep.setString(1, txtname.getText());
	    	            prep.setString(2, txtpasswd.getText());
	    	            ResultSet res = prep.executeQuery();
	    	            if(res!=null) {
	    	            	SupermarketRegistration.username=txtname.getText();
	    	            	
	    	            	while(res.next()) {
	    	            		num++;
	    	            		SupermarketRegistration.shopid=res.getInt("shopId");
	    	            	}
	    	            	if(num==1) {
	    	            		main.frameMainMenu.dispose();
		    	            	new ServiceCodeVerifier();
	    	            	}
	    	            	else if(num==0) {
	    	            		JOptionPane.showMessageDialog(null,"NO ACCOUNT FOUND");
	    	            		num=0;
	    	            	}
	    	            }
	    	            
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	

}
