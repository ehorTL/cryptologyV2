package algos.extendedeuclideanalgoeithm;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ExtendedEuclideanAlgorithmTest {

    @Test
    public void gcdTest() {
        BigInteger gcd1 = ExtendedEuclideanAlgorithm.gcd(new BigInteger(String.valueOf(84)), new BigInteger(String.valueOf(275)))
                .getGcdOfBAndA();
        BigInteger gcd2 = ExtendedEuclideanAlgorithm.gcd(new BigInteger(String.valueOf(100)), new BigInteger(String.valueOf(100)))
                .getGcdOfBAndA();
        BigInteger gcd3 = ExtendedEuclideanAlgorithm.gcd(new BigInteger(String.valueOf(51)), new BigInteger(String.valueOf(17)))
                .getGcdOfBAndA();
        BigInteger gcd4 = ExtendedEuclideanAlgorithm.gcd(new BigInteger(String.valueOf(35)), new BigInteger(String.valueOf(20)))
                .getGcdOfBAndA();

        assertTrue(gcd1.compareTo(BigInteger.ONE) == 0);
        assertTrue(gcd2.compareTo(new BigInteger(String.valueOf(100))) == 0);
        assertTrue(gcd3.compareTo(new BigInteger(String.valueOf(17))) == 0);
        assertTrue(gcd4.compareTo(new BigInteger(String.valueOf(5))) == 0);
    }
}