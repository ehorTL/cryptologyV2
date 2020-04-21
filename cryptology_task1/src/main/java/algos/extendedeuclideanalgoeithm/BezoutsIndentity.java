package algos.extendedeuclideanalgoeithm;

import java.math.BigInteger;

/**
 * Class represents bezouts identity to be
 * a*x + b*y = GCD(a, b), where GCD - greatest common divisor of a and b.
 * */
public class BezoutsIndentity {
    private BigInteger a;
    private BigInteger b;
    private BigInteger x;
    private BigInteger y;
    private BigInteger gcdOfBAndA;

    public BezoutsIndentity(){

    }

    public BezoutsIndentity(BigInteger a, BigInteger b, BigInteger x, BigInteger y, BigInteger gcdOfBAndA) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.gcdOfBAndA = gcdOfBAndA;
    }

    public BigInteger getA() {
        return a;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public BigInteger getB() {
        return b;
    }

    public void setB(BigInteger b) {
        this.b = b;
    }

    public BigInteger getX() {
        return x;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }

    public BigInteger getGcdOfBAndA() {
        return gcdOfBAndA;
    }

    public void setGcdOfBAndA(BigInteger gcdOfBAndA) {
        this.gcdOfBAndA = gcdOfBAndA;
    }

    /**
     * a*x + b*y = GCD(a, b), where GCD - greatest common divisor of a and b
     */
    @Override
    public String toString() {
        return "x = " + x + "\n" +
                "y = " + y + "\n" +
                "GCD( " + a + ", " + b + " ) = " + gcdOfBAndA + "\n" +
                "Control: " + (a.multiply(x).add(b.multiply(y))) + " = " + gcdOfBAndA;
    }
}
