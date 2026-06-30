package me.erano.com.jcip.concurrent.fmentals.sharing;

import net.jcip.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

// Listing 3.12. Immutable Holder for Caching a Number and its Factors.
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,
                         BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
