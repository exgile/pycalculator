package org.ebikyatto.pycalculator.app;

import org.ebikyatto.pycalculator.app.controller.ModalController;
import org.ebikyatto.pycalculator.app.controller.PangyaFXController;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
		rootScene.setFill(null);
		rootScene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
		root.getStyleClass().add("javafx");
		stage.setScene(rootScene);
		stage.initStyle(StageStyle.DECORATED);
		stage.setTitle("Pangya Calculator");
		stage.getIcons().add(new Image(
				this.getClass().getResourceAsStream("/image/icon.png")));
		stage.setResizable(false);
		stage.show();
		
		Stage modal = new Stage();
		FXMLLoader modalLoader = new FXMLLoader(
				this.getClass().getResource("/fxml/modal.fxml"));
		
		Parent modalRoot = modalLoader.load();
		Scene modalScene = new Scene(modalRoot);
		modalScene.setFill(null);
		modalScene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
		modalRoot.getStyleClass().add("modal");
		ModalController modalController = modalLoader.getController();
		modal.setScene(modalScene);
		modal.initModality(Modality.WINDOW_MODAL);
		modal.initOwner(stage);
		modal.setTitle("Result");
		modal.getIcons().add(new Image(
				this.getClass().getResourceAsStream("/image/icon.png")));
		modal.setResizable(false);
		
		controller.setStage(stage);
		modalController.setStage(modal);
		
		controller.setModalController(modalController);
	}
	
}
