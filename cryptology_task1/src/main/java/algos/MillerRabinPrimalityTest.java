package algos;

import customexceptions.IterationsOutException;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class MillerRabinPrimalityTest {
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final Random random = new Random(new Date().getTime());
    private static final int MAX_RANDOM_NUMBER_SEARCH_ITERATION = 5000;

    public static boolean isProbablyPrime(BigInteger numberToTest, int k) throws IterationsOutException {
        if (numberToTest.compareTo(BigInteger.ONE) <= 0){
            return false;
        }
        if (numberToTest.compareTo(TWO) == 0){
            return true;
        }

        //numberToTest - 1 = (2^s)*t, t - odd
        //n = numberToTest - 1
        //n = (2^s)*t
        BigInteger n = new BigInteger(String.valueOf(numberToTest)).subtract(BigInteger.ONE);
        BigInteger t = BigInteger.ONE;
        int s = 0;
        while (n.mod(TWO).compareTo(ZERO) == 0){
            s++;
            n = n.divide(TWO);
        }
        t = n;

        for (int i = 0; i < k; i++){
            BigInteger randBase = randomValueForRound(numberToTest);
            BigInteger x = randBase.modPow(t, numberToTest);
            if ((x.compareTo(BigInteger.ONE) == 0) || (x.compareTo(numberToTest.subtract(BigInteger.ONE)) == 0)){
                continue;
            }

            boolean coutinueOuterLoop = false;
            for (int j = 0; j < (s - 1); j++){
                x = x.modPow(TWO, numberToTest);
                if (x.compareTo(BigInteger.ONE) == 0){
                    return false;
                }
                if (x.compareTo(numberToTest.subtract(BigInteger.ONE)) == 0){
                    coutinueOuterLoop = true;
                    break;
                }
            }
            if (coutinueOuterLoop){
                continue;
            } else{
                return false;
            }
        }

        return true;
    }

    /**
     * @return random value from [2, n-2]
     * @param n  n>=3
     * */
    private static BigInteger randomValueForRound(BigInteger n) throws IterationsOutException {
        for (int i = 0; i < MAX_RANDOM_NUMBER_SEARCH_ITERATION; i++) {
            BigInteger randomOk = new BigInteger(n.bitLength(), random);
            if ((randomOk.compareTo(TWO) >= 0) && (randomOk.compareTo(n.subtract(TWO)) <= 0)) {
                return randomOk;
            }
        }
        throw new IterationsOutException("Iterations out");
    }
}
