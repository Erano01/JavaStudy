<h1>Command</h1>

<h3>Intent</h3>
Bir isteği bir nesne olarak sarmala(encapsulate), böylelikle farklı isteklere, kuyruk(queue) ve log isteklerine sahip clientleri parametrik hale getir ve geri alma işlerini destekle.

//bilmediğin nesneden, bilmediğin bir iş yapmasını istemek. Örneğin bir kişinin başka birine verdiği borcun nasıl değerlendirildiğini o paranın nereye gideceğini bilmemesidir. Misal bizim tarafımızdan verilen borç, borcu alan kişinin vergi borcu için vergi dairesine ödenebilmesi.

//Yada başka bir örnek vermek gerekirse UI frameworkleri button ya da menu gibi nesnelere sahiptir, ama framework bu nesnelerin tıklandığında ya da seçildiğinde yapacağı işleri bilmediğinden, bu nesnelere gelen istekleri yerine getiremez. Ancak bu frameworkü kullanan uygulamalar bir button tıklandığında ne olması gerektiğini bilebilir.

<h3>Also Known As</h3>
Action, Transaction

<h3>Motivation</h3>
Bazen, request edilen operasyon veya request'in receiver'i hakkında hiçbir şey bilmeden nesnelere requestte bulunmak gerekir.
Örneğin, kullanıcı arayüzü toolkitleri, kullanıcı girdisine yanıt olarak bir requesti gerçekleştiren buttonlar ve menüler gibi nesneleri içerir.
Ancak toolkit, requesti buttonda veya menüde açıkça(explicitly) gerçekleştiremez, çünkü yalnızca toolkit'i kullanan uygulamalar hangi nesne üzerinde ne yapılması gerektiğini bilir.
Toolkit tasarımcıları olarak, request'in receiverini veya onu gerçekleştirecek operasyonları bilmemizin bir yolu yoktur.

Command patterni, toolkit nesnelerinin(button, menu etc) bilinmeyen uygulama nesnelerine(toolkit nesnelerinin etki edeceği şeyler), request'in kendisini bir nesneye dönüştürerek requestte bulunmasını sağlar. Bu nesne diğer nesneler gibi saklanabilir(store) ve geçilebilir(passing into something maybe methods etc). 
Bu patternin anahtarı, operasyonları execute etmek için bir arayüz tanımlayan soyut bir Command sınıfıdır. En basit haliyle bu arayüz soyut bir Execute operasyonu içerir.
Somut Command alt sınıfları, receiver'i bir instance değişkeni olarak depolayarak ve requesti çağırmak için Execute'ü gerçekleştirerek bir receiver-action pair'i belirtir.
Receiver, talebi yerine getirmek için gereken bilgiye sahiptir.

//alıcı -> receiver
//istek -> request
//işlem -> method/operation

![image](https://github.com/user-attachments/assets/2fe1a0b0-d916-4e32-a0b8-49fd5b91ea30)


Menüler, Command nesneleriyle kolay bir şekilde gerçekleştirilebilir. Menu'deki her bir seçim MenuItem sınıfının bir örneğidir.
Application sınıfı bu menuleri yaratır ve menu itemlerini kullanıcı arayüzünün geri kalanıyla birlikte oluşturur.
Application sınıfı ayrıca bir kullanıcının açtığı Document nesnelerinide takip eder.

Uygulama her bir MenuItem'i Command arayüzünü gerçekleştiren somut bir alt sınıf instance'i ile konfigure eder.
Kullanıcı MenuItem'i seçtiğinde MenuItem, somut instance üzerindeki execute operasoynunu çağırır(call) ve sonrasını bu execute operasyonu halleder.
MenuItem'ları hangi Command alt sınıfını kullandığını bilmez. Command alt sınıfları request'in receiverını depolar ve bir veya daha fazla operasyonu receiver üzerinde çağırır(invoke).

Misal, PasteCommand clipboard'da bulunan bir text'i yani metini Document üzerine yapıştırabilmesini destekler.
PasteCommand'ın receiver'i instance oluşturma sırasında kendisine sağlanan Document nesnesidir.
Execute operasyonu sağlanan Document üzerinde Paste'i çağırır(invokes). 

// receiving = sağlanan/alınmış

![image](https://github.com/user-attachments/assets/b5263e4f-9752-4019-a8b5-878263f35a9c)


OpenCommand'ın Execute operasyonu farklıdır:
belge adı için kullanıcıya istekte bulunur, karşılık gelen bir Document nesnesi oluşturur, belgeyi sağlanan uygulamaya ekler, ve belgeyi açar.
 
![image](https://github.com/user-attachments/assets/7aaa28b5-be68-450d-bb5b-9e369f37b86c)


Bazen MenuItem bir dizi commandı execute etmelidir. Örneğin, bir sayfayı normal boyutta ortalamak için bir MenuItem CenterDocumentCommand nesnesinden ve NormalSizeCommand nesnesinden oluşturulabilir.
Komutları bu şekilde bir araya getirmek yaygın olduğundan, MenuItem'in açık-uçlu sayıda komutu yürütmesine izin vermek için bir MacroCommand sınıfı tanımlayabiliriz.

MacroCommand bir dizi Command'ı yürüten bir somut Command alt sınıfıdır. MacroCommand explicit yani açıkça yani doğrudan belirtilmiş bir receiveri yoktur, çünkü bu bir dizi komut kendi receiverlarını tanımlarlar.

![image](https://github.com/user-attachments/assets/7ba37bc5-8b19-477e-bfa8-fcb09e6d9e49)


Bu örneklerin herbirinde, Command pattern'in operasyonu çağıran nesneyi, onu gerçekleştirme bilgisine sahip olan nesneden nasıl decouple ettiğine dikkat edin.
Bu kullanıcı arayüzümüzü tasarlamada bize çok fazla esneklik sağlar. 
Bir uygulama, menü ve button'ı aynı somut Command alt sınıfının örneğini paylaşması yoluyla bir özelliğe hem menu hemde button arayüzü sağlayabilir 
Komutları dinamik olarak değiştirebiliriz bu da context-sensitive menüleri gerçekleştirmek için yararlı olacaktır.

Ayrıca commandları bir araya getirerek daha büyük commandlar oluşturarak command scripting'e destek sağlayabiliriz.
Tüm bunlar mümkün çünkü bir requestte bulunan nesnenin yalnızca nasıl yapılacağını bilmesi gerekir; requestin nasıl gerçekleştirileceğini bilmesi gerekmez.

<h3>Applicability</h3>
Command patterni şu durumlarda kullanın:

• Nesneleri gerçekleştirilecek bir eyleme(action) göre paremetrelendirmek gerekiyorsa, Yukarıda Menultem nesnelerinin yaptığı gibi.
   Bu tür parametrelendirmeleri, callback fonksiyonuyla, yani daha sonra bir noktada çağrılması üzerine bir yerde registered fonskyionla, prosedürel paradigmaya sahip bir dilde ifade edebilirsiniz. Komutlar, callback'lerin oop bir alternatifidir.

• Requestleri farklı zamanlarda belirtin, sıraya koyun(queue) ve yürütün(execute). Bir Command nesnesi orjinal request'dan bağımsız bir lifetime(yaşama süresine) sahip olabilir. 
   Bir request'in receiveri adress space-independent şekilde temsil edilebiliyorsa, o zaman request için bir command nesnesini farklı bir işleme aktarabilir ve requesti orada yerine getirebilirsiniz.

• Geri almayı(undo) desteklemek gerekiyorsa. Command'ın execute operasyonu, etkilerinin tersine çevrilmesi için command'ın kendisinde state depolayabilir. Command arayüzünde, execute operasyonuna önceki yapılan çağrının(call) etkilerini tersine çeviren bir unexecute operasyonu eklenmiş olmalıdır.
   Yürütülen komutlar bir history list'de saklanır. Sınırsız düzeyde geri alma(undo) ve yeniden yapma(redo) bu listeyi ileri geri dolaşarak sırasıyla unexecute ve execute operasyonlarını çağırarak elde edilir.

• Sistem çökmesi durumunda yeniden uygulanabilmeleri için değişiklerin loglanmasını destekler. Command arayüzünü load ve store operasyonlarıyla zenginleştirerek değişikliklerin kalıcı bir kaydını tutabilirsiniz(logging).
   Crash durumundan kurtarma, loglanmış komutların diskden yeniden yüklenmesini ve bunların execute operasyonuyla yeniden yürütülmesini içerir.

• Primitive operasyonlar üzerine kurulu high-level operasyonlar etrafında bir sistem mimarisi oluşturabilmek.
   Bu tipte bir mimari, transaction'ları destekleyen bilgi sistemlerinde(information systems) yaygındır. Bir transaction, datalarda yapılan bir dizi değişikliği encapsulate eder.  Command pattern, transaction'ları modellemenin bir yolunu sunar. Command'lar ortak bir arayüze sahiptir ve tüm transactionları aynı şekilde çağırmanıza(invoke) olanak tanır. Bu pattern ayrıca sistemin yeni transactionlarla genişletilmesini kolaylaştırır. 

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/e508ecdc-1a17-4316-b38b-2eac21495a81)


<h3>Participants</h3>
• Command
   ◇ Operasyonu yürütebilmek için arayüz tanımlar.
• ConcreteCommand (PasteCommand, OpenCommand)
   ◇ Receiver nesnesi ile bir eylem(action) arasında bir bağlama(binding) tanımlar.
   ◇ Receiver üzerinde ilgili operasyonu(operasyonları) çağırarak(invoke) execute operasyonunu gerçekleştirir.
• Client (Application)
   ◇ ConcreteCommand nesnesini oluşturur ve receiverini set eder.
• Invoker (MenuItem)
   ◇ Request'in yerine getirilmesi için komut ister.
• Receiver (Document, Application)
   ◇ Bir request'in gerçekleştirilmesiyle ilişkili operasyonların nasıl gerçekleştirileceğini bilir. Herhangi bir sınıf Receiver olarak hizmet verebilir.

<h3>Collaborations</h3>
• Client, ConcreteCommand nesnesini oluşturur ve receiver'ini ayarlar. 
• Invoker nesnesi ConcreteCommand nesnelerini depolar.
• Invoker, komut üzerinde execute operasyonunu çağırarak bir request gönderir. Komutlar geri alınamaz olduğunda, ConcreteCommand, execute operasyonunu çağırmadan önce komutu geri almak için durumu depolar.
• ConcreteCommand nesnesi, requesti gerçekleştirmek için receiver'inda operasyonları çağırır(invokes).

Aşağıdaki diyagram bu nesneler arasındaki etkileşimleri gösterir. Command'ın invokeri receiverdan (ve gerçekleştirdiği requestden) nasıl decouple ettiğini gösterir.
![image](https://github.com/user-attachments/assets/ef3dd6d9-9cce-4d9f-afcc-44e94eb247f7)


<h3>Consequences</h3>
Command patternin aşağıdaki sonuçları vardır:

1. Command patterni, operasyonu çağıran(invoke eden) nesneyi operasyonu nasıl gerçekleştireceğini bilen nesneden ayırır.
2. Komutlar first-class nesnelerdir. Herhangi bir nesne gibi manipule edilebilir ve genişletilebilirler.
3. Komutları composite(bileşik) komuta birleştirebilirsiniz(assemble). Bir örnek, daha önce açıklanan MacroCommand sınıfıdır. Genel olarak, composite komutlar Composite(163) patterninin instance'idir.
4. Yeni komutlar eklemek kolaydır, çünkü var olan sınıfları değiştirmenize gerek kalmaz.

<h3>Related Patterns</h3>
Composite(163), MacroCommand'lar gerçekleştirmek için kullanılabilir.
Memento(283), command'ın kendi etkisini geri almak için ihtiyaç duyduğu durumu saklayabilir. 
Command'ın History list'a eklenmeden önce kopyalanması gereken durumda Prototype(117) kullanılabilir.

//Command Pattern'de history list (geçmiş listesi), uygulamada gerçekleştirilen komutların kaydedildiği bir listedir. Bu liste, kullanıcının veya sistemin geri alma (undo) ve yineleme (redo) işlemlerini yapabilmesi için önemlidir. History list’e eklenen her komut, zamanla bir işlem geçmişi oluşturur ve gerektiğinde liste üzerinden geriye gidilerek her bir komutun etkisi tersine çevrilebilir (undo) veya ileri gidilerek yeniden uygulanabilir (redo).
//Komut nesnelerinin aynı özelliklere sahip kopyalarının oluşturulabilmesi, işlemlerin tekrarlanabilir ve geçmişte saklanabilir olmasını sağlar.










