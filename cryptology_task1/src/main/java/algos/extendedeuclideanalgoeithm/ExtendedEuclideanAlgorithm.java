package algos.extendedeuclideanalgoeithm;

import java.math.BigInteger;

public class ExtendedEuclideanAlgorithm {
    /**
     * @return bezouts identity object, where object fields satisfy:
     * a*x + b*y = GCD(a, b), where GCD - greatest common divisor of a and b.
     * */
    public static BezoutsIndentity gcd(BigInteger a, BigInteger b){
        BezoutsIndentity bezoutsIndentity = new BezoutsIndentity();
        bezoutsIndentity.setA(a);
        bezoutsIndentity.setB(b);

        BigInteger prevX = BigInteger.ONE;
        BigInteger x = BigInteger.ZERO;
        BigInteger prevY = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;

        while (b.compareTo(BigInteger.ZERO) != 0){
            BigInteger q = a.divide(b);
            BigInteger xCopy = new BigInteger(x.toByteArray()),
                        yCopy = new BigInteger(y.toByteArray());
            x = prevX.subtract(q.multiply(x));
            prevX = xCopy;
            y = prevY.subtract(q.multiply(y));
            prevY = yCopy;
            BigInteger prevA = new BigInteger(a.toByteArray());
            a = b;
            b = prevA.mod(b);
        }
        bezoutsIndentity.setGcdOfBAndA(a);
        bezoutsIndentity.setX(prevX);
        bezoutsIndentity.setY(prevY);

        return bezoutsIndentity;
    }
}
