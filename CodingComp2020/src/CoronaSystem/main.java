package CoronaSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main extends JFrame{
	static JFrame frameMainMenu = new JFrame("Homepage");
	static JSplitPane frameSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//Split menu into 2 parts
	static JPanel panelMainMenu = new JPanel();//left panel containing all buttons
	static JPanel panelGrid = new JPanel(); //to insert the pages
	JSeparator emptySpaceInMenuBar= new JSeparator(JSeparator.VERTICAL);
	
	public main() {
		frameMainMenu.setLayout(new BorderLayout());
		frameMainMenu.setVisible(true);
		frameMainMenu.setSize(700,500);
		positioning();
		frameSplit.setRightComponent(new CustomerBooking());
		frameMainMenu.setLocationRelativeTo(null);
		
	}
	
	public void positioning() {
		//making the side bar
		panelMainMenu.setLayout(new BoxLayout(panelMainMenu, BoxLayout.Y_AXIS));
		panelMainMenu.setPreferredSize(new Dimension(150, 500));
		
		JButton Login= new JButton("Login");
		JButton Register= new JButton("Register");
		JButton Book= new JButton("Book a slot");
		JButton Manual= new JButton("Read Manual");
		
		Login.setAlignmentX(Component.CENTER_ALIGNMENT);
		Login.setPreferredSize(new Dimension(150, 50));
		Login.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));
		
		Register.setAlignmentX(Component.CENTER_ALIGNMENT);
		Register.setPreferredSize(new Dimension(150, 50));
		Register.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));
		
		Book.setAlignmentX(Component.CENTER_ALIGNMENT);
		Book.setPreferredSize(new Dimension(150, 50));
		Book.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));
		
		Manual.setAlignmentX(Component.CENTER_ALIGNMENT);
		Manual.setPreferredSize(new Dimension(150, 50));
		Manual.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));
		
		emptySpaceInMenuBar.setPreferredSize(new Dimension(50,200));
		panelMainMenu.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
		panelMainMenu.add(Login);
		panelMainMenu.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
		panelMainMenu.add(Register);
		panelMainMenu.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
		panelMainMenu.add(Book);
		panelMainMenu.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
		panelMainMenu.add(Manual);
		panelMainMenu.add(emptySpaceInMenuBar, BorderLayout.LINE_START);
		
		//add Grid Panel and splitting frame
		panelGrid.setBorder(BorderFactory.createLineBorder(Color.black));
	
		frameSplit.setLeftComponent(panelMainMenu);
		frameSplit.setRightComponent(panelGrid);
		
		frameMainMenu.add(frameSplit,BorderLayout.CENTER);
		
		handlerMainMenu handlerMainMenu = new handlerMainMenu();
		Login.addActionListener(handlerMainMenu);
		Register.addActionListener(handlerMainMenu);
		Book.addActionListener(handlerMainMenu);
		Manual.addActionListener(handlerMainMenu);
	}
	public static class handlerMainMenu implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String action = event.getActionCommand();
			try {
				if(action.equals("Login")) {
					frameSplit.setRightComponent(new SupermarketLogin());
				}
				if(action.equals("Register")) {
					frameSplit.setRightComponent(new SupermarketRegistration());
				}
				if(action.equals("Book a slot")) {
					frameSplit.setRightComponent(new CustomerBooking());
				}
				if(action.equals("Read Manual")) {
					frameSplit.setRightComponent(new manual());
				}
			}
			catch(Throwable e){		
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main a= new main();
	}

}
