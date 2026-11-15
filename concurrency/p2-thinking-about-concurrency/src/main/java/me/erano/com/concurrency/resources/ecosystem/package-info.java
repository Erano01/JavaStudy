/**
 * <h2>Asynchronous &amp; Synchronous Ecosystems Overview</h2>
 *
 * <p><img src="doc-files/ecosystem.png"
 *         alt="Synchronous ekosistem: Thread &amp; Runnable, synchronized/wait/notify, Executors/Locks/AQS,
 *              Fork/Join, Virtual threads, Structured concurrency. Asynchronous ekosistem: Future,
 *              CompletableFuture, Flow API, RxJava, Project Reactor, Spring WebFlux.">
 *
 * <h3>Diyagramı okumak</h3>
 * <ul>
 *   <li><b>Synchronous ekosistem</b> (genelde blocking), tamamı JDK'nın içinde:
 *       Thread &amp; Runnable (JDK 1.0) → synchronized, wait/notify (JDK 1.0) →
 *       Executors, Locks, AQS (JDK 5) → Fork/Join pool (JDK 7) →
 *       Virtual threads (JDK 21) → Structured concurrency (JDK 25).</li>
 *   <li><b>Asynchronous ekosistem</b> (genelde non-blocking):
 *       Future (JDK 5) → CompletableFuture (JDK 8) → Flow API / Reactive Streams (JDK 9)
 *       JDK'nın içinde; RxJava → Project Reactor → Spring WebFlux ise third-party.</li>
 *   <li><b>Blocking / non-blocking</b> bir thread davranışıdır; <b>sync / async</b> ayrı bir eksendir.
 *       İkisi arasında birebir eşleşme yoktur.</li>
 * </ul>
 *
 * <h3>Synchronous Resources</h3>
 * <ol>
 *   <li><b>JCiP</b> (Java Concurrency in Practice) kitabı.</li>
 *   <li><a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html">
 *       The Java Tutorials (JDK 8): Concurrency</a></li>
 *   <li><a href="https://docs.oracle.com/javase/specs/jls/se26/html/jls-17.html">
 *       JLS Chapter 17: Threads and Locks</a></li>
 *   <li><a href="https://docs.oracle.com/en/java/javase/26/core/concurrency.html">
 *       docs.oracle: Concurrency</a></li>
 *   <li><a href="https://gee.cs.oswego.edu/dl/papers/aqs.pdf">
 *       AQS Synchronizer Framework Paper (Doug Lea, 2004)</a>:
 *       JCiP'te kullanıcı olarak öğrendiğin ReentrantLock/Semaphore'un ortak iskeletini (AQS)
 *       tasarlayan orijinal akademik makale.</li>
 *   <li><a href="https://openjdk.org/jeps/444">JEP 444 (Virtual Threads)</a> &amp;
 *       <a href="https://openjdk.org/jeps/505">JEP 505 (Structured Concurrency)</a>:
 *       Motivation/Description bölümleri, Ron Pressler'ın tasarım gerekçelendirmesi,
 *       "neden Loom" sorusunun resmi cevabı.</li>
 * </ol>
 *
 * <h3>Asynchronous Resources</h3>
 * <ol>
 *   <li><b>Built-in Way, CompletableFuture</b>
 *     <ul>
 *       <li><a href="https://gee.cs.oswego.edu/">Doug Lea'nın anasayfası</a></li>
 *       <li><a href="https://gee.cs.oswego.edu/dl/concurrency-interest/">JSR-166 resmi sayfası</a>
 *         <ul>
 *           <li><a href="https://gee.cs.oswego.edu/dl/papers/aqs.pdf">AQS orijinal tasarım makalesi (2004)</a></li>
 *           <li><a href="http://www.briangoetz.com/pubs.html">Brian Goetz'in j.u.c makaleleri arşivi</a></li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li><b>Reactive Streams</b>:
 *       <a href="https://github.com/reactive-streams">github.com/reactive-streams</a>,
 *       <a href="https://github.com/reactive-streams/reactive-streams-jvm">reactive-streams-jvm</a>
 *       <p>Reactive Streams bir kütüphane değil, bir spesifikasyondur (sözleşme). 2013'te Netflix,
 *       Pivotal (Spring), Lightbend (Akka), Red Hat gibi şirketlerin ortaklaşa geliştirdiği,
 *       kütüphaneler arası uyumluluğu garanti eden bir standarttır. Kod değil, dört arayüz tanımlar:
 *       {@code Publisher}, {@code Subscriber}, {@code Subscription}, {@code Processor}.
 *       JDK 9'daki {@link java.util.concurrent.Flow} bu arayüzlerin JDK içindeki karşılığıdır.</p>
 *   </li>
 *   <li><b>Project Reactor</b>:
 *       <a href="https://projectreactor.io/docs/core/release/reference/aboutDoc.html">Reference Guide</a>
 *       <p>API referansı değil, gerçek bir öğretim dokümanı. Reactive'in neden var olduğunu,
 *       callback hell'den nasıl evrildiğini, Mono/Flux ayrımını en net anlatan yer.</p>
 *       <ul>
 *         <li>"Flows, Publisher, and Operator Fusion": backpressure'ın gerçek mekanizması
 *             (request-n protokolü).</li>
 *         <li>"Threading and Schedulers": {@code subscribeOn} / {@code publishOn} farkı.</li>
 *       </ul>
 *   </li>
 *   <li><b>ReactiveX</b>: <a href="https://reactivex.io/intro.html">reactivex.io/intro</a>
 *       <p>RxJava/Reactor'ın ortak felsefesini (Rx pattern'i: Observer + Iterator + Functional
 *       birleşimi) en temiz anlatan yer. Operatörlerin zaman çizgisinde ne yaptığını gösteren
 *       "marble diagram"lar burada; bu diyagramları görmeden reactive operatörleri gerçekten
 *       kavramak zor.</p>
 *   </li>
 * </ol>
 *
 * @see me.erano.com.concurrency.resources.layers
 */
package me.erano.com.concurrency.resources.ecosystem;
