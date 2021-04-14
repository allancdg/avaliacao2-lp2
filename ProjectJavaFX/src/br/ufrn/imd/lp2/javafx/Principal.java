package br.ufrn.imd.lp2.javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application {
	
	private Stage main;
	private BorderPane telaPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		main = primaryStage;
		main.setTitle("Sistema de vendas");
		initPrincipal();
	}

	private void initPrincipal() {
		try{
			// Carrega o arquivo FXML 
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Principal.class.getResource("view/TelaPrincipal.fxml"));
			telaPrincipal = (BorderPane) loader.load();
			
			// Mostra a scene contendo o layout
			Scene scene = new Scene(telaPrincipal);
			main.setScene(scene);
			main.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO Auto-generated method stub
		
	public static void main(String[] args) {
		launch(args);
	}
}
