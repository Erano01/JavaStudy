<h1>Strategy</h1>
//bildiğin nesneden, bildiğin bir iş yapmasını istemek.

<h3>Intent</h3>
Bir algoritma ailesi tanımla, algoritmaların her birini sarmala ve onları birbirleri yerine geçebilecek hale getir. 
Strateji, algoritmanın onu kullanan istemcilerden bağımsız olarak değişebilmesini sağlar.

<h3>Also Known As</h3>
Policy

<h3>Motivation</h3>
Bir metin akışını(stream of text) satırlara(lines) bölmek için birçok algoritma vardır. Tüm bu algoritmaları bunları gerektiren sınıflara sabit bir şekilde bağlamak(hard-wiring) birkaç nedenden dolayı istenmez:

1. Satır sonu(linebreaking) gerektiren istemciler, satır sonu(linebreaking) kodunu eklerlerse daha karmaşık hale gelirler. 
   Bu, istemcileri daha büyük ve bakımı daha zor hale getirir, özellikle de birden fazla satır sonu(linebreaking) algoritmasını destekliyorlarsa.
2. Farklı algoritmalar farklı zamanlarda uygun olacaktır. Hepsini kullanmıyorsak birden fazla satır sonu(linebreaking) algoritmasını desteklemek istemiyoruz.
3. Satır sonu(linebreaking) operasyonları bir istemcinin ayrılmaz bir parçası olduğunda yeni algoritmalar eklemek ve mevcut olanları çeşitlendirmek zordur.

Farklı satır sonu(linebreaking) algoritmalarını sarmalayan(encapsulate) sınıflar tanımlayarak bu sorunlardan kaçınabiliriz. Bu şekilde sarmalanan bir algoritmaya strateji denir.

![image](https://github.com/user-attachments/assets/292bf34a-2f83-4828-8ee9-4e2b23f98a4e)

Bir Composition sınıfının, bir text viewerda görüntülenen metnin satır sonlarını korumaktan ve güncellemekten sorumlu olduğunu varsayalım. 
Satır sonu stratejileri Composition sınıfı tarafından uygulanmaz. Bunun yerine, soyut Compositor sınıfının alt sınıfları tarafından ayrı olarak uygulanırlar. Compositor alt sınıfları farklı stratejiler gerçekleştirir:
//Composition sınıfı burada aggregator

• SimpleCompositor: linebreak'leri tek tek belirleyen basit bir strateji gerçekleştirir.
• TeXCompositor: linebreakları bulan TeX algoritması gerçekleştirir. Bu strateji linebreakları global olarak yani her seferinde bir paragrafta optimize etmeye çalışır.
• ArrayCompositor: her satırın sabit sayıda elemente sahip olması için kesmeleri(breaks) seçen bir strateji gerçekleştirir. Örneğin, bir simge(icons) koleksiyonunu satırlara ayırmak için kullanışlıdır.

Bir Composition, bir Compositor nesnesine referans tutar. Bir Composition metnini yeniden biçimlendirdiğinde, bu sorumluluğu Compositor nesnesine iletir. Composition istemcisi, istediği Compositor'ı Compositiona yükleyerek hangi Compositor'ın kullanılacağını belirtir.

<h3>Applicability</h3>
Strateji patternini şu durumlarda kullanın:
1. Birçok ilgili sınıf yalnızca davranışlarında farklılık gösteriyorsa. Stratejiler, bir sınıfı birçok davranıştan biriyle konfigure etmenin bir yolunu sağlar.
2. bir algoritmanın farklı varyantlarına ihtiyacınız var ise. Örneğin, farklı uzay/zaman dengelerini yansıtan algoritmalar tanımlayabilirsiniz. Stratejiler, bu varyantlar bir algoritma sınıf hiyerarşisi olarak gerçekleştirildiğinde kullanılabilir [HO87].
3. bir algoritma, müşterilerin bilmemesi gereken verileri kullanıyorsa. Kompleks, algoritmaya özgü data structurelarını açığa çıkarmaktan kaçınmak için Strateji desenini kullanın.
4. bir sınıf birçok davranışı tanımlar ve bunlar operasyonlarında birden fazla koşullu ifade olarak görünür. Birçok koşullu ifade yerine, ilgili koşullu dalları kendi Strateji sınıflarına taşıyın.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/a1a464f4-263d-45c3-ab7e-b9f6af86b375)

<h3>Participants</h3>
• Strategy (Compositor)
   ◇ desteklenen tüm algoritmalar için ortak bir arayüz deklere eder. Context, bir ConcreteStrategy tarafından tanımlanan algoritmayı çağırmak için bu arayüzü kullanır.

• ConcreteStrategy (SimpleCompositor, TeXCompositor, ArrayCompositor)
   ◇ Strategy arayüzünü kullanarak algoritmayı gerçekleştirir.

• Context (Composition)
   ◇ ConcreteStrategy nesnesi ile configure edilmiştir
   ◇ Strategy nesnesine referans maintain eder.
   ◇ Stratejinin verilerine erişmesine izin veren bir arayüz tanımlayabilir.

<h3>Collaborations</h3>
Strateji ve Context, seçilen algoritmayı gerçekleştirmek için etkileşime girer. Bir context algoritma çağrıldığında algoritmanın gerektirdiği tüm verileri stratejiye iletebilir. Alternatif olarak, context kendisini Strateji operasyonlarına bir argüman olarak iletebilir. Bu, stratejinin gerektiğinde Contexti geri aramasına olanak tanır.
Bir context, istemcilerinden gelen istekleri stratejisine iletir. İstemciler genellikle bir ConcreteStrategy nesnesi oluşturur ve contexte iletir; bundan sonra istemciler yalnızca contextle etkileşime girer. Genellikle bir istemcinin seçebileceği bir ConcreteStrategy sınıfları ailesi vardır.

<h3>Consequences</h3>
Strateji modelinin aşağıdaki avantajları ve dezavantajları vardır:

1. İlgili algoritmaların aileleri(Families of related algorithms). 
   Strateji sınıflarının hiyerarşileri, contextlerinin yeniden kullanılması için bir algoritma veya davranış ailesi tanımlar. Inheritance, algoritmaların ortak fonksiyonelliğini faktörlemeye yardımcı olabilir.

//composition'u altsınıflandırmak yerine farklı davranışlar için başka bir nesneyi altsınıflandırıyoruz.
2. Alt sınıflandırmaya bir alternatif. 
   Inheritance, çeşitli algoritmaları veya davranışları desteklemenin başka bir yolunu sunar. Bir Context sınıfını doğrudan alt sınıfa ayırarak ona farklı davranışlar kazandırabilirsiniz. Ancak bu, davranışı Context'e sabitler. Algoritma gerçekleştirmesini Context'lerle karıştırır ve Context'in anlaşılmasını, sürdürülmesini ve genişletilmesini zorlaştırır. Ve algoritmayı dinamik olarak değiştiremezsiniz. Tek farkı kullandıkları algoritma veya davranış olan birçok ilişkili sınıfla karşılaşırsınız. Algoritmayı ayrı Strateji sınıflarına yerleştirmek, algoritmayı bağlamından bağımsız olarak değiştirmenize olanak tanır ve geçişi, anlamayı ve genişletmeyi kolaylaştırır.

3. Stratejiler koşullu ifadeleri ortadan kaldırır. Strateji kalıbı, istenen davranışı seçmek için koşullu ifadelere bir alternatif sunar. Farklı davranışlar tek bir sınıfa toplandığında, doğru davranışı seçmek için koşullu ifadeleri kullanmaktan kaçınmak zordur. Davranışı ayrı Strateji sınıflarında kapsüllemek bu koşullu ifadeleri ortadan kaldırır. Örneğin, stratejiler olmadan, metni satırlara bölme kodu şöyle görünebilir
![image](https://github.com/user-attachments/assets/62ede15a-423a-48dd-b012-a41502d40cf5)

Strateji patterninin, satır sonu görevini bir Strateji nesnesine devrederek bu durum ifadesini ortadan kaldırır:
![image](https://github.com/user-attachments/assets/dabadbb4-c783-44ad-9f9b-eba4c6e6820f)

Çok sayıda koşullu ifade içeren kodlar genellikle Strateji patterninin gerçekleştirilmesi gerektiğini gösterir.

4. Gerçekleştirmlerin seçilebilirliği. Stratejiler aynı davranışın farklı gerçekleştirmelerini sağlayabilir. Müşteri farklı zaman ve mekan trade-offlarına sahip stratejiler arasından seçim yapabilir.

5. Müşteriler farklı Stratejilerin farkında olmalıdır. Desenin potansiyel bir dezavantajı vardır çünkü bir müşteri uygun olanı seçebilmek için Stratejilerin nasıl farklılaştığını anlamak zorundadır. Müşteriler gerçekleştirme sorunlarıyla karşılaşabilir. Bu nedenle Strateji desenini yalnızca davranıştaki değişiklik müşteriler için önemli olduğunda kullanmalısınız.

6. Strateji ve Bağlam arasındaki iletişim yükü(overhead). Strateji arayüzü, gerçekleştirdikleri algoritmalar önemsiz veya karmaşık olsun, tüm ConcreteStrategy sınıfları tarafından paylaşılır. Bu nedenle, bazı ConcreteStrategies'lerin bu arayüz üzerinden kendilerine iletilen tüm bilgileri kullanmaması muhtemeldir; basit ConcreteStrategies bunların hiçbirini kullanmayabilir! Bu, contextin asla kullanılmayan parametreler oluşturup başlattığı zamanlar olacağı anlamına gelir. Bu bir sorunsa, o zaman Strateji ve Context arasında daha çok tight couplinge ihtiyacınız olacaktır.

7. Artan nesne sayısı. Stratejiler bir uygulamadaki nesne sayısını artırır. Bazen bu yükü, contextlerin paylaşabileceği stateless nesneler olarak stratejileri gerçekleştirerek azaltabilirsiniz. Herhangi bir kalıntı durum, her istekte Strateji nesnesine ileten context tarafından korunur. Paylaşılan stratejiler, çağrılar arasında durumu korumamalıdır. Flyweight (195) deseni bu yaklaşımı daha ayrıntılı olarak açıklar.

<h3>Related Patterns</h3>
Flyweight (195): Strateji nesneleri genellikle iyi flyweightleri oluşturur.












