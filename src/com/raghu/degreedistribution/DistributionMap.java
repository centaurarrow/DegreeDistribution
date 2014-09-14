package com.raghu.degreedistribution;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

public class DistributionMap extends JFrame implements ActionListener {
	public static int units = 0 ;
	public static int height = 0 ;
	public static ArrayList<Point2D.Double> centers;
	private int centersCnt[];
	
	public DistributionMap(int units, int height) {
		// TODO Auto-generated constructor stub
		
		DistributionMap.units = units;
		DistributionMap.height = height;
		
		centers = new ArrayList<Point2D.Double>();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.setSize(DistributionMap.units,DistributionMap.units);

		JButton generateButton = new JButton("Show PDF");
		generateButton.setBounds(20, 20, 20, 25);
		panel.add(generateButton);
		
		this.setLocation(600, 300);
		this.add(panel);
		this.setPoints();
		//drawProbabilityDensity(centersCnt);
	}
	
	public void setPoints()
	   {
			for(int i = 0; i < DistributionMap.units ; i++) {
			         double x = (double) (Math.random() * DistributionMap.units);
			         double y = (double) (Math.random() * DistributionMap.units);
			         centers.add(new Point2D.Double(x, y));
	           }
			centersCnt = new int[centers.size()];
			int adj[][] = new int[centers.size()][centers.size()];
			for (int i = 0; i < centers.size(); i++) {
				System.out.print(centers.get(i).getX()+" "+centers.get(i).getY()+":");
				int cnt1=0;
				for(int j = 0;j < centers.size(); j++){
					if(i!=j){
						if(distanceBetweenPoints(centers.get(i).getX(),centers.get(i).getY(),centers.get(j).getX(),centers.get(j).getY()) <= DistributionMap.height)
							{
							adj[i][j]=1;
						//		System.out.print(", "+centers.get(j).getX()+" "+centers.get(j).getY());
								cnt1++;
							}
						else{
							adj[i][j]=0;
						}
					}
				}
				centersCnt[i] = cnt1;
			//	System.out.print(" "+cnt1);
			//	System.out.println("");
			}
			
			for(int i=0;i<centers.size();i++){
				for(int j=0;j<centers.size();j++){
					System.out.print(" "+adj[i][j]);
				}
				System.out.println("");
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


