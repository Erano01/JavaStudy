package me.erano.com.jcip.concurrent.fmentals.safety;

import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Immutability için tüm fieldların final olması yetmez, construction aşamasında "this" referansının escape edilmemesi gerekir.
@ThreadSafe
public class AtomicSingleStateFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() { return count.get(); }

    public BigInteger[] service(BigInteger input) {
        BigInteger[] factors = factor(input);
        count.incrementAndGet();
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
