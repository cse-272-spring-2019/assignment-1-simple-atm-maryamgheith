import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ATM {
	private int withdrawal;
	private int index;
	private int deposit;
	private String cardNumber;
	private String existingCN = "123";
	private int balance=0;
	String[] history = new String[5];
	
public ATM(String cardNumber, int balance) {
this.cardNumber = cardNumber;
		this.balance = balance;
		}
public void balanceAfterWithdrawal(String withdrawal)
{
	int bal = balance;
	addToHistory(withdrawal+"$ were withdrawn.");
	int intW = Integer.parseInt(withdrawal);
	bal = bal-intW;
	this.balance = bal;		
	
}
public void balanceAfterDeposit(String deposit)
{
	int intD = Integer.parseInt(deposit);
	addToHistory(deposit+"$ were deposited.");
	int bal = this.balance;
	bal+=intD;
	this.balance=bal;
		}
public boolean validateCardNumber(String cardNumber) {
	boolean x = existingCN.equals(cardNumber);
	if(x == true)
		return true;
	else return false;
}
public void addToHistory(String string) {
	int i,counter=0;
	for(i=0;i<5;i++)
	{
		if(history[i]!=null)
			counter++;
	}
	if(counter == 5)
	{
		for(i=0;i<4;i++)
			{history[i]=history[i+1];}
		history[4]=string;
		
	}
	else if(counter==0) history[0]=string;
	
	else history[counter] = string;
	
}
public int currentBalance(){
	int bal = this.balance;
	addToHistory("Current Balance is"+bal);
	return bal;
}
public String[] getHistory() {
	return history;
}
public void setHistory(String[] history) {
	this.history = history;
}
public int getWithdrawal() {
	return withdrawal;
}
public void setWithdrawal(int withdrawal) {
	this.withdrawal = withdrawal;
}
public int getDeposit() {
	return deposit;
}
public void setDeposit(int deposit) {
	this.deposit = deposit;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public int getBalance() {
    return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
}

