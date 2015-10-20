package ebikyatto.pycalculator.app;

import ebikyatto.pycalculator.app.controller.ModalController;
import ebikyatto.pycalculator.app.controller.PangyaFXController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PangyaFX extends Application {

	public static void main(String[] args) {
		PangyaFX.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		PangyaFX.setUserAgentStylesheet(STYLESHEET_MODENA);
		
		FXMLLoader loader = new FXMLLoader(
				this.getClass().getResource("/fxml/pangyafx.fxml"));
		Parent root = loader.load();
		PangyaFXController controller = loader.getController();
		
		Scene rootScene = new Scene(root);
		rootScene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
		primaryStage.setScene(rootScene);
		primaryStage.setTitle("Pangya Calculator");
		primaryStage.getIcons().add(new Image(
				this.getClass().getResourceAsStream("/image/icon.png")));
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Stage modal = new Stage();
		FXMLLoader modalLoader = new FXMLLoader(
				this.getClass().getResource("/fxml/modal.fxml"));
		
		Parent modalRoot = modalLoader.load();
		ModalController modalController = modalLoader.getController();
		
		modal.setScene(new Scene(modalRoot));
		modal.initModality(Modality.WINDOW_MODAL);
		modal.initOwner(primaryStage);
		modal.setTitle("Result");
		modal.setResizable(false);
		
		controller.setStage(primaryStage);
		modalController.setStage(modal);
		
		controller.setModalController(modalController);
	}
	
}
