package com.raghu.degreedistribution;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

public class DistributionMapFinal extends JFrame implements ActionListener {
	public static int units = 0 ;
	public static int height = 0 ;
	public static ArrayList<Point2D.Double> centers;
	private int centersCnt[];
	
	public DistributionMapFinal(ArrayList<Point2D.Double> centers,int height) {
		// TODO Auto-generated constructor stub
		
		DistributionMapFinal.centers = centers;
		DistributionMapFinal.height = height;
	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.setSize(500,500);

		JButton generateButton = new JButton("Show PDF");
		generateButton.setBounds(20, 20, 20, 25);
		panel.add(generateButton);
		
		this.setLocation(600, 300);
		this.add(panel);
		//drawProbabilityDensity(centersCnt);
	}
	
	public void paint(Graphics g)
	   {
			 Graphics2D ga = (Graphics2D)g;
			 ga.setPaint(Color.red);
			centersCnt = new int[centers.size()];
			int adj[][] = new int[centers.size()][centers.size()];
			for (int i = 0; i < centers.size(); i++) {

				int cnt1=0;
				for(int j = 0;j < centers.size(); j++){
						if(distanceBetweenPoints(centers.get(i).getX()*5,centers.get(i).getY()*5,centers.get(j).getX()*5,centers.get(j).getY()*5) <= DistributionMapFinal.height*5)
							{
							adj[i][j]=1;
							ga.drawLine((int)centers.get(i).getX()*5+1, (int)centers.get(i).getY()*5+1, (int)centers.get(j).getX()*5+1, (int)centers.get(j).getY()*5+1);
					//		g.drawLine(100+i,100,200,200);
								System.out.print((int)centers.get(i).getX()*5 +" "+(int)centers.get(i).getY()*5+" "+(int)centers.get(j).getX()*5+" "+ (int)centers.get(j).getY()*5+" ");
								cnt1++;
							}
						else{
							adj[i][j]=0;
						}
				}
				centersCnt[i] = cnt1;
			}
			
	   }

	public void drawProbabilityDensity() {
		// TODO Auto-generated method stub
		final BarChartDemo demo = new BarChartDemo("Probability Density Function",centersCnt,units,height);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
    {
		drawProbabilityDensity();
    }
	
	public double distanceBetweenPoints (double x1,double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
}


