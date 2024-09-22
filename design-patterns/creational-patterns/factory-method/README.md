<h1>Factory Method</h1>

<h3>Intent</h3>
Nesne yaratmak için bir arayüz tanımlayın, ama  hangi sınıfın başlatılacağını/örneğinin oluşturulacağını sub-classların karar vermesini sağlayın. Factory Method bir sınıfın örneğinin oluşturulmasını subclasslara ertelemesine izin verir.

Also Known As
Virtual Constructor

not-> 
instantiate = başlatmak/örneğini oluşturmak
hook = Bir hook, yazılım geliştirmede, belirli bir işlevselliği veya davranışı değiştirmek, genişletmek veya özelleştirmek için bir genişletme noktasıdır. Bu, belirli olaylar gerçekleştiğinde veya belirli işlemler yapıldığında tetiklenen bir tür callback mekanizmasıdır. Hook'lar, temel bir işlevselliğe dokunmadan veya kodun temel yapısını bozmadan, gerektiğinde özel kodların çalıştırılmasını sağlar.

<h3>Motivation</h3>
Frameworkler nesneler arasında ilişkiler tanımlamak ve ilişkileri devam ettirmek için soyut sınıflar kulanır. Ayriyetten frameworkler sıklıkla bu objeleri yaratmaktan sorumludur. 

Birden çok dökümanı kullanıcıya sunan uygulamalar için bir framework düşünün.Bu frameworkdeki iki temel soyutlama Application ve Document sınıflarıdır.
İki sınıfda soyutdur, ve client'ler onları uygulamaya özgü gerçekleştirmeler(application-specific implementations) olarak kendi sub-classları haline getirmelidir.
Örneğin bir çizim uygulaması oluşturmak için DrawingApplication ve DrawingDocument adlı sınıfları tanımlarız.
Application sınıfı Document'leri yönetmekden ve onları gerektiğinde oluşturmaktan sorumludur -- misal kullanıcı menüden Open veya New seçeneklerini seçtiğinde

Belirli bir Document sub-class'ının örneğinin oluşturulması application-specific olduğundan, Application sınıfı hangi Document sub-class'ının örnekleneceğini öngöremez.
Application sınıfı sadece yeni bir Document'in ne zaman oluşturulacağını bilir, hangi tipte bir Document oluşturulacağını değil.
Bu bir ikilem yaratır: Framework sınıfların örneklerini oluşturmalıdır, ama yalnızca soyut sınıfları bilir ve soyut sınıfların örneklerini oluşturamaz. 

Factory Method pattern bu duruma bir çözüm sunar. Hangi Document tipinin örneğinin oluşturulacağını bilme bilgisini encapsulate eder.
![image](https://github.com/user-attachments/assets/90d02ba1-fefc-4a52-ae3a-9dfae3c79403)



Application sub-classları, uygun Document sub-classını döndürmek için Application'daki soyut CreateDocument operasyonunu yeniden tanımlar.
Bir Application subclass'ı örneği oluşturulduğunda, bu Application sınıfı application-specific Document'lerin sınıflarını bilmeden örneklerini oluşturabilir.
CreateDocument methoduna/fonksiyonuna factory method diyoruz çünkü bu method nesneyi “manufacturing”(üretmek, oluşturmak) 'dan sorumludur.


<h3>Applicability</h3>
Factory Methodu şu durumlarda kullanın:
• Bir sınıf, yaratması gereken nesnelerin sınıfını öngöremediğinde.
• Bir sınıf subclass'larının oluşturduğu nesneleri belirtmesini istediğinde.
• Sınıflar, sorumluluğu birkaç yardımcı subclass'dan birine devrettiğinde ve hangi yardımcı subclass'ın bu sorumluluğu üstlendiği bilgisini yerelleştirmek istediğinizde.


<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/50745b48-4322-4b9d-a415-25337db82950)


<h3>Participants</h3>
• Product (Document)
   ◇ Factory Methodun oluşturduğu nesnelerin arayüzünü tanımlar.
• ConcreteProduct (MyDocument)
   ◇ Product arayüzünü gerçekleştirir.
• Creator (Application)
   ◇ Product tipinde bir nesne döndüren factory methodunu tanımlar. Creator aynı zamanda factory methodunun ConcreteProduct döndüren default implementasyonunuda tanımlar.
   ◇ Product nesnesi oluşturmak için factory method çağrısı yapabilir.
• ConcreteCreator (MyApplication)
   ◇ ConcreteProduct örneği döndürebilmek için factory methodu override eder.

<h3>Collaborations</h3>
• Creator, uygun bir ConcreteProduct örneğini döndürebilmesi için subclasslarına factory methodunu tanımlamaları konusunda güvenir.


<h3>Consequences</h3>
Factory methodlar, application-specific sınıfları kodunuza bağlama(bind) ihtiyacını ortadan kaldırır. Kod yalnızca Product arayüzüyle ilgilenir; bu nedenle herhangi bir kullanıcı tanımlı ConcreteProduct sınıfıyla çalışabilir.

Factory methodlarının olası bir dezavantajı, clientlerin belirli bir ConcreteProduct nesnesi oluşturmak için Creator sınıfının subclassını oluşturmak zorunda kalabilmeleridir.
Subclass oluşturma, client'in zaten Creator sınıfının subclassını oluşturması gerektiğinde iyidir, ancak aksi takdirde client artık başka bir evrim noktasıyla uğraşmak zorundadır.

FactoryMethod deseninin iki ek sonucu şunlardır:
• Creator subclasslar için hook'lar sağlar. Bir sınıfın içinde factory methodu ile nesne oluşturmak, doğrudan nesne oluşturmaktan her zaman daha esnektir. Factory methodu, subclasslara bir nesnenin genişletilmiş bir sürümünü sağlamak için bir hook verir. Document örneğinde, Document sınıfı, var olan bir documenti açmak için default file dialog nesnesi oluşturan CreateFileDialog adlı bir  factory methodu tanımlayabilir. Bir Document subclass'ı, factory metodunu override ederek application specific bir file dialog tanımlayabilir. Bu durumda factory method soyut değildir ancak makul bir default gerçekleştirme sağlar.

• Paralel sınıf hiyerarşilerini birbirine bağlar. Şimdiye kadar ele aldığımız örneklerde, factory metodu yalnızca Creator'lar tarafından çağrılır. Ancak durum böyle olmak zorunda değil; client'lar factory methodlarını, özellikle paralel sınıf hiyerarşileri durumunda, yararlı bulabilirler. Paralel sınıf hiyerarşileri, bir sınıfın sorumluluklarının bir kısmını ayrı bir sınıfa devretmesiyle ortaya çıkar. İnteraktiv olarak manipulate edilebilen grafiksel figürleri düşünün; yani, fare kullanılarak esnetilebilir, hareket ettirilebilir veya döndürülebilir. Bu tür etkileşimleri(interactions) gerçekleştirmek her zaman kolay değildir. Genellikle, manipülasyonun durumunu(state) belirli bir zamanda kaydeden(records) bilgilerin depolanması(store) ve güncellenmesi gerekir. Bu durum sadece manipülasyon sırasında gereklidir; bu nedenle figür nesnesinde tutulması gerekmez. Ayrıca, farklı figürler kullanıcı tarafından manipüle edildiğinde farklı şekilde davranırlar. Örneğin, bir çizgi şeklini germek bir endpoint'i hareket ettirme etkisine sahip olabilirken, bir metin şeklini germek satır aralığını değiştirebilir. Bu kısıtlamalarla(constraint), etkileşimi gerçekleştiren ve ihtiyaç duyulan herhangi bir manipülasyona özgü durumu izleyen ayrı bir Manipulator nesnesi kullanmak daha iyidir. Farklı figürler, belirli etkileşimleri ele almak için farklı Manipülatör subclasslarını kullanacaktır. Ortaya çıkan Manipülatör sınıf hiyerarşisi Figure sınıfı hiyerarşisine (en azından kısmen) paraleldir:
![image](https://github.com/user-attachments/assets/e58dae4f-f222-49fa-9825-63caaa2e1905)


Figure sınıfı, clientlerin bir Figure'e karşılık gelen Manipulator'unu oluşturmasına izin veren bir CreateManipulator factory methodunu sağlar. Figure subclassları, kendileri için doğru olan Manipulator subclassının bir örneğini döndürmek için bu factory methodu override eder. Alternatif olarak, Figure sınıfı createManipulator'ı gerçekleştirerek default bir Manipulator örneği döndürebilir ve Figure subclassları basitçe bu default'u devralabilir. Bunu yapan Figure sınıflarının karşılık gelen Manipülatör subclassına ihtiyacı yoktur—bu nedenle hiyerarşiler yalnızca kısmen paraleldir. Factory methodunun iki sınıf hiyerarşisi arasındaki bağlantıyı nasıl tanımladığına dikkat edin. Hangi sınıfların birbirine ait olduğuna dair bilgiyi yerelleştirir.

Yazar-Not: Creator sınıfının üzerinde bulunan methodlardan bazıları hook'tur. Hook olarak kabul edilebilmesi için genişletilebiliyor olmalı. 
Abstract methodlar, protected/public methodlar, default implementasyonlu arayüz methodları hook'tur. 
Ama Private, Standart işlevsel methodlar, final methodlar hook değildir. 
Standart işlevsel methodlar -> Sınıfın ana işlevselliğini gerçekleştiren, genellikle sabit bir iş akışını takip eden ve özelleştirme amacı taşımayan metodlardır. (getter, setter, tostring, hashcode, database integration methods etc)


Comparison Factory Method with Abstract Factory
• Abstract Factory
   ◇ Client kodundan kullanılan factoryleri ve somut nesneleri gizler
   ◇ birden fazla nesnenin birlikte çalışacak şekilde tasarlanması ve client'in aynı anda tek bir aileden productlar kullanması gerektiğinde uygundur

• Factory Method
   ◇ Client kodundan kullanılan somut nesneleri gizler
   ◇ tek bir product ve onun subclasslarıyla ilgilidir. Product'ın diğer nesnelerle işbirliği yapması önemsizdir.
   ◇ tek bir inheritance hiyerarşisinden nesneler oluşturur.
