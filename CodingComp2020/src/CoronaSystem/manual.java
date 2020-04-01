package CoronaSystem;
import java.awt.*;
import javax.swing.*;

public class manual extends JPanel {
	
	public manual() {
		setSize(550,500);
		setVisible(true);
		setLayout(new FlowLayout());
		
		Image maleimage=new ImageIcon("manual.png").getImage().getScaledInstance(550,450, java.awt.Image.SCALE_SMOOTH);;
		ImageIcon maleicon=new ImageIcon(maleimage);	
		JLabel Micon = new JLabel(maleicon);
		Micon.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Micon);
	}
	
}
