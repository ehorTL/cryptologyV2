package algos;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FermatPrimalityTestTest {

    @Test
    public void isProbablyPrime() throws InterruptedException {
        BigInteger[] primeList = new BigInteger[]{
                new BigInteger("7"), new BigInteger("11"), new BigInteger("13"),
                new BigInteger("17"), new BigInteger("19"), new BigInteger("23"),
                new BigInteger("29"), new BigInteger("31"), new BigInteger("37"),
                new BigInteger("41"), new BigInteger("43"), new BigInteger("47"),
                new BigInteger("53"), new BigInteger("59"), new BigInteger("61"),
                new BigInteger("67"), new BigInteger("71"), new BigInteger("73"),
                new BigInteger("79"), new BigInteger("83"), new BigInteger("89"),
                new BigInteger("97"), new BigInteger("101"), new BigInteger("103"),
                new BigInteger("107"), new BigInteger("109"), new BigInteger("113"),
                new BigInteger("999946346549"), new BigInteger("999946346551"),
                new BigInteger("999946346563"), new BigInteger("999946346611"),
                new BigInteger("999946346723"), new BigInteger("999946346731"),
                new BigInteger("999946346809"), new BigInteger("999946346813")
        };

        for (int i = 0; i < primeList.length; i++) {
            assertTrue(FermatPrimalityTest.isProbablyPrime(primeList[i]));
        }
    }
}