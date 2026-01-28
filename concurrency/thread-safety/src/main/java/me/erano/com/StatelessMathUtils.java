package me.erano.com;

// Shared Mutable state içermeyen sınıflar thread-safe olarak kabul edilir çünkü
// herhangi bir durum (state) tutmazlar. Dolayısıyla senkronizasyon ihtiyacı yoktur.
// "Shared"dan kastımız bir değişkenin birden fazla thread tarafından erişilebileceği anlamındadır.
// "Mutable"dan kastımız ise değerinin ömrü boyunca değişebileceği kastedilmektedir.
public class StatelessMathUtils {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
