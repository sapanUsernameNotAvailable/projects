package app;

public class Clazz {

	@Annotation(annotationParam = "param value")
	public void annotatedMethod() {
		System.out.println("inside annotatedMethod");
	}
}
