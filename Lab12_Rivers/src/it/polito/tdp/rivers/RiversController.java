package it.polito.tdp.rivers;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {

	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> boxRiver;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtNumMeasurements;

    @FXML
    private TextField txtFMed;

    @FXML
    private TextField txtK;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doMostra(ActionEvent event) {

    	txtStartDate.clear();
    	txtEndDate.clear();
    	txtNumMeasurements.clear();
    	txtFMed.clear();
    	River selez = boxRiver.getValue();
    	if(selez == null){
    		txtResult.appendText("Seleziona un fiume.\n");
    		return;
    	}
    	
    	Flow primaMisurazione = model.getPrimaMisurazione(selez);
    	Flow ultimaMisurazione = model.getUltimaMisurazione(selez);
    	
    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	txtStartDate.appendText(primaMisurazione.getDay().toString());//al posto del toString() mettere .format(formatter)
    	txtEndDate.appendText(ultimaMisurazione.getDay().toString());
    	txtNumMeasurements.appendText(model.getNumeroMisurazioni(selez)+"");
    	txtFMed.appendText(model.getFlussoMedio(selez)+"");
    	
    	
    	
    	
    }

    @FXML
    void doSimula(ActionEvent event) {

    	River selez = boxRiver.getValue();
    	float fMed= model.getFlussoMedio(selez);
    	if(selez == null){
    		txtResult.appendText("Seleziona un fiume.\n");
    		return;
    	}
    	String k = txtK.getText();//Float.parseFloat(txtK.getText());
    	int K = 0;
    	if(!k.isEmpty()){
    		try{
    			K = Integer.parseInt(txtK.getText());
    		}catch(Exception e){
    			txtResult.appendText("Inserire un valore intero per k.\n");
    		}
    	}else{
    		txtResult.appendText("Inserire un valore intero per k.\n");
    	}
    	
    	txtResult.appendText(model.creaSimulazione(selez, K, fMed));
    	
    	
    	
    	
    }

    @FXML
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;		
		this.boxRiver.getItems().addAll(model.getAllRivers());
	}
}