package algos;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class KaratsubaMultiplicationTest {

    @Test
    public void multiply() {
        BigInteger num = new BigInteger("722876385");

        assertTrue(KaratsubaMultiplication.multiply(num, BigInteger.ONE).compareTo(num) == 0);
        assertTrue(KaratsubaMultiplication.multiply(BigInteger.ZERO, BigInteger.ONE).compareTo(BigInteger.ZERO) == 0);
        assertTrue(KaratsubaMultiplication.multiply(new BigInteger("53423434348768"), new BigInteger("846348765834658363523376721"))
                .compareTo(new BigInteger("45214857727728692358861251840800966229728")) == 0);
        assertTrue(KaratsubaMultiplication.multiply(new BigInteger("374672651726121212154315321132"),
                new BigInteger("12341634163146136152"))
                .compareTo(new BigInteger("4624072798539651690985560306986814303740874764064")) == 0);
    }
}