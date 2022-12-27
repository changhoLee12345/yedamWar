package com.yedam.edu;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("start");
		String num = "2,000,000,000,000";
		num=num.replace(",", "");
		System.out.println(num);
//		int idx = 0;
//		while (idx != -1) {
//			idx = num.indexOf(",");
//			num = num.replace(",", "");
//			System.out.println(num);
//		}
		System.out.println("end");
	}

}
