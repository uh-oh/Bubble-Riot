import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class panelTester extends JFrame
{

	public static void main(String[] args)
	{
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new panelTester();
            }
        });
	}

	PaPanel newbie = new PaPanel(); 
	public panelTester()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,350);
		this.setResizable(false);
		
		this.add(newbie);
		this.setVisible(true);
	}
}
