package algos.extendedeuclideanalgoeithm;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class BezoutsIndentityTest {

    @Test
    public void setGetTest(){
        BezoutsIndentity bi = new BezoutsIndentity();
        BigInteger[] expected = new BigInteger[]{
                BigInteger.valueOf(2731237),
                BigInteger.valueOf(1876182),
                BigInteger.valueOf(993904934),
                BigInteger.valueOf(32329883),
                BigInteger.valueOf(832783487)
        };

        bi.setA(expected[0]);
        bi.setX(expected[1]);
        bi.setB(expected[2]);
        bi.setY(expected[3]);
        bi.setGcdOfBAndA(expected[4]);

        assertTrue(bi.getA().compareTo(expected[0]) == 0);
        assertTrue(bi.getX().compareTo(expected[1]) == 0);
        assertTrue(bi.getB().compareTo(expected[2]) == 0);
        assertTrue(bi.getY().compareTo(expected[3]) == 0);
        assertTrue(bi.getGcdOfBAndA().compareTo(expected[4]) == 0);
    }

    @Test
    public void constructorTest(){
        BigInteger[] expected = new BigInteger[]{
                BigInteger.valueOf(2731237),
                BigInteger.valueOf(1876182),
                BigInteger.valueOf(993904934),
                BigInteger.valueOf(32329883),
                BigInteger.valueOf(832783487)
        };
        BezoutsIndentity bi = new BezoutsIndentity(expected[0], expected[1], expected[2], expected[3], expected[4]);

        assertTrue(bi.getA().compareTo(expected[0]) == 0);
        assertTrue(bi.getB().compareTo(expected[1]) == 0);
        assertTrue(bi.getX().compareTo(expected[2]) == 0);
        assertTrue(bi.getY().compareTo(expected[3]) == 0);
        assertTrue(bi.getGcdOfBAndA().compareTo(expected[4]) == 0);
    }

}