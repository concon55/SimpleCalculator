package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Calculator extends JFrame implements ActionListener{
	static JFrame f;
	static JTextField textField;
	String s0, s1, s2; 
	
	/**
	 * Constructor
	 */
	Calculator(){
		s0 = s1 = s2 = ""; 
	}
	
	/**
	 * Create buttons and add action listeners
	 * @param frame JFrame
	 * */
	private static void createUI(JFrame frame){
		Calculator c= new Calculator();
		JPanel p = new JPanel();
		
		GridBagLayout layout = new GridBagLayout();          
	    GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(layout);
		p.setBackground(Color.blue);
		
		textField = new JTextField(16); 
		textField.setEditable(false);
		
		//create buttons
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1; 
        b0 = new JButton("0"); 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8"); 
        b9 = new JButton("9");
        beq1 = new JButton("=");
        ba = new JButton("+"); 
        bs = new JButton("-"); 
        bd = new JButton("/"); 
        bm = new JButton("*"); 
        beq = new JButton("C");
        be = new JButton(".");
        
        //add action listeners
        bm.addActionListener(c); 
        bd.addActionListener(c); 
        bs.addActionListener(c); 
        ba.addActionListener(c); 
        b9.addActionListener(c); 
        b8.addActionListener(c); 
        b7.addActionListener(c); 
        b6.addActionListener(c); 
        b5.addActionListener(c); 
        b4.addActionListener(c); 
        b3.addActionListener(c); 
        b2.addActionListener(c); 
        b1.addActionListener(c); 
        b0.addActionListener(c); 
        be.addActionListener(c); 
        beq.addActionListener(c); 
        beq1.addActionListener(c); 
        
        //add elements to panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; p.add(ba, gbc);     
        gbc.gridx = 1; gbc.gridy = 0; p.add(b1, gbc); 
        gbc.gridx = 2; gbc.gridy = 0; p.add(b2, gbc); 
        gbc.gridx = 3; gbc.gridy = 0; p.add(b3, gbc); 
        gbc.gridx = 0; gbc.gridy = 1; p.add(bs, gbc); 
        gbc.gridx = 1; gbc.gridy = 1; p.add(b4, gbc); 
        gbc.gridx = 2; gbc.gridy = 1; p.add(b5, gbc); 
        gbc.gridx = 3; gbc.gridy = 1; p.add(b6, gbc); 
        gbc.gridx = 0; gbc.gridy = 2; p.add(bm, gbc); 
        gbc.gridx = 1; gbc.gridy = 2; p.add(b7, gbc); 
        gbc.gridx = 2; gbc.gridy = 2; p.add(b8, gbc); 
        gbc.gridx = 3; gbc.gridy = 2; p.add(b9, gbc); 
        gbc.gridx = 0; gbc.gridy = 3; p.add(bd, gbc); 
        gbc.gridx = 1; gbc.gridy = 3; p.add(be, gbc); 
        gbc.gridx = 2; gbc.gridy = 3; p.add(b0, gbc); 
        gbc.gridx = 3; gbc.gridy = 3; p.add(beq, gbc); 
        gbc.gridwidth = 3;

        gbc.gridx = 0; gbc.gridy = 4; p.add(textField, gbc);        
        gbc.gridx = 3; gbc.gridy = 4; p.add(beq1, gbc);
        f.getContentPane().add(p, BorderLayout.CENTER);      

	}
	
	/**
	 * Create the calculator window
	 */
	private static void createWindow(){
		f = new JFrame("Simple Calculator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI(f);
        f.setSize(325,325);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
	
	/**
	 * Gets the event to perform calculation on and evaluates
	 * @param e ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		  
        //if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
            textField.setText(s0 + s1 + s2); 
        }else if (s.charAt(0) == 'C') { //Clear
        	s0 = s1 = s2 = ""; 
        	textField.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == '=') {  //Equal
            double res; 
            if (s1.equals("+")) 
            	res = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
            	res = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
            	res = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
            	res = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
            String resStr ="";
            if (res % 1.0 != 0)
                resStr= String.format("%s", res);
            else
                resStr= String.format("%.0f", res);
            textField.setText(s0 + s1 + s2 + "=" + resStr); 
            s0 = resStr; 
            s1 = s2 = ""; 
        }else { 
        	if(s0.equals("")){ //invalid expression 
        		textField.setText("");
        	}
        	else if (s1.equals("") || s2.equals("")) //if no operand
                s1 = s; 
            else { 
                double res; 
                if (s1.equals("+")) 
                	res = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                	res = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                	res = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                	res = (Double.parseDouble(s0) * Double.parseDouble(s2));
                String resStr ="";
                if (res % 1.0 != 0)
                    resStr= String.format("%s", res);
                else
                    resStr= String.format("%.0f", res);
                s0 = resStr;
                s1 = s; 
                s2 = ""; 
            } 
            textField.setText(s0 + s1 + s2); 
        } 
	}
	
	
	public static void main(String args[]){
		createWindow();
	}

}
