package app;

public class ViewLayerFactory {
	public static ViewLayer getProduct(){
		return ViewLayerImpl.getInstance();
	}
}
