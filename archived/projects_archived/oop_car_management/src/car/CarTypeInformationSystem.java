package car;

public interface CarTypeInformationSystem {
	/**
	 * Add a new car type, eg. sedan to the app's in-memory information storage.
	 * 
	 * @param carType
	 *            : new car type to add to the system.
	 * @return total no. of car types in information storage
	 * */
	public int addCarType(String carTypeName, CarType carType);
	/**
	 * Check if a car type already exists in the system. If it does, increment
	 * its count and return true; else return false.
	 * 
	 * @param carTypeNameToAddTo
	 *            : car type to which we are going to add the car model to
	 * @return true if car type already exists else false.
	 * */
	public boolean addInstanceOfCarType(String name);
	/**
	 * Used to find the car types for which the passed car specifications
	 * qualify eg.: tata safari specs should qualify for SUV
	 * 
	 * @params car model specs to test. eg: tata safari specs
	 * @return car types it qualifies for, concatenated as a string . eg: "SUV"
	 *         TODO return list instead
	 */
	public String getCarTypeByCarSpecs(double length, double heigth, double cc);
}
