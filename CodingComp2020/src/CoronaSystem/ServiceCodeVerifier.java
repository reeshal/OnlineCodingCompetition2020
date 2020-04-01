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
import javax.swing.border.Border;

public class ServiceCodeVerifier extends JFrame{
	JLabel lblusername, lblcode, lbltimeslot, lblname, lblqueue;
	JTextField txtcode, txttimeslot, txtname;
	JButton verify, logout;
	Connection conn= DatabaseConnect.getConnection();
	JPanel a,b,c,d,e, container;
	public ServiceCodeVerifier() {
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(800,500);
		positioning();
		getQueue();
	}
	
	public void positioning() {
		lblusername= new JLabel(SupermarketRegistration.username);
		String info=":  Max number of people who can queue in your premises:"+SupermarketRegistration.lengthofQueue;
		lblqueue= new JLabel(info);
		lblcode= new JLabel("Enter a Service Code");
		lbltimeslot= new JLabel("Timeslot");
		lblname= new JLabel("Customer Name");
		txtcode= new JTextField(15);
		txtcode.setPreferredSize(new Dimension(200,40));
		txttimeslot= new JTextField(15);
		txttimeslot.setPreferredSize(new Dimension(200,40));
		txtname= new JTextField(15);
		txtname.setPreferredSize(new Dimension(200,40));
		txttimeslot.setEditable(false);
		txtname.setEditable(false);
		verify=new JButton("Verify Code");
		logout=new JButton("Logout");
		
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupermarketRegistration.username="";
				SupermarketRegistration.shopid=0;
				dispose();
				new main();
			}
		});
		
		a= new JPanel();
		b= new JPanel();
		c= new JPanel();
		d= new JPanel();
		e= new JPanel();
		container= new JPanel();
		
		a.setLayout(new FlowLayout(FlowLayout.RIGHT));
		a.add(lblusername);
		a.add(lblqueue);
		a.add(Box.createRigidArea(new Dimension(100,0)));
		a.add(logout);
		a.setBorder(BorderFactory.createLineBorder(Color.black));
		b.setLayout(new FlowLayout());
		c.setLayout(new FlowLayout());
		d.setLayout(new FlowLayout(FlowLayout.CENTER));
		container.setLayout(new GridLayout(4,1));

		b.add(lblcode);
		b.add(txtcode);
		c.add(lbltimeslot);
		c.add(txttimeslot);
		d.add(lblname);
		d.add(txtname);
		e.add(verify);
		
		container.add(b);
		container.add(c);
		container.add(d);
		container.add(e);

		add(a, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
		add(Box.createRigidArea(new Dimension(200,150)),BorderLayout.SOUTH);
		verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtcode.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Input a Service Code");
				else {
					try {
						String query="SELECT slots, customername FROM dailyTimeslots WHERE servicecode='"+txtcode.getText()+"' AND shopId="+SupermarketRegistration.shopid;
						Statement stt = conn.createStatement();
						stt.execute(query);
						ResultSet rs = stt.getResultSet();
						int flag=0;
						if( rs != null) {	
							//JOptionPane.showMessageDialog(null, rs);
			    			while(rs.next()) {
			    				txttimeslot.setText(rs.getString("slots"));			    				
			    				if(rs.getString("customername").equals("")) {
			    					txtname.setText("Not yet booked");
			    					flag=2;
			    				}
			    				else {
			    					txtname.setText(rs.getString("customername"));
			    					flag=1;
			    				}
			    			}			    			
			    		}
						if(flag==0) {
							txttimeslot.setText("Service code not found");
							txtname.setText("Null");
						}
						flag=0;
					}
					catch(SQLException se) {
						se.printStackTrace();
					}
				}
				
			}
		});
	}
	
	public void getQueue() {
		try {
			int length=0;
			String query="SELECT shopRSA FROM Supermarket WHERE shopId="+SupermarketRegistration.shopid;
			Statement stt = conn.createStatement();
			stt.execute(query);
			ResultSet rs = stt.getResultSet();
			if( rs != null) {	
				while(rs.next()) {
					length=(int)(0.25 *(rs.getFloat("shopRSA")) / 4);
				}
				String info=":  Max number of people who can queue in your premises:"+length;
				
				lblqueue.setText(info);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		ServiceCodeVerifier a= new ServiceCodeVerifier();
//	}
}
