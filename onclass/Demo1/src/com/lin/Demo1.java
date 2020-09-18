package com.lin;

import java.io.IOException;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("hello java");
		System.out.print("请输入自动关机时间（秒）：");
		Scanner input = new Scanner(System.in);
		String shutdown_time = input.nextLine();
		// shutdown pc
		Runtime.getRuntime().exec("shutdown -s -t " + input);
		// cancel shutdown
//		Runtime.getRuntime().exec("shutdown -a");
	}

}
