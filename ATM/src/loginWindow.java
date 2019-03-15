import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.Font;
public class loginWindow  {
	Scene scene;
	String cardN;
	Stage stage;
	guiF guiF;
	ATM atm;

	public loginWindow(Stage stage,ATM atm) {
		this.stage = stage;
		this.atm = atm;
	}
	public void setGuiF(guiF guiF) {
		this.guiF = guiF;
	}
	public void prepareScene() {
	FlowPane flow = new FlowPane();
	Label welcome = new Label("Welcome To ATM");
	TextField cardNumber = new TextField();
	Label label = new Label("Enter Card Number Below");
	Button next = new Button("Next");
	Label validation = new Label();
	welcome.setFont(new Font("Times New Roman", 18));
	label.setFont(new Font("Times New Roman", 18));
	cardNumber.setFont(new Font("Times New Roman",18));
	validation.setFont(new Font("Times New Roman", 18));
	next.setFont(new Font("Times New Roman",18));
	flow.setOrientation(Orientation.VERTICAL);
	flow.setHgap(10);
	flow.setVgap(10);
	flow.getChildren().add(welcome);
	flow.getChildren().add(label);
	flow.getChildren().add(cardNumber);
	flow.getChildren().add(next);	
	flow.getChildren().add(validation);
	scene = new Scene(flow, 300,300);
	next.setOnAction(e -> {
			
	
			cardN = cardNumber.getText();
			
			boolean x = atm.validateCardNumber(cardN);
			if(x == true) { 
			stage.setScene(guiF.getScene());
			
			}
			else if(x == false ) {
				validation.setText("Incorrect Card Number!\nTry Again.");
				cardNumber.clear();
			}
			
		
	});
	
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	}
