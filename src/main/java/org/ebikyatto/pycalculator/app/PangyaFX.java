package org.ebikyatto.pycalculator.app;

import org.ebikyatto.pycalculator.app.controller.ModalController;
import org.ebikyatto.pycalculator.app.controller.PangyaFXController;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class PangyaFX extends Application {

	public static void main(String[] args) {
		PangyaFX.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		PangyaFX.setUserAgentStylesheet(STYLESHEET_MODENA);
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/fxml/pangyafx.fxml"));
		Parent root = loader.load();
		PangyaFXController controller = loader.getController();
		
		stage.setScene(new Scene(root));
		stage.setTitle("Pangya Calculator");
		stage.setResizable(false);
		stage.show();
		
		Stage modal = new Stage();
		FXMLLoader modalLoader = new FXMLLoader(
				getClass().getResource("/fxml/modal.fxml"));
		
		Parent modalRoot = modalLoader.load();
		ModalController modalController = modalLoader.getController();
		
		modal.setScene(new Scene(modalRoot));
		modal.initModality(Modality.WINDOW_MODAL);
		modal.initOwner(stage);
		modal.setTitle("Result");
		modal.setResizable(false);
		
		controller.setStage(stage);
		modalController.setStage(modal);
		
		controller.setModalController(modalController);
	}
	
}
