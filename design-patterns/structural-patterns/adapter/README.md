<h1>Adapter</h1>

<h3>Intent</h3>
Bir sınıfın arayüzünü clientlerin beklediği başka bir arayüzüne dönüştürür. Adapter, uyumsuz arayüzler nedeniyle birlikte çalışamayan sınıfların birlikte çalışmasını sağlar.

Yazar-Not:
<p>uyarlama = adaptasyon</p>
<p>adaptee = adapte edilen</p>
<p>adapter = adapte eden</p>
<p>class adapter = two way adapter -> uses inheritance</p>
<p>object adapter -> uses composition</p>

<h3>Also Known As</h3>
Wrapper

<h3>Motivation</h3>
Bazen reusable olarak tasarlanmış bir toolkit sınıfı, yalnızca arayüzü bir uygulamanın gerektirdiği domain-specific arayüzle eşleşmediği için yeniden kullanamaz. 
Örneğin, kullanıcıların grafiksel elementleri (çizgiler(lines), çokgenler(polygons), text(metin) gibi) resim ve diyagramlara çizmesini ve düzenlemesine olanak tanıyan bir drawing editor düşünün.
Drawing editor'ün temel soyutlaması, düzenlenebilir bir şekle sahip(editable shape) olan ve kendisini çizebilen grafiksel nesnedir.
Grafiksel nesneler için arayüz, Shape adı verilen soyut bir sınıf tarafından tanımlanır. Editör, her tip grafik nesnesi için Shape'in subclassını tanımlar: çizgiler için bir LineShape sınıfı, çokgenler için bir PolygonShape sınıfı, vb.

LineShape ve PolygonShape gibi temel geometrik şekiller için sınıflar gerçekleştirmek oldukça kolaydır, çünkü çizim ve düzenleme yetenekleri doğası gereği sınırlıdır.
Ancak metni görüntüleyebilen ve düzenleyebilen bir TextShape subclass'ının gerçekleştirilmesi çok daha zordur, çünkü temel metin düzenleme bile karmaşık ekran güncelleme ve arabellek yönetimini(buffer management) içerir.
Bu arada, hazır bir kullanıcı arayüzü toolkit'i, metni görüntülemek ve düzenlemek için gelişmiş bir TextView sınıfı sağlayabilir.
İdeal olarak TextShape'i gerçekleştirmek için TextView'ı yeniden kullanmak(reuse) istiyoruz, ancak toolkit Shape sınıfları düşünülerek tasarlanmamıştı. Yani TextView ve Shape nesnelerini birbirinin yerine kullanamayız.

TextView gibi var olan ve unrelated sınıflar, farklı ve uyumsuz bir arayüze sahip sınıflar bekleyen bir uygulamada nasıl çalışabilir?
TextView sınıfını Shape arayüzüne uyacak şekilde değiştirebiliriz, ancak toolkit'in kaynak koduna sahip olmadığımız sürece bu bir seçenek değildir. Bunu yapsak bile, TextView'ı değiştirmek mantıklı olmazdı; toolkit'in sadece bir uygulamayı çalıştırmak için domain-specific arayüzleri benimsemesi gerekmez.

Bunun yerine, TextView arayüzünü Shape'e uyarlayacak şekilde TextShape'i tanımlayabiliriz.
Bunu iki yoldan biriyle yapabiliriz: (1) Shape'in arayüzünü ve TextView'in gerçekleştirmesini miras alarak(inheritance) veya (2) TextShape içinde bir TextView örneği oluşturarak ve TextShape'i Text View'in arayüzü açısından gerçekleştirerek.
Bu iki yaklaşım, class adapter ve object adapter olarak karşılık gelir.
TextShape'e adaptör diyoruz.

![image](https://github.com/user-attachments/assets/bb726842-f0a9-45c3-b81c-48885d2789a4)

Bu diyagram object adapter durumunu göstermektedir. Shape sınıfında tanımlanan boundingBox requestlerinin TextView'da tanımlanan getExtent request'lerine nasıl dönüştürüldüğünü gösterir.
TextShape, TextView'i Shape arayüzüne adapte ettiğinden, drawing editor aksi takdirde uyumsuz olan TextView sınıfını yeniden kullanabilir.

Genellikle adaptör, adapte edilen sınıfın sağlamadığı fonksiyonellikten sorumludur. Diagramda bir adaptörün bu sorumlulukları nasıl yerine getirebileceği gösterilmektedir. Kullanıcı her Shape nesnesini etkileşimli olarak yeni bir yere "sürükleyebilmelidir", ancak TextView bunu yapmak için tasarlanmamıştır.
TextShape, uygun Manipulator subclassının bir örneğini döndüren Shape'in CreateManipulator operasyonunu gerçekleştirerek bu eksik fonksiyonelliği ekleyebilir.

Manipulator, kullanıcı girdisine yanıt olarak bir Shape'i nasıl canlandıracağını bilen nesneler için soyut bir sınıftır, örneğin şekli yeni bir konuma sürüklemek gibi.
Manipulator'ın farklı şekiller için subclassları vardır; örneğin TextManipulator, TextShape için karşılık gelen subclassdır.
Bir TextManipulator örneği döndürerek, TextShape, TextView'in sahip olmadığı ancak Shape'in gerektirdiği fonksiyonelliği ekler.

<h3>Applicability</h3>
Adapter paterni şu durumlarda kullanın:

• mevcut bir sınıfı kullanmak istiyorsunuz ve arayüzü ihtiyacınız olanla uyuşmuyor.
• Unrelated veya öngörülemeyen(unforeseen) sınıflarla, yani uyumlu arayüzlere sahip olmayan sınıflarla işbirliği yapan reusable bir sınıf oluşturmak istersiniz.
• (object adapter only) birkaç mevcut subclass kullanmanız gerekir, ancak her birini subclass'a ayırarak arayüzlerini adapte etmek pratik değildir. Bir object adapter'i üst sınıfının arayüzünü adapte edebilir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/347f23a2-0939-434f-987a-5ea2ab794a38)

<h3>Participants</h3>
• Target (Shape)
   ◇ Client'in kullanacağı domain-specific arayüzü tanımlar
• Client (DrawingEditor)
   ◇ Targer arayüzüne uygun nesnelerle işbirliği yapar.
• Adaptee (TextView)
   ◇ adapte edilmeye ihtacı olan arayüzdür.
• Adapter (TextShape)
   ◇ Adaptee arayüzünü Target arayüzüne adapte eder.

<h3>Collaborations</h3>
• Clientler Adapter örneğindeki operasyonları çağırır. Buna karşılık, Adapter isteği gerçekleştiren Adaptee operasyonlarını çağırır.

<h3>Consequences</h3>

Class adapter'in ve object adapter'inin farklı trade-off'ları vardır. 

Bir class adapteri: 
• Somut bir Adaptee sınıfına bağlı kalarak Adaptee'yi Target'a adapte eder. Sonuç olarak, bir sınıfı ve onun subclasslarını adapte etmek istediğimizde class adapter'i çalışmayacaktır.
• Adapter'ın Adaptee'nin bazı davranışlarını override etmesine izin verir, çünkü Adapter Adaptee'nin bir subclass'ıdır.
• sadece bir nesneyi tanıtır ve adapte edilene ulaşmak için ek bir işaretçi dolaylı yönlendirmesine gerek yoktur.

Bir Object adapteri:
• tek bir adapter'in birçok adaptee ile çalışmasını sağlar; yani, adaptee'nin kendisi ve tüm subclassları(varsa). Adaptör aynı zamanda tüm Adaptee'lerle aynı anda fonksiyonellik ekleyebilir.
• Adaptee'nin davranışını override etmeyi zorlaştırır. Adaptee'nin subclassa dönüştürülmesini ve Adapter'ın Adaptee'nin kendisinden ziyade subclass'a başvurmasını gerektirir.

Adapter patterni kullanırken dikkate alınması gereken diğer hususlar şunlardır:
1. Adapter ne kadar adapte yapar? Adapterler, Adaptee'yi Target arayüzüne uyarlamak için yaptıkları iş miktarına göre farklılık gösterir. Basit bir arayüz dönüşümünden—örneğin, operasyonların isimlerini değiştirmekten—tamamen farklı bir dizi işlemi desteklemeye kadar uzanan bir iş spektrumu vardır. Adapter'in yaptığı iş miktarı, Target arayüzünün Adaptee'nin arayüzüne ne kadar benzediğine bağlıdır.
2. Pluggable(takılabilir) adapterler. Bir sınıfın yeniden kullanılabilirliği, diğer sınıfların onu kullanmak için yapması gereken varsayımları en aza indirdiğinizde artar. Bir sınıfa arayüz adaptasyonu  ekleyerek, diğer sınıfların aynı arayüzü gördüğü varsayımını ortadan kaldırırsınız. Başka bir deyişle, arayüz adaptasyonu, sınıfımızı farklı arayüzlere sahip olabilecek mevcut sistemlere entegre etmemize olanak tanır. ObjectWorks\Smalltalk [Par90], arayüz adaptasyonu built-in olan sınıfları tanımlamak için takılabilir adapter terimini kullanır.
   Diyelim ki tree yapılarını grafiksel olarak gösterebilen bir TreeDisplay widget'ımız var. Eğer bu widget sadece tek bir uygulama için özel amaçlı bir widget olsaydı, o zaman gösterdiği nesnelerin belirli bir arayüze sahip olmasını gerektirebilirdik; yani hepsi bir Tree soyut sınıfından türemek zorunda olurdu. Ancak TreeDisplay'i daha yeniden kullanılabilir yapmak isteseydik (örneğin, faydalı widget'ların bulunduğu bir araç setinin parçası haline getirmek isteseydik), bu gereklilik mantıksız olurdu. Uygulamalar, kendi ağaç yapısı sınıflarını tanımlar. Bizim Tree soyut sınıfımızı kullanmak zorunda olmamalılar. Farklı ağaç yapılarının farklı arayüzleri olacaktır. Örneğin, bir dizin hiyerarşisinde alt öğelere GetSubdirectories işlemi ile erişilirken, bir kalıtım hiyerarşisinde karşılık gelen işlem GetSubclasses olarak adlandırılabilir. Yeniden kullanılabilir bir TreeDisplay widget'ı, farklı arayüzler kullansalar bile her iki tür hiyerarşiyi de gösterebilmelidir. Başka bir deyişle, TreeDisplay'in içine arayüz uyarlaması yerleştirilmiş olmalıdır. Arayüz adaptasyonunun sınıflara yerleştirmenin farklı yollarını Uygulama bölümünde inceleyeceğiz.
3. Şeffaflık sağlamak için iki yönlü adapterler kullanma. Adapterlerle ilgili potansiyel bir sorun, tüm istemcilere şeffaf olmamalarıdır. Adapte edilen bir nesne artık Adaptee arayüzüne uymadığından, Adaptee nesnesinin kullanılabildiği her yerde olduğu gibi kullanılamaz. İki yönlü adapterler bu tür bir şeffaflık sağlayabilir. Özellikle, iki farklı istemcinin bir nesneyi farklı görmesi gerektiğinde kullanışlıdırlar. Unidraw (grafiksel düzenleme çerçevesi) [VL90] ve QOCA (kısıtlama çözme araç seti) [HHMV92] entegre eden iki yönlü adapteri düşünün. Her iki sistemde de değişkenleri açıkça temsil eden sınıflar vardır: Unidraw'da StateVariable ve QOCA'da ConstraintVariable. Unidraw'ın QOCA ile çalışması için ConstraintVariable'ın StateVariable'a uyarlanması gerekir; QOCA'nın çözümleri Unidraw'a yayması için ise StateVariable'ın ConstraintVariable'a uyarlanması gerekir.

![image](https://github.com/user-attachments/assets/40a211f3-e702-4236-acba-c571437b14bc)


Çözüm, hem StateVariable hem de ConstraintVariable'ın alt sınıfı olan ve iki arayüzü birbirine uyarlayan iki yönlü bir sınıf adapteri olan ConstraintStateVariable'ı içerir. Bu durumda birden fazla kalıtım, uyarlanan sınıfların arayüzleri oldukça farklı olduğundan uygulanabilir bir çözümdür. İki yönlü sınıf adapteri, her iki uyarlanan sınıfa da uyar ve her iki sistemde de çalışabilir.

