<h1>Composite</h1>

<h3>Intent</h3>
Parça-bütün (part-whole) hiyerarşilerini temsil etmek için nesneleri ağaç mimarilerine (tree structures) dönüştürün. Composite, client'lerin bireysel nesneleri ve nesne compositionlarını tek tip olarak ele almasını sağlar.

//burada ki composition kavramı oop'daki composition kavramı değildir. oopda içinde başka bir nesneye işaret eden bir referansa sahip bir nesnemiz olduğu anlamına gelir. Fakat bu composite patterninde, oopdaki composition kullanılır.

<h3>Motivation</h3>
Drawing editörleri ve şematik yakalama sistemleri(schematic capture systems) gibi grafik uygulamaları, kullanıcıların basit componentlerden karmaşık diyagramlar oluşturmasına olanak tanır.
Kullanıcı, daha büyük componentler oluşturmak için componentleri gruplayabilir ve bu componentler daha da büyük componentler oluşturmak için gruplandırılabilir
Basit bir gerçekleştirme, Text ve Lines gibi grafiksel primitive öğeler için sınıflar ve bu primitive öğeler için container görevi gören diğer sınıflar tanımlayabilir.

Ancak bu yaklaşımda bir sorun var: Bu sınıfları kullanan kod, çoğu zaman kullanıcı bunları aynı şekilde ele alsa bile, primitive ve container nesneleri farklı şekilde ele almalıdır.Bu nesneleri ayırmak uygulamayı daha karmaşık hale getirir.
Composite pattern, clientlerin bu ayrımı yapmak zorunda kalmaması için recursive composition'un nasıl kullanılacağını açıklar.

![image](https://github.com/user-attachments/assets/b5ef2760-84f9-4e79-85c8-8f5e108185a9)


Composite deseninin anahtarı, hem primitive'ları hem de bunların containerlarını temsil eden soyut bir sınıftır.
Grafik sistemi için bu sınıf Graphic'tir. Grafik Grafiksel nesnelere özgü Draw gibi operasyonları tanımlar.
Ayrıca, tüm composite nesnelerin paylaştığı operasyonları, örneğin çocuklarına erişim(access) ve yönetme(managing) operasyonlarını tanımlar.
Line, Rectangle ve Text alt sınıfları (önceki sınıf diyagramına bakın) primitive grafik nesneleri tanımlar. Bu sınıflar sırasıyla Line, Rectangle ve Text çizmek için Draw'u gerçekleştirir.
Primitive grafiklerin alt grafikleri olmadığından, bu alt sınıfların hiçbiri alt grafikle ilgili operasyonları gerçekleştiremez.

Picture sınıfı, Graphic nesnelerinin bir toplamını (aggregate of graphic objects) tanımlar. Picture,  alt nesnelerinde çağırmak için Draw operasyonunu gerçekleştirir ve buna göre alt nesnelerle ilgili operasyonları gerçekleştirir.
// aggregate -> toplu veya bileşik anlamına gelir. Bir grup nesnenin bir bütün olarak ele alındığı anlamındadır.
Picture arayüzü Graphic arayüzüne uygun olduğundan, Picture nesneleri diğer Picture'ları recursive şekilde oluşturabilir.
Aşağıdaki diyagram, recursive şekilde oluşturulmuş Graphic nesnelerin tipik bir composite nesne mimarisini göstermektedir:

![image](https://github.com/user-attachments/assets/7c92cca8-9fda-41ee-bc10-eb314b7fd759)

<h3>Applicability</h3>
Composite desenini şu durumlarda kullanın:
• Nesnelerin parça-bütün(part-whole) hiyerarşilerini temsil etmek isterseniz.
• Clientlerin composition'lar nesneler ve bireysel nesneler arasındaki farkı görmezden gelebilmelerini istiyorsanız. Client'ler composite mimarideki tüm nesneleri eşit şekilde ele alacaklardır.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/54816234-0f5c-48b6-ada7-07041de1e276)

Tipik bir Composite nesne mimarisi şu şekilde görünebilir:
![image](https://github.com/user-attachments/assets/d8a730aa-2535-4200-831b-24308e11ea7c)

<h3>Participants</h3>
• Component (Graphic)
   ◇ Composition'daki nesneler için arayüz bildirir.
   ◇ tüm sınıflar için ortak olan arayüz için varsayılan davranışı uygun şekilde gerçekleştirir.
   ◇ Child componentlere erişim ve yönetim için bir arayüz tanımlar.
   ◇ (isteğe bağlı) Recursive mimarideki bir component'in üst componentine erişmek için bir arayüz tanımlar ve uygunsa bunu gerçekleştirir.
• Leaf (Rectangle, Line, Text, etc.)
   ◇ Composition'da ki leaf(yaprak) nesnelerini temsil eder. Bir leaf'in alt sınıfı(child) yoktur.
   ◇ Composition'da ki primitive nesnelerin davranışını tanımlar.
• Composite (Picture)
   ◇ Child'i olan componentlerin davranışını tanımlar.
   ◇ Child componentleri depolar.
   ◇ child-related operasyonları Component arayüzünde gerçekleştirir.
• Client
   ◇ Component arayüzü aracılığıyla composition'daki nesneleri düzenler.

<h3>Collaborations</h3>
• Client'ler, composite mimarisindeki nesnelerle etkileşim kurmak için Component sınıfı arayüzünü kullanırlar. Alıcı(recipient) bir Leaf ise, request doğrudan handle edilir. Alıcı bir Composite ise, genellikle requestleri alt componentlere iletir ve muhtemelen iletmeden önce ve/veya sonra ek işlemler gerçekleştirir.

<h3>Consequences</h3>
Composite patterni
• Primitive ve composite nesnelerden oluşan sınıf hiyerarşileri tanımlar. Primitive nesneler daha komplex nesneler halinde birleştirilebilir(composed) ve bu süreç tekrarlanarak(recursively) devam eder. Client kodunun primitive bir nesne beklediği her yerde, composite bir nesne de kullanılabilir.
• Client'i basitleştirir. Client'ler, composite mimarileri ve bireysel nesneleri tek tip olarak işleyebilirler. Clientler genellikle bir yaprakla(leaf) mı yoksa composite bir component'le mi uğraştıklarını bilmezler (ve umursamamalıdırlar). Bu, composition'u tanımlayan sınıflar üzerinde tag-and-case-statement-style fonksiyonlar yazmak zorunda kalmamak için client kodunu basitleştirir.
• Yeni componentler eklemeyi kolaylaştırır. Yeni tanımlanmış Composite veya Leaf subclassları, var olan mimari ve client kodu ile otomatik olarak çalışacaktır. Client'lerin, yeni Component sınıfları için değişmesine gerek yoktur.
• Tasarımınızı aşırı genel hale getirebilir. Yeni componentler eklemeyi kolaylaştırmanın dezavantajı, bir composite'nin componentlerini sınırlamayı zorlaştırmasıdır. Bazen bir composite'nin yalnızca belirli componentlere sahip olmasını istersiniz. Composite ile, bu kısıtlamaları sizin için zorlaması için tip sistemine güvenemezsiniz. Bunun yerine runtime kontrollerini kullanmanız gerekecektir.


