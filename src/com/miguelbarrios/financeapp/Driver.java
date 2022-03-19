package com.miguelbarrios.financeapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


public class Driver {
	public static void main(String[] args) {

		Transaction a = new Transaction(Catagory.FAST_FOOD, 25,LocalDate.now());
		Transaction b = new Transaction(Catagory.ENTERTAINMENT, 125,LocalDate.now());
		Transaction c = new Transaction(Catagory.FITNESS, 50,LocalDate.now());
		Transaction.addTransaction(a);
		Transaction.addTransaction(b);
		List<Transaction> transactions = Transaction.getTransactions();
		
		
	    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	saveTransactions(transactions);
	        }
	    }, "Shutdown-thread"));
	}
	
	public static void saveTransactions(List<Transaction> transactions) {
		try {
			FileWriter fw = new FileWriter("transactions.csv");
			PrintWriter pw = new PrintWriter(fw);
			for (Transaction transaction : transactions) {
				System.out.println(transaction.csvString());
				pw.println(transaction.csvString());
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

