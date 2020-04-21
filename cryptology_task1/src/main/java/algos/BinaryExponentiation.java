package algos;

import java.math.BigInteger;

public class BinaryExponentiation {
    /**
     * @return base^power
     * Algorithm estimated to work with log(n) time complexity,
     * where n - power the base have to be powered to
     * Simple exponentiation works for O(n) time complexity.
     * */
    public static BigInteger pow (BigInteger base, BigInteger power){
        if (base.compareTo(BigInteger.ZERO) == 0){
            return BigInteger.ZERO;
        }

        BigInteger result = BigInteger.ONE;
        while (power.compareTo(BigInteger.ZERO) != 0){
            if (power.and(BigInteger.ONE).compareTo(BigInteger.ZERO) != 0){
                result = result.multiply(base);
            }
                base = base.multiply(base);
                power = power.shiftRight(1);
        }

        return result;
    }
}

