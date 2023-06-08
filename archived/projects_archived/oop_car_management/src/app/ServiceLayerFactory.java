package app;

public class ServiceLayerFactory {
	public static ServiceLayer getProduct() {
		return ServiceLayerImpl.getInstance();
	}
}
