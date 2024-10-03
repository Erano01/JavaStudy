package me.erano.com.example3;

public abstract class CryptoService {

    private DatabaseService databaseService;
    private SomeComplexStuff complexStuff;

    public abstract void buyCurrency(User user, double amount);

    public static class SomeComplexStuff { }

}
