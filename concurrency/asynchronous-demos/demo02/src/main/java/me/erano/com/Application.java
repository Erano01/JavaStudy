package me.erano.com;


import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {

        Service service = new Service();

        System.out.println("Veri işleme başlıyor...");

        // Tüm veri işleme sürecini başlat
        service.processWords()
                .thenRun(() -> {
                    System.out.println("İşlem tamamlandı!");
                    System.out.println("Repository'deki veri sayısı: " + service.getRepository().size());
                    System.out.println("Repository içeriği: " + service.getRepository());
                })
                .join(); // Ana thread'in işlem tamamlanana kadar beklemesi için

    }



}
