package app;

public interface ServiceLayer {
	/**
	 * Adds a car type. For eg: SUV
	 * 
	 * @param name
	 *            : new car type name
	 * @param lmin
	 *            : new car type minimum length
	 * @param lmax
	 *            : new car type maximum length
	 * @param hmin
	 *            : new car type minimum height
	 * @param hmax
	 *            : new car type maximum height
	 * @param ccmin
	 *            : new car type minimum engine capacity
	 * @param ccmax
	 *            : new car type maximum engine capacity
	 * @return total number of car types in the system
	 * */
	public int addCarType(String name, double lmin, double lmax, double hmin, double hmax, double ccmin, double ccmax);
	/**
	 * @param carTypeName
	 *            : car type for which an instance is to be created.
	 * @return true, if car type exists else false.
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
