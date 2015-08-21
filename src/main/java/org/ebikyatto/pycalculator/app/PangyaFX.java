package org.ebikyatto.pycalculator.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.ebikyatto.pycalculator.app.controller.ModalController;
import org.ebikyatto.pycalculator.app.controller.PangyaFXController;

/**
 * Pangya Application
 * @author ebikyatto
 */
public class PangyaFX extends Application {

	/*
	 * Main
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		setUserAgentStylesheet(STYLESHEET_MODENA);
		
		// Main Window
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/fxml/PangyaFX.fxml"));
		Parent root = loader.load();
		PangyaFXController controller = loader.getController();
		
		stage.setScene(new Scene(root));
		stage.setTitle("Pangya Calculator by ebikytto");
		stage.setResizable(false);
		stage.show();
		
		// Modal Window
		Stage modal = new Stage();
		FXMLLoader modalLoader = new FXMLLoader(
				getClass().getResource("/fxml/Modal.fxml"));
		
		Parent modalRoot = modalLoader.load();
		ModalController modalController = modalLoader.getController();
		
		modal.setScene(new Scene(modalRoot));
		modal.initModality(Modality.WINDOW_MODAL);
		modal.initOwner(stage);
		modal.setTitle("Result");
		modal.setResizable(false);
		
		// Set Modal Stage to It's Controller
		controller.setStage(stage);
		modalController.setStage(modal);
		
		// Set Modal Controller to Main Controller
		controller.setModalController(modalController);
	}
}
