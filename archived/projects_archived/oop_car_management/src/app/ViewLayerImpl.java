package app;

import java.util.Scanner;

import utils.SystemChoice;

public class ViewLayerImpl implements ViewLayer {
	Scanner in = new Scanner(System.in);
	ServiceLayer serviceLayer = ServiceLayerFactory.getProduct();
	/**
	 * I want to use the factory pattern for this, so the constructor is
	 * private. I have used a static object of this class to implement a
	 * singleton pattern.
	 * */
	private static ViewLayerImpl viewLayerImpl = new ViewLayerImpl();

	private ViewLayerImpl() {
	}
	public static ViewLayer getInstance() {
		return viewLayerImpl;
	}
	public void execute() {
		SystemChoice sysChoice = systemChoiceFromUserInput(getUserInput());
		while (sysChoice != SystemChoice.EXIT) {
			switch (sysChoice) {
				case ADD_TYPE: {
					addCarType();
					break;
				}
				case ADD_INSTANCE: {
					addInstanceOfCarType();
					break;
				}
				case GET_TYPE: {
					getCarTypeByCarSpecs();
					break;
				}
				case EXIT: {
					exit();
					break;
				}
			}
			sysChoice = systemChoiceFromUserInput(getUserInput());
		}
	}
	/**
	 * Eg: add sedan car type
	 * */
	public void addCarType() {
		System.out.println("Enter new car type name");
		String name = in.nextLine();
		System.out.println("Enter minimum length");
		double lengthMin = in.nextDouble();
		in.nextLine();
		System.out.println("Enter maximum length");
		double lengthMax = in.nextDouble();
		in.nextLine();
		System.out.println("Enter minimum heigth");
		double heigthMin = in.nextDouble();
		in.nextLine();
		System.out.println("Enter maximum heigth");
		double heigthMax = in.nextDouble();
		in.nextLine();
		System.out.println("Enter minimum capacity");
		double ccMin = in.nextDouble();
		in.nextLine();
		System.out.println("Enter maximum capacity");
		double ccMax = in.nextDouble();
		in.nextLine();
		int noCarTypes = serviceLayer.addCarType(name, lengthMin, lengthMax, heigthMin, heigthMax, ccMin, ccMax);
		System.out.println(noCarTypes + " car types exist");
	}
	/**
	 * Eg: add instance for sedan car type.
	 * */
	public void addInstanceOfCarType() {
		System.out.println("Enter car type of the car you want to make");
		String name = in.nextLine();
		if (serviceLayer.addInstanceOfCarType(name)) {
			System.out.println("Car has been added");
		} else {
			System.out.println("Car type doesn't exist !");
		}
	}
	/**
	 * Eg:  add specs for ferrai enzo and get sedan sports car as output.
	 * Note that sedan and sports car specs must already be fed into the system.
	 * */
	public void getCarTypeByCarSpecs() {
		System.out.println("Enter length");
		double length = in.nextDouble();
		in.nextLine();
		System.out.println("Enter  heigth");
		double heigth = in.nextDouble();
		in.nextLine();
		System.out.println("Enter capacity");
		double cc = in.nextDouble();
		in.nextLine();
		System.out.println(serviceLayer.getCarTypeByCarSpecs(length, heigth, cc));
	}
	public void exit() {
		System.out.println("Application exited");
		System.exit(0);
	}
	/**
	 * Gets the user input from the console.
	 * @return choice : An int representing the choice the user has made.
	 * */
	public int getUserInput() {
		System.out.println("*******");
		System.out.println("What do you want to do ?");
		System.out.println("1. Add car type");
		System.out.println("2. Add car instance");
		System.out.println("3. Get type of a car");
		System.out.println("4. Quit");
		System.out.println("Enter choice (1-4)");
		int userInput = in.nextInt();
		in.nextLine();// clear buffer
		System.out.println("*******");
		return userInput;
	}
	/**
	 * @param userInput
	 *            : a user input for app navigation.
	 * @return an enum usable by the system to handle app navigation.
	 * */
	public SystemChoice systemChoiceFromUserInput(int userInput) {
		SystemChoice userChoice;
		switch (userInput) {
			case 1: {
				userChoice = SystemChoice.ADD_TYPE;
				break;
			}
			case 2: {
				userChoice = SystemChoice.ADD_INSTANCE;
				break;
			}
			case 3: {
				userChoice = SystemChoice.GET_TYPE;
				break;
			}
			case 4: {
				userChoice = SystemChoice.EXIT;
				break;
			}
			default: {
				userChoice = SystemChoice.EXIT;
				break;
			}
		}
		return userChoice;
	}
}
