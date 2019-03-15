import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
public class runGUI extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		ATM user = new ATM("123",0);
		guiF guiF = new guiF(primaryStage,user);
		withdrawWindow withdrawWindow = new withdrawWindow(primaryStage,user);
		loginWindow loginWindow =  new loginWindow(primaryStage,user);
		depositWindow depositWindow = new depositWindow(primaryStage,user);
		loginWindow.prepareScene();
		guiF.prepareScene();
		depositWindow.prepareScene();
		withdrawWindow.prepareScene();
		depositWindow.setGuiF(guiF);
		loginWindow.setGuiF(guiF);
		guiF.setWithdrawWindow(withdrawWindow);
		guiF.setDepositWindow(depositWindow);
		withdrawWindow.setGuiF(guiF);
		primaryStage.setScene(loginWindow.getScene());
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
		}

}
