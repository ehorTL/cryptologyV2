package algos;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class FermatPrimalityTest {
    public static long ITERATIONS = 2000;

    /**
     * The method checks condition for random base
     * base ^ (numberToTest - 1) mod (numberToTest) == 1
     * ITERATION times
     * If there is at least one case that results in false the FALSE is returned
     * else TRUE is returned
     *
     * @param numberToTest number to be tested for primeness
     * @return if the input number is prime
     * */
    public static boolean isProbablyPrime(BigInteger numberToTest) throws InterruptedException {
        if (numberToTest.compareTo(BigInteger.ONE) <= 0){
            return false;
        } else if (numberToTest.compareTo(BigInteger.valueOf(2)) == 0){
            return true;
        }

        for (int i = 0; i < ITERATIONS; i++){
            if (getRandomBigIntFermatBaseFor(numberToTest).modPow(numberToTest.subtract(BigInteger.ONE),
                    numberToTest).compareTo(BigInteger.ONE) != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * @param p>=3 - number to be tested for primeness
     * @return number calles "base" that satisfies conditions:
     * base > 1 (non negative, no sense to check for base 1) and
     * base < p (to assure p cannot be divide by base - fermat test condition)
     * */
    private static BigInteger getRandomBigIntFermatBaseFor(BigInteger p) throws InterruptedException {
        Random randomizder = new Random(new Date().getTime());
        while(true){
            BigInteger base = new BigInteger(p.bitLength(), randomizder);
            if ((base.compareTo(p) < 0) && (base.compareTo(BigInteger.ONE) > 0)){
                return base;
            }
        }
    }
}
