package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
	 private Main main;
	 private Stage primaryStage;
	 Scanner in = null;
		String room;
		String firstName;
		String lastName;
		int start;
		int finish;
		PrintWriter out = null;
		
		
		 //deklaracja zmiennych z scenebuilder
	@FXML private TableView<Person> tableView;
	 @FXML private TableColumn<Person,String> firstNameColumn;
	 @FXML private TableColumn<Person,String> lastNameColumn;
	 @FXML private TableColumn<Person,String> roomColumn;
	 @FXML private TableColumn<Person,Integer> startColumn;
	 @FXML private TableColumn<Person,Integer> finishColumn;
	 @FXML private TableColumn<Person,Integer> hourColumn;
	 @FXML private TextField firstNameText;
	 @FXML private TextField lastNameText;
	 @FXML private TextField roomText;
	 @FXML private TextField startText;
	 @FXML private TextField finishText;
	 @FXML private Button wczytajButton;
	 @FXML private Button zapiszButton;
	 @FXML private Button dodajButton;
	 @FXML private Button raportButton;
	 @FXML private ListView<Person> planListView;
	 @FXML private GridPane roomPane;
	 @FXML private Rectangle room1;
	 @FXML private Rectangle room2;
	 @FXML private ImageView planImageView;
	 
	 
	 
	 
	 
	 private ObservableList<Person> personList=FXCollections.observableArrayList(); //przechowywanie danych, ktore mozna przegladac


	public void setMain(Main main,Stage primaryStage){
		// setTable();
		 tableView.setItems(personList);}
	 
	 @FXML
	 public void wczytaj(){
		 try {
			 personList.clear();
			 
			//sciezka dla folderow na komuterze politechniki:
			// in = new Scanner(Paths.get("/home/users/ksamkows/workspace/workspaceFX/MVCPracaDomowa3_KSamkowska/src/outfile.txt"));
				//in = new Scanner(Paths.get("C:/Users/Kasia/eclipse-workspace/workspaceFX/MVCPracaDomowa3_KSamkowska/src/outfile.txt"));
			 in = new Scanner(Paths.get("src/outfile.txt"));
				while (in.hasNext()) { // odczytanie token po tokenie, czyli cos do spacji
					firstName = in.next();
					lastName = in.next();
					room = in.next();
					start=in.nextInt();
					finish=in.nextInt();
					
					personList.add(new Person(firstName, lastName,room,start,finish));
				}
		} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) { // jeżeli otwarcie się nie uda, dalej będzie nullem. Jezeli otworzy się, czyli nie będzie juz nullem->zamykamy
					in.close();}
						}
			}
	 @FXML
	 private void zapisz(){
		 try {
			 
			//sciezka dla folderow na komuterze politechniki:
			 //out = new PrintWriter("/home/users/ksamkows/workspace/workspaceFX/MVCPracaDomowa3_KSamkowska/src/outfile.txt");
			// out = new PrintWriter("C:/Users/Kasia/eclipse-workspace/workspaceFX/MVCPracaDomowa3_KSamkowska/src/outfile.txt");
			 out = new PrintWriter("src/outfile.txt");
			 //Collections.sort(personList, new Sortowanie());
				for (int i = 0; i < personList.size(); i++) {
					out.printf("%s %s %s %d %d\n", 
							personList.get(i).getFirstName(),
							personList.get(i).getLastName(), 
							personList.get(i).getRoom(),
							personList.get(i).getStart(), 
							personList.get(i).getFinish());
				}
		 } catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) { // jeżeli otwarcie się nie uda, dalej będzie nullem. Jezeli otworzy się, czyli nie będzie juz nullem->zamykamy
					out.close();
				}}
		 }
	 @FXML
	 private void dodaj(){
		 personList.add(new Person(firstNameText.getText(),lastNameText.getText(),roomText.getText(),Integer.parseInt(startText.getText()),Integer.parseInt(finishText.getText())));
		 
	 }
	 @FXML
	 private void raport(){
		 
		 try {
			 
			//sciezka dla folderow na komuterze politechniki:
			 //PrintWriter raport = new PrintWriter("/home/users/ksamkows/workspace/workspaceFX/MVCPracaDomowa3_KSamkowska/src/outfile2.txt");
			 //PrintWriter raport = new PrintWriter("C:/Users/Kasia/eclipse-workspace/workspaceFX/MVCPracaDomowa3_KSamkowska/src/outfile2.txt");
			 PrintWriter raport = new PrintWriter("src/outfile2.txt");
			 Collections.sort(personList, new Sortowanie());
			 for (int i = 0; i < personList.size(); i++) {
					raport.printf("%s %s %s %d %d %s\n",
							personList.get(i).getFirstName(),
							personList.get(i).getLastName(), 
							personList.get(i).getRoom(),
							personList.get(i).getStart(), 
							personList.get(i).getFinish(),
							" czas pracy : " + (personList.get(i).getFinish()
									- personList.get(i).getStart()));
					
				}
			 raport.close();
				System.out.println("Sortowanie wykonane, otworz raport aby sprawdzic szczegoly" );
		 } catch (IOException e) {
				e.printStackTrace();
		 }
		 }
	// private void setTable(){
	//	 personList.add(new Person("10","Charlie","Brown"));
	//	 personList.add(new Person("11","Jan","Kowalski"));
	//	 personList.add(new Person("12","Stefan","Nowak"));}
	 
	 
	 
	 
	 public void initialize(){ //wiazanie kolumny z odpowiednim polem klasy Person
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
		roomColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("room") );
		startColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("start") );
		finishColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("finish") );
		//powi�zanie akcji nacisniecia przycisku z funkcja
		wczytajButton.setOnAction((event)->{wczytaj();});
		zapiszButton.setOnAction((event)->{zapisz();});
		dodajButton.setOnAction((event)->{dodaj();});
		raportButton.setOnAction((event)->{raport();});
		
		tableView.getSelectionModel().selectedItemProperty().addListener((ov,oldVal,newVal)->{
				firstNameText.setText(newVal.getFirstName());
				lastNameText.setText(newVal.getLastName());
				roomText.setText(newVal.getRoom());
				startText.setText(newVal.getStartTxt());
				finishText.setText(newVal.getFinishTxt());
				Integer k=Character.getNumericValue(newVal.getRoom().charAt(0));
				
				//zajetosc poszczegolnych biur
				if (k == 1) {
					Image image1 = new Image(getClass().getResourceAsStream("1.gif"));
					planImageView.setImage(image1);
					System.out.println("Osoba znajduje si� w pokoju 1" );
				} else if (k== 2) {
					Image image2 = new Image(getClass().getResourceAsStream("2.gif"));
					planImageView.setImage(image2);
					System.out.println("Osoba znajduje si� w pokoju 2" );
				} else if (k == 3) {
					Image image3 = new Image(getClass().getResourceAsStream("3.gif"));
					planImageView.setImage(image3);
				} else if (k == 4) {
					Image image4 = new Image(getClass().getResourceAsStream("4.gif"));
					planImageView.setImage(image4);
				} else if (k == 5) {
					Image image5 = new Image(getClass().getResourceAsStream("5.gif"));
					planImageView.setImage(image5);
				} else if (k == 6) {
					Image image6 = new Image(getClass().getResourceAsStream("6.gif"));
					planImageView.setImage(image6);
				} else {Image image0 = new Image(getClass().getResourceAsStream("0.gif"));
				planImageView.setImage(image0);}
				System.out.println("zajety jest pokoj nr "+newVal.getRoom());	
				
		});
		
		
	 }
	// funkcja sortująca
		class Sortowanie implements Comparator<Person> {

			@Override
			public int compare(Person p1, Person p2) {
				if ((p1.getFinish()
						- p1.getStart()) > ((p2.getFinish() - p2.getStart())))
					return 1;
				return 0;
			}

		}

}

