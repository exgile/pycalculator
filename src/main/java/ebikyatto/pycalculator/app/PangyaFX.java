package ebikyatto.pycalculator.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.springframework.stereotype.Component;

import ebikyatto.pycalculator.app.controller.ModalController;
import ebikyatto.pycalculator.app.controller.PangyaFXController;

@Component
public class PangyaFX extends Application {

	public static void main(String[] args) {
		PangyaFX.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		PangyaFX.setUserAgentStylesheet(STYLESHEET_MODENA);
		
		FXMLLoader loader = new FXMLLoader(
				this.getClass().getResource("/fxml/pangyafx.fxml"));
		Parent root = loader.load();
		PangyaFXController controller = loader.getController();
		
		Scene rootScene = new Scene(root);
		rootScene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
		stage.setScene(rootScene);
		stage.setTitle("Pangya Calculator");
		stage.getIcons().add(new Image(
				this.getClass().getResourceAsStream("/image/icon.png")));
		stage.setResizable(false);
		stage.show();
		
		Stage modal = new Stage();
		FXMLLoader modalLoader = new FXMLLoader(
				this.getClass().getResource("/fxml/modal.fxml"));
		
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
