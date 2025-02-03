<h1>1.2 Algorithms as a Technology</h1>
Bilgisayarlar sonsuz derecede hızlı ve bilgisayar belleği boş olsaydı, algoritmaları incelemek için herhangi bir nedeniniz olur muydu? Cevap evet, başka bir neden olmasa bile çözüm yönteminizin sonlanacağından ve bunu doğru cevapla yapacağından emin olmak istersiniz.

Eğer bilgisayarlar sonsuz derecede hızlı olsaydı, bir problemi çözmek için herhangi bir doğru yöntem işe yarardı. Muhtemelen gerçekleştirmenizin iyi yazılım mühendisliği pratikleri sınırları içinde olmasını istersiniz (örneğin, uygulamanız iyi tasarlanmış ve belgelenmiş olmalıdır), ancak çoğunlukla gerçekleştirilmesi en kolay olan yöntemi kullanırsınız.

Elbette bilgisayarlar hızlı olabilir, ancak sonsuz derecede hızlı değildirler. Bu nedenle hesaplama zamanı sınırlı bir kaynaktır, bu da onu değerli kılar. "Zaman paradır" sözü geçerli olsa da, zaman paradan bile daha değerlidir: harcadıktan sonra parayı geri alabilirsiniz, ancak zaman harcandıktan sonra asla geri alamazsınız. Bellek ucuz olabilir, ancak ne sonsuzdur ne de ücretsizdir. Zaman ve mekan kaynaklarını etkin bir şekilde kullanan algoritmaları seçmelisiniz

<h3>Efficiency</h3>
Aynı problemi çözmek için tasarlanan farklı algoritmalar genellikle verimlilikleri açısından önemli ölçüde farklılık gösterir. Bu farklılıklar, donanım ve yazılımdan kaynaklanan farklılıklardan çok daha önemli olabilir.
Örnek olarak, Bölüm 2'de sıralama(sorting) için iki algoritma tanıtılmaktadır.

İlki, ekleme sıralaması(insertion sort) olarak bilinir, n öğeyi sıralamak için yaklaşık olarak c1 n kareye eşit zaman alır, burada c1 n'ye bağlı olmayan bir sabittir. Yani, yaklaşık olarak n kareye orantılı bir zaman alır.
İkincisi, birleştirme sıralaması(merge sort), yaklaşık olarak c2 n lg n'ye eşit bir zaman alır, burada lg n log 2 n'yi temsil eder ve c2 de n'ye bağlı olmayan başka bir sabittir.

Eklemeli sıralama(insertion sort), birleştirme sıralamasından(merge sort'dan) genellikle daha küçük bir sabit faktöre sahiptir, bu nedenle c1 < c2 olur.















