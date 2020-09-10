package com.lin;

import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("hello java");
		// shutdown pc
//		Runtime.getRuntime().exec("shutdown -s -t 1000");
		// cancel shutdown
		Runtime.getRuntime().exec("shutdown -a");
	}

}
