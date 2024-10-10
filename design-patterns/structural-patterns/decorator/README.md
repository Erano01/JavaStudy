<h1>Decorator</h1>

<h3>Intent</h3>
Bir nesneye dinamik olarak ek sorumluluklar eklemenize olanak sağlar. Decoratorler, fonksiyonelliği genişletmek için alt sınıflandırmaya esnek bir alternatif sunar.

<h3>Also Known As</h3>
Wrapper
//individual objects = bazı instance nesnelerine

<h3>Motivation</h3>
<p>
Bazen sorumlulukları tüm bir sınıfa değil, tek tek nesnelere eklemek isteriz. Örneğin, bir GUI toolkit'i , herhangi bir UI componentine kenarlıklar(border) veya kaydırma(scrolling) gibi özellikler eklemenize izin vermelidir.

Sorumluluk eklemenin bir yolu da mirasdır(inheritance). Başka bir sınıftan border devralmak, her alt sınıf örneğinin etrafına bir border koyar. Bu esnek değildir, herneyse border seçimi statik olarak yapılır. Bir client, componenti bir borderla nasıl ve ne zaman dekore edeceğini kontrol edemez.

Daha esnek bir yaklaşım, componenti border ekleyen başka bir nesnenin içine yerleştirmektir. Çevreleyen nesneye(enclosing object) dekoratör denir
Dekoratör, dekore ettiği componentin arayüzüne uyum sağlar, böylece varlığı componentin clientleri için şeffaf olur.
Dekoratör, requestleri componente iletir ve iletmeden önce veya sonra ek eylemler (örneğin, border(kenarlık) çizme) gerçekleştirebilir.
Şeffaflık(transparency), dekoratörleri recursive olarak iç içe yerleştirmenize olanak tanır ve böylece sınırsız sayıda ek sorumluluk sağlar.
</p>
![image](https://github.com/user-attachments/assets/e4471b52-3768-49bc-80dd-4370647fb437)
<p>
Örneğin, bir pencerede metin görüntüleyen bir TextView nesnemiz olduğunu varsayalım. 
TextView'de varsayılan olarak scrollbar'lar yoktur, çünkü bunlara her zaman ihtiyacımız olmayabilir.
Bunu yaptığımızda, bunları eklemek için bir ScrollDecorator kullanabiliriz. Diyelim ki TextView'ın etrafına kalın siyah bir kenarlık eklemek istiyoruz
Bunu eklemek için BorderDecorator'ı da kullanabiliriz. İstenilen sonucu üretmek için dekoratörleri TextView ile birleştiririz.
Aşağıdaki nesne diyagramı, border'a sahip, scrollbar'lı bir TextView üretmek için BorderDecorator ve ScrollDecorator nesneleriyle bir TextView nesnesinin nasıl oluşturulacağını gösterir:
</p>
![image](https://github.com/user-attachments/assets/1dc14b40-c690-4112-8f1a-0d6aa71efec2)
<p>
ScrollDecorator ve BorderDecorator sınıfları, diğer görsel componentleri dekore eden görsel componentler için soyut bir sınıf olan Decorator'ın alt sınıflarıdır.
</p>
![image](https://github.com/user-attachments/assets/7f7649c4-94b4-42f8-a0ae-0be2c816a7b0)
<p>
VisualComponent görsel nesneler için soyut sınıftır. Çizimlerini ve event handling arayüzlerini tanımlar. 
Dekoratör sınıfının draw requestlerini nasıl basitçe componentine ilettiğine ve Dekoratör alt sınıflarının bu operasyonu nasıl genişletebileceğine dikkat edin.
Dekoratör alt sınıfları belirli fonksyionlar için operasyonlar eklemekte özgürdür.
Örneğin, ScrollDecorator'ın scrollTo operasyonu, arayüzde bir ScrollDecorator nesnesi olduğunu bildikleri takdirde diğer nesnelerin arayüzü kaydırmasına izin verir.
Bu desenin önemli tarafı, dekoratörlerin bir VisualComponent'in erişebildiği her yerde görünmesine izin vermesidir.
Bu sayede clientler genellikle dekore edilmiş bir parça ile dekore edilmemiş bir parça arasındaki farkı ayırt edemiyor ve dolayısıyla dekorasyona hiç bağımlı kalmıyorlar.
</p>
<h3>Applicability</h3>
Şu durumlarda dekoratör kullan:
• Bazı instance nesnelere dinamik ve şeffaf bir şekilde, yani diğer nesneleri etkilemeden sorumluluklar eklemen gerekiyorsa.
• Geri alınabilen sorumluluklar yükleyebilmek için.
• Alt sınıflar ile genişletmenin pratik olmadığı durumlarda. Bazen, çok sayıda bağımsız genişletme mümkündür ve her kombinasyonu desteklemek için bir alt sınıf patlaması yaratabilir. Ya da bir sınıf tanımı gizlenmiş olabilir veya alt sınıf oluşturma için kullanılamaz durumda olabilir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/2b8d555f-b2c3-42c9-8e7c-1b2b8da8fc90)

<h3>Participants</h3>
• Component (VisualComponent)
   ◇ Sorumlulukların dinamik olarak eklenebileceği nesneler için bir arayüz tanımlar.
• ConcreteComponent (TextView)
   ◇ Ek sorumlulukların eklenebileceği bir nesneyi tanımlar.
• Decorator
   ◇ Bir Component nesnesine referans tutar ve Component'in arayüzüne uygun bir arayüz tanımlar.
• ConcreteDecorator (BorderDecorator, ScrollDecorator)
   ◇ Component'e sorumluluklar ekler.

<h3>Collaborations</h3>
Decorator, istekleri Component nesnesine iletir. İsteği iletmeden önce ve sonra isteğe bağlı olarak ek işlemler gerçekleştirebilir.

<h3>Consequences</h3>
Decorator deseni en az iki önemli fayda ve iki soruna sahiptir:

1. Statik kalıtımdan daha fazla esneklik
   Decorator deseni, statik (çoklu) kalıtım kullanarak nesnelere sorumluluklar eklemekten daha esnek bir yol sunar. Decorator ile sorumluluklar runtime'da eklenip çıkarılabilir, sadece onları iliştirip ayırarak. Buna karşılık, kalıtım her ek sorumluluk için yeni bir sınıf oluşturulmasını gerektirir (örneğin, BorderedScrollableTextView, BorderedTextView). Bu da çok sayıda sınıf oluşturulmasına ve sistemin karmaşıklığının artmasına yol açar. Ayrıca, belirli bir Component sınıfı için farklı Decorator sınıfları sağlamak, sorumlulukları karıştırıp eşleştirmenize olanak tanır. Decorator'lar aynı özelliği iki kez eklemeyi de kolaylaştırır. Örneğin, bir TextView'e çift kenarlık vermek için sadece iki BorderDecorator ekleyin. Bir Border sınıfından iki kez türetmek en iyi ihtimalle hataya açıktır.

2. Hiyerarşinin üst kısımlarında özellik yüklü sınıflardan kaçınma
   Decorator, sorumluluk eklemek için kullanıcının sadece ihtiyacı olanı ödediği (pay-as-you-go) bir yaklaşım sunar. Bütün öngörülebilir özellikleri desteklemeye çalışan karmaşık ve özelleştirilebilir bir sınıf yerine, basit bir sınıf tanımlayabilir ve işlevselliği Decorator nesneleriyle kademeli olarak ekleyebilirsiniz. İşlevsellik basit parçalar halinde birleştirilebilir. Sonuç olarak, bir uygulama kullanmadığı özellikler için ödeme yapmak zorunda kalmaz. Ayrıca, genişlettikleri nesnelerin sınıflarından bağımsız olarak yeni türde Decorator'lar tanımlamak kolaydır, hatta öngörülemeyen genişletmeler için bile. Karmaşık bir sınıfı genişletmek, eklemeye çalıştığınız sorumluluklarla ilgisiz ayrıntıları açığa çıkarmaya eğilimlidir.

3. Bir decorator ve componenti aynı değildir
   Bir decorator, şeffaf bir kaplama gibi hareket eder. Ancak nesne kimliği açısından bakıldığında, dekore edilmiş bir component, componentin kendisiyle aynı değildir. Bu yüzden, decorator kullanırken nesne kimliğine güvenmemelisiniz.

4. Çok sayıda küçük nesne
   Decorator desenini kullanan bir tasarım, genellikle birbirine benzeyen çok sayıda küçük nesneden oluşan sistemlere yol açar. Nesneler sadece birbirleriyle nasıl bağlantılı oldukları açısından farklılık gösterirler, sınıfları ya da değişkenlerinin değerleri açısından değil. Bu tip sistemler özelleştirilebilir olsa da, çok fazla küçük nesne olması sistemi yönetmeyi zorlaştırabilir.

<h3>Related Patterns</h3>
• Adapter (139): Bir decorator, bir adapter'den farklıdır çünkü decorator yalnızca bir nesnenin sorumluluklarını değiştirir, arayüzünü değil. Oysa bir adapter, bir nesneye tamamen yeni bir arayüz sağlar.
• Composite (163): Bir decorator, yalnızca bir componenti olan bir "dejenere edilmiş" composite olarak görülebilir. Ancak, bir decorator ek sorumluluklar ekler — nesnelerin bir araya getirilmesi (aggregation) için tasarlanmamıştır.
• Strategy (315): Bir decorator, bir nesnenin dış görünüşünü (skin) değiştirmenizi sağlar; bir strategy ise iç işleyişini (guts) değiştirir. Bu, bir nesneyi değiştirmenin iki alternatif yoludur.





