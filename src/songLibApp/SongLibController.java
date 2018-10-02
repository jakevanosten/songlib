package songLibApp;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn.CellEditEvent;




public class SongLibController {

	/* controller: deals with event handling logic */
	
	/* FXML Widget IDs that will format the widgets within bottom HBox */
		//@FXML Button add;
		//@FXML Button delete;
		//@FXML Button edit;
	
	private TableView<Song> library;
	private ObservableList<Song> data;
	
	public void start(Stage primaryStage) {

	
	/*----- Song Library Title Label -----*/
	Label label = new Label("Song Library");
	label.setTextFill(Color.FIREBRICK);
	label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
	HBox titleBox = new HBox();
	titleBox.setAlignment(Pos.CENTER);
	titleBox.getChildren().add(label);
	
	/*----- Table view, data, columns and other properties -----*/
	library = new TableView<>();
	data = getInitialTableData();
	library.setItems(data);
	
	
	

	
	
	}
	
	private ObservableList<Song> getInitialTableData() {
		
		List<Song> list = new ArrayList<>();
		
		list.add(new Song("Versace On The Floor", "Bruno Mars", "24K Magic", "2016"));
		list.add(new Song("24k Magic", "Bruno Mars", "24K Magic", "2016"));
		list.add(new Song("Finesse", "Bruno Mars", "24K Magic", "2016"));
		
		ObservableList<Song> data = FXCollections.observableList(list);

		return data;
	}
	
		
	
	
}
