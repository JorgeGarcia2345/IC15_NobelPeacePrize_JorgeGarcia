package edu.miracostacollege.cs112.ic15_nobelpeaceprize.controller;

import edu.miracostacollege.cs112.ic15_nobelpeaceprize.model.Model;
import edu.miracostacollege.cs112.ic15_nobelpeaceprize.model.NobelLaureate;
import javafx.collections.ObservableList;


/*

	Singleton Pattern - Only one object can ever be created from this class // abstract 0 objects

	1) Class variable w/ same data type as the class // STATIC!!!!!!!!!!!!!! Belongs to class, and only one

	2) Make a private constructor, no one else can use it!!!!!!

	3) Make a public method called get (getInstance)
		a) if instance is null, create 1 obj.
		b) else return the instance




	MVC
	Model (back end)

	Controller (one controller, brain of the operation)

	View (front end GUI)

 */


/**
 * The <code>Controller</code> is a Singleton object that relays all commands between the Model and View
 * (and vice versa).  There is only one Controller object, accessible by a call to the static getInstance()
 * method.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Controller {

	private static Controller theInstance; // convention to call it "the"
	private ObservableList<NobelLaureate> mAllLaureatesList;

	private Controller() {

	} // does nothing, no else can use it (2) ????????????? He updated this


	/**
	 * Gets the one instance of the Controller.
	 * @return The instance
	 */
	public static Controller getInstance() {

		// if instance is null, create a new obj
		if(theInstance == null) {
			theInstance = new Controller();
			// Fill the allLaureates list w/ Data from the Model class
			// if binary file has data, fill w/ binary file
			if(Model.binaryFileHasData())
				theInstance.mAllLaureatesList = Model.populateListFromBinaryFile();
			// otherwise fill w/ CVS file
			theInstance.mAllLaureatesList = Model.populateListFromCSVFile();
			// Otherwise, return the instance
		}
		return theInstance;
	}

	/**
	 * Gets the list of all laureates.
	 * @return The list of all laureates.
	 */
	public ObservableList<NobelLaureate> getAllLaureates() {


		return mAllLaureatesList;
	}

	/**
	 * Makes a request for the model to save all the laureates data (the list of all laureates) to
	 * a persistent binary file.
	 */
	public void saveData() {

		Model.writeDataToBinaryFile(mAllLaureatesList);
	}
}
