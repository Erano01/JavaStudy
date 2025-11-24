<h1>Flyweight</h1>

<h3>Intent</h3>
Çok sayıda fine-grained(ince taneli, küçük) nesneyi etkin/verimli bir şekilde sağlamak için paylaşmayı kullan.

Flyweight = sinek siklet

<h3>Motivation</h3>
Bazı uygulamalar, dizaynları boyunca nesneleri kullanmaktan faydalanabilir, ancak naif bir gerçekleştirme aşırı derecede pahalı olacaktır.
Örneğin, çoğu document editor gerçekleştirmesi, bir dereceye kadar modülerleştirilmiş text formatting ve editing olanaklarına sahiptir.
Nesne yönelimli document editorler genellikle tablolar ve şekiller(tables and figures) gibi embedded elementleri temsil etmek için nesneleri kullanır.
Ancak, uygulamada en iyi seviyelerde esnekliği teşvik edecek olmasına rağmen, genellikle belgedeki(document) her karakter için bir nesne kullanmaktan kaçınırlar.
Karakterler(characters) ve embedded elementler daha sonra çizilme(drawn) ve biçimlendirilmeleri(formatted) açısından tek tip olarak ele alınabilir.
Uygulama, diğer fonksiyonellikleri bozmadan yeni character setlerini destekleyecek şekilde genişletilebilir.
Uygulamanın nesne mimarisi document'in fiziksel mimarisini taklit edebilir.
Aşağıdaki diyagram, bir document editörünün karakterleri temsil etmek için nesneleri nasıl kullanabileceğini göstermektedir.
![image](https://github.com/user-attachments/assets/9b3b6997-6c8a-440c-99c6-41be1da3b2ac)


Böyle bir dizayn'ın dezavantajı ise maliyetidir.
Orta büyüklükteki document'ler bile yüzbinlerce karakter nesnesi gerektirebilir, bu da çok fazla memory tüketir ve kabul edilemez run-time yüküne(overhead) neden olabilir.
Flyweight deseni, nesnelerin, aşırı maliyetlere yol açmadan, ince ayrıntılarda(fine granularities) kullanılmasına izin vermek için nasıl paylaşılacağını açıklar.
Flyweight, aynı anda birden fazla bağlamda(multiple contexts) kullanılabilen paylaşımlı bir nesnedir(shared object).
Flyweight her bağlamda(context) bağımsız(independent) bir nesne gibi davranır; paylaşılmayan bir nesne örneğinden ayırt edilemez.
Flyweight'ler faaliyet gösterdikleri bağlam hakkında varsayımlarda bulunamazlar.
Buradaki temel kavram intrinsic(içsel) ve extrinsic(dışsal) state arasındaki ayrımdır.
Extrinsic(dışsal) durum, flyweight'in bağlamına bağlı olup değişir ve bu nedenle paylaşılamaz.
Client nesneleri, ihtiyaç duyduğunda flyweight'a extrinsic(dışsal) durumu iletmekten sorumludur.

Flyweight, normalde sunumlanması için çok fazla olan konseptleri veya entityleri nesnelerle modeller. Örneğin, bir document editor alfabenin her harfi için bir flyweight oluşturabilir.
Her flyweight bir karakter kodu depolar, ancak document'deki koordinat konumu(cordinate position) ve tipografik stili(typographic style), karakterin göründüğü her yerde geçerli olan metin düzeni algoritmaları(text layout algorithms) ve biçimlendirme komutlarından(formatting commands) belirlenebilir
Karakter kodu içsel durumdur(intrinsic state), diğer bilgiler ise dışsaldır(extrinsic state).

Mantıksal(logically) olarak, document'da verilen karakterin her oluşumu için bir nesne vardır:
![image](https://github.com/user-attachments/assets/78d243df-37a7-4281-ac6b-f4470b7af272)


Ancak fiziksel olarak, karakter başına bir paylaşılan flyweight nesnesi vardır ve bu nesne document mimarisinde farklı context'lerde görünür.
Belirli bir karakter nesnesinin her bir oluşumu, flyweight nesnelerinin paylaşılan havuzundaki aynı örneği ifade eder (shared pool of flyweight objects):
![image](https://github.com/user-attachments/assets/aceb8147-77d9-4c53-a816-9c5b6cc6710a)



Bu nesnelerin sınıf structure'i aşağıda gösterilmektedir. Glyph, bazıları flyweight olabilen grafiksel nesneler için soyut bir sınıftır. Dışsal duruma (extrinsic state) bağımlı(depend) olabilen operasyonlar, bu durumu bir parametre olarak kendilerine geçerler.
Örneğin, Draw ve Intersects, işlerini yapabilmeleri için glyph'in hangi contex'da olduğunu bilmelidir.


"A" harfini temsil eden bir flyweight yalnızca karşılık gelen karakter kodunu depolar; konumunu veya yazı tipini depolamasına gerek yoktur. Client'ler, flyweight'in kendisini çizebilmesi için ihtiyaç duyduğu context'e bağlı bilgileri sağlar.
Örneğin, bir Row(satır) gliphy'i, child'larının kendilerini nereye çizmesi gerektiğini bilir, böylece horizontally(yatay) olarak çizilirler. Böylece her child'i çizim requestindeki lokasyonuna geçebilir.
![image](https://github.com/user-attachments/assets/291a72bb-3f1f-41ef-94b5-edfc109987eb)

Farklı karakter nesnelerinin sayısı document'daki karakter sayısından çok daha az olduğundan, nesnelerin toplam sayısı basit bir gerçekleştirmenin kullanacağından önemli ölçüde daha azdır.
Tüm karakterlerin aynı yazı tipi ve renkte göründüğü bir document, document'in uzunluğundan bağımsız olarak 100 karakter nesnesi (kabaca ASCII karakter kümesinin boyutu) mertebesinde yer ayırır.
Ve çoğu document 10'dan fazla farklı yazı tipi-renk kombinasyonu kullanmadığından, bu sayı pratikte önemli ölçüde artmayacaktır. Böylece bir nesne soyutlaması her bir karakter için pratik hale gelir.

<h3>Applicability</h3>
Flyweight deseninin etkinliği büyük ölçüde nasıl ve nerede kullanıldığına bağlıdır. Aşağıdakilerin hepsi doğru olduğunda Flyweight desenini gerçekleştirin:
• Bir uygulama yüksek sayıda nesne kullanıyorsa.
• Depolama maliyetleri, nesnelerin çokluğu nedeniyle yüksekse.
• Çoğu nesne durumu dışsal durum (extrinsic state) haline getirilebiliyorsa.
• Dışsal durum(extrinsic state) kaldırıldığında, birçok nesne grubu nispeten az sayıda paylaşılan nesneyle değiştirilebiliyorsa.
• Uygulama nesne kimliğine bağımlı değildir. Flyweight nesneleri paylaşılabileceğinden, kimlik(identity) testleri konsept olarak farklı nesneler için true döndürecektir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/068eca88-ea6e-4b61-a541-377857ac0c79)


Aşağıdaki nesne diagramı flyweight'lerin nasıl paylaşıldığını gösteriyor:
![image](https://github.com/user-attachments/assets/9ec89cd8-fe7b-4692-9170-35e1f2fa6eff)



<h3>Participants</h3>
• Flyweight (Glyph)
   ◇ flyweight'ların dışsal(extrinsic) durumları alabileceği ve bu durumlara göre hareket edebileceği bir arayüz bildirir.
• ConcreteFlyweight (Character)
   ◇ Flyweight arayüzünü gerçekleştirir ve varsa içsel(instrinsic) durum için depolama(storage) alanı ekler. Concrete Flyweight nesnesi paylaşılabilir olmalıdır. Depoladığı herhangi bir durum içsel(instrinsic) olmalıdır; yani, Concrete Flyweight nesne context'inden bağımsız olmalıdır.
• UnsharedConcreteFlyweight (Row, Column)
   ◇ tüm Flyweight sub classlarının paylaşılması gerekmez. Flyweight arayüzü paylaşımı etkinleştirir; bunu zorlamaz. UnsharedConcreteFlyweight nesnelerinin flyweight nesne mimarisinde bir düzeyde ConcreteFlyweight nesnelerinin child olarak bulunması yaygındır (Row(satır) ve Column(Sütun) sınıflarında olduğu gibi).
• FlyweightFactory
   ◇ flyweight nesnelerini oluşturur ve yönetir.
   ◇ flyweight'ların düzgün bir şekilde paylaşılmasını sağlar. Bir client bir flyweight istediğinde, FlyweightFactory nesnesi mevcut bir örneği sağlar veya eğer yoksa bir tane oluşturur.
• Client
   ◇ Flyweight'e(lerine) bir referans tutar
   ◇ Flyweight(ler)in dışsal(extrinsic) durumunu hesaplar veya depolar.

<h3>Collaborations</h3>
Bir flyweight'inin fonksiyonelliğini yerine getirebilmesi için içsel(instrinsic) veya dışsal(extrinsic) olarak karakterize edilmesi gerekir.
İçsel(instrinsic) durum ConcreteFlyweight nesnesinde saklanır; dışsal(extrinsic) durum Client nesneleri tarafından saklanır veya hesaplanır. Client'ler bu durumu flyweight'a, operasyonlarını çağırdıklarında geçerler.

<h3>Consequences</h3>
Flyweight'ler, özellikle daha önce içsel(instrinsic) durum olarak depolanmışsa, dışsal(extrinsic) durumu aktarma(transferring), bulma(finding) ve/veya hesaplama(computing) ile ilişkili runtime maliyetleri getirebilir.
Ancak bu maliyetler, daha fazla flyweight paylaşıldıkça artan alan tasarruflarıyla telafi edilir.

Depolama tasarrufu birkaç faktörün bir fonksiyonudur:
• paylaşımdan kaynaklanan toplam örnek sayısındaki azalma.
• nesne başına içsel(instrinsic) durum miktarı.
• dışsal(extrinsic) durumun hesaplanıp hesaplanmadığı veya depolanıp depolanmadığı.(computed or stored)

Daha fazla flyweight paylaşıldıkça, depolama tasarrufu da artar. Tasarruflar paylaşılan durum miktarıyla artar.
En büyük tasarruf, nesneler hem içsel(instrinsic) hem de dışsal(extrinsic) durumdan önemli miktarda kullandığında ve dışsal(extrinsic) durum depolanmak yerine hesaplanabildiğinde gerçekleşir.
Daha sonra depolama alanından iki şekilde tasarruf edersiniz: Paylaşım, içsel(instrinsic) durumun maliyetini azaltır ve hesaplama süresi için dışsal(extrinsic) durumu takas edersiniz.

Flyweight deseni, genellikle hiyerarşik bir mimariyi, paylaşılan yaprak düğümlerine(leaf nodes) sahip bir grafik olarak temsil etmek için Composite (163) deseniyle birleştirilir.
Paylaşımın bir sonucu olarak, flyweight yaprak düğümleri(leaf nodes) parentina bir pointer depolayamaz. Bunun yerine, parent pointer'i flyweight'a dışsal(extrinsic) durumunun bir parçası olarak geçirilir.Bunun, hiyerarşideki nesnelerin birbirleriyle nasıl iletişim kurduğu üzerinde büyük bir etkisi vardır.
