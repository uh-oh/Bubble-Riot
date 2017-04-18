import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class PaPanel extends JPanel
{

	//load characters
	File F = new File("passwordrules.csv");
	CSVConverter C = new CSVConverter();
	ArrayList<ArrayList<String>> Profile = C.ConvertToArrayList(F);

	//create panelPassword Length and its components
	JPanel setPasswordLengthPanel = new JPanel();
		JSlider minLength = new JSlider(1,64,1);
		JSlider maxLength = new JSlider(1,64,64);
		JSlider staticLength = new JSlider(0,64,32);
		JLabel minLenLabel = new JLabel("Minimum Password Length");
		JLabel maxLenLabel = new JLabel("Maximum Password Length");
		JLabel staticLenLabel = new JLabel("Static Password Length");
		SlideListener SL = new SlideListener();
		JLabel minLabel = new JLabel(""+ minLength.getValue());
		JLabel maxLabel = new JLabel(""+ maxLength.getValue());
		JLabel staticLabel = new JLabel(""+ staticLength.getValue());
	
	//create generate panel and its components   
	JPanel generate = new JPanel();
		JButton generateButton = new JButton("Generate");
		JButton copyPassword = new JButton("Copy");
		ButtonListener BL = new ButtonListener();
	
	//create setAllowable characters and its components
	JPanel setAllowableCharactersPanel = new JPanel();
		ArrayList<JCheckBox> checks= new ArrayList<JCheckBox>();
		CheckListener CL= new CheckListener();
		HoverListener HL = new HoverListener();
		
	//create hover message item
	JLabel hoverMessage = new JLabel("");

	//create password panel and its component
	JPanel pash = new JPanel();	
		JTextArea password = new JTextArea ("Click Generate!",3,20);
	
	//other variables
	character pikachu = new character();
    PasswordGenerator PG = new PasswordGenerator();
	int rowlength = 8;
	
	public PaPanel()
	{	

        //SetPreferred size for text Area
        password.setEditable(false);
        password.setLineWrap(true);

		//create and add borders for the panels
		Border B1 = BorderFactory.createTitledBorder("Set Password Length");
		Border b2 = BorderFactory.createTitledBorder("Set Allowable Characters");
		Border B3 = BorderFactory.createTitledBorder("Generate");
		setAllowableCharactersPanel.setBorder(b2);	
		setPasswordLengthPanel.setBorder(B1);
		generate.setBorder(B3);
		
		//add changeListeners to sliders
		minLength.addChangeListener(SL);
		maxLength.addChangeListener(SL);
		staticLength.addChangeListener(SL);
		
		//set layouts for panels		
		generate.setLayout(new FlowLayout());
		setPasswordLengthPanel.setLayout(new GridBagLayout());
		setAllowableCharactersPanel.setLayout( new GridBagLayout());
		this.setLayout(new GridBagLayout());
		
		//Add Components to generate panel
		generate.add(generateButton);
		generate.add(copyPassword);

		//AddComponents to password panel
		pash.add(password);


		//Add Components to set Password Length Panel
		AddItem(setPasswordLengthPanel,minLenLabel,0,0,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,minLength,0,1,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,maxLenLabel,0,2,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,maxLength,0,3,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,staticLenLabel,0,4,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,staticLength,0,5,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,minLabel,2,1,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,maxLabel,2,3,1,1,GridBagConstraints.WEST);
		AddItem(setPasswordLengthPanel,staticLabel,2,5,1,1,GridBagConstraints.WEST);
	

		//Add checkboxes to Array
		for (int i = 0; i < Profile.get(1).size(); i++)
		{
			int dec = Integer.parseInt(Profile.get(0).get(i));
			String nn = pikachu.getValue(dec);
			if(Integer.parseInt(Profile.get(1).get(i))==0)
			{
				checks.add(new JCheckBox(nn,false));
			}
			else
			{
				checks.add(new JCheckBox(nn,true));
			}
		}
		int k = 0;
		int div = checks.size()/rowlength;
		int rem = checks.size() % rowlength;
		int NumRows;
		if(rem == 0)
		{
			NumRows = div;
		}
		else
		{
			NumRows = div+1;
		}
		
		for(int n = 0; n<NumRows; n++)
		{
			for (int i = 0; i< rowlength;i++)
			{
				if(k < checks.size() )
				{
					AddItem(setAllowableCharactersPanel,checks.get(k),i,n,1,1,
					GridBagConstraints.WEST);
					k++;
				}
			
				else {/*do nothing*/}
			}
		}
		
		//add mouseListeners and action listenersto check boxes
		for(int i = 0; i<95;i++)
		{
			checks.get(i).addMouseListener(HL);
			checks.get(i).addActionListener(CL);
		}
		
		//Add Button Listeners
		generateButton.addActionListener(BL);
		copyPassword.addActionListener(BL);
		
		
		
		//Add Items to this
		AddItem(this,hoverMessage,0,0,1,1,GridBagConstraints.NORTHWEST);
		AddItem(this,setAllowableCharactersPanel,0,1,1,4,GridBagConstraints.NORTHWEST);
		
		AddItem(this,new JLabel("static length = 0 for random length"),1,0,1,1,GridBagConstraints.NORTHWEST);
		AddItem(this,setPasswordLengthPanel,1,1,1,1,GridBagConstraints.NORTHWEST);
		AddItem(this,generate,1,2,1,1,GridBagConstraints.NORTHWEST);
		AddItem(this,pash,1,4,1,1,GridBagConstraints.NORTHWEST);
		
		
	}

	private void AddItem(JPanel p, JComponent c, int x, int y, int width, 
		int height, int align)
	{
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx = 100.0;
		gc.weighty = 100.0;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c,gc);
	}
	
	private class HoverListener implements  MouseListener
	{
		public void mouseEntered(MouseEvent e)
		{
			for (int i = 0; i<95; i++)
			{
				if(e.getSource() == checks.get(i))
				{
					int a = Integer.parseInt(Profile.get(0).get(i));
					hoverMessage.setText( pikachu.getUnicode(a) +"  "+ pikachu.getDescription(a));
				}
				else{}
			}
			
		}
		public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseClicked(MouseEvent e){}
		public void mouseExited(MouseEvent e)
		{
			hoverMessage.setText("");
		}
	}

	private class SlideListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			if(e.getSource() == minLength) {minLabel.setText(""+minLength.getValue());}
			if(e.getSource() == maxLength) {maxLabel.setText(""+maxLength.getValue());}
			else {staticLabel.setText(""+staticLength.getValue());}
		}
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
            if (e.getSource() == generateButton)
            {
            	int L;
                if(staticLength.getValue() == 0)
                {
                    L = (int)(Math.random()*(maxLength.getValue()-minLength.getValue()) +minLength.getValue());
                }
                else
                {
                    L = staticLength.getValue();
                }
                
                
                password.setText(PG.generate(Profile,L));
            }
            else
            {
                StringSelection ss = new StringSelection(password.getText());
                Clipboard cpd = Toolkit.getDefaultToolkit().getSystemClipboard();
                cpd.setContents(ss, null);
            }
		}
	}
	private class CheckListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int i = 0; i<95; i++)
			{
				if(e.getSource() == checks.get(i))
				{
					int a = Integer.parseInt(Profile.get(1).get(i));
					if(a==0)
					{
						Profile.get(1).set(i,"1");
					}
					if(a==1)
					{
						Profile.get(1).set(i,"0");
					}
                    C.ConvertToCSV(Profile,"passwordrules.csv");
				}
				else{}
			}
			
		}
	}
}
