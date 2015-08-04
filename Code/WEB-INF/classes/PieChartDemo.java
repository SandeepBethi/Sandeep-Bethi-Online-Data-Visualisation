package data;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.ArrayList;
import java.io.File;
public class PieChartDemo extends ApplicationFrame {
static ArrayList<Pattern> list;
   
    public PieChartDemo(String title,ArrayList<Pattern> l) {
        super(title);
		list=l;
        setContentPane(createDemoPanel());
    }

  
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
          for(int i=0;i<list.size();i++){
			  Pattern pat = list.get(i);
		String s[]=list.get(i).toString().split(",");
        dataset.setValue(pat.getProduct(), pat.getCount());
		  }
        return dataset;        
    }
    
   
    private static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Pie Chart Demo",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
  
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
		try{
	File f=new File("D:/pie.jpg");
	ChartUtilities.saveChartAsJPEG(f,chart,800,600);
	}catch(Exception e){
		e.printStackTrace();
	}
        return new ChartPanel(chart);
    }
    
   
   

}
