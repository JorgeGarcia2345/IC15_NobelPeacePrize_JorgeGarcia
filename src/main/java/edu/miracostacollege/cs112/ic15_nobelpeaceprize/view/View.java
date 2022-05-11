package edu.miracostacollege.cs112.ic15_nobelpeaceprize.view;

import edu.miracostacollege.cs112.ic15_nobelpeaceprize.controller.Controller;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The <code>View</code> class represents the user interface for the application.  It initializes the
 * primary stage (window), then instructs the ViewNavigator to load the very first scene (the MainScene).
 *
 * @author Michael Paulding
 * @version 1.2
 */
public class View extends Application {

	/**
	 * Starts the application by setting the stage (window) with a custom Nobel icon, then navigating
	 * to the first scene (canvas), which happens to be the MainScene for this application.
	 * @param primaryStage The primary stage (window)
	 * @throws Exception if one occurs during startup.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		ViewNavigator.setStage(primaryStage);
		//TODO: Uncomment when res folder has been configured:
		primaryStage.getIcons().add(new Image("nobel_peace_prize_icon.png"));
		ViewNavigator.loadScene("Nobel Peace Prize Laureates", new MainScene());
		// TODO: Load new Scene if needed!
	}

	/**
	 * Stop is called whenever the application shuts down (e.g. user closes the window).
	 * In this case we request the Controller to initiate the saving of all laureate data to the binary file.
	 * @throws Exception if one occurs during shutdown.
	 */
	@Override
	public void stop() throws Exception {
		// TODO: Uncomment when finished with Controller.java
		Controller.getInstance().saveData();
	}

	/**
	 * The entry point to this JavaFX application.  Application.launch will eventually make a call
	 * to the start() method.
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);

	}

}
