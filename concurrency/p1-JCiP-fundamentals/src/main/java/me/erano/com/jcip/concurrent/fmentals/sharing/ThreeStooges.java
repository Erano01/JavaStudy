package me.erano.com.jcip.concurrent.fmentals.sharing;

import net.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

// Listing 3.11. Immutable Class Built Out of Mutable Underlying Objects.
@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
