package me.erano.com.jcip.concurrent.fmentals.safety;

import net.jcip.annotations.NotThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Listing 2.2. Class That Counts Requests without the Necessary Synchronization. Don't Do this.
@NotThreadSafe
public class UnsafeCountingFactorizer {

    private long count = 0;
    public long getCount() { return count; }

    public BigInteger[] service(BigInteger number) {
        BigInteger i = number;
        BigInteger[] factors = factor(i);
        ++count;
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
