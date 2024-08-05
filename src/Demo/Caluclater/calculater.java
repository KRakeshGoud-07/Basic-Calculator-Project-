package Demo.Caluclater;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class calculater implements ActionListener{
	double num1=0,num2=0,result=0;
	char operator;
	
	JTextField textfield=new JTextField();
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[8];
	JButton addButton, subButton, mulButton, divButton;
	JButton delButton, clrButton, decButton, equButton;
	JPanel panel=new JPanel();
	//constructor-----
	calculater(){
		
	JFrame frame=new JFrame("caluclater");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);//set layout is imp for input box
	frame.setSize(400,550);//fame size
	
	
	panel.setBounds(50,100,250,300);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel.setBackground(Color.GRAY);
	 
	
	
	//textfields
	 textfield.setBounds(50,25,250,50);
	 textfield.setEditable(false);//here no key boards is working only frame added buttons are used..
	    
	 addButton=new JButton("+");
	 subButton=new JButton("-");
	 mulButton=new JButton("*");
	 divButton=new JButton("/");
	 decButton=new JButton(".");
	 equButton=new JButton("=");
	 delButton=new JButton("Delete");
	 clrButton=new JButton("Clear");
	   
	 functionButton[0]=addButton;
	 functionButton[1]=subButton;
	 functionButton[2]=mulButton;
	 functionButton[3]=divButton;
	 functionButton[4]=decButton;
	 functionButton[5]=equButton;
	 functionButton[6]=delButton;
	 functionButton[7]=clrButton;
	  
	 
	 
	 for(int i=0; i<8; i++)
	 {
		 functionButton[i].addActionListener(this);
		 functionButton[i].setFocusable(false);
		 //frame.add(functionButton[i]);
	 }
	   
	 for(int i=0; i<10; i++)
	 {
		 numberButton[i]=new JButton(String.valueOf(i));
		 numberButton[i].addActionListener(this);
		 numberButton[i].setFocusable(false);
	 }
	 
	 panel.add(numberButton[1]);
	 panel.add(numberButton[2]);
	 panel.add(numberButton[3]);
	 panel.add(addButton);
	 panel.add(numberButton[4]);
	 panel.add(numberButton[5]);
	 panel.add(numberButton[6]);
	 panel.add(subButton);
	 panel.add(numberButton[7]);
	 panel.add(numberButton[8]);
	 panel.add(numberButton[9]);
	 panel.add(mulButton);
	 panel.add(decButton);
	 panel.add(numberButton[0]);
	 panel.add(equButton);
	 panel.add(divButton);
	 
	 
	 
	 delButton.setBounds(50,430,120,50);
	 clrButton.setBounds(170,430,130,50);
	
	
	 frame.add(delButton);
	 frame.add(clrButton);
	 frame.add(panel);
	 frame.add(textfield);
	 frame.setVisible(true);
	}
	//@OVERRIDE
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<10; i++)
		{
			//Object[] numberButton;
			if(e.getSource()== numberButton[i])
			{
			 
				String currentText = textfield.getText();
				String intasString = String.valueOf(i);
				String newText= currentText.concat(intasString);
				textfield.setText(newText);
				//2nd way
				//textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() ==  decButton)
		{
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		 if(e.getSource() == subButton)
		 {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '-';
			 textfield.setText("");
		 }
		 if(e.getSource() == mulButton)
		 {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '*';
			 textfield.setText("");
		 }
		 if(e.getSource()== divButton)
		 {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '/';
			 textfield.setText("");
		 }
		 if(e.getSource() == equButton)
		 {
			 num2 = Double.parseDouble(textfield.getText());
			 switch(operator)
			 {
			 case '+':
				 result=num1+num2;
				 break;
			 case '-':
				 result=num1-num2;
				 break;
			 case '*':
				 result = num1 *num2;
				 break;
			 case '/':
				 result= num1/num2;
				 break;
			 }
			 textfield.setText(String.valueOf(result));
			 num1=0;
					 
		 }
		  if(e.getSource()==clrButton)
		  {
			  textfield.setText("");
		  }
		  if(e.getSource() == delButton)
		  {
			  String string = textfield.getText();
			  textfield.setText("");
			  for(int i=0;i<string.length()-1; i++)
			  {
				  textfield.setText(textfield.getText()+string.charAt(i));
			  }
		  }
		 
	}
	public static void main(String args[])
	{
		 calculater calc=new calculater();
		 
	}
}
