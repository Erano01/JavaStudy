<h1>ABSTRACT FACTORY</h1>

<h3>Intent</h3>
<p>
Birbirleri ile ilişkili veya birbirine bağımlı nesneler ailelerini yaratırken somut sınıflarını belirtmeden arayüz sağlar.

not: birbiri ile çalışması için yazılmış 2 product nesne varsa bu pattern uygulanabilir.

Also Known As : Kit

not: “Kit” veya “Product family” duyduğun zaman bu şuna referansdır: sınıflar doğrudan inheritance aracılığı ile birbirleriyle ilgili olmasalarda bu nesnelerin birlikte çalışan gruplar olduğu ifade ediliyordur. 
</p>
<h3>Motivation</h3>
<p>
Çoklu görünüm ve his standartlarını destekleyen bir kullanıcı arayüzü toolkit düşünün. Motif ve Presentation Manager(PM) gibi.
Farklı görünüm ve his standartları, ScrollBars, Windows ve Buttons gibi kullanıcı arayüzü Widgetlarının farklı görünümlerini ve davranışlarını tanımlar.
Farklı görünüm ve his standartları arasında taşınabilir olması için, bir uygulama widget'larını belirli bir görünüm ve his standartı için hard-code etmemelidir. 
Uygulama genelinde görünüm ve his standartına özgü widget sınıflarını somutlaştırmak, daha sonra görünüm ve his standartını değiştirmeyi zorlaştırır.

Bu problemi, her bir widgeti oluşturmak için bir arayüz tanımlayan soyut bir WidgetFactory sınıfı tanımlayarak çözebiliriz. 
Her bir widget için bir soyut sınıf (Window,ScrollBar gibi) vardır ve somut subclasslar belirli görünüm ve his standartlarına uygun widget'lar implement eder(PMWindow,PMScrollBar, MotifWindow,MotifScrollBar gibi).  
WidgetFactory'nin arayüzünde, her soyut widget sınıfı için yeni bir widget nesnesi döndüren bir operasyon bulunur. 
Client'ler, widget örnekleri elde etmek için bu işlemleri çağırır, ancak Clientler kullandıkları somut sınıfların farkında değildir. 
Böylece clientler, belirli bir görünüm ve his oluşturmadan bağımsız kalır.

Her görünüm ve his standardı için WidgetFactory'nin somut bir subclass'ı vardır (PMWidgetFactory, MotifWidgetFactory gibi). Her subclass, görünüm ve his için uygun widget'i oluşturmak üzere operasyonları gerçekleştirir. 
Örneğin, MotifWidgetFactory'deki createScrollBar() operasyonu bir MotifScrollBar örneği oluşturur ve döndürürken, PMWidgetFactory'deki karşılık gelen operasyon PMScrollBar örneği döndürür.
Client'ler yalnızca WidgetFactory arayüzü aracılığıyla widget'lar oluştururlar ve belirli bir görünüm ve his için widget'ları gerçekleştiren sınıflar hakkında hiçbir bilgiye sahip değillerdir(bu bilgileri Factory arayüzü ve subclassları bilir).
Başka bir deyişle, Client'lerin yalnızca soyut bir sınıf tarafından tanımlanan bir arayüze bağlı kalmaları gerekir, belirli bir somut sınıfa bağlı kalmaları gerekmez.

Bir WidgetFactory aynı zamanda somut widget sınıfları arasındaki bağımlılıkları da zorunlu kılar.
MotifScrollBar ,MotifButton ve MotifTextEditor birlikte kullanılmalıdır ve bu kısıtlama MotifWidgetFactory kullanmanın sonucu olarak otomatik olarak gerçekleştirirlir.
</p>
![image](https://github.com/user-attachments/assets/82d6918c-5e6b-4081-85c7-c14611624888)



<h3>Applicability</h3>
<p>
Abstract Factory Pattern'i şu durumlarda kullanın:
• Sistem Product'ların nasıl yaratıldığından, nasıl oluşturulduğundan(compose) ve nasıl sunulduğundan(representation) bağımsız olması gerektiğinde.
• Sistem birden fazla Product ailesinden biri ile konfigure edilmesi gerektiğinde.
• İlgili Product nesnelerinin aile hierarşisi birlikte kullanılacak şekilde tasarlanmışsa ve bu kısıtlamayı zorunlu kılmak istiyorsanız.
• Productlar için sınıf kütüphanesi sağlamak istiyorsanız, ve sadece arayüzleri açıkça sunmak istiyorsanız, gerçekleştirmelerini değil.
</p>
<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/572def77-1ec8-408c-88e7-f126222796a9)



<h3>Participants (katılımcılar)</h3>
<p>
• AbstractFactory (WidgetFactory)
   ◇ Soyut Product nesneleri yaratan operasyonlar için arayüz tanımlar.
• ConcreteFactory (MotifWidgetFactory, PMWidgetFactory)
   ◇ somut product nesneleri oluşturmak için operasyonları gerçekleştirir.
• AbstractProduct (Window, ScrollBar)
   ◇ product nesnelerinin tipi için arayüz tanımlamasıdır.
• ConcreteProduct (MotifWindow, MotifScrollBar)
   ◇ İlgili somut factory tarafından oluşturulacak Product nesnesi tanımlar.
   ◇ AbstractProduct arayüzünü gerçekleştirir.
• Client
   ◇ Sadece AbstractFactory ve AbstractProduct sınıfları tarafından tanımlanan arayüzleri kullanır.
</p>
<h3>Collaborations(işbirlikçiler)</h3>
<p>
• Normalde ConcreteFactory sınıfının tek bir örneği run-time'da oluşturulur. Bu somut factory belirli gerçekleştirmelere sahip product nesneleri oluşturur. Farklı product nesneleri oluşturmak için, clientler farklı somut factory'ler kullanmalıdır.
• AbstractFactory product nesnelerinin oluşturulmasını ConcreteFactory subclasslarına erteler.
</p>
<h3>Consequences(Sonuçlar)</h3>
<p>
Abstract factory patterninin aşağıdaki yararları ve sorumlulukları vardır:

1. Somut sınıfları izole eder. Abstract Factory deseni, bir uygulamanın oluşturduğu nesnelerin sınıflarını kontrol etmenize yardımcı olur. Bir factory, product nesnelerini oluşturma sorumluluğunu ve sürecini kapsüllediği için, clientleri gerçekleştirme sınıflarından izole eder. Clientler, instanceleri(örnekleri) soyut arayüzler üzerinden manipüle eder. Product sınıfı isimleri, somut fabrikanın gerçekleştirmesinde izole edilmiştir; client kodunda görünmezler.

2. Product ailelerini değiştirmeyi kolaylaştırır. Somut factory sınıfı, bir uygulamada yalnızca bir kez - yani instance'i oluşturulduğu yerde - görünür. Bu, bir uygulamanın kullandığı somut factory'i değiştirmeyi kolaylaştırır. Farklı product konfigurasyonlarını, sadece somut factory'i değiştirerek kullanabilir. Bir soyut factory, eksiksiz bir product ailesi oluşturduğu için, tüm product ailesi bir kerede değişir. Kullanıcı arayüzü örneğimizde, ilgili factory nesnelerini değiştirip arayüzü yeniden oluşturarak Motif widget'larından Presentation Manager widget'larına geçebiliriz.

3. Productlar arasında tutarlılığı(consistency) teşvik eder. Bir ailedeki product nesneleri birlikte çalışacak şekilde tasarlandığında, bir uygulamanın yalnızca bir aileden nesneler kullanması önemlidir. AbstractFactory, bunu yapmayı kolaylaştırır.

4.  Yeni tipte productları desteklemek zordur. Soyut fabrikaları yeni tipte productlar üretmek için genişletmek kolay değildir. Bunun nedeni, AbstractFactory arayüzünün oluşturulabilecek productların setini sabitlemesidir. Yeni tipde productları desteklemek, fabrika arayüzünü genişletmeyi gerektirir, bu da AbstractFactory sınıfını ve tüm alt sınıflarını değiştirmeyi içerir. Bu soruna bir çözümü Implementation bölümünde tartışıyoruz.

5.  Client kodu, somut factorylerle ve bu factoryler tarafından oluşturulan somut productlarla sıkı bir şekilde bağımlı(tightly coupled) değildir.




Not: 
• Nesnelerin bir kümede birlikte çalıştığı birden fazla nesne kümeniz varsa, client kodunu somut nesnelerden ve onların factorylerinden ayırmak için abstract factory patternini kullanabilirsiniz.
• Abstract factory patterni Factory method patternini birden çok nesne ailesi için kullanıyor gibi düşünebilirsin.
• yeni bir product tipi eklemek base factory ve gerçekleştirmelerinde değişikliklere gidilmesi anlamına gelir.
• somut factoryler singleton olabilir eğer bir tanesinin sadece tek bir örneği olsun istiyorsan.
• Client kodunu somut factory örneği ile sağlarız. Factoryler runtime da değişebilir.
</p>
