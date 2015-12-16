package ManipulacaoArquivos;

import models.alg;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ShapeUtilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class Graficos {
    public void GerarGraficos(String metodo, float[] tempo, long[]qtNumeros){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(int i =0; i < tempo.length; i++){
            data.addValue(tempo[i],"Tempo Gasto",String.valueOf(qtNumeros[i]));
        }


        JFreeChart grafico = ChartFactory.createLineChart(
                metodo,                  // chart title
                "Quantidade de Numeros", // x axis label
                "Tempo Gasto(Segundos)",       // y axis label
                data,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );
        CategoryPlot plot = (CategoryPlot) grafico.getPlot();
        DecimalFormat decimalformat1 = new DecimalFormat("#,##### 0.00000");
        StandardCategoryItemLabelGenerator labelGenerator = new StandardCategoryItemLabelGenerator("{2}", decimalformat1);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(labelGenerator);
        renderer.setBaseItemLabelFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 15));

        renderer.setSeriesShape(0, ShapeUtilities.createDiamond(1F));

        plot.setRenderer(renderer);

//        LogAxis logAxis = new LogAxis("Tempo Em Segundos");
//        logAxis.setBase(2);
//        logAxis.setTickUnit(new NumberTickUnit(1));
//        logAxis.setMinorTickMarksVisible(true);
//        //logAxis.setNumberFormatOverride(decimalformat1);
//        logAxis.setAutoRange(true);
//        plot.setRangeAxis(logAxis);

        OutputStream arquivo = null;
        try {
            arquivo = new FileOutputStream("./"+metodo +" grafico.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 800, 600);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void GerarGraficos(List<alg> Algoritmo, String nome){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        long[]qtNumeros ={100, 1000, 10000, 100000, 1000000};
        for(alg algoritmo: Algoritmo){


            for(int i =0; i < algoritmo.tempo.length; i++){
                data.addValue(algoritmo.tempo[i], algoritmo.getNome(), String.valueOf(qtNumeros[i]));
            }
        }

        JFreeChart grafico = ChartFactory.createLineChart(
                "Comparacoes Algoritmos de Ordenacao",                   // chart title
                "Quantidade de Numeros",  // x axis label
                "Tempo Gasto(Segundos)",        // y axis label
                data,                     // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );
        CategoryPlot plot = (CategoryPlot) grafico.getPlot();
        DecimalFormat decimalformat1 = new DecimalFormat("#,#### 0.0000");
        StandardCategoryItemLabelGenerator labelGenerator = new StandardCategoryItemLabelGenerator("{2}", decimalformat1);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(labelGenerator);
        renderer.setBaseItemLabelFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 15));

        renderer.setSeriesShape(0, ShapeUtilities.createDiamond(1F));

        plot.setRenderer(renderer);

        LogAxis logAxis = new LogAxis("Tempo Em Segundos");

//        logAxis.setBase(2);
//        logAxis.setTickUnit(new NumberTickUnit(1));
//        logAxis.setMinorTickMarksVisible(true);
//      //  logAxis.setNumberFormatOverride(decimalformat1);
//        logAxis.setAutoRange(true);
//        plot.setRangeAxis(logAxis);


        OutputStream arquivo = null;
        try {
            arquivo = new FileOutputStream("./Grafico de Comparacoes Algoritmos de Ordenacao "+nome+".png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 800, 600);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void GerarGraficosfuncoes(String metodo, float[] tempo, long[]qtNumeros){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(int i =0; i < tempo.length; i++){
            data.addValue(tempo[i],"Tempo Gasto",String.valueOf(qtNumeros[i]));
        }


        JFreeChart grafico = ChartFactory.createLineChart(
                metodo,                  // chart title
                "Valor do numero de entrada", // x axis label
                "Resultado Funcao",       // y axis label
                data,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );
        CategoryPlot plot = (CategoryPlot) grafico.getPlot();
        DecimalFormat decimalformat1 = new DecimalFormat("#,##### 0.00000");
        StandardCategoryItemLabelGenerator labelGenerator = new StandardCategoryItemLabelGenerator("{2}", decimalformat1);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(labelGenerator);
        renderer.setBaseItemLabelFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 15));

        renderer.setSeriesShape(0, ShapeUtilities.createDiamond(1F));

        plot.setRenderer(renderer);

//        LogAxis logAxis = new LogAxis("Tempo Em Segundos");
//        logAxis.setBase(2);
//        logAxis.setTickUnit(new NumberTickUnit(1));
//        logAxis.setMinorTickMarksVisible(true);
//        //logAxis.setNumberFormatOverride(decimalformat1);
//        logAxis.setAutoRange(true);
//        plot.setRangeAxis(logAxis);

        OutputStream arquivo = null;
        try {
            arquivo = new FileOutputStream("./"+metodo +" grafico.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 800, 600);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
