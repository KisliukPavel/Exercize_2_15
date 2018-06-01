import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Exercize_2_15 extends Application {
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("Exercize_2_15.fxml"));
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.setTitle("JavaFX application");
		primaryStage.centerOnScreen();
		//-----------------------------------------------
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
	}
}