package me.erano.com;

import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// dakikada sadece 20 request yapabilirsin.
// aynı anda 20 thread ile aynı requesti yapacaksın.
// her bir thread aynı anda birbirinden farklı datalar için request yapmış olacak
// daha sonrasında her thread kendi datasını diğer threadlerle paralel olarak repository'e ekleyecek.
public class Service {

    //belkide on binlerce data barındıran bir kaynak olarak düşün bunu
    private volatile CopyOnWriteArrayList<String> data;

    private volatile CopyOnWriteArrayList<String> repository;

    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    private final ExecutorService threadPool = Executors.newFixedThreadPool(20);
    private final RateLimiter rateLimiter = RateLimiter.create(20.0 / 60.0);

    public Service(){
        this.data = new CopyOnWriteArrayList<>(List.of(
                "elma", "armut", "portakal", "muz", "çilek", "kiraz", "karpuz", "kavun", "şeftali", "üzüm",
                "ananas", "avokado", "greyfurt", "mandalina", "incir", "kayısı", "erik", "ayva", "dut", "nar",
                "mango", "hindistan cevizi", "kivi", "limon", "ahududu", "böğürtlen", "yaban mersini", "kuşburnu", "alıç", "hurma",
                "kestane", "fındık", "badem", "ceviz", "fıstık", "leblebi", "kaju", "kabak çekirdeği", "ay çekirdeği", "antep fıstığı",
                "zeytin", "domates", "biber", "patlıcan", "kabak", "patates", "soğan", "sarımsak", "havuç", "kereviz",
                "pırasa", "ıspanak", "marul", "lahana", "brokoli", "karnabahar", "turp", "şalgam", "enginar", "kuşkonmaz",
                "bakla", "bezelye", "fasulye", "nohut", "mercimek", "bulgur", "pirinç", "makarna", "buğday", "mısır",
                "çavdar", "yulaf", "arpa", "kinoa", "karabuğday", "tef", "darı", "soya", "barbunya", "börülce",
                "bamya", "pazı", "semizotu", "roka", "tere", "dereotu", "maydanoz", "nane", "fesleğen", "kekik",
                "biberiye", "adaçayı", "lavanta", "ıhlamur", "papatya", "rezene", "tarçın", "karanfil", "kimyon", "sumak",

                "kitap", "kalem", "defter", "silgi", "cetvel", "pergel", "sözlük", "atlas", "harita", "takvim",
                "telefon", "bilgisayar", "tablet", "televizyon", "radyo", "kamera", "kulaklık", "hoparlör", "mikrofon", "klavye",
                "masa", "sandalye", "koltuk", "yatak", "dolap", "raf", "kapı", "pencere", "perde", "halı",
                "buzdolabı", "fırın", "ocak", "çamaşır makinesi", "bulaşık makinesi", "süpürge", "ütü", "tost makinesi", "mikser", "blender",
                "araba", "bisiklet", "motosiklet", "otobüs", "tren", "uçak", "gemi", "tekne", "helikopter", "kamyon",
                "okul", "hastane", "kütüphane", "müze", "sinema", "tiyatro", "park", "bahçe", "market", "mağaza",
                "gömlek", "pantolon", "etek", "elbise", "ceket", "mont", "ayakkabı", "çorap", "şapka", "eldiven",
                "güneş", "ay", "yıldız", "gezegen", "bulut", "yağmur", "kar", "rüzgar", "şimşek", "gökkuşağı",
                "deniz", "göl", "nehir", "dağ", "tepe", "orman", "çöl", "vadi", "ada", "okyanus",
                "kaplan", "aslan", "fil", "zürafa", "maymun", "köpek", "kedi", "kuş", "balık", "kaplumbağa"
        ));

        this.repository = new CopyOnWriteArrayList<>(); //CopyOnWriteArrayList
    }

    public CompletableFuture<String> getRequestForMContainsWords(int start, int count){
        return CompletableFuture.supplyAsync(()->{
            rateLimiter.acquire();
            return data.stream()
                    .filter(s->s.contains("m"))
                    .findFirst()
                    .orElseThrow(()->new RuntimeException("No m contains words"));
        }, threadPool);
    }

    public CompletableFuture<Void> processMContainsWords(){
        return CompletableFuture.runAsync(()->{

        }, threadPool);
    }

    public boolean persistData(String data){
        this.repository.add(data);
        return true;
    }


}
