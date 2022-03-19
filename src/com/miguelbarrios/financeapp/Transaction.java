package com.miguelbarrios.financeapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

	private static List<Transaction> transactions = new ArrayList<>();
	
	private Catagory catagory;
	
	private double amount;
	
	private LocalDate transactionDate;


	public Transaction(Catagory catagory, double amount, LocalDate transactionDate) {
		super();
		this.catagory = catagory;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	
	public Transaction(Catagory catagory, double amount) {
		this(catagory, amount, LocalDate.now());
	}

	public static List<Transaction> getTransactions() {
		return new ArrayList<>(transactions);
	}
	
	public static void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	@Override
	public String toString() {
		return "Catagory:" + catagory + " " + amount + " " + "data: " + transactionDate;
	}
	
	public String csvString() {
		return catagory + "," + amount + "," + transactionDate;
	}
	
	
	
}
