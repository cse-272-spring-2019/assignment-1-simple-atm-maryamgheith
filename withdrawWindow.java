import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class withdrawWindow{
	Scene scene;
	Stage stage;
	guiF guiF;
	ATM atm;
	String amount = "";
	public withdrawWindow(Stage stage, ATM atm) {
		this.stage = stage;
		this.atm = atm;
	}
	public guiF getGuiF() {
		return guiF;
	}

	public void setGuiF(guiF guiF) {
		this.guiF = guiF;
	}

   public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public void prepareScene(){
	    GridPane grid1 = new GridPane();
		grid1.setHgap(10);
		grid1.setVgap(10);
		Button button1 =  new Button("1");
		grid1.add(button1, 4, 1);
		Button button2 =  new Button("2");
		grid1.add(button2, 5, 1);
		Button button3 =  new Button("3");
		grid1.add(button3, 6, 1);
		Button button4 =  new Button("4");
		grid1.add(button4, 4, 2);
		Button button5 =  new Button("5");
		grid1.add(button5, 5, 2);
		Button button6 =  new Button("6");
		grid1.add(button6,6, 2);
		Button button7 =  new Button("7");
		grid1.add(button7, 4, 3);
		Button button8 =  new Button("8");
		grid1.add(button8, 5, 3);
		Button button9 =  new Button("9");
		grid1.add(button9,6, 3);
		Button button0 =  new Button("0");
		grid1.add(button0, 5, 4);
		Button done = new Button("Done");
		grid1.add(done, 0, 13);
		Button back = new Button("Back");
		grid1.add(back, 0, 14);
		Label titleLabel =  new Label();
		titleLabel.setText("Enter amount to be withdrawn:");
		grid1.add(titleLabel,0 ,11 );
		Label display = new Label();
		grid1.add(display, 0, 12);
		Label validation = new Label();
		grid1.add(validation, 0, 15);
		button9.setFont(new Font("Times New Roman", 18));
		button8.setFont(new Font("Times New Roman", 18));
		button7.setFont(new Font("Times New Roman", 18));
		button6.setFont(new Font("Times New Roman", 18));
		button5.setFont(new Font("Times New Roman", 18));
		button4.setFont(new Font("Times New Roman", 18));
		button3.setFont(new Font("Times New Roman", 18));
		button2.setFont(new Font("Times New Roman", 18));
		button1.setFont(new Font("Times New Roman", 18));
		button0.setFont(new Font("Times New Roman", 18));
		validation.setFont(new Font("Times New Roman", 18));
		titleLabel.setFont(new Font("Times New Roman", 18));
		back.setFont(new Font("Times New Roman", 18));
		done.setFont(new Font("Times New Roman", 18));
		display.setFont(new Font("Times New Roman", 18));
		scene = new Scene(grid1, 500,500);
		back.setOnAction(e ->{
			display.setText("");
			stage.setScene(guiF.getScene());
			
		});
		button1.setOnAction(event ->{
		String b1 = ((Button)event.getSource()).getText();
		amount = amount +b1;
		display.setText(amount);
		});
		button2.setOnAction(event ->{
			String b2 = ((Button)event.getSource()).getText();
			amount = amount +b2;
			display.setText(amount);
			});
		button3.setOnAction(event ->{
			String b3 = ((Button)event.getSource()).getText();
			amount = amount +b3;
			display.setText(b3);
			});
		button4.setOnAction(event ->{
			String b4 = ((Button)event.getSource()).getText();
			amount = amount +b4;
			display.setText(amount);
			});
		button5.setOnAction(event ->{
			String b5 = ((Button)event.getSource()).getText();
			amount = amount +b5;
			display.setText(amount);
			});
		button6.setOnAction(event ->{
			String b6 = ((Button)event.getSource()).getText();
			amount = amount +b6;
			display.setText(amount);
			});
		button7.setOnAction(event ->{
			String b7 = ((Button)event.getSource()).getText();
			amount = amount +b7;
			display.setText(amount);
			});
		button8.setOnAction(event ->{
			String b8 = ((Button)event.getSource()).getText();
			amount = amount +b8;
			display.setText(amount);
			});
		button9.setOnAction(event ->{
			String b9 = ((Button)event.getSource()).getText();
			amount = amount +b9;
			display.setText(amount);
			});
		button0.setOnAction(event ->{
			String b0 = ((Button)event.getSource()).getText();
			amount = amount +b0;
			display.setText(amount);
			});
		done.setOnAction(event ->{
			amount = display.getText();
			int bal = atm.getBalance();
			int intW = Integer.parseInt(amount);
			if(bal<intW) {
				validation.setText("Cannot withdraw this amount.\nBalance is insufficient.");
			}
			else {
				atm.balanceAfterWithdrawal(amount);
			}
			
			amount = "";
			display.setText(amount);
			
			
			});
		}
	}