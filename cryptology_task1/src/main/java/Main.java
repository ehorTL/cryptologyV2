import algos.MontgomeryArithmetic;
import customexceptions.IterationsOutException;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException, IterationsOutException {
        System.out.println((MontgomeryArithmetic.multiply(new BigInteger("90"),
                new BigInteger("15"), new BigInteger("13")).toString()));
    }
}
