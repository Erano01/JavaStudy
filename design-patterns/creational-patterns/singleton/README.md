<h1>Singleton</h1>

<h3>Intent</h3>
Bir sınıfın yalnızca bir örneğinin olduğundan emin olun ve ona global access sağlayın. (method veya field aracılığı ile sağlanır) 

Not: Singletonunuza eklediğiniz her durum uygulamanızın “global durumu” haline gelir. 

<h3>Motivation</h3>
Bazı sınıfların sadece bir örneğinin olması önemlidir. Bir sistemde birçok printer olabilmesine rağmen, yalnızca bir printer spooler olmalıdır. Sadece bir dosya sistemi(file system) ve bir pencere yöneticisi(window manager) olmalıdır. Dijital bir filtrenin bir A/D converter'i olacaktır.
Muhasebe sistemi tek bir şirkete hizmet edecek şekilde oluşturulacak.

Bir sınıfın yalnızca bir örneğinin olduğundan ve örneğin kolayca erişilebilir olduğundan nasıl emin olabiliriz? Global bir değişken bir nesneyi erişilebilir kılar, ancak birden fazla nesneyi örneklendirmenizi engellemez. 

Daha iyi bir çözüm, sınıfın kendi tek örneğini takip etmekten sorumlu olmasını sağlamaktır. Sınıf, başka hiçbir örneğin oluşturulamayacağından emin olabilir (yeni nesneler oluşturma isteklerini keserek) ve örneğe erişmenin bir yolunu sağlayabilir. Bu Singleton desenidir.

<h3>Applicability</h3>
Singleton desenini şu durumlarda kullanın:
• Bir sınıfın tek bir örneği olmalı ve bu örnek, iyi bilinen bir erişim noktasından Clientler tarafından erişilebilir olmalıdır.
• Tek örnek subclassing ile genişletilebilir olmalı ve Clientler kodlarını değiştirmeden genişletilmiş bir örneği kullanabilmelidir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/47fbf624-401d-4a60-99c5-818fb8a8978a)


<h3>Participants</h3>
• Singleton
   ◇ Clientlerin benzersiz örneğine erişmesine izin veren bir Instance operasyonu tanımlar. Instance, bir sınıf operasyonudur (yani Smalltalk'ta bir sınıf methodu ve C++'ta statik member fonksiyondur).
   ◇ belki de kendi benzersiz örneğini yaratmaktan sorumludur.

<h3>Collaborations</h3>
• Clientler, yalnızca Singleton'ın Instance operasyonu aracılığıyla bir Singleton örneğine erişir.

<h3>Consequences</h3>
Singleton deseninin birçok faydası vardır:

• Tek örneğe kontrollü erişim. Singleton sınıfı tek örneğini kapsüllediği için, clientlerin ona nasıl ve ne zaman erişeceği konusunda sıkı bir kontrole sahip olabilir.
• Azaltılmış namespace. Singleton deseni, global değişkenlere göre bir iyileştirmedir. Tek örnekleri depolayan global değişkenlerle namespace'ni kirletmekten kaçınır.
• Clientlerin ve sunumun iyileştirilmesine izin verir. Singleton sınıfı subclasslara ayrılabilir ve bu genişletilmiş sınıfın bir örneğiyle bir uygulamayı konfigure etmek kolaydır. Uygulamayı, run-time'da ihtiyaç duyduğunuz sınıfın bir örneğiyle konfigure edebilirsiniz.
• Değişken sayıda örneğe izin verir. Bu pattern, fikrinizi değiştirmenizi ve Singleton sınıfının birden fazla örneğine izin vermenizi kolaylaştırır. Dahası, uygulamanın kullandığı örnek sayısını kontrol etmek için aynı yaklaşımı kullanabilirsiniz. Yalnızca Singleton örneğine erişim izni veren operasyonun değişmesi gerekiyor.
• Sınıf operasyonlarından daha esnektir. Singleton'un fonksiyonelliğini paketlemenin bir diğer yolu da sınıf operasyonları kullanmaktır (yani, C++'da statik member fonksiyonları veya Smalltalk'ta sınıf methodları). Ancak bu dil tekniklerinin her ikisi de bir sınıfın birden fazla örneğine izin vermek için bir tasarımı değiştirmeyi zorlaştırır. Dahası, C++'daki statik member fonksiyonları asla soyut(virtual) değildir, bu nedenle subclasslar bunları polimorfik olarak override edemezler.

--

<h3>Implementation: </h3>
• sınıf constructoru global erişimde olmamalı
• subclassing/inheritance'a izin verilmemeli, çünkü eğer subclasslamaya izin verirsen subclass'ın oluşturulması kontrolünüzden çıkar.
• sınıfın örneğinin kontrol edilmesi sınıfın kendisinde olması iyi bir yerdir.
• public static method iyi bir seçimidr
• örneği final public static field olarak da dağıtabiliriz fakat bu tüm singleton gerçekleştirmeleriyle birlikte çalışmaz.
• singleton oluşturulurken herhangi bir parametre ihtiyacı olmaz eğer constructor yardımına ihtiyacınız olursa simple factory veya factory method kullanın.
• singleton'larınızın çok fazla global mutable statelere sahip olmaması gereklidir.
• Yaratma maliyeti yüksek ve başlatma süresi etkisi belirgin değilse her zaman eager loading'i tercih edin.

• Singletonu gerçekleştirmek için 2 seçeneğimiz vardır
   ◇ Eager Singleton - Early initialization
      ▪ singleton'u class yüklenir yüklenmez oluşturur.
   ◇ Lazy Singleton - Lazy initialization
      ▪ singleton'a ihtiyaç duyulduğunda yaratılır.

<h3>Trade-Offs:</h3>
• Singleton deseni gerçek bağımlılıklar konusunda sizi yanıltabilir! Global olarak erişilebilir oldukları için bağımlılıkları gözden kaçırmak kolaydır.
• unit test yapmak zordur. döndürülen örneği kolayca taklit edemezsiniz.
• Java'da singleton'ları uygulamanın en yaygın yolu statik değişkenlerdir ve bunlar class loader başına tutulur, JVM başına değil. Bu yüzden bir OSGi veya web uygulamasında gerçek anlamda Singleton olmayabilirler.
• Fazlaca global state taşıyan bir singleton, kötüye kullanılan bir Singleton deseninin iyi bir göstergesidir.

![image](https://github.com/user-attachments/assets/f6b052be-5ffe-4cef-bc56-587848d9b77e)
![image](https://github.com/user-attachments/assets/f6aef879-0e42-4551-a1d7-5d21e48e2ce6)









<h3>Comparison between Prototype and Singleton Design Patterns</h3>

• Prototype
   ◇ örneğimizin kopyasını döndürürüz.
   ◇ Prototipler ile oluşturulmuş örneklerimizin state'lerinin bazısı veya tümü farklı olabilir.  
• Singleton
   ◇ her zaman aynı örneği döndürürüz.
   ◇ her zaman aynı örneği döndürdüğümüz için state değişmez.
