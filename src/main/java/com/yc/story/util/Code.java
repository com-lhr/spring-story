package com.yc.story.util;

import java.util.Random;



public class Code {
 
	public static String createData() {
		return createData(6);
	}
 
 
	public static String createData(int length) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}

}
