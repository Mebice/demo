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
		if (amount > 0) { // �]��amount�t���t�ơA�������B�j��0
			balance += amount;
		}
		return balance; // �p�G���t�A�N���i��if�P�_�����쥻���l�B
	}

	public int withdraw(int amount) {
		if (amount > 0 && balance >= amount) { // ���󬰴��������B�j��0�åB�l�B�n�j�󵥩󴣻⪺���B
			balance -= amount;
		}
		return balance;
	}

	// ��void(���^�ǭ�)�A�i���greturn
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
