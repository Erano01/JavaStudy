package me.erano.com.concurrency.why;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>NOT THREAD-SAFE</b> - bilerek bozuk bırakılmış örnek.
 *
 * <ul>
 *   <li>Spring bean'leri varsayılan olarak singleton'dır: tüm istekler aynı
 *       {@code VisitController} nesnesini kullanır.</li>
 *   <li>Tomcat istekleri bir thread pool ile karşılar (varsayılan {@code maxThreads = 200}).</li>
 *   <li>50 kullanıcı aynı anda {@code /visit} çağırırsa 50 thread aynı
 *       {@code visitCount} alanına dokunur.</li>
 * </ul>
 *
 * <p><b>Sonuç:</b> Sayaç bazı ziyaretleri sessizce kaybeder. Exception yok, log yok,
 * sadece yanlış bir sayı. Thread'i sen açmadın, framework açtı.
 *
 * <p>Neden bozulduğu: Part 1. Nasıl düzeltileceği: Part 3.
 */
@RestController
public class VisitController {

    private int visitCount = 0; // paylaşılan, mutable state, hiçbir koruma yok

    @GetMapping("/visit")
    public int visit() {
        return ++visitCount; // ⚠ atomik değil: oku -> artır -> yaz (read-modify-write)
    }
}
