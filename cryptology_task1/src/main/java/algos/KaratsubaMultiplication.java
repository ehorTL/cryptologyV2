package algos;

import java.math.BigInteger;

public class KaratsubaMultiplication {
    public static final int START_BIT_LENGTH = 2;

    public static BigInteger multiply(BigInteger a, BigInteger b){
        int bitLengthMax = Math.max(a.bitLength(), b.bitLength());
        if (bitLengthMax < START_BIT_LENGTH){
            return a.multiply(b);
        }

        //half length of bit view of input numbers,
        int m = (int)Math.ceil((double)bitLengthMax / 2);
        // a = a0 + a1*base^m, b = b0 + b1*base^m, base = 2
        BigInteger a1 = a.shiftRight(m);
        BigInteger a0 = a.subtract(a1.shiftLeft(m));
        BigInteger b1 = b.shiftRight(m);
        BigInteger b0 = b.subtract(b1.shiftLeft(m));

        //A * B = A0 * B0 + ((A0+A1)*(B0+B1) — A0*B0 — A1*B1) * BASE^m + A1*B1*BASE^(2*m)
        BigInteger a0b0Product = KaratsubaMultiplication.multiply(a0, b0);
        BigInteger a1b1Product = KaratsubaMultiplication.multiply(a1, b1);
        BigInteger product2 = KaratsubaMultiplication.multiply(a0.add(a1), b0.add(b1));

        return a0b0Product.add((product2.subtract(a0b0Product).subtract(a1b1Product)).shiftLeft(m)).add((a1b1Product.shiftLeft(2*m)));
    }
}
