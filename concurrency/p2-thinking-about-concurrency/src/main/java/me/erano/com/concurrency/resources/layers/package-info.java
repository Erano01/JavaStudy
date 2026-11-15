/**
 * <h2>Layers of Reasoning About Java Concurrency</h2>
 *
 * <p>Concurrent bir programın "doğru" olması tek bir seviyede cevaplanmaz. Doğruluğun
 * matematiksel bir karşılığı, tasarımda (JCiP) bir karşılığı, kodda bir karşılığı ve en altta
 * donanımda bir karşılığı vardır. Concurrent düşünme biçimi bu katmanları <b>soyuttan somuta</b>
 * doğru dolaşarak kurulur; her katman kendi sorusunu sorar.
 *
 * <p><img src="doc-files/layers-of-reasoning-about-concurrency.png"
 *         alt="Soyuttan somuta yedi katman: Mathematical specification, State machine model,
 *              Design policy, Contracts and static analysis, Exploration by execution,
 *              Java Memory Model, Hardware.">
 *
 * <h3>Katmanlar</h3>
 * <p><b>Kod yazmadan önce:</b>
 * <ol>
 *   <li><b>Mathematical specification</b>: Her zaman ne doğru olmalı?
 *       <i>(TLA+, Alloy, Lean/Coq)</i></li>
 *   <li><b>State machine model</b>: Hangi interleaving'ler mümkün?
 *       <i>(FSP/LTSA, P, Promela)</i></li>
 * </ol>
 *
 * <p><b>Kodla birlikte:</b>
 * <ol start="3">
 *   <li><b>Design policy</b>: Safety nasıl sağlanıyor?
 *       <i>(JCiP, concurrency patterns)</i></li>
 *   <li><b>Contracts and static analysis</b>: Kod policy'ye uyuyor mu?
 *       <i>({@code @GuardedBy}, JML/KeY, Checker)</i></li>
 *   <li><b>Exploration by execution</b>: Gerçekte ne oluyor?
 *       <i>(Java PathFinder, Lincheck)</i></li>
 *   <li><b>Java Memory Model</b>: Hangi yazmalar görünür?
 *       <i>(happens-before, jcstress)</i></li>
 * </ol>
 *
 * <p><b>JVM'in ve CPU'nun işi:</b>
 * <ol start="7">
 *   <li><b>Hardware</b>: CPU neyi yeniden sıralıyor?
 *       <i>(fences, store buffers, caches)</i></li>
 * </ol>
 *
 * <h3>Teorik arka plan</h3>
 * <p>En üstteki iki katman teorik bilgisayar biliminden gelir. Concurrency hem
 * <b>Theory A</b> (algoritmalar, karmaşıklık) hem <b>Theory B</b> (mantık, semantik, doğrulama)
 * tarafında çalışılır.
 *
 * <p><img src="doc-files/approaches.png"
 *         alt="Theoretical computer science, Theory A ve Theory B'ye ayrılır; ikisi de concurrency'yi
 *              çalışır. System axes: timing, communication, progress guarantee, failure model.
 *              Reasoning approaches: state-based ve process algebra.">
 *
 * <ul>
 *   <li><b>System axes</b> (Theory A geleneği): bir concurrent sistemi sınıflandıran eksenler.
 *     <ul>
 *       <li>Timing: sync, async, partially sync</li>
 *       <li>Communication: shared memory, message passing</li>
 *       <li>Progress guarantee: blocking, lock-free, wait-free</li>
 *       <li>Failure model: crash, Byzantine</li>
 *     </ul>
 *   </li>
 *   <li><b>Reasoning approaches</b> (Theory B geleneği): doğruluğu kanıtlama yolları.
 *     <ul>
 *       <li><b>State-based</b>: Hoare logic, Dijkstra, Pnueli. Araç: TLA+ (Lamport).
 *           → <i>Mathematical specification</i> katmanı.</li>
 *       <li><b>Process algebra</b>: CSP (Hoare), CCS ve π (Milner). Araçlar: FSP/LTSA, FDR.
 *           → <i>State machine model</i> katmanı.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see me.erano.com.concurrency.resources.ecosystem
 */
package me.erano.com.concurrency.resources.layers;
