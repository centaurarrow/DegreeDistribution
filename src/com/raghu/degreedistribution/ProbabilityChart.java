package com.raghu.degreedistribution;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

/**
 * A simple demonstration application showing how to create a bar chart.
 *
 */
public class ProbabilityChart extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
	public int units;
	public int height;
    public ProbabilityChart(final String title,double[] probMat) {

        super(title);

        final IntervalXYDataset  dataset = createDataset(probMat);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 570));
        setContentPane(chartPanel);

    }

    /**
     * Returns a sample dataset.
     * 
     * @return The dataset.
     */
    private IntervalXYDataset  createDataset(double[] probMat) {
        
        // row keys...
        final String series1 = "First";

        // column keys...
        final String category1 = "Category 1";
       

        // create the dataset...
        final XYSeries series = new XYSeries("Probability Density Function");
        
        
        for(int i=0;i<probMat.length;i++){
        	double temp =  probMat[i];
        	series.add(i, temp);
       // 	System.out.print(probMat[i]);
        }
        final XYSeriesCollection dataset = new XYSeriesCollection(series);
        return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    	private JFreeChart createChart(IntervalXYDataset dataset) {
            final JFreeChart chart = ChartFactory.createXYBarChart(
                "Probability",
                "Number of links", 
                false,
                "Probabilities", 
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
            );
            XYPlot plot = (XYPlot) chart.getPlot();
            NumberAxis range = (NumberAxis) plot.getRangeAxis();
            range.setRange(0.0, 1);
            range.setTickUnit(new NumberTickUnit(0.01));

            final IntervalMarker target = new IntervalMarker(400.0, 700.0);
            target.setLabel("Target Range");
            target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
            target.setLabelAnchor(RectangleAnchor.LEFT);
            target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
            target.setPaint(new Color(222, 222, 255, 128));
            plot.addRangeMarker(target, Layer.BACKGROUND);
            return chart;    
        }
    

}
