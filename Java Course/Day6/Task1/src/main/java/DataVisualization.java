import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataVisualization
{
    public void GraphPassengerAges(List<TitanicPassenger> passengerList)
    {
        List<Float> pAges = passengerList.stream().map(TitanicPassenger::getAge).limit(8).collect(Collectors.toList());
        List<String> pNames = passengerList.stream().map(TitanicPassenger::getName).limit(8).collect(Collectors.toList());

        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        chart.addSeries("Passenger's Ages", pNames, pAges);

        new SwingWrapper(chart).displayChart();
    }

    public void GraphPassengerClass(List<TitanicPassenger> passengerList)
    {
        Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting()));

        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);

        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));

        new SwingWrapper(chart).displayChart();
    }

    public void GraphPassengerSurvived(List<TitanicPassenger> passengerList)
    {
        Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger::getSurvived, Collectors.counting()));

        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);

        chart.addSeries("عاش عاش", result.get("1"));
        chart.addSeries("مات مات", result.get("0"));

        new SwingWrapper(chart).displayChart();
    }

    public void GraphPassengerSurvivedGender(List<TitanicPassenger> passengerList)
    {
        Map<String, Long> result = passengerList.stream().filter(s->s.getSurvived().equals("1")).collect(Collectors.groupingBy(TitanicPassenger::getSex, Collectors.counting()));

        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);

        //chart.addSeries("FemaleSurvived", result.get("female"));
        //chart.addSeries("MaleSurvived", result.get("male"));

        chart.addSeries("روز", result.get("female"));
        chart.addSeries("الغنى الى كان بيحب روز", result.get("male"));

        new SwingWrapper(chart).displayChart();
    }
}
