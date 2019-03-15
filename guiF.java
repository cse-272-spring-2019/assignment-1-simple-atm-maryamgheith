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
public class guiF {
	Scene scene;
	String cardN;
	withdrawWindow withdrawWindow;
	ATM atm;
	depositWindow depositWindow;
	int balance;
	Stage stage;
	loginWindow loginWindow;
	int index=0;
	int j=0;
	int counter=0;
	public depositWindow getDepositWindow() {
		return depositWindow;
	}
	public void setDepositWindow(depositWindow depositWindow) {
		this.depositWindow = depositWindow;
	}
	public void setLoginWindow(loginWindow loginWindow) {
		this.loginWindow = loginWindow;
	}
	public void setWithdrawWindow(withdrawWindow withdrawWindow) {
		this.withdrawWindow = withdrawWindow;
	}
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}


	public loginWindow getLoginWindow() {
		return loginWindow;
	}
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public guiF(Stage stage, ATM atm) {
		this.stage = stage;
		this.atm = atm;
	}
	
	public void prepareScene()
	{
		Button balanceBtn = new Button("Balance Inquiry");
		Button depositBtn = new Button("Deposit Money");
		Button withdrawalBtn =  new Button("Withdraw Money");
		Button nextBtn = new Button("Next");
		Button prevBtn = new Button("Previous");
		Label historyNav = new Label("For History Navigation :");
		Label choose = new Label("Choose the desired action");
		Label balanceL = new Label();
		Label history =  new Label();
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(choose, 0, 0);
		grid.add(depositBtn,0,1);
		grid.add(withdrawalBtn,0,2);
		grid.add(balanceBtn,0,3);
		grid.add(balanceL,0,4);
		grid.add(prevBtn,0,5);
		grid.add(nextBtn, 1, 5);
		grid.add(history, 0, 6);
		balanceBtn.setFont(new Font("Times New Roman", 18));
		depositBtn.setFont(new Font("Times New Roman", 18));
		withdrawalBtn.setFont(new Font("Times New Roman", 18));
		balanceL.setFont(new Font("Times New Roman", 18));
		nextBtn.setFont(new Font("Times New Roman", 18));
		prevBtn.setFont(new Font("Times New Roman", 18));
		historyNav.setFont(new Font("Times New Roman", 18));
		choose.setFont(new Font("Times New Roman", 18));
		history.setFont(new Font("Times New Roman", 18));
	    scene = new Scene(grid,500,500);
		balanceBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
					int bal = atm.currentBalance();
				history.setText("Current Balance is "+bal);
			}
		});
		withdrawalBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
			stage.setScene(withdrawWindow.getScene());
			}});
		depositBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			stage.setScene(depositWindow.getScene());
			}});
		prevBtn.setOnAction(e ->{
			
			while(atm.history[counter]!=null)
			{
				counter++;
			}
			if(index == 5||(counter-index-1)<0)
			{
				history.setText("No history to display");
				index=0;
				
			}
			else{
				history.setText(atm.history[counter-index-1]);
			    index++;
				}
		});
		nextBtn.setOnAction(e ->{
			counter =0;
			while(atm.history[counter]!=null)
			{
				counter++;
			}
			if(atm.history[index]==null) {
				
				history.setText("No history to display.");
				index=0;
			}
			else{
				history.setText(atm.history[counter-index]);
			index--;
				}
			});
		}
}
