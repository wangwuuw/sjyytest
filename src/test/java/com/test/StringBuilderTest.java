package com.test;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("123456");
		sb.delete(0, sb.length()-1);
		System.out.println(sb);
		sb.append("123");
		System.out.println(sb);

	}

}
