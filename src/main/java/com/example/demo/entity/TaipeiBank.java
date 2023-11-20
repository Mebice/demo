package com.example.demo.entity;

public class TaipeiBank {

	private String branch;
	private String user;
	private int balance = 1000;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int saving(int amount) {
		if (amount > 0) { // 因為amount含有負數，須讓金額大於0
			balance += amount;
		}
		return balance; // 如果為負，就不進到if判斷維持原本的餘額
	}

	public int withdraw(int amount) {
		if (amount > 0 && balance >= amount) { // 條件為提取的金額大於0並且餘額要大於等於提領的金額
			balance -= amount;
		}
		return balance;
	}

	// 當void(不回傳值)，可不寫return
	public String saving1(Dog dog, int... inte) {
		return "";
	}
	//inte[0]: age; inte[1]: amount; inte[2]: number;
	public String saving2(Dog dog, int... inte) {
		return "";
	}

	public String saving2(Dog dog, int age,int amount,int number) {
		return "";
	}
}
