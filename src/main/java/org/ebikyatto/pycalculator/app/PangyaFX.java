package org.ebikyatto.pycalculator.app;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.ebikyatto.pycalculator.app.controller.ModalController;
import org.ebikyatto.pycalculator.app.controller.PangyaFXController;
import org.ebikyatto.pycalculator.common.util.ResourceUtil;
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

	private static final URL PANGYAFX_FXML = ResourceUtil.getURL("/fxml/pangyafx.fxml");
	private static final URL MODAL_FXML = ResourceUtil.getURL("/fxml/modal.fxml");
	private static final Image ICON = ResourceUtil.getImage("/image/icon.png");
	private static final String STYLESHEETS = ResourceUtil.getPath("/css/style.css");
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("config/label", Locale.JAPAN);
	
	public static void main(String[] args) {
		PangyaFX.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		PangyaFX.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
		
		// Application settings
		FXMLLoader loader = new FXMLLoader(PangyaFX.PANGYAFX_FXML);
		loader.setResources(BUNDLE);
		Parent root = loader.load();
		PangyaFXController controller = loader.getController();
		
		Scene scene = new Scene(root);
		scene.setFill(null);
		scene.getStylesheets().add(PangyaFX.STYLESHEETS);
		root.getStyleClass().add("javafx");
		stage.setScene(scene);
		stage.initStyle(StageStyle.DECORATED);
		stage.setTitle("Pangya Calculator");
		stage.getIcons().add(PangyaFX.ICON);
		stage.setResizable(false);
		stage.show();
		
		// Modal settings
		FXMLLoader modalLoader = new FXMLLoader(PangyaFX.MODAL_FXML);
		modalLoader.setResources(BUNDLE);
		Parent modalRoot = modalLoader.load();
		ModalController modalController = modalLoader.getController();
		
		Stage modal = new Stage();
		Scene modalScene = new Scene(modalRoot);
		modalScene.setFill(null);
		modalScene.getStylesheets().add(PangyaFX.STYLESHEETS);
		modalRoot.getStyleClass().add("modal");
		modal.setScene(modalScene);
		modal.initModality(Modality.WINDOW_MODAL);
		modal.initOwner(stage);
		modal.setTitle("Result");
		modal.getIcons().add(PangyaFX.ICON);
		modal.setResizable(false);
		
		// Set stages to own controller
		controller.setStage(stage);
		modalController.setStage(modal);
		
		// Set modal to application, make application can control modal to display
		controller.setModal(modalController);
	}
	
}
