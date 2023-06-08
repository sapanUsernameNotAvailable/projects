package app;

public class App {
	public static void main(String[] args) {
		ViewLayer viewLayer = ViewLayerFactory.getProduct();
		viewLayer.execute();
	}
}