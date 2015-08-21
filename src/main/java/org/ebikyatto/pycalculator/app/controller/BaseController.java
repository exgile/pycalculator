package org.ebikyatto.pycalculator.app.controller;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Base Controller for Extends
 * @author ebikyatto
 */
public abstract class BaseController implements Initializable {
	protected Stage stage;
	
	/**
	 * Get Stage from Controller
	 * @return Stage
	 */
	public Stage getStage() {
		return stage;
	}
	
	/**
	 * Set Stage to Controller
	 * @param stage Stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Showing Stage
	 */
	public void show() {
		stage.show();
	}
	
	/**
	 * Hiding Stage
	 */
	public void hide() {
		stage.hide();
	}
	
	/**
	 * Showing Stage and Waiting for Close
	 */
	public void showAndWait() {
		stage.showAndWait();
	}
}
