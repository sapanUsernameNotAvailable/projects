package app;

import car.CarType;
import car.CarTypeInformationSystem;
import car.CarTypeInformationSystemFactory;

public class ServiceLayerImpl implements ServiceLayer {
	CarTypeInformationSystem carTypeInformationSystem = CarTypeInformationSystemFactory.getFactoryProductInstance();
	/**
	 * I want to use the factory pattern for this, so the constructor is
	 * private. I have used a static object of this class to implement a
	 * singleton pattern.
	 * */
	private static ServiceLayerImpl serviceLayerImpl = new ServiceLayerImpl();

	private ServiceLayerImpl() {
	}
	public static ServiceLayerImpl getInstance() {
		return serviceLayerImpl;
	}
	
	public int addCarType(String name, double lmin, double lmax, double hmin, double hmax, double ccmin, double ccmax) {
		CarType carType = new CarType(name, lmin, lmax, hmin, hmax, ccmin, ccmax);
		return carTypeInformationSystem.addCarType(name, carType);
	}
	
	public boolean addInstanceOfCarType(String carTypeName) {
		return carTypeInformationSystem.addInstanceOfCarType(carTypeName);
	}
	public String getCarTypeByCarSpecs(double length, double heigth, double cc) {
		return carTypeInformationSystem.getCarTypeByCarSpecs(length, heigth, cc);
	}
}
