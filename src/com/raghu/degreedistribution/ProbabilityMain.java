package com.raghu.degreedistribution;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

public class ProbabilityMain extends JFrame implements ActionListener {

	JLabel unitsLabel,distanceLabel;
	JTextField unitsText,distanceText,numberText;
	JButton generateButton;
	private JLabel NumberLabel;
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		ProbabilityMain frame = new ProbabilityMain(panel);

		frame.setSize(400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		frame.setResizable(false); 
		frame.setLocation(700, 500);
		frame.setVisible(true);
	}

	private ProbabilityMain(JPanel panel) {

		panel.setLayout(null);

		unitsLabel = new JLabel("Enter the number of units");
		unitsLabel.setBounds(10, 10, 180, 25);
		panel.add(unitsLabel);

		unitsText = new JTextField(20);
		unitsText.setText("100");
		unitsText.setBounds(200, 10, 160, 25);
		panel.add(unitsText);

		distanceLabel = new JLabel("Enter the distance (d)");
		distanceLabel.setBounds(10, 40, 180, 25);
		panel.add(distanceLabel);

		distanceText = new JTextField(20);
		distanceText.setText("30");
		distanceText.setBounds(200, 40, 160, 25);
		panel.add(distanceText);
		
		NumberLabel = new JLabel("Enter the Number of nodes");
		NumberLabel.setBounds(10, 80, 180, 25);
		panel.add(NumberLabel);

		numberText = new JTextField(20);
		numberText.setText("0");
		numberText.setBounds(200, 80, 160, 25);
		panel.add(numberText);

	
		generateButton = new JButton("Generate PDF");
		generateButton.setBounds(180, 120, 120, 25);
		panel.add(generateButton);
		
		generateButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
    {
		System.out.println(Integer.parseInt(unitsText.getText()));
		System.out.println(Integer.parseInt(distanceText.getText()));
		System.out.println(Integer.parseInt(numberText.getText()));
		
		int lambda = 0;
		int numberofnodes = Integer.parseInt(unitsText.getText());
		int distance = Integer.parseInt(distanceText.getText());
		double probability = 0;
		int noofnodesp = 20;
		double probMat[] = new double[noofnodesp];
		
		probability = ((Math.PI)*(distance*distance))/(numberofnodes*numberofnodes);
		lambda = (int) (probability*(numberofnodes-1));
		System.out.println(lambda);
		
		for(int i=0;i<noofnodesp;i++){
		//	double temp = ((1/power(Math.E,lambda))*(((lambda)^i)/(factorial(i))));
			double temp = (1/power(Math.E,lambda))*(power(lambda,i));
			temp = temp/(factorial(i));
			probMat[i] = temp;
			System.out.println(temp);
		}
		
		final ProbabilityChart demo = new ProbabilityChart("Probability Density Function",probMat);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
	
	public static long factorial(int n) {
			long result = 1;
	       for (int i = 1; i <= n; i++) {
	           result = result * i;
	       }
	   //    System.out.println("factorial:"+result);
	       return result;
	   }

	public static double power(double d,int n) {
	       double result = 1;
	       for (int i = 1; i <= n; i++) {
	           result = result * d;
	       }
	   //    System.out.println("power:"+result);
	       return result;
	   }
}