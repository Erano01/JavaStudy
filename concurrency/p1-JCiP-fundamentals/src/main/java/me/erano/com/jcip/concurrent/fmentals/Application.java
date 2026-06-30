package me.erano.com.jcip.concurrent.fmentals;

// Durumsuz (Shared Mutable State içermeyen) nesneler doğrudan thread-safe'dir.
// Bir sınıfın shared state değişkenlerininin hepsi immutable ise bu sınıfta thread-safe'dir.
// Eğer shared state'in tek bir shared mutable variable'i varsa ve invariant'ı yoksa, sadece in-built atomic wrapper type'lar ile gerekli senkronizasyonu sağlayabiliriz.
// Eğer shared state'in birden fazla shared mutable variable'i var ise ve invariant'ıda varsa kesinlikle intrinsic veya explicit locklar kullanmalıyız.
public class Application {

    public static void main(String[] args) {

    }
}
