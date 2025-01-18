<h1>Mediator</h1>

<h3>Intent</h3>
Bir nesne kümesini kapsayan ve etkileşime giren bir nesne tanımlayın. Mediator(arabulucu), nesnelerin birbirlerine açıkça(explicitly) referans olmasını önleyerek loose coupling'i teşvik eder ve birbirleriyle olan etkileşimlerini(yani bağlantıları) bağımsız olarak değiştirmenize olanak tanır.

Define an object that encapsulate show a set of objects interact. Mediator promotes
loose coupling by keeping objects from referring to each other explicitly, and it
lets you vary their interaction independently.

//Arabulucu, herkesi tanıyan
![image](https://github.com/user-attachments/assets/c6eafa49-3810-4cf7-af3e-b73de5e2e9e8)

// Bu pattern kullanılmadan n*(n-1)/2 iletişim kanalı oluşması yerine, bu pattern ile n nesne için n tane iletişim kanal oluşturulur. 
// Many-to-many bağlantıları one-to-many şeklinde gerçekleştirilir.
// JPA, EntityFramework vb. ORM frameworklerinde kullanılan ve entityler ile RDBMS tabloları arasındaki eşleşmeleri yöneten Mapper nesneleri bir mediator gibi çalışır.
// .NET'da MediatR, istemciler arasındaki mesajlaşmayı merkezi bir şekilde yönetmek için Mediator kalıbını kullanan bir çerçevedir.

<h3>Motivation</h3>
Nesne yönelimli tasarım, davranışın nesneler arasında dağıtılmasını teşvik eder. Bu tip bir dağıtım, nesneler arasında çok sayıda bağlantıya sahip bir nesne mimarisiyle sonuçlanabilir; en kötü durumda, tüm nesneler diğer tüm nesneler hakkında bilgi sahibi olur.
Bir sistemi birçok nesneye bölmek genellikle yeniden kullanılabilirliği artırsa da, artan bağlantılar yeniden kullanılabilirliği azaltma eğilimindedir.
Çok sayıda bağlantı bir nesnenin başkalarının desteği olmadan çalışmasını daha az olası hale getirir, sistem monolithic'miş(tek parça) gibi davranır.
Ayrıca, davranış birçok nesne arasında dağıtıldığı için sistemin davranışını önemli bir şekilde değiştirmek zor olabilir.
Sonuç olarak sistemin davranışını özelleştirmek için birçok alt sınıf tanımlamak zorunda kalabilirsiniz.

Örnek olarak, grafiksel bir kullanıcı arayüzünde(GUI) dialog box'ların gerçekleştirilmesini ele alalım.
Bir dialog box, burada gösterildiği gibi butonlar, menüler ve entry field gibi bir dizi widget'ı sunmak için bir window kullanır:
![image](https://github.com/user-attachments/assets/f1cb6515-9a52-4f8b-957b-531a3b621b9f)

Diyalogdaki widget'lar arasında çoğunlukla bağımlılıklar(dependencies) vardır. Örneğin, belirli bir entry field boş olduğunda bir button devre dışı kalır.
Bir listbox seçim listesinde bir entry'nin seçilmesi, başka bir entry field'inin içeriğini değiştirebilir.
Tersine, entry fielda metin yazmak, listbox'daki bir veya daha fazla ilgili entry'i otomatik olarak seçebilir.
Entry fieldda, metin göründüğünde, kullanıcının metinle ilgili bir şeyler yapmasına izin veren diğer butonlar etkinleştirilebilir, örneğin, metinle ilgili şeyi değiştirmek veya silmek gibi.
Farklı dialog boxlar, widget'lar arasında farklı bağımlılıklara(dependencies) sahip olacaktır. Bu nedenle, dialog boxları aynı tipden widget'ları görüntülese bile, stok widget sınıflarını yeniden kullanamazlar; dialog box'a özgü bağımlılıkları yansıtacak şekilde özelleştirilmeleri gerekir.
Bunları alt sınıflara ayırarak tek tek özelleştirmek çok sıkıcı olacaktır, çünkü birçok sınıf söz konusudur.
Toplu olarak davranışları ayrı bir mediator nesnede kapsülleyerek bu sorunlardan kaçınabilirsiniz.
Mediator, bir grup nesnenin etkileşimlerini kontrol etmek ve koordine etmekten sorumludur. Mediator, gruptaki nesnelerin birbirlerine açıkça(explicitly) referansta bulunmasını engelleyen bir aracı(intermediary) görevi görür.
Nesneler yalnızca mediator'u tanır, böylece nesneler arasındaki bağlantıların sayısı azalır. Örneğin, FontDialogDirector bir dialog boxdaki widget'lar arasında mediator olabilir. 
FontDialogDirector nesnesi dialog boxdaki componentleri tanır ve etkileşimlerini koordine eder. Componentler için bir iletişim merkezi görevi görür:

![image](https://github.com/user-attachments/assets/ebcd4cc1-d0c9-4b1d-bba1-97ce8e007c8a)

Aşağıdaki etkileşim diyagramı(interaction diagram), nesnelerin bir listbox'un seçimindeki bir değişikliği işlemek için nasıl işbirliği yaptığını göstermektedir:
![image](https://github.com/user-attachments/assets/c5478f00-f5d9-426e-b114-18e71c306762)

İşte bir listbox'un seçiminin bir entry fielda geçmesini sağlayan olayların ardışıklığı:

1. Listbox, director'üne değiştiğini bildirir.
2. Director seçimi listboxdan alır.
3. Director seçimi entry field'a geçirir.
4. Artık entry field biraz metin içerdiğinden, director bir eylemi başlatmak için butonu/butonları etkinleştirir (örneğin, "demibold", "oblique").

Director'un listbox ile entry field arasında nasıl arabuluculuk ettiğine dikkat edin. Widget'lar birbirleriyle yalnızca dolaylı olarak, director aracılığıyla iletişim kurarlar.
Birbirleri hakkında bilgi sahibi olmaları gerekmez; bildikleri tek şey director'dur. Dahası, davranış bir sınıfta yerelleştirildiği için, o sınıf genişletilerek değiştirilebilir veya yerine başka bir sınıf getirerek değiştirilebilir.
FontDialogDirector soyutlamasının bir sınıf kütüphanesine(class library) nasıl entegre edilebileceği aşağıda açıklanmıştır.

![image](https://github.com/user-attachments/assets/8e8fb757-6dbb-4124-8e07-23a9c4cb2759)


DialogDirector, bir dialog box'un genel davranışını tanımlayan soyut bir sınıftır. Clientler, ekranda diyaloğu görüntülemek için ShowDialog operasyonunu çağırır. CreateWidgets(), bir diyaloğun widget'larını oluşturmak için soyut bir operasyondur.
WidgetChanged başka bir soyut operasyondur; widget'lar directorlarına değiştiklerini bildirmek için bunu çağırırlar.
DialogDirector alt sınıfları, uygun widget'ları oluşturmak için CreateWidgets() operasyonunu override eder ve değişiklikleri işlemek için WidgetChanged operasyonunu override eder.

<h3>Applicability</h3>
Mediator patternini şu durumlarda kullanın:

1. bir nesne kümesi iyi tanımlanmış ancak karmaşık yollarla iletişim kurar. Ortaya çıkan karşılıklı bağımlılıklar yapılandırılmamış ve anlaşılması zordur.
2. Bir nesne vardır ve bunu yeniden kullanmak zordur çünkü birçok başka nesneye referansta bulunur ve onlarla iletişim kurar.
3. Birkaç sınıf arasında dağıtılan bir davranış, çok fazla alt sınıflandırmaya gerek kalmadan özelleştirilebilir olmalıdır.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/740503e2-0644-4c0a-8862-b0521b5526ac)


<h3>Participants</h3>
1. Mediator (DialogDirector)
Colleague nesneleriyle iletişim kurmak için bir arayüz tanımlar.

2. ConcreteMediator (FontDialogDirector)
Colleague nesnelerini koordine ederek işbirlikçi davranışı gerçekleştirir. Colleague'ları tanır ve maintain eder.

3. Colleague classes (ListBox, EntryField)
Her Colleague sınıfı kendi Mediator nesnesini bilir. Her Colleague, başka bir colleague ile(meslektaşıyla) iletişim kurabileceği zaman mediatoru ile iletişim kurar.

<h3>Collaborations</h3>
Coleague'lar bir Mediator nesnesinden requestler gönderir ve alır. Mediator, requestleri uygun coleague'lar(meslektaşlar) arasında yönlendirerek işbirlikçi davranışı gerçekleştirir.

<h3>Consequences</h3>
Mediator patterninin aşağıdaki avantajları ve dezavantajları vardır:

1. Alt sınıflandırmayı sınırlar. Bir mediator, aksi takdirde birkaç nesne arasında dağıtılacak olan davranışı tek bir sınıfta yerelleştirir. Bu davranışı değiştirmek için yalnızca Mediator'un alt sınıflandırması gerekir; Colleague(Meslektaş) sınıfları olduğu gibi yeniden kullanılabilir.
2. Colleague'ları decouple eder(bağımlılıkların azaltılması). Bir mediator, colleaguelar arasında loose coupling(gevşek birleşmeyi) teşvik eder. Colleague ve Mediator sınıflarını bağımsız olarak değiştirebilir ve yeniden kullanabilirsiniz.
3. Nesne protokollerini basitleştirir. Bir mediator, many-to-many etkileşimleri, mediator ile colleaguelar arasındaki one-to-many etkileşimlerle değiştirir. One-to-many ilişkilerin anlaşılması, sürdürülmesi ve genişletilmesi daha kolaydır.
4. Nesnelerin nasıl işbirliği yaptığını soyutlar. Arabuluculuğu bağımsız bir kavram haline getirmek ve onu bir nesneye kapsüllemek, nesnelerin bireysel davranışlarından ayrı olarak nasıl etkileşime girdiğine odaklanmanızı sağlar. Bu, nesnelerin bir sistemde nasıl etkileşime girdiğini netleştirmeye yardımcı olabilir.
5. Kontrolü merkezileştirir. Mediator design pattern, etkileşimin karmaşıklığını mediatordaki karmaşıklıkla değiştirir. Bir mediator protokolleri kapsadığı için, herhangi bir colleague'dan daha karmaşık hale gelebilir. Bu, mediatorun kendisini bakımı zor bir monolit haline getirebilir.

<h3>Implementation</h3>
Mediator deseniyle ilgili gerçekleştirme sorunları:
1. Soyut Mediator sınıfını atlamak. Colleague'lar sadece bir mediator ile çalışabiliyorsa soyut bir Mediator sınıfı tanımlamaya gerek yoktur. Mediator sınıfının sağladığı soyut bağlantı, colleagueların farklı Mediator alt sınıflarıyla çalışmasına ve bunun tersinin de geçerli olmasına olanak tanır.
2. Colleague-Mediator iletişimi. Colleague'lar, ilgi duydukları bir olay meydana geldiğinde arabuluculurayıla iletişim kurmak zorundadır. Bir yaklaşım, Observer (293) modelini kullanarak Mediatoru Observer olarak gerçekleştirmektir. Colleague sınıfları Özneler(Subjects) olarak hareket eder ve durumlarını değiştirdikleri her zaman arabulucuya bildirimler gönderir. Mediator, değişikliğin etkilerini diğer colleaguelara yayarak yanıt verir. Başka bir yaklaşım, Mediatorda colleagueların iletişimlerinde daha doğrudan olmalarını sağlayan özel bir bildirim arayüzü(notification interface) tanımlar.
   Windows için Smalltalk/V bir tür delege etme kullanır: Aracıyla iletişim kurarken, bir meslektaş kendisini bir argüman olarak iletir ve aracının göndereni tanımlamasına izin verir. Örnek Kod(Sample Code section) bu yaklaşımı kullanır ve Smalltalk/V uygulaması Bilinen Kullanımlar bölümünde daha ayrıntılı olarak ele alınmıştır.

<h3>Related Patterns</h3>
Facade (185), daha kullanışlı bir arayüz sağlamak için nesnelerin bir alt sistemini soyutlaması bakımından Mediator'dan farklıdır.
Protokolü tek yönlüdür; yani, Facade nesneleri alt sistem sınıflarına istekte bulunur ancak tersi olmaz.
Bunun aksine, Mediator meslektaş nesnelerinin sağlamadığı veya sağlayamadığı işbirlikçi davranışı etkinleştirir ve protokol çok yönlüdür.
Meslektaşlar, Observer (293) patternini kullanarak arabulucuyla iletişim kurabilirler.



