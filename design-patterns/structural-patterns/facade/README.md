<h1>Facade</h1>

<h3>Intent</h3>
Bir alt sistemdeki arayüz kümesine birleştirici bir arayüz sağlayın. Facade, alt sistemi kullanmayı daha kolay hale getiren daha üst düzey bir arayüz tanımlar.

//Fransızca “Façade” binaların ön yüzü, ön cephesi anlamına gelir. Zaten kelime yapısı itibariyle “face” yani “yüz” ile de akrabadır.

<h3>Motivation</h3>
Bir sistemi alt sistemlere mimarilendirmek kompleksliği azaltmaya yardımcı olur. Yaygın bir tasarım hedefi olarak, alt sistemler arasındaki iletişimi(communication) ve bağımlılıkları(dependencies) en aza indirmektir. Bu hedefe ulaşmanın bir yolu, bir alt sistemin daha genel olanaklarına tek, basitleştirilmiş bir arayüz sağlayan bir facade nesnesi tanıtmaktır.

![image](https://github.com/user-attachments/assets/def51618-a5e3-49d9-b36d-376e671ac4e6)

Örneğin, uygulamalara compiler alt sistemine erişim(access) sağlayan bir programlama ortamını ele alalım.
Bu alt sistem, compiler'i gerçekleştiren Scanner,Parser, ProgramNode, BytecodeStream ve ProgramNodeBuilder gibi sınıfları içerir. Bazı özel uygulamaların bu sınıflara doğrudan erişmesi gerekebilir.
Ancak bir compiler'in client'lerinin çoğu genellikle parsing ve code generation gibi ayrıntılarla ilgilenmez; yalnızca biraz kod compile etmek isterler. Onlar için, compiler alt sistemindeki güçlü ama düşük seviyeli arayüzler yalnızca görevlerini karmaşıklaştırır.
Clientleri bu sınıflardan koruyabilen daha üst düzey bir arayüz sağlamak için, compiler alt sistemi ayrıca bir Compiler sınıfı içerir. Bu sınıf, compiler'in fonksiyonelliğine birleşik bir arayüz tanımlar.
Compiler sınıfı bir facade görevi görür: Clientlere compiler alt sistemine tek ve basit bir arayüz sunar.
Compiler fonksiyonelliğini gerçekleştiren sınıfları tamamen gizlemeden birbirine yapıştırır. Compiler facade, daha düşük seviyeli fonksiyonelliğe ihtiyaç duyan birkaç kişiden gizlemeden çoğu programcının hayatını kolaylaştırır.

![image](https://github.com/user-attachments/assets/e0c9ea90-14d3-4d2f-8710-8b40aa87d302)

<h3>Applicability</h3>
Şu durumlarda Facade patternini kullanabilirsiniz:
• karmaşık bir alt sisteme basit bir arayüz sağlamak istiyorsanız. Alt sistemler genellikle evrimleştikçe daha karmaşık hale gelir. Çoğu desen, uygulandığında daha fazla ve daha küçük sınıflarla sonuçlanır. Bu, alt sistemi daha reusable ve özelleştirilmesi daha kolay hale getirir, ancak özelleştirmeye ihtiyacı olmayan client'ler için kullanımı da zorlaşır. Bir facade, çoğu client için yeterince iyi olan alt sistemin basit bir varsayılan görünümünü sağlayabilir. Yalnızca daha fazla özelleştirilebilirliğe ihtiyaç duyan clientlerin facade'nin ötesine bakması gerekecektir.

• clientler ve bir soyutlamanın gerçekleştirme sınıfları arasında birçok bağımlılık vardır.Alt sistemi clientlerden ve diğer alt sistemlerden ayırmak için bir facade tanıtın, böylece alt sistemin bağımsızlığını ve taşınabilirliğini teşvik edin.

• alt sistemlerinizi katmanlamak(layered) istiyorsunuz. Her alt sistem seviyesine bir giriş noktası(entry point) tanımlamak için bir facade kullanın. Alt sistemler bağımlıysa(dependent), o zaman aralarındaki bağımlılıkları(dependencies), yalnızca facadeleri aracılığıyla birbirleriyle iletişim kurmalarını sağlayarak basitleştirebilirsiniz.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/df32bfe2-230e-4a6f-a4b7-77ae7744ca94)

<h3>Participants</h3>
• Facade (Compiler)
   ◇ gelen request için hangi subsystem sınıfları sorumlu bilir.
   ◇ Client requestlerini uygun alt sistem nesnelerine devreder.
• subsystem classes (Scanner, Parser, ProgramNode, etc)
   ◇ subsystem fonksiyonelliğini gerçekleştirir.
   ◇ Facade nesne tarafından atanmış işi yapar.
   ◇ Facade hakkında bilgi sahibi değildir; yani, ona dair hiçbir referansa sahip değildir.

<h3>Collaborations</h3>
• Clientler, requestleri Facade'e göndererek alt sistemle iletişim kurarlar ve Facade bunları uygun alt sistem nesnesine iletir. Alt sistem nesneleri gerçek işi yapsa da, arayüzünü alt sistem arayüzlerine çevirmek için, facade kendi işini yapması gerekebilir.
• Facade kullanan clientlerin alt sistem nesnelerine doğrudan erişmeleri gerekmez.

<h3>Consequences</h3>
Facade deseni aşağıdaki avantajları sunar:

1. Clientleri alt sistem componentlerinden korur, böylece clientlerin ilgilendiği nesne sayısını azaltır ve alt sistemin kullanımını kolaylaştırır. 

2.  Alt sistem ile clientleri arasında weak coupling'i teşvik eder. Genellikle bir alt sistemdeki componentler strongly coupled'dir. Weak coupling, clientlerini etkilemeden alt sistemin componentlerini değiştirmenize olanak tanır. Facade'lar bir sistemi ve nesneler arasındaki bağımlılıkları(dependencies) katmanlandırmaya yardımcı olur. Karmaşık veya dairesel bağımlılıkları(complex or circular dependencies) ortadan kaldırabilirler. Bu, client ve alt sistem bağımsız olarak gerçekleştirildiğinde önemli bir sonuç olabilir. Derleme bağımlılıklarını azaltmak büyük yazılım sistemlerinde hayati önem taşır. Alt sistem sınıfları değiştiğinde yeniden derlemeyi en aza indirerek zamandan tasarruf etmek istersiniz. Facade'lerle derleme bağımlılıklarını azaltmak, önemli bir alt sistemdeki küçük bir değişiklik için gereken yeniden derlemeyi sınırlayabilir. Bir facade ayrıca sistemlerin diğer platformlara taşınmasını da basitleştirebilir çünkü bir alt sistemi oluşturmanın diğerlerini oluşturmayı gerektirmesi daha az olasıdır.

3. Uygulamaların ihtiyaç duymaları halinde alt sistem sınıflarını kullanmalarını engellemez. Bu sayede kullanım kolaylığı ile genellik(generality) arasında seçim yapabilirsiniz. 














