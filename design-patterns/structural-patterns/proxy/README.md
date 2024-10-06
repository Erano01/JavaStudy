<h1>Proxy</h1>

<h3>Intent</h3>
Başka bir nesneye erişimi kontrol etmek için bir vekil veya placeholder(yer tutucu) sağlar.

<h3>Also Known As</h3>
Surrogate

<h3>Motivation</h3>
<p>
// görüntü/görsel == image
Bir nesneye erişimi kontrol etmenin bir nedeni, nesnenin yaratılmasının ve başlatılmasının(init) tüm maliyetini, onu gerçekten kullanmamız gerekene kadar ertelemektir.
Bir belgeye grafiksel nesneler gömebilen bir document editor düşünün. Büyük raster resimler gibi bazı grafiksel nesnelerin oluşturulması pahalı olabilir.
Ancak bir belgeyi açmak hızlı olmalı, bu yüzden belge açıldığında tüm pahalı nesneleri aynı anda oluşturmaktan kaçınmalıyız.
Bu zaten gerekli değil, çünkü bu nesnelerin hepsi aynı anda belgede görünür olmayacak.

Bu kısıtlamalar, her pahalı nesnenin talep üzerine yaratılmasını önerebilir; bu durumda, bir görüntü(image) görünür hale geldiğinde bu gerçekleşir.
Peki belgeye görüntünün yerine ne koyacağız? Ve görüntünün talep üzerine oluşturulduğu gerçeğini nasıl gizleyebiliriz ki editörün gerçekleştirmesini karmaşıklaştırmayalım? Bu optimizasyon örneğin, rendering ve formatting kodunu etkilememelidir.

Çözüm, gerçek görüntü(image) için bir vekil(proxy) görevi gören başka bir nesne, bir image proxy'si kullanmaktır. Proxy, görüntü gibi davranır ve gerektiğinde onun örneğini oluşturmakla ilgilenir.
</p>
![image](https://github.com/user-attachments/assets/c00c4d18-9fc1-4161-9968-e3f61274b692)

<p>
Görüntü proxy'si, yalnızca document editor draw() operasyonunu çağırarak kendisini görüntülemesini istediğinde gerçek görüntüyü oluşturur. 
Proxy, sonraki requestleri doğrudan görüntüye iletir. Bu nedenle, görüntüyü oluşturduktan sonra görüntüye bir referans tutmalıdır.

Görüntülerin ayrı dosyalarda saklandığını varsayalım. Bu durumda dosya adını gerçek nesneye referans olarak kullanabiliriz. Proxy ayrıca kendi kapsamını, yani genişliğini ve yüksekliğini de saklar. Kapsam, proxy'nin formatterindan gelen boyut isteklerine resmi gerçekten örneklendirmeden yanıt vermesini sağlar.

Aşağıdaki sınıf diyagramı bu örneği daha detaylı göstermektedir.
</p>

![image](https://github.com/user-attachments/assets/c1a79098-b03d-4758-8a7f-06f7ab9726b5)

Document editor, embedded resimlere soyut Graphic sınıfı tarafından tanımlanan arayüz aracılığıyla erişir. ImageProxy, talep üzerine oluşturulan resimler için bir sınıftır. ImageProxy, dosya adını diskteki resme bir referans olarak korur. Dosya adı, ImageProxyconstructor'a bir argüman olarak geçirilir.

ImageProxy ayrıca görüntünün/resimin sınırlayıcı kutusunu(bounding box) ve gerçek Görüntü örneğine bir referansı depolar. Bu referans, proxy gerçek görüntünün örneğini oluşturana kadar geçerli olmayacaktır. Draw operasyonu, isteği iletmeden önce görüntünün örneklendiğinden emin olur. GetExtent, isteği yalnızca örneklenmişse görüntüye iletir; aksi takdirde ImageProxy depoladığı kapsamı döndürür.

<h3>Applicability</h3>
Proxy, basit bir pointerdan daha çok yönlü(versatile) veya sofistike bir nesne referansına ihtiyaç duyulduğunda uygulanabilir. Proxy deseninin uygulanabilir olduğu birkaç yaygın durum şunlardır:
1. Remote proxy, farklı bir adres alanındaki bir nesne için yerel bir temsilci(local representative) sağlar. 
   NEXTSTEP [Add94]bu amaçla NXProxy sınıfını kullanır. Coplien [Cop92]bu tür proxy'ye "Ambassador" adını verir.
2. Virtual proxy, talep üzerine pahalı nesneler yaratır. Motivasyon'da açıklanan ImageProxy, bu tür bir proxy'nin örneğidir. 
   //Nesne lazım olana kadar o nesnenin yaratılmasını geciktirir.
3. Protection proxy, orijinal nesneye erişimi kontrol eder. Protection proxy'leri nesnelerin farklı erişim haklarına sahip olması gerektiğinde faydalıdır. Örneğin, Choices işletim sistemindeki [CIRM93] KernelProxies işletim sistemi nesnelerine korunmuş erişim sağlar.
4. Smart reference, bir nesneye erişildiğinde ek eylemler gerçekleştiren çıplak bir işaretçinin yerine geçen bir referanstır. Tipik kullanımlar şunları içerir:
   ◇ gerçek nesneye yapılan referansların sayısını sayarak, daha fazla referans olmadığında otomatik olarak serbest bırakılabilmesini sağlamak (smart pointer olarak da adlandırılır [Ede92]).
   ◇ kalıcı(persistent) bir nesneyi ilk kez referans alındığında memory'e yüklemek.
   ◇ Gerçek nesneye erişilmeden önce, başka hiçbir nesnenin onu değiştiremeyeceğinden emin olmak için nesnenin kilitlendiğini(lock) kontrol etmek.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/4a7cd73c-cffe-4f0a-bd1b-5bdd1968bfea)
<p>
İşte runtime'daki proxy mimarisinin muhtemel object diagramı:
</p>
![image](https://github.com/user-attachments/assets/36d494e6-89a3-4603-9aab-23c93ddddf6d)

<h3>Participants</h3>

<ul>
<li>• Proxy (ImageProxy)</li>
   <ul>
   <li>◇ Proxy gerçek subjecte erişmesine izin veren bir referansı barındırır. Proxy, RealSubject ve Subject arayüzleri aynıysa bir Subject'e başvurabilir.</li>
   <li>◇ Proxy, Subject ile aynı olan bir arayüz sağlar böylece bir proxy, real subject yerine kullanılabilir.</li>
   <li>◇ Proxy, real subject'e olan erişimi kontrol eder ve real subject'i oluşturmak ve silmekten sorumlu olabilir. </li>
   <li>◇ Diğer sorumluluklar proxy tipine bağlıdır:</li></ul><ul>
      <li>▪ remote proxy'ler bir isteği ve onun argümanlarını encode'lamak ve encode'lanmış isteği farklı bir adres alanındaki real subjecte göndermekten sorumludur.</li>
      <li>▪ virtual proxy'ler real subject hakkındaki ek bilgileri cache'leyebilir. Örneğin, Motivasyon'daki ImageProxy, gerçek görüntünün/resimin boyutlarını önbellekte saklar(cache'ler).</li>
      <li>▪ protection proxy'ler çağıranın(caller) bir isteği gerçekleştirmek için gereken erişim izinlerine sahip olup olmadığını kontrol eder.</li>
</ul>
<li>• Subject (Graphic)</li>
<ul>
   <li>◇ RealSubject ve Proxy için ortak arayüzü tanımlar, böylece bir Proxy RealSubject'in beklendiği her yerde kullanılabilir.</li>
</ul>
<li>• RealSubject (Image)</li>
   <ul>
  <li> ◇ Proxy'nin sunduğu gerçek nesneyi tanımlar.</li>
   </ul>
</ul>
// encode'lamak = farklı bir formata veya yapıya dönüştürme işlemidir

<h3>Collaborations</h3>
Proxy, proxy tipine bağlı olarak uygun olduğunda istekleri RealSubject'e iletir.

<h3>Consequences</h3>
Proxy pattern, bir nesneye erişirken bir dolaylılık(indirection) leveli sunar. Ek dolaylılığın, proxy tipine bağlı olarak birçok kullanımı vardır:
1. Remote proxy, bir nesnenin farklı bir adres alanında bulunduğu gerçeğini gizleyebilir.
2. Virtual proxy, isteğe bağlı bir nesne oluşturma gibi optimizasyonlar gerçekleştirebilir.
3. Hem protection proxy'leri hem de smart referanslar, bir nesneye erişildiğinde ek temizlik(housekeeping)(housekeeping tasks) görevlerine izin verir.

Proxy patterninin client'dan gizleyebileceği başka bir optimizasyon daha var. Buna copy-on-write denir ve talep üzerine oluşturma ile ilgilidir.
Büyük ve karmaşık bir nesneyi kopyalamak pahalı bir işlem olabilir. Kopya asla değiştirilmezse, o zaman bu maliyete katlanmaya gerek yoktur.
Kopyalama işlemini ertelemek için bir proxy kullanarak, nesnenin kopyalanmasının bedelini yalnızca nesnenin değiştirilmesi durumunda ödeyeceğimizden emin oluruz.

Copy-on-write işleminin çalışmasını sağlamak için, subject referans sayılmalıdır. Proxy'yi kopyalamak, bu referans sayısını artırmaktan başka bir şey yapmayacaktır.
Yalnızca istemci subjecti değiştiren bir işlem talep ettiğinde proxy aslında onu kopyalar.
Bu durumda proxy'nin subject'in referans sayısını da azaltması gerekir. Referans sayısı sıfıra indiğinde, subject silinir.
Copy-on-write, heavyweight subjelerin kopyalanmasının maliyetini önemli ölçüde azaltabilir.

<h3>Related Patterns</h3>
Adapter (139): Bir adaptör, adapte ettiği nesneye farklı bir arayüz sağlar. Bunun aksine, bir proxy, subjecti ile aynı arayüzü sağlar. Ancak, erişim koruması için kullanılan bir proxy, subject'in gerçekleştireceği bir işlemi gerçekleştirmeyi reddedebilir, bu nedenle arayüzü, subject'in arayüzünün etkili bir alt kümesi olabilir.

Decorator (175): Dekoratörler, proxy'lerle benzer gerçekleştirmelere sahip olabilse de, dekoratörlerin farklı bir amacı vardır. Bir dekoratör, bir nesneye bir veya daha fazla sorumluluk eklerken, bir proxy, bir nesneye olan erişimi kontrol eder.

Proxy'ler, bir decorator gibi gerçekleştirilme derecesine göre değişir. Bir protection proxy'si, bir dekoratör gibi gerçekleştirilebilir.
Öte yandan, remote proxy real subject'e doğrudan bir referans içermez, yalnızca "ana bilgisayar kimliği ve ana bilgisayardaki yerel adres" gibi dolaylı bir referans içerir. 
Virtual proxy, dosya adı gibi dolaylı bir referansla başlar, ancak sonunda doğrudan bir referans elde eder ve kullanır.




