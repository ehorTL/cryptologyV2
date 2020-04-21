package algos;

import algos.extendedeuclideanalgoeithm.BezoutsIndentity;
import algos.extendedeuclideanalgoeithm.ExtendedEuclideanAlgorithm;
import javafx.util.Pair;

import java.math.BigInteger;

public class MontgomeryArithmetic {

    /**
     * Main quick montgomery multiplication method.
     *
     * @return the value of (a * b) mod n
     */
    public static BigInteger multiply(BigInteger a, BigInteger b, BigInteger n) {
        Pair<BigInteger, BigInteger> helper = multiplicationHelp(a, b, n);
        return helper.getKey().multiply(helper.getValue()).mod(n);
    }

    /**
     * Main quick montgomery exponentiation method.
     *
     * @return the value of (a^e) mod n
     * */
    public static BigInteger pow(BigInteger a, BigInteger e, BigInteger n) {
        BigInteger u = powHelp(a, e, n);
        BigInteger r = computeR(n);
        BezoutsIndentity eeRes = ExtendedEuclideanAlgorithm.gcd(r, n);
        if (eeRes.getGcdOfBAndA().compareTo(BigInteger.ONE) != 0) {
            throw new ArithmeticException("N and R are not co-prime");
        }
        BigInteger r1 = eeRes.getX();

        return u.multiply(r1).mod(n);
    }

    /**
     * Returns the pair of big integers (u, r1) to be used in main multiplication function.
     */
    private static Pair<BigInteger, BigInteger> multiplicationHelp(BigInteger a, BigInteger b, final BigInteger n) {
        BigInteger r = computeR(n);
        BigInteger a1 = a.shiftLeft(r.bitLength() - 1).mod(n);
        BigInteger b1 = b.shiftLeft(r.bitLength() - 1).mod(n);
        BigInteger t = KaratsubaMultiplication.multiply(a1, b1);
        BezoutsIndentity eeRes = ExtendedEuclideanAlgorithm.gcd(r, n);

        if (eeRes.getGcdOfBAndA().compareTo(BigInteger.ONE) != 0) {
            throw new ArithmeticException("N and R are not co-prime");
        }

        BigInteger n1 = eeRes.getY().multiply(BigInteger.valueOf(-1));
        BigInteger r1 = eeRes.getX();
        BigInteger residue = KaratsubaMultiplication.multiply(t, n1).subtract(KaratsubaMultiplication.multiply(t, n1)
                .shiftRight(r.bitLength() - 1).shiftLeft(r.bitLength() - 1));
        BigInteger u = t.add(KaratsubaMultiplication.multiply(residue, n)).shiftRight(r.bitLength() - 1);

        while (u.compareTo(n) >= 0) {
            u = u.subtract(n);
        }

        return new Pair<>(u, r1);
    }

    public static BigInteger computeR(BigInteger n) {
        BigInteger r = BigInteger.ONE;
        return r.shiftLeft(n.bitLength());
    }

    /**
     * Returns helping expression to be used in main exponentiation montgomery method.
     * */
    private static BigInteger powHelp(BigInteger a, BigInteger e, final BigInteger n) {
        BigInteger r = computeR(n);
        BigInteger a1 = a.shiftLeft(r.bitLength() - 1).mod(n);
        BigInteger x = BigInteger.ONE.shiftLeft(r.bitLength() - 1).mod(n);

        for (int i = e.bitLength() - 1; i >= 0; --i) {
            x = multiplicationHelp(x, x, n).getKey();
            if (e.testBit(i)) {
                x = multiplicationHelp(a1, x, n).getKey();
            }
        }

        return multiplicationHelp(x, BigInteger.ONE, n).getKey();
    }
}