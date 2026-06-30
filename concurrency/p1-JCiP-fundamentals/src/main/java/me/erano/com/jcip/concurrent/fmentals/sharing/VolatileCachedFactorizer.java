package me.erano.com.jcip.concurrent.fmentals.sharing;

import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Listing 3.13. Caching the Last Result Using a Volatile Reference to an Immutable Holder Object
@ThreadSafe
public class VolatileCachedFactorizer {
    private volatile OneValueCache cache =
            new OneValueCache(null, null);

    public BigInteger[] service(BigInteger input) {
        BigInteger i = input;
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        return factors;
    }

    public BigInteger[] factor(BigInteger n) {
        if (n == null) {
            throw new IllegalArgumentException("n cannot be null");
        }
        if (n.signum() <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (n.equals(BigInteger.ONE)) {
            return new BigInteger[]{BigInteger.ONE};
        }

        List<BigInteger> factors = new ArrayList<>();
        BigInteger two = BigInteger.valueOf(2);

        // 2'ye tam bolunenleri once topla
        while (n.mod(two).equals(BigInteger.ZERO)) {
            factors.add(two);
            n = n.divide(two);
        }

        // Sonra sadece tek sayilari dene: 3,5,7...
        BigInteger i = BigInteger.valueOf(3);
        while (i.multiply(i).compareTo(n) <= 0) {
            while (n.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                n = n.divide(i);
            }
            i = i.add(two);
        }

        // Kalan 1'den buyukse asaldir
        if (n.compareTo(BigInteger.ONE) > 0) {
            factors.add(n);
        }

        return factors.toArray(BigInteger[]::new);
    }
}
