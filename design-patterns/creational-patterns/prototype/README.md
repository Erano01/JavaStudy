<h1>Prototype</h1>

<h3>Intent</h3>
Prototip bir instance kullanarak oluşturulacak nesne tiplerini belirtin ve bu prototipi kopyalayarak yeni nesneler oluşturun.

//bir sınıfın yeni bir örneğini oluşturmak maliyetli bir işlem olduğunda kullanılır.

not: 
music score = nota kağıdı, muzik notasyonu
state = durum -> field anlamına gelir

<h3>Motivation</h3>
Genel bir grafik editör frameworkü özelleştirerek ve notalar(notes), suslar(rests) ve porteler(staves) gibi yeni nesneler ekleyerek bir nota kağıdı editörü oluşturabilirsiniz. 
Editör frameworkunde, bu müzik nesnelerini nota kağıdına eklemek için bir araç paleti olabilir. 
Palette ayrıca müzik nesnelerini seçmek, taşımak ve başka şekillerde düzenlemek için araçlar da yer alacak.
Kullanıcılar QuarterNoteTool'a tıklayıp bunu nota kağıdına çeyrek notalar eklemek için kullanabilirler. 
Veya MoveTool kullanarak bir notayı porte üzerinde yukarı veya aşağı hareket ettirerek notanın sesini değiştirebilirler.

Varsayalım ki framework, notalar ve porteler gibi grafik componentleri için soyut bir Graphic sınıfı sağlar. 
Ayrıca, palet içindeki araçları tanımlamak için soyut bir Tool sınıfı da sağlar. 
Framework, grafik nesnelerinin örneklerini oluşturan ve bunları belgeye ekleyen GraphicTool subclassını da önceden tanımlar.

Ancak GraphicTool, framework tasarımcısı için bir sorun teşkil eder. Notalar ve porteler için olan sınıflar uygulamamıza özgüdür, ancak GraphicTool sınıfı framework'e aittir. 
GraphicTool, nota kağıdına eklemek için müzik sınıflarımızın örneklerini nasıl oluşturacağını bilmez. 
Her müzik nesne tipi için GraphicTool sınıfını subclass yapabiliriz, ancak bu, sadece örneklenen müzik nesnesinin tipinde farklı olan birçok subclass üretir. 
Nesne bileşiminin(object composition'in), subclass oluşturmaya esnek bir alternatif olduğunu biliyoruz. Soru şu: Framework, oluşturulacak GraphicTool örneklerini, yaratmaları gereken Graphic sınıfıyla nasıl parametreleştirebilir?

Çözüm, GraphicTool’un yeni bir Graphic yaratmak için bir Graphic subclass'ının bir örneğini kopyalaması veya "klonlamasında" yatar. 
Bu örneğe prototip diyoruz. GraphicTool, klonlayıp belgeye eklemesi gereken prototiple parametrelenmiştir. Eğer tüm Graphic subclassları bir Clone operasyonu desteklerse, GraphicTool her türlü Graphic’i klonlayabilir.

Bu nedenle müzik editörümüzde, bir müzik nesnesi oluşturan her tool, farklı bir prototiple başlatılmış bir GraphicTool örneğidir. Her GraphicTool örneği, prototipini klonlayarak bir müzik nesnesi oluşturacak ve klonu nota kağıdına ekleyecektir.
![image](https://github.com/user-attachments/assets/c1868938-ad10-4846-8fd9-d57ee03f4f22)



Sınıf sayısını daha da azaltmak için Prototip desenini kullanabiliriz. WholeNote ve HalfNote için ayrı sınıflarımız var ama bu muhtemelen gereksizdir. 
Bunun yerine, farklı bit map'ler ve sürelerle başlatılan aynı sınıfın örnekleri olabilirler. WholeNote oluşturmak için kullanılan bir araç, prototipi WholeNote olarak başlatılmış bir MusicalNote olan bir GraphicTool'a dönüşür.
Bu, sistemdeki sınıf sayısını önemli ölçüde azaltabilir. Ayrıca müzik editörüne yeni bir nota türü eklemeyi de kolaylaştırır.

<h3>Applicability</h3>
Bir sistemin productlarının nasıl yaratıldığı, oluşturulduğu ve sunulduğu konusunda bağımsız olması gerektiğinde Prototip modelini kullanın; ve

• örneklenecek sınıflar runtime'da belirtildiğinde, örneğin, dynamic loading yoluyla; veya
• ürünlerin sınıf hiyerarşisine paralel bir factory sınıf hiyerarşisi oluşturmaktan kaçınmak; veya
• bir sınıfın örnekleri yalnızca birkaç farklı durum(state) kombinasyonundan birine sahip olabildiğinde.Sınıfı her seferinde uygun durumla manuel olarak örneklendirmektense, karşılık gelen sayıda prototipi kurup bunları klonlamak daha uygun olabilir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/d396ecbf-82db-4b79-9aeb-fdcba7c33c38)


<h3>Participants</h3>
• Prototype (Graphic)
   ◇ Kendini klonlamak için bir arayüz tanımlar
• ConcretePrototype (Staff, WholeNote, HalfNote)
   ◇ Kendini klonlamak için bir operasyonu gerçekleştirir.
• Client (GraphicTool)
   ◇ prototype'ın kendisini klonlamasını isteyerek yeni bir nesne oluşturur.

<h3>Collaborations</h3>
• Bir client bir prototipten kendisini klonlamasını ister

<h3>Consequences</h3>

Prototype, Abstract Factory (87) ve Builder (97) gibi birçok aynı sonucu paylaşır: Client'dan somut product sınıflarını gizler, böylece client'in bildiği isimlerin sayısını azaltır. Ayrıca, bu desenler bir clientin uygulamaya özgü sınıflarla değişiklik yapmadan çalışmasına olanak tanır.

Prototype deseninin ek faydaları aşağıda listelenmiştir:

1. Productları rum-time'da ekleme ve çıkarma. Prototipler, client'e prototipik bir örnek kaydederek yeni bir somut product sınıfını bir sisteme dahil etmenizi sağlar. Bu, diğer creational patternlardan biraz daha esnektir, çünkü bir client, prototipleri run-time'da yükleyip kaldırabilir.

2. Yeni nesneleri, değerleri değiştirerek belirtme. Oldukça dinamik sistemler, yeni davranışı sınıflar tanımlayarak değil, nesne birleşimi(object composition) yoluyla - örneğin, bir nesnenin değişkenlerine değerler atayarak - tanımlamanıza olanak tanır. Mevcut sınıfları örnekleyerek ve bu örnekleri client nesnelerinin prototipleri olarak kaydederek, fiilen yeni tipte nesneler tanımlarsınız. Client, sorumluluğu prototipe devrederek yeni davranış sergileyebilir. Bu tip bir dizayn, kullanıcıların programlama yapmadan yeni "sınıflar" tanımlamalarına olanak tanır. Aslında, bir prototipi klonlamak, bir sınıfı örneklemeye benzer. Prototype deseni, bir sistemin ihtiyaç duyduğu sınıf sayısını büyük ölçüde azaltabilir. Müzik editörümüzde, tek bir GraphicTool sınıfı sınırsız çeşitlilikte müzik nesnesi yaratabilir.

3. Yeni nesneleri structure'i değiştirerek belirtme. Birçok uygulama, nesneleri parçalardan(part) ve alt parçalardan(subpart) oluşturur. Örneğin, devre tasarımı editörleri, devreleri alt devrelerden oluşturur. Kolaylık sağlamak için, bu tür uygulamalar genellikle karmaşık, kullanıcı tanımlı structurelara örneklemenize olanak tanır, örneğin belirli bir alt devreyi tekrar tekrar kullanmak için. Prototype deseni bunu da destekler. Bu alt devreyi, mevcut devre elemanlarının paletine bir prototip olarak eklememiz yeterlidir. Kompozit devre nesnesi, derin kopya olarak bir Clone operasyonu gerçekleştirdiği sürece, farklı structurelara sahip devreler prototip olabilir.

4. Azaltılmış subclass oluşturma. Factory Method (107), genellikle product sınıf hiyerarşisini paralel olarak izleyen bir Creator sınıf hiyerarşisi üretir. Prototype deseni, yeni bir nesne oluşturmak için factory method'a sormak yerine bir prototipi klonlamanıza olanak tanır. Bu nedenle, bir Creator sınıf hiyerarşisine hiç ihtiyaç duymazsınız. Bu fayda, özellikle sınıfları birinci sınıf nesneler olarak ele almayan C++ gibi dillere uygulanır. Smalltalk ve Objective-C gibi bu tür sınıflar, daha az fayda sağlar, çünkü bu dillerde her zaman bir sınıf nesnesini Creator olarak kullanabilirsiniz. Sınıf nesneleri bu dillerde zaten prototip gibi davranır.

5. Bir uygulamayı sınıflarla dinamik olarak konfigure etmek. Bazı run-time ortamları, sınıfları bir uygulamaya dinamik olarak yüklemenize izin verir. Prototype deseni, C++ gibi bir dilde bu tür özellikleri kullanmanın anahtarıdır. Dinamik olarak yüklenmiş bir sınıfın örneklerini oluşturmak isteyen bir uygulama, constructor fonksiyonuna statik olarak başvuramaz. Bunun yerine, runtime ortamı, her sınıf yüklendiğinde otomatik olarak bir örnek oluşturur ve bu örneği bir prototip manager'a kaydeder (bkz. Gerçekleştirilme bölümü). Daha sonra uygulama, başlangıçta programla bağlantılı olmayan yeni yüklenen sınıfların örneklerini prototip yöneticisinden isteyebilir. ET++ application framework [WGM88], bu şemayı kullanan bir runtime sistemine sahiptir.

Prototype deseninin başlıca dezavantajı, Prototype'ın her subclassının Clone operasyonunu gerçekleştirmek zorunda olmasıdır, bu da zor olabilir. 
Örneğin, handle edilen sınıflar zaten mevcut olduğunda Clone eklemek zordur. Clone operasyonunu gerçekleştirmek, iç yapıları(internals) kopyalamayı desteklemeyen nesneleri içerdiğinde veya döngüsel referanslara sahip olduğunda zor olabilir.

---


<h3>Implementation</h3>

• Javada Cloneable arayüzünü gerçekleştirmek zorundayız. (Cloneable in-built ve marker arayüzdür)
• clone() methodunu override etmemiz ve bu methodu gerçekleştirdiğimiz somut sınıfın kendi tipinde birşey döndürmeliyiz.
• method CloneNotSupportedException throw edebilmeli

Not: Marker interface, herhangi bir method tanımlamayan ancak sınıfımızın kapasitesinin bir işareti veya göstergesi olarak hizmet eden bir arayüzdür. Diğer kodlara sınıfınızın klonlama işlemini desteklediğini söyleriz.

Deep Copy:
Deep copy, bir nesnenin tamamen bağımsız bir kopyasını oluşturur. Bu, nesnenin kendisinin yanı sıra içindeki tüm iç içe geçmiş nesnelerin de kopyalanması anlamına gelir. Yani, kopyalanan nesne, orijinal nesneden tamamen bağımsızdır ve herhangi bir değişiklik, diğer nesneyi etkilemez.

Shallow Copy: 
Shallow copy, bir nesnenin yeni bir örneğini oluşturur, ancak bu nesnenin içindeki nesnelerin referanslarını kopyalar. Yani, yüzeysel kopyalama, yalnızca ilk seviye verileri kopyalar ve nesne içindeki herhangi bir diğer nesneye olan referansları aynı kalır. Bu, kopyalanan nesne ve orijinal nesnenin, iç içe geçmiş nesneleri paylaşacağı anlamına gelir.

Implement Considerations
• Prototipinizin state'e sahipse veya bunlar prototip state'nizin bir parçasıysa ve immutable iseler, o zaman shallow copy yaparak idare edebilirsiniz çünkü bu nesneler değiştirilemezdir ve bir kopya aynı nesneleri işaret etmeye devam edebilir.
• Prototipiniz mutable nesnelere sahipse deep copy kullanmalısınız.
• Cloneable arayüzündeki clone methodu protected olarak gelir onu public yapmalısınız.
• clone methodunuzda kopyayı döndürdüğünüzde, nesnenizin mutable statelerini sıfırladığınızdan emin olun. Aksi takdirde, bu nesnelere dayanan kod farklı davranabilir. Şimdi, bu sıfırlama işlemini ayrı bir method olarak uygulamak her zaman iyi bir fikirdir, böylece subclasslar bu methodu override edebilir ve kendi statelerini sıfırlamak için kendi kodlarını sağlayabilir.
• Cloneable arayüzü ayrıyetten bir marker interface'dir. Marker arayüzler herhangi bir method tanımlamaz fakat sınıfınızın clone methodunu desteklediğini gösterir.
• Composite ve Decorator pattern'lar ile çalışırken Prototype patternlar kullanışlıdır.
• Prototipinizin durumu(state'i) çok sayıda değişebilir nesneden oluşuyorsa, prototipi uygulamak karmaşık bir süreç olabilir çünkü artık prototipinizin durumunda bulunan tüm bu değişebilir nesnelerin derin kopyasını sağlamanız gerekir.
• Java'da varsayılan clone() methodu shallow copy'dir eğer deep copy istiyorsanız bunu kendiniz implement etmelisiniz.

Not: 
Java'da covariant return type özelliği, bir alt sınıfın, üst sınıfın bir metodunu geçersiz kılarken (override), o metodun dönüş türünü daha spesifik bir alt tür ile değiştirmesine olanak tanır.
Normalde, bir alt sınıf bir üst sınıf metodunu geçersiz kılarken, o metodun dönüş türü, üst sınıfta tanımlanan dönüş türüyle aynı olmalıdır. Ancak, covariant return type sayesinde, alt sınıf metodu, üst sınıfta tanımlanan dönüş türünün alt türünü döndürebilir. Bu özellik, daha fazla esneklik sağlar ve alt sınıf nesneleriyle çalışırken daha uygun türlerin kullanılmasına olanak tanır.
![image](https://github.com/user-attachments/assets/5905967f-07eb-427e-83cb-96f94e924b46)


Using Covariant return type feature for prototype pattern:
![image](https://github.com/user-attachments/assets/889165cc-9113-486c-939b-75bd305b7dea)



Comparison Builder and Prototype Design Patterns

• Builder
   ◇  Kompleks constructor ve builder'imiz vardır.
   ◇ Builder'i farklı sınıfta tanımlayabiliriz yani legacy kodlar ile çalışabilir.
• Prototype
   ◇ Constructor aşamalarının tümünü skiplemenize olanak sağlar.
   ◇ Javada bu pattern clone methodu ile birlikte çalışır ve var olan kodu değiştirme gereksinimi duyar yani legacy kodlar ile çalışmayabilir.







