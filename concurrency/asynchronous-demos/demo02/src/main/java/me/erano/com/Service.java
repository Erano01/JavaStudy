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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// dakikada sadece 20 request yapabilirsin.
// aynı anda 10 thread ile aynı requesti yapacaksın.
// her bir thread aynı anda birbirinden farklı datalar için request yapmış olacak
// daha sonrasında her thread kendi datasını diğer threadlerle paralel olarak repository'e ekleyecek.
// her bir request için çekebileceğin data limiti 5.
public class Service {

    //belkide on binlerce data barındıran bir kaynak olarak düşün bunu
    private volatile CopyOnWriteArrayList<String> data;

    private volatile CopyOnWriteArrayList<String> repository;

    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    private final ExecutorService threadPool = Executors.newFixedThreadPool(10);
    private final RateLimiter rateLimiter = RateLimiter.create(20.0 / 60.0);

    private static final int MAX_DATA_PER_REQUEST = 5;
    private static final int THREAD_COUNT = 10;
    private static final int PAGE_SIZE = 20;


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

    public CompletableFuture<List<String>> getRequestForMWords(int pageIndex){
        return CompletableFuture.supplyAsync(()->{
            rateLimiter.acquire();
            logger.info("Thread {} requesting page {}", Thread.currentThread().getName(), pageIndex);
            // Sayfalama mantığı - belirtilen sayfadaki verileri al
            int startIndex = pageIndex * PAGE_SIZE;
            int endIndex = Math.min(startIndex + PAGE_SIZE, data.size());
            // Sayfa dışına çıktıysak boş liste dön
            if (startIndex >= data.size()) {
                return List.of();
            }
            List<String> pageData = new ArrayList<>(data.subList(startIndex, endIndex));
            // "m" harfi içeren verileri filtreliyoruz
            List<String> filteredData = pageData.stream()
                    .filter(s -> s.contains("m"))
                    .limit(MAX_DATA_PER_REQUEST) // Her request için maksimum 5 veri
                    .collect(Collectors.toList());
            logger.info("Thread {} found {} words with 'm' in page {}",
                    Thread.currentThread().getName(), filteredData.size(), pageIndex);

            return filteredData;
        }, threadPool);
    }

    public CompletableFuture<Void> processWords(List<String> words){
        return CompletableFuture.runAsync(()->{

        }, threadPool);
    }
    public CompletableFuture<Void> processWords() {
        // Her thread için ayrı bir sayfa başlangıç indeksi oluştur
        List<CompletableFuture<Void>> futures = IntStream.range(0, THREAD_COUNT)
                .mapToObj(this::paginateData)
                .collect(Collectors.toList());

        // Tüm thread'lerin işlemleri tamamlanınca sonlanan bir CompletableFuture döndür
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    logger.info("All data processing completed. Repository size: {}", repository.size());
                    threadPool.shutdown();
                });
    }


    private CompletableFuture<Void> paginateData(int threadIndex) {
        return CompletableFuture.runAsync(() -> {
            int currentPage = threadIndex; // Her thread farklı bir sayfadan başlar
            boolean hasMoreData = true;

            while (hasMoreData) {
                try {
                    // Mevcut sayfayı işle
                    List<String> pageWords = getRequestForMWords(currentPage).join();

                    // Sayfa boşsa, işlenecek veri kalmamış demektir
                    if (pageWords.isEmpty()) {
                        hasMoreData = false;
                        continue;
                    }

                    // Bulunan kelimeleri repository'e ekle
                    for (String word : pageWords) {
                        persistData(word);
                        logger.info("Thread {} persisted: {}", Thread.currentThread().getName(), word);
                    }

                    // Bir sonraki sayfa için thread indeksini THREAD_COUNT kadar artır
                    // Bu sayede her thread kendi "şeridinde" ilerler
                    currentPage += THREAD_COUNT;

                } catch (Exception e) {
                    logger.error("Error in thread {}: {}", Thread.currentThread().getName(), e.getMessage());
                    hasMoreData = false; // Hata durumunda döngüyü sonlandır
                }
            }

            logger.info("Thread {} completed processing", Thread.currentThread().getName());
        }, threadPool);
    }


    public boolean persistData(String data){
        this.repository.add(data);
        return true;
    }

    public CopyOnWriteArrayList<String> getRepository() {
        return repository;
    }
}
