package algos;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class MontgomeryArithmeticTest {

    @Test
    public void multiplication() {
        assertTrue(MontgomeryArithmetic.multiply(new BigInteger("53423434348768"),
                new BigInteger("846348765834658363523376721"), new BigInteger("651456546333"))
        .compareTo(new BigInteger("84758131354")) == 0);
        assertTrue(MontgomeryArithmetic.multiply(new BigInteger("374672651726121212154315321132"),
                new BigInteger("12341634163146136152"), new BigInteger("87687875998211"))
                .compareTo(new BigInteger("39119834394045")) == 0);
    }

    @Test
    public void pow() {
        assertTrue(MontgomeryArithmetic.pow(new BigInteger("53423434348768"),
                new BigInteger("3"), new BigInteger("651456546333"))
                .compareTo(new BigInteger("263504744413")) == 0);
        assertTrue(MontgomeryArithmetic.pow(new BigInteger("374672651726121212154315321132"),
                new BigInteger("5"), new BigInteger("87687875998211"))
                .compareTo(new BigInteger("1619440123374")) == 0);
    }

    @Test
    public void computeR() {
        assertTrue(MontgomeryArithmetic.computeR(new BigInteger("8"))
                .compareTo(new BigInteger("16")) == 0);
        assertTrue(MontgomeryArithmetic.computeR(new BigInteger("7"))
                .compareTo(new BigInteger("8")) == 0);
        assertTrue(MontgomeryArithmetic.computeR(new BigInteger("127"))
                .compareTo(new BigInteger("128")) == 0);
    }
}