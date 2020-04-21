package algos;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class BinaryExponentiationTest {

    @Test
    public void pow() {
        BigInteger exp1 = BinaryExponentiation.pow(new BigInteger("100"), new BigInteger("5"));
        BigInteger exp2 = BinaryExponentiation.pow(BigInteger.ZERO, new BigInteger("123"));
        BigInteger exp3 = BinaryExponentiation.pow(BigInteger.ONE, new BigInteger("7576234374"));
        BigInteger exp4 = BinaryExponentiation.pow(new BigInteger("72657634"), BigInteger.ZERO);

        assertTrue(exp1.compareTo(new BigInteger("10000000000")) == 0);
        assertTrue(exp2.compareTo(BigInteger.ZERO) == 0);
        assertTrue(exp3.compareTo(BigInteger.ONE) == 0);
        assertTrue(exp4.compareTo(BigInteger.ONE) == 0);
    }
}