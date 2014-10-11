package fx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Version extends Application {

	public static void main(String[] args) {
		System.out.println(System.getProperty("javafx.version"));
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(System.getProperty("javafx.version"));
	}
}