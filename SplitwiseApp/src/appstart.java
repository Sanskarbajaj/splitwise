import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class appstart extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("splitwisefxml.fxml"));
		Stage stage=new Stage();
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
