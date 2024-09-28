<h1>Bridge</h1>

<h3></h3>Intent
Bir soyutlamayı gerçekleştirmesinden ayırır(decouple), böylece ikisi bağımsız olarak değişebilir.

//inheritance'in oluşturduğu tightly coupled sınıfları decouple eder. iki hierarşiyi birbirinden bağımsız olarak geliştirmemizi sağlar. sınıfları inheritence ile sonsuza kadar extend etme işleminden kurtarır.

<h3>Also Known As</h3>
Handle / Body

<h3>Motivation</h3>
Bir soyutlama birden fazla gerçekleştirmelere sahip olabiliyorsa, bunları barındırmanın olağan yolu inheritance(kalıtım) kullanmaktır.
Soyut sınıf, soyutlamaya ait arayüzü tanımlar ve somut subclassları bunu farklı şekillerde gerçekleştirir. Ancak bu yaklaşım her zaman yeterince esnek değildir.
Kalıtım, bir gerçekleştirmeyi kalıcı olarak soyutlamaya bağlar(bind); bu da soyutlamaları ve gerçekleştirmeleri bağımsız olarak(independently) değiştirmeyi, genişletmeyi ve yeniden kullanmayı zorlaştırır.

Taşınabilir bir Window soyutlamasının kullanıcı arayüzü toolkit'ine gerçekleştirilmesini düşünün.
Bu soyutlama, örneğin hem X Window Sistemi hem de IBM'in PresentationManager (PM) üzerinde çalışan gerçekleştirmeler yazmamızı sağlamalıdır
Inheritance kullanarak, soyut bir sınıf olan Window ve farklı platformlar için Window arayüzünü uygulayan XWindow ve PMWindow subclasslarını tanımlayabiliriz.

Ancak bu yaklaşımın iki dezavantajı var:
1. Farklı tipte pencereleri veya yeni platformları kapsayacak şekilde Window soyutlamasını genişletmek zahmetlidir. Window soyutlamasını simgeler (ikonlar) için özelleştiren bir IconWindow alt sınıfı hayal edin. Hem XWindow hem de PMWindow platformları için IconWindows'u desteklemek amacıyla, iki yeni sınıf olan XIconWindow ve PMIconWindow'u gerçekleştirmemiz gerekecektir. Daha da kötüsü, her tip pencere için iki yeni sınıf tanımlamamız gerekecek. Üçüncü bir platformu desteklemek, her tip pencere için bir başka yeni Window subclass'ı gerektirir.
2. Client kodunu platforma bağımlı(platform-dependent) hale getirir. Bir Client bir pencere oluşturduğunda, belirli bir gerçekleştirmeye sahip somut bir sınıf örneği oluşturur. Örneğin, bir XWindow nesnesi oluşturmak, Window soyutlamasını XWindow gerçekleştirmesine bağlar ve bu da client kodunu XWindow gerçekleştirmesine bağımlı(dependent) hale getirir. Bu da, client kodunu diğer platformlara taşımayı zorlaştırır.
   Clientler, somut bir gerçekleştirmeye bağlı kalmadan bir pencere oluşturabilmelidir. Sadece pencere gerçekleştirmesi, uygulamanın çalıştığı platforma bağlı olmalıdır. Bu nedenle, client kodu, belirli platformları belirtmeden pencereler oluşturmalıdır.

Bridge patterni, Window soyutlamasını ve onun gerçekleştirmesini ayrı sınıf hiyerarşilerinde tutarak bu sorunları ele alır. Pencere arayüzleri (Window, IconWindow, TransientWindow) için bir sınıf hiyerarşisi ve platform-specific pencere gerçekleştirmeleri için, root olarak WindowImp olan ayrı bir hiyerarşi vardır. Örneğin, XWindowImp subclassı, X Window Sistemi tabanlı bir gerçekleştirme sağlar.

![image](https://github.com/user-attachments/assets/03b22150-a2bb-4c2f-86ce-0f5a5dc8a55c)

Window subclasslarındaki tüm operasyonlar, WindowImp arayüzünden soyut operasyonlar açısından gerçekleştirilir. Bu, pencere soyutlamalarını çeşitli platform-specific gerçekleştirmekten ayırır. Window ve WindowImp arasındaki ilişkiye köprü (bridge) denir, çünkü bu, soyutlama ile uygulama arasındaki bağlantıyı kurar ve onların bağımsız olarak değişebilmesine olanak tanır.

<h3>Applicability</h3>
Bridge patternini şu durumlarda kullanın:
• Bir soyutlama ile onun gerçekleştirmesi arasında kalıcı bir bağ oluşmasını önlemek istersiniz. Bu durum, misal gerçekleştirmenin run-time'da seçilmesi veya değiştirilmesi gerektiğinde söz konusu olabilir.
• Hem soyutlamaların hem de gerçekleştirmelerin alt sınıflarla genişletilebilir olması gerektiğinde. Bu durumda, Bridge deseni farklı soyutlamalar ve gerçekleştirmeler arasında kombinasyon yapmanıza ve bunları bağımsız olarak genişletmenize olanak tanır.
• Bir soyutlamanın gerçekleştirmesindeki değişikliklerin client kodlarını etkilememesi gerektiğinde; yani, client kodunun yeniden derlenmesine gerek kalmamalıdır.
• (C++) Bir soyutlamanın gerçekleştirmesini tamamen client kodundan gizlemek istediğinizde. C++'ta bir sınıfın temsili sınıf arayüzünde görünür.
• Daha önce ilk motivasyon diyagramında gösterildiği gibi, çok sayıda sınıfın oluştuğu durumlarda. Böyle bir sınıf hiyerarşisi, bir nesnenin iki parçaya bölünmesi gerektiğini gösterir. Rumbaugh, bu tip sınıf hiyerarşileri için "nested generalizations" terimini kullanır [RBP+91].
• Bir gerçekleştirmeyi birden fazla nesne arasında paylaşmak istediğinizde (belki referance counting kullanarak) ve bu durumun client kodundan gizlenmesi gerektiğinde. Basit bir örnek, Coplien'in String sınıfıdır [Cop92]. (StringRep)

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/d9a141cd-a686-4d40-9f01-b6a17b2e0904)


Yazar not : RefinedAbstraction Abstraction'ı kalıtım yoluyla implement eder daha sonra Implementor arayüzünü private field olarak tutar ve constructorunda Implementor ile oluşturulur.


<h3>Participants</h3>
• Abstraction (Window)
   ◇ Abstraction arayüzünü tanımlar.
   ◇ Implementor tipindeki nesneye referansı sağlar.

• RefinedAbstraction (IconWindow)
   ◇ Abstraction tarafından tanımlanan arayüzü extend eder.

• Implementor (WindowImp)
   ◇ Gerçekleştirme sınıfları için arayüzü tanımlar. Bu arayüzün, Abstraction'ın arayüzüyle tam olarak örtüşmesi gerekmez; aslında, iki arayüz oldukça farklı olabilir. Genellikle, Implementor arayüzü yalnızca temel operasyonları sağlar ve Abstraction, bu temel operasyonlar üzerinde daha üst düzey operasyonlar tanımlar.

• ConcreteImplementor (XWindowImp, PMWindowImp)
   ◇ Implementor arayüzünü gerçekleştirir ve somut gerçekleştirmesini tanımlar.

<h3>Collaborations</h3>
• Abstraction, client request'lerini Implementor nesnesine iletir.

<h3>Consequences</h3>
Bridge Design Patternin aşağıdaki sonuçları vardır:

1. Arayüzü ve gerçekleştirmesini birbirinden ayırır(decoupled). Bir gerçekleştirme kalıcı olarak bir arayüze bağlı değildir. Bir soyutlamanın gerçekleştirmesi runtime'da yapılandırılabilir. Hatta bir nesnenin runtime'da gerçekleştirmesini değiştirmesi bile mümkündür. 
   Abstraction ve Implementor’ın ayrılması(decouple edilmesi), gerçekleştirme üzerindeki compile-time bağımlılıklarını(dependencies) da ortadan kaldırır. Bir gerçekleştirme sınıfını değiştirmek, Abstraction sınıfını ve onun clientlerini recompile etmeyi gerektirmez. Bu özellik, bir sınıf kütüphanesinin farklı sürümleri arasında ikili uyumluluğu sağlamak zorunda olduğunuzda önemlidir. 
   
   Ayrıca, bu ayrışma daha iyi yapılandırılmış bir sistemin oluşmasına yol açabilecek katmanlaşmayı teşvik eder. Bir sistemin üst düzey kısmı yalnızca Abstraction ve Implementor hakkında bilgi sahibi olmalıdır.

2. Geliştirilmiş genişletilebilirlik(Improved extensibility). Soyutlama ve Implementor hiyerarşilerini bağımsız olarak genişletebilirsiniz.

3. Gerçekleştirme ayrıntılarını clientler'dan gizlemek. Clientleri, Implementor nesnelerinin paylaşılması ve bunun beraberindeki eğer var ise referance count mekanizması gibi gerçekleştirme ayrıntılarından koruyabilirsiniz.

<h3>Comparison between Adapter & Bridge Design Pattern</h3>

• Bridge
   ◇ Soyutlama ve gerçekleştirmenin birbirinden bağımsız olarak değişmesine izin verme amacına sahiptir.
   ◇ Bu design pattern en başından itibaren tasarlanması ve gerçekleştirilmesi gerektiğidir. Tüm bu sınıflara sahip olduğunuzda, bunları bridge design apttern ile yeniden düzenlemek oldukça basittir.
• Adapter
   ◇ birbiri ile ilişkisi bulunmayan sınıfların birbiri ile çalışmasını sağlar.
   ◇ Adaptör legacy sistemlerin yeni kodlar ile entegre olmasını sağlar.


<h3>Trade-Offs of Bridge Design Pattern:</h3>
• Bridge design patterni anlaması ve gerçekleştirmesi kompleks olan bir patterndir.
• Bridge patterni kullanma kararını doğru bir şekilde verebilmek için projedeki alakalı kısımların tüm tasarımı önünüzde olması gereklidir. Bu da bizi, uygulamanız zaten tamamlanmışsa Bridge design patterni gerçekleştirmenin oldukça zor olduğunu söyleyen son noktaya getiriyor. Çünkü sınıfların veya nesnelerin birbirleriyle etkileşimini değiştirir buda çok fazla yeniden çalışma ve yeni unit test aşaması gerektirebilir.














