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
		Parent root =FXMLLoader.load(getClass().getResource("tictactoefxml.fxml"));
		Stage stage=new Stage();
		Scene scene=new Scene(root);
		stage.setTitle("Tic_Tac_Toe");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
		
	}

}
