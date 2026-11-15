/**
 * <h2>Why Concurrency</h2>
 *
 * <p>Programın açıkça thread oluşturmasa bile frameworkler senin adına thread oluşturur;
 * bu threadlerden çağrılan kodun thread-safe olması gerekir.
 *
 * <p><b>Threadler her yerde:</b>
 * <ul>
 *   <li>JVM: main thread + housekeeping threadleri (GC, finalization).</li>
 *   <li>AWT / Swing: GUI eventleri için threadler.</li>
 *   <li>Timer: ertelenmiş görevler (deferred tasks) için threadler.</li>
 *   <li>Servlet / RMI: thread pool kurup component methodlarını bu threadlerde çağırır.
 *       Spring Boot (Tomcat) da servlet kullanır.</li>
 * </ul>
 *
 * <p><b>Concurrency'yi neden kullanırız:</b>
 * <ul>
 *   <li><b>Throughput / responsiveness:</b> Bir thread I/O beklerken (DB, network, disk)
 *       başka bir thread CPU'yu kullanır. Web sunucuları böyle çalışır.</li>
 *   <li><b>Latency / parallelism:</b> Büyük bir hesaplamayı parçalara bölüp birden fazla
 *       çekirdekte aynı anda çalıştırarak cevabı daha hızlı alırsın.</li>
 * </ul>
 *
 * @see me.erano.com.concurrency.why.VisitController framework'ün açtığı threadlerin bozduğu bir sayaç
 */
package me.erano.com.concurrency.why;
