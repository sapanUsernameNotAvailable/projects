package car;

import java.util.*;

/**
 * This class represents all the car types stored in memory.
 * */
public class CarTypeInformationSystemImpl implements CarTypeInformationSystem {
	HashMap<String, CarType> carTypeDB = new HashMap<String, CarType>();
	/**
	 * I want to use the factory pattern for this, so the constructor is
	 * private. I have used a static object of this class to implement a
	 * singleton pattern.
	 * */
	private static CarTypeInformationSystemImpl carTypeInformationSystem = new CarTypeInformationSystemImpl();

	private CarTypeInformationSystemImpl() {
	}
	public static CarTypeInformationSystemImpl getInstance() {
		return carTypeInformationSystem;
	}
	public int addCarType(String carTypeName, CarType carType) {
		carTypeDB.put(carTypeName, carType);
		return carTypeDB.size();
	}
	public String getCarTypeByCarSpecs(double length, double heigth, double cc) {
		String qualifiedCarsTypes = "";
		for (Map.Entry<String, CarType> currentCarTypeEntry : carTypeDB.entrySet()) {
			CarType currentCarType = currentCarTypeEntry.getValue();
			if (currentCarType.qualifies(length, heigth, cc)) {
				qualifiedCarsTypes = qualifiedCarsTypes + currentCarType.getName() + " ";
			}
		}
		return qualifiedCarsTypes;
	}
	public boolean addInstanceOfCarType(String carTypeNameToAddTo) {
		boolean carTypeAlreadyExists = false;
		for (Map.Entry<String, CarType> currentCarTypeEntry : carTypeDB.entrySet()) {
			String currentCarTypeName = currentCarTypeEntry.getKey();
			/* increment count if car type exists */
			if (currentCarTypeName.equals(carTypeNameToAddTo)) {
				currentCarTypeEntry.getValue().addCar();
				carTypeAlreadyExists = true;
			}
		}
		return carTypeAlreadyExists;
	}
	public HashMap<String, CarType> getCarTypeDB() {
		return carTypeDB;
	}
	public void setCarTypeDB(HashMap<String, CarType> cars) {
		this.carTypeDB = cars;
	}
}
