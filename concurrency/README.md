<h1>Concurrency</h1>

Bilgisayar kullanıcıları, sistemlerinin aynı anda birden fazla şey yapabileceğini varsayarlar.
Diğer uygulamalar dosyaları indirirken, yazdırma kuyruğunu(print queue) yönetirken ve ses akışı(stream audio) yaparken, bir kelime işleyiciyle(word processor) çalışmaya devam edebileceklerini varsayarlar.
Tek bir uygulamadan bile sıklıkla aynı anda birden fazla şey yapması beklenir. Örneğin, bu streaming audio uygulaması aynı anda dijital sesi ağdan okumalı, sıkıştırmasını açmalı, oynatmayı yönetmeli ve görüntüsünü güncellemelidir.

Kelime işleyicisi(word processor) bile, metni yeniden biçimlendirmekle veya ekranı güncellemekle ne kadar meşgul olursa olsun, klavye ve fare eventlerine yanıt vermeye her zaman hazır olmalıdır. Bu tür şeyleri yapabilen yazılıma concurrent(eş zamanlı) yazılım denir.

Java platformu, Java programlama dilinde ve Java sınıf kütüphanelerinde temel concurrency(eş zamanlılık) desteğiyle concurrent(eş zamanlı) programlamayı desteklemek için baştan sona tasarlanmıştır.

5.0 sürümünden bu yana, Java platformu ayrıca üst düzey concurrency API'lerini de içermektedir. Bu ders, platformun temel concurrency desteğini tanıtmakta ve java.util.concurrent paketlerindeki high level API'lerden bazılarını özetlemektedir.

<h1>Processes and Threads</h1>

Concurrent(eşzamanlı) programlamada, iki temel execution unit vardır: process'ler(süreçler) ve thread'ler(iş parçacıkları). Java programlama dilinde, concurrent programlama çoğunlukla threadlerle ilgilenir. Ancak process'ler de önemlidir.

Bir bilgisayar sistemi normalde birçok aktif processes ve thread'e sahiptir. Bu yalnızca tek bir execution core'a(yürütme çekirdeğine) sahip olan ve bu nedenle belirli bir anda yalnızca bir thread'in gerçekten yürütüldüğü sistemlerde bile geçerlidir.
Tek bir core için processing zamanı, zaman dilimleme(time slicing) adı verilen bir işletim sistemi özelliği aracılığıyla processler ve threadler arasında paylaşılır.

Bilgisayar sistemlerinin birden fazla işlemciye(processor) veya birden fazla execution core'a sahip işlemcilere sahip olması giderek daha yaygın hale geliyor. Bu, bir sistemin concurrent process ve thread yürütme kapasitesini büyük ölçüde artırır, ancak concurrency, birden fazla işlemci veya execution core olmadan basit sistemlerde bile mümkündür.

<h3>Processes(işlem)</h3>
Bir process'in(işlem) kendi kendine yeten bir yürütme ortamı vardır. Bir işlem genellikle temel run-time kaynaklarının tam, özel bir kümesine sahiptir; özellikle, her işlemin kendi bellek alanı(memory space) vardır.

İşlemler genellikle programlar veya uygulamalarla eşanlamlı olarak görülür.
Ancak, kullanıcının tek bir uygulama olarak gördüğü şey aslında bir dizi iş birliği yapan işlem olabilir. İşlemler arasındaki iletişimi kolaylaştırmak için çoğu işletim sistemi, pipe'lar ve socket'ler gibi İşlemler Arası İletişim (IPC-Inter Process Communication) kaynaklarını destekler.
IPC yalnızca aynı sistemdeki işlemler arasındaki iletişim için değil, farklı sistemlerdeki işlemler için de kullanılır.

Java virtual machine'in çoğu gerçekleştirmesi tek bir işlem olarak çalışır. Bir Java uygulaması, ProcessBuilder nesnesini kullanarak ek işlemler oluşturabilir. Çoklu işlem uygulamaları bu dersin kapsamı dışındadır. (Multiprocess applications)

<h3>Threads</h3>
Threadler bazen lightweight processler olarak adlandırılır. Hem processler hem de threadleri bir yürütme ortamı sağlar, ancak yeni bir threadi oluşturmak yeni bir process oluşturmaktan daha az kaynak gerektirir.

Threadler bir process içinde bulunur. Her process en az bir tane thread içerir. Threadler, memory ve açık dosyalar dahil olmak üzere process'in kaynaklarını paylaşır. Bu, verimli ancak potansiyel olarak sorunlu bir iletişim sağlar.

Multithreaded execution, Java platformunun temel bir özelliğidir. Her uygulama en az bir threade sahiptir veya memory management ve signal handling gibi şeyler yapan "sistem" threadlerini sayarsanız birkaç threade sahiptir.
Ancak uygulama programcısının bakış açısından, main thread adı verilen tek bir threadle başlarsınız. Bu thread, bir sonraki bölümde göstereceğimiz gibi ek threadleri oluşturma yeteneğine sahiptir.
