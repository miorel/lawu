package com.googlecode.lawu.math;

import java.math.BigInteger;

/**
 * Some combinatorics formulas.
 * 
 * @author Miorel-Lucian Palii
 */
public class Combinatorics {
	/**
	 * There is no need to instantiate this class.
	 */
	private Combinatorics() {
	}

	/**
	 * Computes the factorial of a number n, i.e.&nbsp;(n)(n - 1)(n -
	 * 2)...(2)(1).
	 * 
	 * @param n the number whose factorial to calculate
	 * @return n factorial
	 */
	public BigInteger factorial(int n) {
		if(n < 0)
			throw new IllegalArgumentException("Can't calculate the factorial of negative numbers.");
		BigInteger ret = BigInteger.ONE;
		for(int i = 1; i <= n; ++i)
			ret = ret.multiply(BigInteger.valueOf(i));
		return ret;
	}
}
