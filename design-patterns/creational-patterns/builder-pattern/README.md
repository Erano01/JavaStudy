<h1>Builder</h1>

<h3>Intent</h3>
Karmaşık bir nesnenin inşasını sunumundan ayırın, böylece aynı inşa süreci farklı sunumlar yaratabilir.

not: Representation -> Sunum,Temsil (her bir concrete builder bir sunum/temsil oluşturur)

<h3>Motivation</h3>
RTF (Rich Text Format) döküman değişim formatı için olan bir reader, RTF belgelerini birçok text formatına dönüştürebilmelidir.
Reader, RTF dökümanlarını düz ASCII metne veya interaktif olarak düzenlenebilen bir text widget'a dönüştürebilir. 
Ancak sorun şudur ki, dönüşüm yapılacak format tipi sayısının ucu açıktır. Dolayısıyla RTF reader'i değiştirmeden yeni bir dönüşüm formatı eklemek kolay olmalıdır. (Örneğin ilerde başka metin tiplerinin eklenmesi -> Builder arayüzünü implement eden başka bir concrete builder oluşturulur.) 

Bir çözüm, RTFReader sınıfını RTF'yi başka bir metinsel sunuma dönüştüren bir TextConverter nesnesi ile yapılandırmaktır. 
RTFReader, RTF dökümanını parse'larken TextConverter'ı dönüşümü gerçekleştirmek için kullanır. 
RTFReader, bir RTF tokeni (ya düz metin(plain text) ya da bir RTF kontrol kelimesi) tanıdığında, bu tokeni dönüştürmek için TextConverter'a bir istek gönderir. 
TextConverter nesneleri, veri dönüşümünü gerçekleştirmenin yanı sıra belirli bir formatta tokeni sunmaktan sorumludur. 

TextConverter'ın alt sınıfları, farklı dönüşümler ve formatlar için spesifik olarak geliştirilmiştir. Örneğin, 
ASCIIConverter, düz metin(plain text) dışında herhangi bir şeyi dönüştürme isteklerini görmezden gelir. 
Öte yandan, TeXConverter, metindeki tüm stil bilgilerini yakalayan bir TeX sunumu üretmek için tüm istekler için operasyonları gerçekleştirir. 
Bir TextWidgetConverter ise kullanıcıya metni görmesine ve düzenlemesine olanak tanıyan karmaşık bir kullanıcı arayüzü nesnesi üretir.
![image](https://github.com/user-attachments/assets/a6e5d77e-debe-460e-8011-51b641674e39)



Her dönüştürücü(converter) sınıfı, karmaşık bir nesne oluşturma ve birleştirme(assembling) mekanizmasını soyut bir arayüzün arkasına yerleştirir. 
Dönüştürücü(Converter), bir RTF dökümanını parse etmekten sorumlu olan reader'dan ayrıdır. 

Bu ilişkilerin tamamı Builder deseni tarafından sağlanır. Desendeki her dönüştürücü(converter) sınıfı bir builder olarak adlandırılır ve reader, director olarak adlandırılır. 
Bu örneğe uygulandığında, Builder deseni metinsel bir formatı yorumlama algoritmasını (yani RTF dökümanları için parser'i) bir dönüştürülmüş formatın nasıl oluşturulup sunulacağından ayırır. 
Bu, RTFReader'ın parse algoritmasını reuse olarak kullanmamıza olanak tanır, böylece RTF dökümanlarından farklı metin sunumları oluşturabiliriz - sadece RTFReader'ı TextConverter'ın farklı alt sınıfları ile yapılandırarak.

<h3>Applicability</h3>
Aşağıdaki durumlarda Builder pattern kullanın:

• Karmaşık nesne oluşturma algoritması, nesneyi oluşturan parçalardan ve onların nasıl birleştirildiğinden bağımsız olmalıdır.
• Oluşturma süreci, inşa edilen nesne için farklı temsillere izin vermelidir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/891ac994-bdc6-4718-b39b-731113175b8a)


<h3>Participants</h3>
• Builder (TextConverter)
   ◇ Product nesnesinin parçalarını oluşturmak için soyut bir arayüz(abstract class or interface) belirtir.

• ConcreteBuilder (ASCIIConverter, TeXConverter, TextWidgetConverter)
   ◇ Builder arayüzünü gerçekleştirerek product'un parçalarını oluşturur ve birleştirir(constructs and assembles).
   ◇ Oluşturduğu sunumu tanımlar ve takip eder.
   ◇ Product'u almak için bir arayüz(method arayüzü) sağlar (Örneğin, GetASCIIText, GetTextWidget).

• Director (RTFReader)
   ◇ Builder arayüzünü kullanarak bir nesne oluşturur.

• Product (ASCIIText, TeXText, TextWidget)
   ◇ İnşa edilmekte olan kompleks nesneyi temsil eder. ConcreteBuilder, product'un iç sunumunu(internal represantation) oluşturur ve nasıl birleştirildiğini tanımlar.
   ◇ Parçaları tanımlayan sınıfları içerir ve parçaları sonuçta bir araya getirmek için arayüzler sağlar.

<h3>Collaborations</h3>
• Client, Director nesnesini oluşturur ve onu istenen Builder nesnesiyle yapılandırır. 
• Director, product'ın bir parçasının yapılması gerektiğinde builder'i bilgilendirir.
• Builder, director'dan gelen istekleri işler ve product'a parçalar ekler.
• Client, product'u builder'dan alır.
Aşağıdaki uml interaction diagramı(uml sequence diagram olarak da geçiyor), Builder ve Director'un bir client ile nasıl işbirliği yaptığını göstermektedir.
![image](https://github.com/user-attachments/assets/d45e1c9d-d9e0-46ed-bf41-668ad0c9c6a1)


<h3>Consequences</h3>
Builder modelini gerçekleştirmenin temel sonuçları şunlardır:
1. Product'ın internal sunumunu (iç sunumunu/somutluğunu) çeşitlendirmenize olanak tanır. Builder nesnesi, director'a product'ı oluşturmak için soyut bir arayüz sağlar. Arayüz, builder'in product sunumunu ve internal yapısını gizlemesine olanak tanır. Ayrıca product'ın nasıl birleştirileceğini de gizler. Product soyut bir arayüz aracılığıyla oluşturulduğu için, Product'ın internal sunumunu(somutluğunu) değiştirmek için yapmanız gereken tek şey yeni bir tip Builder tanımlamaktır.

2. İnşa(Construction) ve Sunum(representation) için kodu izole eder. Builder patterni, kompleks bir nesnenin oluşturulma ve sunulma biçimini kapsülleyerek modülerliği iyileştirir. Clientlerin product'ın iç yapısını tanımlayan sınıflar hakkında hiçbir şey bilmesine gerek yoktur; bu tip sınıflar Builder'ın arayüzünde görünmez. Her ConcreteBuilder, belirli bir tip Product'ı oluşturmak ve birleştirmek için gereken tüm kodu içerir. Kod bir kez yazılır; daha sonra farklı Directorlar aynı parça kümesinden Product varyantları oluşturmak için onu yeniden kullanabilir. Önceki RTF örneğinde, RTF dışındaki bir format için bir reader tanımlayabilirdik, örneğin, bir SGMLReader ve aynı TextConverters'ı kullanarak SGML documentlerinin ASCIIText, TeXText ve TextWidget yorumlarını üretebilirdik.

3.  İnşaat süreci üzerinde daha hassas kontrol sağlar. Product'ları tek seferde oluşturan creational patternlerin aksine, Builder patterni Product'ı Director'un kontrolü altında adım adım oluşturur. Yalnızca Product tamamlandığında Director onu Builder'dan alır. 

----------------------

<h1>Wikipedia</h1>

Problem that Builder pattern solves:
• Bir sınıf aynı inşa süreci ile kompleks bir nesnenin farklı sunumlarını nasıl yaratabilir?
• Karmaşık bir nesne oluşturmayı içeren bir sınıf nasıl basitleştirilebilir?

Karmaşık bir nesnenin parçalarını doğrudan bir sınıf içinde oluşturmak ve birleştirmek esnek değildir.
Sınıfı, karmaşık nesnenin belirli bir sunumunu oluşturmaya zorlar ve sunumu daha sonra sınıftan bağımsız olarak (değiştirmek zorunda kalmadan) değiştirmeyi imkansız hale getirir.

Benefit of Builder Pattern:
• Bir Product sınıfının internal(iç) sunumunu değiştirmenize olanak tanır.
• İnşa (Construction) ve Sunum (Representation) için kodu encapsulate eder.
• İnşaat sürecinin adımları üzerinde kontrol sağlar.

Trade-Offs of Builder Pattern
• Product sınıflarının her bir tipi için belirli bir ConcreteBuilder oluşturulmalıdır.
• Builder sınıfları mutable olmalıdır.
• Dependency Enjection'u engelleyebilir/karmaşık hale getirebilir.
• Birçok null-safe dilde, Buidler pattern, set edilmemiş field'lar için compile-time hatalarını runtime'a erteler.

