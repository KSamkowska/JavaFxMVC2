package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		mainWindow();
	}
	public void mainWindow(){ //opis okna
		try{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));
		
	AnchorPane pane=loader.load();
	primaryStage.setMinWidth(700.0);
	primaryStage.setMinHeight(500.0);
	Scene scene=new Scene(pane);
	MainWindowController mainWindowController=loader.getController();
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 //firstNameText.getStyleClass().add("my-field");
	// zapiszButton.getStyleClass().add("label");
	
	mainWindowController.setMain(this,primaryStage);
	
	primaryStage.setScene(scene);
	primaryStage.show();
		}
	catch(IOException e){e.printStackTrace();}}
		
	public static void main(String[] args) {
		launch(args);
	}
}
