<h1>Observer</h1>

<h3>Intent</h3>
Nesneler arasında one-to-many bağımlılıklar tanımlayın, böylece bir nesnenin durumu değiştiğinde tüm bağımlı olduğu nesneleri bilgilendirilir ve otomatik olarak bilgilendirilen nesne güncellenir.

Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically

<h3>Erano-Notes</h3>
//Observable (Subject/Publisher)-> Durumundaki değişikliklerin takip edildiği nesne.
//Observer (Subscriber)-> Observable nesnesine abone olup ondaki değişikliklerden haberdar olmak isteyen nesne.
//Bu kalıba Publisher-Subscriber dışında Producer-Consumer, Event-Notification, Event-Bus da denir.
//Message Oriented Middleware(MOM), sistemler arası olay (event) mekanizması kuran bir yapıdır ve Java'da Java Messager Service .NET Azure Bus Services ile gerçekleştirilir.

![image](https://github.com/user-attachments/assets/943c58a7-e971-43e0-9b21-52f9c31cb3d7)

//java 9 dan önceki yapı ile gerçekleştirme yap daha sonra java.util.concurrent ile yap
//Observer patterne merkezi yapı eklemek istersek Mediator patterni kullanabiliriz.
https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Observable.html
https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/concurrent/package-summary.html
https://docs.oracle.com/en/java/javase/23/docs/api/java.desktop/java/beans/package-summary.html
https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/concurrent/Flow.html

observer = listener, subscriber
subject = observable, publisher, event

<h3>Also Known As</h3>
Dependents, Publish-Subscribe

<h3>Motivation</h3>
Bir sistemi iş birliği yapan sınıflar koleksiyonuna bölmenin yaygın bir yan etkisi, ilişkili nesneler arasında tutarlılığı koruma gereksinimidir.
Sınıfları tightly coupled şekilde birleştirerek tutarlılık elde etmek istemezsiniz çünkü bu onların yeniden kullanılabilirliğini azaltır.
Örneğin, birçok grafik kullanıcı arayüzü aracı, kullanıcı arayüzünün sunumsal yönlerini temel uygulama verilerinden ayırır [KP88, LVC89, P+88, WGM88]. 
Uygulama verilerini ve sunumlarını tanımlayan sınıflar, birbirinden bağımsız olarak yeniden kullanılabilir. Ancak, birlikte de çalışabilirler. 
Hem bir tablo nesnesi (spreadsheet object) hem de bir çubuk grafik nesnesi (bar chart object), aynı uygulama veri nesnesindeki bilgiyi farklı sunumlar kullanarak gösterebilir. 
Tablo ve çubuk grafik birbirini bilmez, bu da yalnızca ihtiyacınız olanı yeniden kullanmanıza olanak tanır. 
Ancak, birbirlerini biliyormuş gibi davranırlar. Kullanıcı tabloda bilgiyi değiştirdiğinde, çubuk grafik değişiklikleri hemen yansıtır ve tam tersi de geçerlidir.

![image](https://github.com/user-attachments/assets/e01785ce-a9a2-4d5f-8b86-425d6eb7420e)

Bu davranış, tablo (spreadsheet) ve çubuk grafik (bar chart) nesnelerinin veri nesnesine bağımlı(dependent) olduğunu ve bu nedenle durumundaki herhangi bir değişiklikten haberdar edilmeleri gerektiğini ima eder. 
Ayrıca, bağımlı nesnelerin sayısını iki ile sınırlamak için bir neden yoktur; aynı veriye bağlı herhangi bir sayıda farklı kullanıcı arayüzü olabilir.
Observer (Gözlemleyici) tasarım deseni, bu ilişkilerin nasıl kurulacağını açıklar. Bu desende, kilit nesneler subject (konu) ve observer (gözlemleyici) olarak adlandırılır. 
Bir subject herhangi bir sayıda bağımlı observer içerebilir. Subject durumunda bir değişiklik olduğunda tüm observer'lar bilgilendirilir. 
Bunun üzerine her bir observer, kendi durumunu subject'in durumu ile senkronize etmek için subject'e sorgu gönderir.
Bu tür bir etkileşim, yayınla-abone ol (publish-subscribe) olarak da bilinir. Subject, bildirimlerin yayıncısıdır (publisher). Bu bildirimleri, observer'larının kim olduğunu bilmek zorunda kalmadan gönderir. Herhangi bir sayıda observer, bildirim almak için abone olabilir.

<h3>Applicability</h3>
Observer (Gözlemleyici) tasarım desenini aşağıdaki durumların herhangi birinde kullanabilirsiniz:
1. Bir soyutlamanın iki yönü olduğunda ve biri diğerine bağımlıysa. Bu yönleri ayrı nesnelerde kapsüllemek, bunları bağımsız olarak çeşitlendirmenize ve yeniden kullanmanıza olanak tanır.
2. Bir nesnedeki bir değişikliğin diğer nesneleri değiştirmesini gerektirdiğinde ve değişmesi gereken nesnelerin sayısını bilmediğinizde.
3. Bir nesnenin, diğer nesnelere kim olduklarına dair varsayımlarda bulunmadan bildirim gönderebilmesi gerektiğinde. Başka bir deyişle, bu nesnelerin tightly coupled şekilde birbirine bağlı olmasını istemediğinizde.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/0d3f61b3-ce42-4372-8bd1-20d734609497)

<h3>Participants</h3>
1. Subject
Kendi gözlemcilerini (observers) bilir. Herhangi bir sayıda Observer nesnesi bir Subject'i gözlemleyebilir.
Observer nesnelerinin eklenmesi ve çıkarılması için bir arayüz sağlar.

2. Observer
Bir Subject'teki değişikliklerden haberdar edilmesi gereken nesneler için bir güncelleme arayüzü tanımlar.

3. ConcreteSubject
ConcreteObserver (Somut Gözlemleyici) nesneleri için ilgi çekici durumu saklar. Durumu değiştiğinde gözlemcilerine bir bildirim gönderir.

4. ConcreteObserver  
Bir ConcreteSubject nesnesine referans tutar. 
Subject ile tutarlı kalması gereken bir durumu saklar. 
Kendi durumunu Subject'in durumu ile tutarlı tutmak için Observer güncelleme arayüzünü gerçekleştirir.

<h3>Collaborations</h3>
1. ConcreteSubject, gözlemcilerinin durumunu kendi durumuyla tutarsız hale getirebilecek bir değişiklik meydana geldiğinde gözlemcilerini bilgilendirir.
2. Concrete subject'daki bir değişiklik hakkında bilgilendirildikten sonra, bir ConcreteObserver nesnesi subject'dan bilgi isteyebilir. ConcreteObserver bu bilgiyi kendi durumunu subject'in durumuyla uzlaştırmak için kullanır. Aşağıdaki interaction diyagramı(sequence diagram?) bir subject ile iki observer arasındaki işbirliklerini göstermektedir:
![image](https://github.com/user-attachments/assets/2ce893fd-aba2-4c3e-adee-cc6a02fbe514)


Değişiklik isteğini başlatan Observer nesnesinin, subject'dan bir bildirim alana kadar güncellemesini nasıl ertelediğine dikkat edin.
Notify her zaman subject tarafından çağrılmaz. Bir observer veya tamamen başka bir tip nesne tarafından çağrılabilir. Implementation bölümü bazı yaygın varyasyonları ele alır.

<h3>Consequences</h3>
Observer (Gözlemleyici) deseni, subject (konu) ve observer (gözlemleyici) nesnelerini birbirinden bağımsız olarak çeşitlendirmenizi sağlar. 
Subject nesnelerini observer nesnelerini yeniden kullanmadan, ya da tam tersini yapmadan yeniden kullanabilirsiniz. Ayrıca, subject ya da diğer observer nesnelerini değiştirmeden yeni observer eklemenize olanak tanır.
Observer deseninin diğer faydaları ve olası sakıncaları şunlardır:

1. Subject ve Observer arasında soyut bağlanma (Abstract coupling):
Bir subject yalnızca bir observer list'e sahip olduğunu ve her bir observer'in soyut Observer sınıfının basit arayüzüne uyduğunu bilir.
Subject, hiçbir observer'ın somut sınıfını bilmez. Bu nedenle, subject ve observer nesneleri arasındaki bağlanma soyut ve minimum seviyededir.
Subject ve observer tightly coupled(sıkı sıkıya) bağlanmadığı için, sistemin farklı soyutlama katmanlarına ait olabilirler.
Daha alt seviyedeki bir subject, daha üst seviyedeki bir observer ile iletişim kurabilir ve onu bilgilendirebilir; böylece sistemin katmanlı yapısı korunmuş olur. Eğer subject ve observer birlikte gruplanırsa, ortaya çıkan nesne ya iki katmanı birleştirir (ve katmanlı yapıyı ihlal eder) ya da bir katmanda yer almak zorunda kalır (bu da soyutlama katmanlarını zedeleyebilir).

2. Yayın (broadcast) iletişimi desteği:
Normal bir request'in aksine, bir subject tarafından gönderilen bildirim receiver'ini belirtmek zorunda değildir. Bildirim, otomatik olarak abone olmuş tüm ilgili nesnelere yayınlanır.
Subject, kaç tane ilgili nesne olduğunu umursamaz; tek sorumluluğu gözlemcilerini bilgilendirmektir.
Bu, istediğiniz zaman observerları ekleme ve çıkarma özgürlüğü sağlar. Bildirimi işlemek ya da göz ardı etmek observer'in sorumluluğundadır.

3. Beklenmedik güncellemeler:
Observerlar birbirlerinin varlığından habersiz oldukları için, subject'teki bir değişikliğin nihai maliyetine kör kalabilirler.
Subject üzerinde masum görünen bir işlem, observerlara ve onların bağlı nesnelerine bir güncelleme zinciri başlatabilir.
Ayrıca, iyi tanımlanmamış veya korunmamış bağımlılık kriterleri genellikle gereksiz güncellemelere yol açar ve bunları takip etmek zor olabilir.
Bu problem, basit güncelleme protokolünün subject'te neyin değiştiğine dair herhangi bir ayrıntı sağlamaması nedeniyle daha da kötüleşir. 
Observerların değişiklikleri anlamalarına yardımcı olacak ek bir protokol olmadan, değişiklikleri çıkarmak için yoğun çaba harcamaları gerekebilir.

<h3>Implementation</h3>
Bağımlılık mekanizmasının gerçekleştirilmesiyle ilgili birkaç konu bu bölümde ele alınmıştır:

1. Subjectleri onların observerlarına haritalamak. 
Bir subject'in, bildirim yapması gereken observerları takip etmesinin en basit yolu, bu observerlarının referanslarını açıkça(explicitly) subject içerisinde saklamaktır. 
Ancak, çok sayıda subject ve az sayıda observer olduğunda bu yöntem fazla yer kaplayabilir. 
Bunun bir çözümü, subject-observer haritalamasını sürdürmek için bir ilişkilendirme arama(associative look-up) mekanizması (örneğin, bir hash table) kullanarak yerden tasarruf sağlamak olabilir. Bu sayede observeri olmayan bir subject herhangi bir depolama maliyeti getirmez. Ancak, bu yaklaşım observerlara erişim maliyetini artırabilir.

2. Birden fazla subjecti observe etmek. Bazı durumlarda, bir observer'in birden fazla subject'e bağımlı olması mantıklı olabilir. Örneğin, bir hesap tablosu birden fazla veri kaynağına bağımlı olabilir. Bu tip durumlarda, Update arayüzünü genişletmek ve hangi subject'in bildirimi gönderdiğini observer'a bildirmek gerekir. Subject, Update işleminde kendisini bir parametre olarak ileterek observer'a hangi subject'i incelemesi gerektiğini bildirebilir.

3. Kim güncellemeyi tetikler ? Subject ve observerları, tutarlılığı sağlamak için bildirim mekanizmasına güvenir. Ancak, Notify metodunu çağırarak güncellemeyi kim tetikler? İşte iki seçenek:
a) Subject'daki durum ayarlama işlemlerinin, durum değişikliğinden sonra Notify çağırması. Bu yaklaşımın avantajı, istemcilerin subject'in Notify metodunu çağırmayı hatırlamasına gerek olmamasıdır. Dezavantajı ise, ardışık işlemler birden fazla güncellemeyi tetikleyebilir ve bu verimsiz olabilir.
b) Güncellemeyi doğru zamanda tetiklemekten istemcilerin sorumlu olması. Bunun avantajı, istemcinin, bir dizi durum değişikliği yaptıktan sonra güncellemeyi tetikleyerek gereksiz ara güncellemeleri önleyebilmesidir. Ancak, bu yöntem istemcilere ek sorumluluk yükler ve hatalara neden olabilir çünkü istemciler Notify çağrısını unutabilir.

4. Silinmiş subjectlere asılı kalmış referanslar: Bir subject'in silinmesi, observerlarında asılı referanslara neden olmamalıdır. Bunu önlemenin bir yolu, subject silinirken observerlarını bilgilendirmesidir. Böylece observerlar referanslarını sıfırlayabilir. Observerları tamamen silmek genelde bir seçenek değildir çünkü diğer nesneler onları referans alıyor olabilir ya da başka subjectleri gözlemliyor olabilirler.

5. Bildirimden önce Subject durumunun tutarlı olduğundan emin olma: Notify çağrılmadan önce Subject durumunun tutarlı olduğundan emin olmak önemlidir, çünkü gözlemciler (observers) kendi durumlarını güncellerken Subject'in mevcut durumunu sorgularlar. Bu tutarlılık kuralı, özellikle Subject alt sınıf operasyonları miras alınan operasyonları çağırdığında istemeden ihlal edilebilir. Örneğin, aşağıdaki kod dizisinde, bildirim (notification), Subject'in tutarsız bir durumda olduğu sırada tetiklenir:

![image](https://github.com/user-attachments/assets/9152ca0c-e7ce-42e5-a365-64524ccf2160)

Bu tür bir hatadan kaçınmak için bildirimleri soyut Subject sınıflarındaki şablon yöntemler (Template Method) aracılığıyla gönderebilirsiniz. Alt sınıflar için bir temel operasyon tanımlayın ve template methodunda Notify işlemini en son sıraya koyun. Bu, alt sınıfların Subject operasyonlarını geçersiz kıldığında nesnenin tutarlı olmasını sağlar.

![image](https://github.com/user-attachments/assets/8da6a29b-ff24-4bf5-bdc1-6fd765c41712)

Bu arada, hangi Subject operasyonlarının bildirimleri tetiklediğini belgelemek her zaman iyi bir fikirdir.

6. Observer'a özgü güncelleme protokollerinden kaçınma: push ve pull modelleri
Observer (Gözlemci) tasarım deseninin uygulamaları genellikle Subject'in (Konu) değişiklikle ilgili ek bilgiler yayınlamasını içerir. Subject bu bilgileri, Update işlemine bir argüman olarak iletir. Bu bilginin miktarı büyük ölçüde değişebilir.
Bir uçta, push modeli dediğimiz yaklaşımda, Subject değişiklikle ilgili ayrıntılı bilgileri, observerlar bunu isteseler de istemeseler de gönderir. 
Diğer uçta ise pull modeli bulunur; burada Subject yalnızca en minimal bildirimi gönderir ve observerlar gerekli detayları açıkça talep eder.
Pull modeli, Subject'in observerlar hakkında bilgisizliğini vurgular,
Push modeli ise Subject'in, observerların ihtiyaçları hakkında bir şeyler bildiğini varsayar.
Push modeli, Subject sınıflarının Observer sınıfları hakkında varsayımlarda bulunması nedeniyle observerların yeniden kullanılabilirliğini azaltabilir. Ancak, pull modeli verimsiz olabilir; çünkü Observer sınıfları, Subject'ten yardım almadan neyin değiştiğini belirlemek zorunda kalır.

7. İlgilendiğiniz değişiklikleri açıkça belirtmek
Güncelleme verimliliğini artırmak için, Subject'in (Konu) kayıt arayüzünü genişleterek observerların yalnızca belirli ilgilendikleri olaylar için kaydolmasına izin verebilirsiniz. Böyle bir olay meydana geldiğinde, Subject yalnızca o olaya ilgi duyan observerlara bilgi verir.
Bunu desteklemenin bir yolu, Subject nesneleri için aspect (yön) kavramını kullanmaktır. Belirli olaylara ilgi kaydetmek için gözlemciler şu şekilde Subject'e eklenir:

![image](https://github.com/user-attachments/assets/84fbaef9-c1bb-48e0-910f-997e6d9423d7)

Bu yöntem, yalnızca ilgili olaylarla ilgilenilen durumlarda gereksiz bildirimleri ortadan kaldırır ve performansı artırır.

8. Karmaşık güncelleme semantiğini kapsüllemek
Konu (subject) ve gözlemciler (observers) arasındaki bağımlılık ilişkisi özellikle karmaşık olduğunda, bu ilişkileri yöneten bir nesne gerekebilir. 
Bu tür bir nesneye ChangeManager diyoruz. Amacı, observerların, konularındaki bir değişikliği yansıtması için gereken işlemi minimize etmektir. Örneğin, bir işlem birkaç birbirine bağlı subjectte değişiklik yapıyorsa, observerların yalnızca tüm subjectler değiştirildikten sonra bildirilmesini sağlamak gerekebilir, böylece observerlar birden fazla kez bildirilmemiş olur.
ChangeManager'ın üç sorumluluğu vardır:

(a) Bir subjecti observerlarına haritalar ve bu haritalamayı sürdürmek için bir arayüz sağlar. Bu, subjectlerin observerlarına ve observerların subjectlerine olan referansları sürdürme ihtiyacını ortadan kaldırır.
(b) Belirli bir güncelleme stratejisini tanımlar.
(c) Bir subject tarafından talep edildiğinde tüm bağımlı observerları günceller.

Aşağıdaki diyagram, Observer desenine dayalı basit bir ChangeManager implementasyonunu göstermektedir. İki özel ChangeManager tipi vardır:
SimpleChangeManager, her subject için her zaman tüm observerları günceller, yani biraz naiftir.
DAGChangeManager, subjectler ile observerları arasındaki yönlendirilmiş çevrimsiz grafikleri (DAG - directed-acyclic graphs) işler. Bir observer birden fazla subject'i gözlemliyorsa, DAGChangeManager SimpleChangeManager'dan daha uygundur. 
Bu durumda, iki ya da daha fazla subject'daki değişiklik redundant (gereksiz) güncellemeye yol açabilir. DAGChangeManager, observer'in yalnızca bir güncelleme almasını sağlar. Birden fazla güncelleme sorunu olmadığında SimpleChangeManager uygundur.

![image](https://github.com/user-attachments/assets/7af5b60e-6154-4cdc-8c50-f273d92655b6)


ChangeManager, Mediator (273) deseninin bir örneğidir. Genel olarak yalnızca bir ChangeManager vardır ve bu global olarak bilinir. Bu durumda, Singleton (127) deseni faydalı olabilir.

9. Subject ve Observer sınıflarını birleştirmek
Çoklu kalıtımın (multiple inheritance) olmadığı dillerde (örneğin Smalltalk) yazılmış sınıf kütüphaneleri genellikle ayrı Subject ve Observer sınıfları tanımlamaz, bunun yerine her iki arayüzü bir sınıfta birleştirirler. Bu, çoklu kalıtım olmadan hem bir konu (subject) hem de bir gözlemci (observer) olarak davranan bir nesne tanımlamanıza olanak sağlar. Örneğin Smalltalk'ta, Subject ve Observer arayüzleri kök sınıf olan Object içinde tanımlanır, bu da onları tüm sınıflar için kullanılabilir hale getirir.


<h3>Related Patterns</h3>
Mediator(273):  Karmaşık güncelleme semantiğini kapsülleyerek, ChangeManager sınıfı subjectler ve observerlar arasında arabulucu görevi görür.
Singleton(127): ChangeManager sınfını benzersiz ve global olarak erişilebilir kılmak için Singleton modelini kullanabilir.



