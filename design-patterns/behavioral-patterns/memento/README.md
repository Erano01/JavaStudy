<h1>Memento</h1>

<h3>Intent</h3>
Kapsüllemeyi/Sarmalamayı(encapsulation) ihlal etmeden, bir nesnenin iç(internal) durumunu yakalayın ve dışsallaştırın(externalize), böylece nesne daha sonra bu duruma geri döndürülebilir.

Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.

//Originator durumu saklanacak olan nesnedir, Memento durumu saklayan nesnedir, Caretaker ise Originator'un durumunu saklaması için Mementoyu tetikleyen nesnedir.
// Javada memento gof örneği dışında mementoyu originator içinde inner class olacak şekilde tasarlayabilirsiniz.
// istenirse saklanacak durum ayrı bir nesne haline getirilebilir(GUI örneği).

//originator -> başlatıcı/yaratıcı
<h3>Also Known As</h3>
Token

<h3>Motivation</h3>
Bazen bir nesnenin içsel durumunu kaydetmek gerekir. Bu, kullanıcıların geçici işlemlerden geri çekilmesine veya hatalardan kurtarılmasına izin veren kontrol noktaları ve geri alma mekanizmaları uygulanırken gereklidir.
Nesneleri önceki durumlarına geri döndürebilmek için durum bilgilerini bir yere kaydetmeniz gerekir.
Ancak nesneler normalde durumlarının bir kısmını veya tamamını kapsüller, bu da diğer nesneler için erişilemez hale getirir ve dışsal(external) olarak kaydedilmesini imkansız hale getirir.
Bu durumu açığa çıkarmak, kapsüllemeyi ihlal eder ve bu da uygulamanın güvenilirliğini ve genişletilebilirliğini tehlikeye atabilir.
Örneğin nesneler arasında bağlantıyı destekleyen bir grafik düzenleyiciyi düşünün. Bir kullanıcı iki dikdörtgeni bir çizgiyle birbirine bağlayabilir ve kullanıcı bunlardan herhangi birini hareket ettirdiğinde dikdörtgenler birbirine bağlı kalır.
Editör, bağlantıyı korumak için çizginin uzamasını sağlar.
![image](https://github.com/user-attachments/assets/f0072bb9-0c4a-4c5d-9564-88fc01736fde)

Nesneler arasındaki bağlantı ilişkilerini sürdürmenin bilinen bir yolu kısıtlama çözme(constraint-solving) sistemidir.
Bu işlevselliği bir ConstraintSolver nesnesi içerisinde kapsülleyebiliriz. ConstraintSolver, bağlantılar kuruldukça bunları kaydeder ve bunları tanımlayan matematiksel denklemler üretir.
Kullanıcı bir bağlantı kurduğunda veya diyagramı başka bir şekilde değiştirdiğinde bu denklemleri çözer.
ConstraintSolver, hesaplamalarının sonuçlarını kullanarak grafikleri yeniden düzenler ve böylece uygun bağlantıları korur.

Bu uygulamada geri almayı desteklemek göründüğü kadar kolay değildir. Bir taşıma(move) işlemini geri almanın bariz bir yolu, taşınan orijinal mesafeyi depolamak ve nesneyi eşdeğer bir mesafe geriye taşımaktır.
Ancak bu, tüm nesnelerin daha önce göründükleri yerde görüneceğini garanti etmez.
Bağlantıda biraz gevşeklik olduğunu varsayalım. Bu durumda, dikdörtgeni orijinal konumuna geri taşımak mutlaka istenen etkiyi sağlamayacaktır.

![image](https://github.com/user-attachments/assets/23d562e9-a816-4a7a-b91b-988027bbc9f9)



Genel olarak, ConstraintSolver'ın public interface'i, diğer nesneler üzerindeki etkilerinin tam olarak tersine çevrilmesine izin vermek için yetersiz olabilir.
Geri alma mekanizması, önceki durumu yeniden kurmak için ConstraintSolver ile daha yakın çalışmalıdır, ancak ConstraintSolver'ın iç işleyişini geri alma mekanizmasına maruz bırakmaktan da kaçınmalıyız.
Bu sorunu Memento patterni ile çözebiliriz. Bir memento, başka bir nesnenin - mementonun yaratıcısının(originator'unun) - iç durumunun anlık görüntüsünü saklayan bir nesnedir.
Geri alma mekanizması, originator'unun durumunu kontrol noktası olarak belirlemesi gerektiğinde originatordan bir memento talep edecektir. Originator, memento'yu, mevcut durumunu karakterize eden bilgilerle başlatır.
Sadece originator memento'dan bilgi depolayabilir ve alabilir— memento diğer nesnelere karşı "opaktır".

Az önce tartışılan grafiksel düzenleyici örneğinde, ConstraintSolver bir originator olarak davranabilir. Aşağıdaki olay dizisi geri alma işlemini karakterize eder:

1. Editör, taşıma işleminin bir yan etkisi olarak ConstraintSolver'dan bir memento ister.
2. ConstraintSolver bir memento oluşturur ve döndürür; bu durumda bir SolverState sınıfının bir örneğidir. Bir SolverState memento, ConstraintSolver'ın iç denklemlerini ve değişkenlerini tanımlayan veri yapılarını içerir.
3. Daha sonra, kullanıcı taşıma işlemini geri aldığında, düzenleyici SolverState'i ConstraintSolver'a geri verir.
4. ConstraintSolver, SolverState'deki bilgilere dayanarak iç yapısını değiştirir ve denklemlerini ve değişkenlerini önceki durumuna tam olarak geri döndürür.

Bu düzenleme, ConstraintSolver'ın önceki bir duruma geri dönmek için ihtiyaç duyduğu bilgileri diğer nesnelere emanet etmesine olanak tanır; bunu yaparken, kendi iç mimarisini ve temsillerini(representations) açığa çıkarmaz.

<h3>Applicability</h3>
Memento desenini şu durumlarda kullanın:
1. Bir nesnenin (veya bir kısmının) durumunun anlık görüntüsünün kaydedilmesi ve bu durumun daha sonra geri yüklenmesi gerektiğinde,
2. Durumu doğrudan elde etmek için kullanılacak bir arayüz, nesnenin gerçekleştirme detaylarını açığa çıkaracak ve nesnenin kapsülleme ilkesini bozacaksa.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/01a5bca8-865d-46d4-909e-60100a43962b)

<h3>Participants</h3>
1. Memento (SolverState)
Originator nesnesinin içsel(internal) durumunu depolar. Memento, kendi takdirine bağlı olarak gerekli olduğu kadar çok veya az miktarda originator'ın internal durumunu depolayabilir.
Originator dışındaki nesnelerin erişimine karşı koruma sağlar. Memento aslında iki arayüze sahiptir: 
Caretaker, Memento'ya dar bir arayüzden erişir; sadece Memento'yu diğer nesnelere iletebilir.
Originator, Memento'ya geniş bir arayüzden erişir ve bu arayüz sayesinde kendisini önceki durumuna geri yüklemek için gerekli tüm verilere erişebilir.
İdeal olarak, Memento'nun iç durumuna sadece onu oluşturan Originator erişebilmelidir.

2. Originator (ConstraintSolver)
Geçerli iç durumunun bir anlık görüntüsünü içeren bir Memento oluşturur.
İç durumunu geri yüklemek için Memento'yu kullanır.

3. Caretaker (undo mechanism)
Memento'nun güvende tutulmasından sorumludur. Hiçbir zaman Memento'nun içeriği üzerinde işlem yapmaz veya içeriğini incelemez.

<h3>Collaborations</h3>
Caretaker, originatordan memento ister, bir süre tutar ve originator'a geri verir, aşağıdaki etkileşim diyagramında gösterildiği gibi:

![image](https://github.com/user-attachments/assets/ccc5f734-3c75-40f1-b5d2-f92134e8244f)

Bazen caretaker, mementoyu originator'una geri vermez, çünkü originator'un daha önceki bir duruma geri dönmesine asla gerek kalmayabilir.
Mementolar pasiftir. Sadece bir mementoyu oluşturan originator, onun durumunu atayabilir veya geri alabilir.

<h3>Consequences</h3>
Memento tasarım deseni çeşitli sonuçlara sahiptir:
1. Kapsülleme sınırlarının korunması (Preserving encapsulation boundaries). Memento, yalnızca bir originator (başlatıcı) tarafından yönetilmesi gereken ancak yine de originator dışında saklanması gereken bilgilerin ifşa edilmesini önler. Bu desen, diğer nesneleri potansiyel olarak karmaşık Originator iç detaylarından korur ve böylece kapsülleme sınırlarını muhafaza eder.
2. Originator'ı basitleştirir (It simplifies Originator). Kapsüllemeyi koruyan diğer tasarımlarda, Originator, istemcilerin (clients) talep ettiği iç durum(internal state) versiyonlarını tutar. Bu durumda, tüm depolama yönetimi yükü Originator'ın üzerinde olur. Ancak istemcilerin talep ettikleri durumları kendilerinin yönetmesi, Originator'ı basitleştirir ve istemcilerin işleri bittiğinde originator'ı bilgilendirme zorunluluğunu ortadan kaldırır.
3. Mementoların kullanımı maliyetli olabilir (Using mementos might be expensive). Eğer Originator, mementoya büyük miktarda bilgi kopyalamak zorundaysa veya istemciler sık sık mementolar oluşturup originatora geri döndürüyorsa, mementolar önemli bir ek yük oluşturabilir. Originator durumunun kapsüllenmesi ve geri yüklenmesi ucuz değilse, bu desen uygun olmayabilir. Gerçekleştirme (Implementation) bölümünde artımlılık (incrementality) üzerine yapılan tartışmaya bakın.
4. Dar ve geniş arayüzlerin tanımlanması (Defining narrow and wide interfaces). Bazı programlama dillerinde, yalnızca originator'ın mementonun durumuna erişmesini sağlamak zor olabilir.
5. Mementolara özen gösterilmesindeki gizli maliyetler (Hidden costs in caring for mementos). Bir caretaker (bakıcı), sorumlu olduğu mementoları silmekle yükümlüdür. Ancak, caretaker mementonun içinde ne kadar durum bulunduğuna dair bir fikre sahip değildir. Bu nedenle, aksi halde hafif bir yapı olan bir caretaker, mementoları sakladığında büyük depolama maliyetleriyle karşılaşabilir.

<h3>Implementation</h3>
Memento desenini uygularken dikkate alınması gereken iki konu vardır:
1. Mementoların iki arayüzü vardır: Originator (başlatıcı) için geniş bir arayüz ve diğer nesneler için dar bir arayüz. İdeal olarak, kullanılan programlama dili iki seviyeli statik korumayı desteklemelidir(two levels of static protection). C++, Originator'ı Memento'nun bir dostu (friend) yaparak ve Memento'nun geniş arayüzünü özel (private) tanımlayarak bunu sağlar. Sadece dar arayüz genel (public) olarak tanımlanmalıdır. Örneğin:

//Wide(Geniş) Interface: Originator tarafından kullanılan ve memento'nun tam durumunu okuma veya değiştirme yetkisi sağlayan arayüzdür. Bu arayüz, yalnızca Originator sınıfı tarafından erişilebilir olmalıdır.
//Narrow Interface: Diğer nesnelere (örneğin caretaker) sunulan arayüzdür ve memento'nun iç durumuna erişimi kısıtlar. Bu arayüz, memento'yu yalnızca bir nesne olarak taşıma veya saklama işlemlerine olanak tanır.
//"Two levels of static protection," bu iki farklı erişim seviyesini programlama dilinin doğal araçlarıyla ayrıştırma yeteneğidir.
//Kitapta verilen örnek C++ dilindedir, çünkü C++ bu iki seviyeyi doğrudan destekleyen araçlara sahiptir: private erişim belirteci: Memento'nun iç durumunu (geniş arayüz) yalnızca Originator'ın erişebileceği şekilde sınırlar. friend anahtar kelimesi: Originator'ı Memento'nun bir dostu (friend) yaparak, Originator'ın memento'nun geniş arayüzüne erişmesine izin verir. Ancak diğer sınıflar, bu verilere erişemez.
//Bazı diller, bu seviyede statik korumayı desteklemeyebilir. Örneğin: Java: Java'da friend özelliği yoktur. Bunun yerine, memento'nun wide(geniş) arayüzünü Originator ile aynı pakete koyarak paket düzeyinde (package-private) erişim sağlanabilir. Ancak bu çözüm tam anlamıyla iki seviyeli koruma sağlamaz. Java'da Memento tasarım desenini bir inner class (iç sınıf) kullanarak uygulamak, geniş ve dar arayüzler arasındaki erişim kontrolünü yönetmek için oldukça etkili bir yöntemdir. Bu yaklaşım, two levels of static protection sorununu çözmek için güzel bir alternatiftir.

![image](https://github.com/user-attachments/assets/325ce01b-252a-4ec1-a149-7067254f360a)

2. Artımlı değişikliklerin saklanması (Storing incremental changes). Mementolar öngörülebilir bir sırayla oluşturulup originator’a geri döndürüldüğünde, Memento sadece originator’ın iç durumundaki artımlı değişikliği saklayabilir. Örneğin, bir geçmiş (history) listesinde geri alınabilir komutlar, komutların geri alındıklarında tam olarak aynı duruma döndürülmelerini sağlamak için mementoları kullanabilir (bkz. Command (233)). Geçmiş listesi, komutların hangi sırayla geri alınabileceğini ve yeniden yapılabileceğini tanımlar. Bu, mementoların her nesnenin tam durumunu saklamak yerine bir komutun yaptığı yalnızca artımlı değişikliği saklamasına olanak tanır. Daha önce verilen Motivasyon örneğinde, kısıt çözücü (constraint solver), dikdörtgenleri birleştiren çizgiyi korumak için yalnızca değişen iç yapıları saklayabilir; bu, bu nesnelerin mutlak konumlarını saklamaktan daha az maliyetlidir.


<h3>Related Patterns</h3>
Command (233): Komutlar (Commands), geri alınabilir (undoable) işlemler için durumu korumak amacıyla mementoları kullanabilir.
Iterator (257): Daha önce açıklandığı gibi, mementolar yineleme (iteration) için kullanılabilir.
