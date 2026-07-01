package me.erano.com.jcip.concurrent.fmentals.safety;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Listing 2.6. Class that Caches Last Result, But with Unacceptably Poor Concurrency. Don't Do this.
@ThreadSafe
public class SynchronizedFactorizer {
    @GuardedBy("this") private BigInteger lastNumber;
    @GuardedBy("this") private BigInteger[] lastFactors;

    public synchronized BigInteger[] service(BigInteger input) {
        if (input.equals(lastNumber)) {
            return lastFactors;
        }

        BigInteger[] factors = factor(input);
        lastNumber = input;
        lastFactors = factors;
        return factors;
    }

    private BigInteger[] factor(BigInteger n) {
        List<BigInteger> factors = new ArrayList<>();
        BigInteger two = BigInteger.valueOf(2);

        while (n.mod(two).equals(BigInteger.ZERO)) {
            factors.add(two);
            n = n.divide(two);
        }

        BigInteger i = BigInteger.valueOf(3);
        while (i.multiply(i).compareTo(n) <= 0) {
            while (n.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                n = n.divide(i);
            }
            i = i.add(two);
        }

        if (n.compareTo(BigInteger.ONE) > 0) {
            factors.add(n);
        }

        return factors.toArray(BigInteger[]::new);
    }
}
