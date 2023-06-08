package car;

public class CarTypeInformationSystemFactory {
	public static CarTypeInformationSystem getFactoryProductInstance(){
		return CarTypeInformationSystemImpl.getInstance();
	}
}
