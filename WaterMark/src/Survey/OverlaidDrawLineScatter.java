package Survey;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demonstration application show the line and scatter.
 */
public class OverlaidDrawLineScatter extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	public OverlaidDrawLineScatter(String title) {
        super(title);
    }

    /**
     * Creates an overlaid chart.
     *
     * @return The chart.
     */
    private JFreeChart createOverlaidChart() {
    	// Add first data set and rendererLine
        DefaultXYDataset dataLine = createDatasetLine();
        XYItemRenderer rendererLine = new XYLineAndShapeRenderer();
        NumberAxis XAxis = new NumberAxis("X 值");
        NumberAxis YAxis = new NumberAxis("Y 值");
		NumberTickUnit unit=new NumberTickUnit(0.5);
		XAxis.setTickUnit(unit);
		YAxis.setTickUnit(unit);
        
        // create plot
        XYPlot plot = new XYPlot(dataLine, XAxis, YAxis, rendererLine);

        // Add second data set and rendererScatter
        DefaultXYDataset dataScatter = createDatasetScatter();
        XYItemRenderer rendererScatter = new XYShapeRenderer();
        plot.setDataset(1, dataScatter);
        plot.setRenderer(1, rendererScatter);

        // return a new chart containing the overlaid plot
        return new JFreeChart("线性拟合y=0.08362 x + 57.34\n", JFreeChart.DEFAULT_TITLE_FONT, plot, true);

    }

    /**
     * Generate the dataset
     * @return The dataset.
     */
    private DefaultXYDataset createDatasetLine() {

    	DefaultXYDataset dataset = new DefaultXYDataset();
    	double[][] data= {{1,2,3},{57.4,57.51,57.59}};
    	dataset.addSeries("拟合数据", data);
        return dataset;
    }
    
    private DefaultXYDataset createDatasetScatter() {
        DefaultXYDataset dataset = null;
        try {
            dataset = BMIData.DataSet3();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
    
    public ChartPanel getPanel() {
        JFreeChart chart = createOverlaidChart();
        ChartPanel panel = new ChartPanel(chart, true, true, true, true, true);
        panel.setPreferredSize(new java.awt.Dimension(650, 500));
        return panel;


    }
}