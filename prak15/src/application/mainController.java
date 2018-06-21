package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class mainController 
{
	@FXML private Wuerfel wuerfel;
	@FXML private TextField anzahlWuerfe;
	@FXML private TableView tabHaeufigkeiten;
	@FXML private TableColumn spalteAugenzahl;
	@FXML private TableColumn spalteAbs;
	@FXML private TableColumn spalteRel;
	@FXML private PieChart diaHaeufigkeiten;
	
	@FXML
	public void handleWuerfeln()
	{
		wuerfel = new Wuerfel();
		try
		{
			wuerfel.wuerfeln( Integer.parseInt(anzahlWuerfe.getText()) );
		}
		catch (NumberFormatException e)
		{
			System.out.println("gehe dich aufhängen");
		}
		showTableView();
		showPieChart();
	}
	
	public void showTableView()
	{
		ObservableList<Haeufigkeiten> data = FXCollections.observableArrayList(
		  new Haeufigkeiten( "Eins", wuerfel.getAbsHaeufigkeit(0), wuerfel.getRelHaeufigkeit(0) ),
		  new Haeufigkeiten( "Zwei", wuerfel.getAbsHaeufigkeit(1), wuerfel.getRelHaeufigkeit(1) ),
		  new Haeufigkeiten( "Drei", wuerfel.getAbsHaeufigkeit(2), wuerfel.getRelHaeufigkeit(2) ),
		  new Haeufigkeiten( "Vier", wuerfel.getAbsHaeufigkeit(3), wuerfel.getRelHaeufigkeit(3) ),
		  new Haeufigkeiten( "Fünf", wuerfel.getAbsHaeufigkeit(4), wuerfel.getRelHaeufigkeit(4) ),
		  new Haeufigkeiten( "Sechs", wuerfel.getAbsHaeufigkeit(5), wuerfel.getRelHaeufigkeit(5))
		);
		
		spalteAugenzahl.setCellValueFactory(new PropertyValueFactory("augenzahl"));
		spalteAbs.setCellValueFactory(new PropertyValueFactory("absHaeufigkeit"));
		spalteRel.setCellValueFactory(new PropertyValueFactory("relHaeufigkeit"));
		
		tabHaeufigkeiten.setItems(data);
	}
	
	public void showPieChart()
	{
		String[] augenzahl = { "1", "2", "3", "4", "5", "6" };
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		for(int i = 0; i < 6; ++i)
		{
			data.add( new PieChart.Data(augenzahl[i], wuerfel.getRelHaeufigkeit(i)) );
		}
		
		diaHaeufigkeiten.setData(data);
		diaHaeufigkeiten.setTitle("Relative Häufigkeiten");
	}
	
}
