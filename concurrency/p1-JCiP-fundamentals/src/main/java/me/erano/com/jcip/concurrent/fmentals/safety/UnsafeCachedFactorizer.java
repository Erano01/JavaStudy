package me.erano.com.jcip.concurrent.fmentals.safety;

import net.jcip.annotations.NotThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// Listing 2.5. A plain Java version of the unsafe cached factorizer.
// It keeps the same check-then-act race between the cached values.
@NotThreadSafe
public class UnsafeCachedFactorizer {
    private final AtomicReference<BigInteger> lastNumber
            = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors
            = new AtomicReference<BigInteger[]>();

    public BigInteger[] service(BigInteger input) {
        if (input.equals(lastNumber.get())) {
            return lastFactors.get();
        }

        BigInteger[] factors = factor(input);
        lastNumber.set(input);
        lastFactors.set(factors);
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
