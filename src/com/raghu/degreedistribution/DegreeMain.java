package com.raghu.degreedistribution;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DegreeMain extends JFrame implements ActionListener {

	JLabel unitsLabel,distanceLabel;
	JTextField unitsText,distanceText;
	JButton generateButton;
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		DegreeMain frame = new DegreeMain(panel);

		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		frame.setResizable(false); 
		frame.setLocation(700, 500);
		frame.setVisible(true);
	}

	private DegreeMain(JPanel panel) {

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
		distanceText.setText("10");
		distanceText.setBounds(200, 40, 160, 25);
		panel.add(distanceText);

	
		generateButton = new JButton("Generate PDF");
		generateButton.setBounds(180, 80, 120, 25);
		panel.add(generateButton);
		
		generateButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
    {
		DistributionMap distributionMap = new DistributionMap(Integer.parseInt(unitsText.getText()),Integer.parseInt(distanceText.getText()));
	//	distributionMap.setVisible(true);
		distributionMap.drawProbabilityDensity();
		DistributionMapFinal dmapfinal = new DistributionMapFinal(distributionMap.centers,Integer.parseInt(distanceText.getText()));
		dmapfinal.setVisible(true);
    }

}