package com.test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("100.35");
		BigDecimal setScale = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println(setScale);
//		BigInteger valueOf = BigInteger.valueOf(210000);
//		System.out.println(valueOf);
	}

}
