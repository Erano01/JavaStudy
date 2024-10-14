<h1>Chain Of Responsibility</h1>

<h3>Intent</h3>
İsteği yerine getirmek üzere birden fazla nesneye şans vererek, isteğin göndericisini(sender'ini) alıcısına(receiver'ina) bağımlı hale getirmekten kaçının.
İsteği alan nesneleri zincire koyup isteği yerine getiren nesneyi buluncaya kadar zincir boyunca dolaştır.

Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

//receiver -> alıcı
//sender -> gönderici
//request -> istek
//successor -> halefi/varacağı nokta/ handle edileceği yer

<h3>Motivation</h3>
GUI için context-sensitive bir yardım olanağı düşünün. Kullanıcı, arayüzün herhangi bir kısmı hakkında sadece tıklayarak yardım bilgisi alabilir.
Sağlanan yardım, seçilen arayüzün parçasına ve context'ine bağlıdır; örneğin, bir dialog box'daki bir button widget'i, main window'daki benzer bir buttondan farklı yardım bilgilerine sahip olabilir.
Arayüzün o kısmı için belirli bir yardım bilgisi yoksa, yardım sistemi, örneğin, dialog box'un tamamı gibi, yakın context hakkında daha genel bir yardım mesajı görüntülemelidir.

Bu nedenle yardım bilgilerini genelliğine göre düzenlemek doğaldır - en spesifikten en geneline. 
Ayrıca, bir yardım isteğinin birkaç kullanıcı arayüzü nesnesinden biri tarafından handle edildiğini buradan anlamalıyız; hangisinin context'inin ne kadar spesifik olduğu ve mevcut yardımın ne kadar spesifik olduğuna bağlıdır.

Buradaki sorun, yardımı nihayetinde sağlayacak nesnenin, yardım isteğini başlatan nesne (örneğin button) tarafından açıkça(explicitly) bilinmemesidir.
İhtiyacımız olan şey, yardım isteğini başlatan buttonu, yardım bilgisi sağlayabilecek nesnelerden bağımlılığını kaldırmanın(decoupling the button) bir yoludur.
Chain of Responsibility pattern'i bunun nasıl gerçekleştiğini tanımlar.

Bu desenin fikri, birden fazla nesneye bir isteği işleme şansı vererek göndericileri ve alıcıları bağımlılıklarını birbirinden ayırmaktır(decouple).
İstek, nesnelerden biri onu işleyene kadar bir nesne zinciri boyunca iletilir.

![image](https://github.com/user-attachments/assets/00abf4bd-8d42-4e87-9d7b-10fee68875af)

Zincirdeki ilk nesne isteği alır ve ya onu işler ya da zincirdeki bir sonraki adaya iletir, o da aynısını yapar.
İsteği yapan nesnenin, isteği kimin ele alacağına dair açık bir bilgisi yoktur; isteğin örtük bir alıcısı(implicit receiver'i) olduğunu söyleriz.

Kullanıcının yardım için "Print" olarak işaretlenmiş bir button widget'ına tıkladığını varsayalım.
Button, ait olduğu uygulama nesnesini bilen bir PrintDialog örneğinde yer alır (önceki nesne diyagramına bakın).
Aşağıdaki etkileşim diyagramı yardım talebinin zincir boyunca nasıl iletildiğini göstermektedir:

![image](https://github.com/user-attachments/assets/3ec50b76-bf2c-43d8-83a0-03cff304ee53)

Bu durumda, ne aPrintButton ne de aPrintDialog isteği işlemez; isteği işleyebilen veya istenirse görmezden gelebilen anApplication'da durur.
İsteği gönderen client'in, isteği nihayetinde yerine getiren nesneye doğrudan bir referansı yoktur.

İsteği zincir boyunca iletmek ve alıcıların örtük(implicit) kalmasını sağlamak için, zincirdeki her nesne, istekleri işlemek ve zincirdeki varacağı nokta yani handle edileceği yere erişmek için ortak bir arayüzü paylaşır.
Örneğin, yardım sistemi, HandleHelp işlemine karşılık gelen bir HelpHandler sınıfı tanımlayabilir. HelpHandler aday(candidate) nesne sınıfları için üst sınıf olabilir veya bir mixin sınıfı olarak tanımlanabilir.

//mixin sınıf demek o sınıf ile doğrudan kalıtım yoluyla bir bağlantı kurulmadan o sınıfın methodlarını sanki arada bir kalıtım ilişkisi varmış gibi kullanmaktır.

Daha sonra yardım isteklerini işlemek isteyen sınıflar HelpHandler'ı bir üst sınıf yapabilir:

![image](https://github.com/user-attachments/assets/230ea32b-32f3-4c0d-ba42-0d48a12f3cf2)

Button,Dialog ve Application sınıfları yardım isteklerini işlemek için HelpHandler işlemlerini kullanır. HelpHandler'ın HandleHelp işlemi isteği varsayılan olarak halefine(successor) iletir.
Alt sınıflar, doğru koşullar altında yardım sağlamak için bu işlemi override edebilir; aksi takdirde isteği iletmek için varsayılan gerçekleştirmeyi kullanabilirler.

<h3>Applicability</h3>
Aşağıdaki durumlarda Chain of Responsibility kullanın
• birden fazla nesne bir isteğini handle edebiliyorsa ve handler bilgisi yoksa. Handler otomatik olarak belirlenmeliyse.
• Alıcıyı(receiver'i) açıkça(explicitly) belirtmeden birkaç nesneden birine bir istek göndermek istiyorsanız.
• Bir isteği handle edecek nesnelerin kümesi dinamik olarak belirtilmişse.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/4c659099-2961-4d39-bf24-dc84db73290a)
Tipik nesne mimarisi şu şekilde görünebilir:
![image](https://github.com/user-attachments/assets/391d4c2e-d8eb-4934-9e84-cb1b12103fd6)

<h3>Participants</h3>
• Handler (HelpHandler)
   ◇ Requestlerin handle edilebilmesi için arayüz tanımlar.
   ◇ (opsiyonel) successor link gerçekleştirir.
• ConcreteHandler (PrintButton, PrintDialog)
   ◇ requestleri handle etmekten sorumludur.
   ◇ kendi successor'una erişebilir.
   ◇ ConcreteHandler requesti handle edebiliyorsa, ki bunu yapıyor; aksi taktirde requesti successor'una yönlendirir.
• Client
   ◇ Zincirde bulunan bir ConcreteHandler nesnesine request başlatır.

<h3>Collaborations</h3>
Client bir istek gönderdiğinde, istek zincir boyunca yayılır ve bir ConcreteHandler nesnesi bunu işleme sorumluluğunu üstlenir.

<h3>Consequences</h3>
Chain of Responsibility'nin aşağıdaki faydaları ve sakıncaları vardır:

1. Azaltılmış Coupling. Bu desen, bir nesneyi hangi diğer nesnenin requesti handle ettiğini bilmekten kurtarır. Bir nesnenin sadece requestin "uygun bir şekilde" handle edileceğini bilmesi gerekir. Hem receiver hem de sender birbirleri hakkında doğrudan bilgi sahibi değildir ve zincirdeki bir nesnenin zincirin mimarisini bilmesi gerekmez.
   Sonuç olarak, Chain of Responsibility nesneler arası bağlantıları(interconnections) basitleştirebilir. Nesnelerin tüm olası receiverlarına referanslar tutmak yerine, yalnızca bir successer'ına referans tutması yeterlidir.

2. Sorumlulukların nesnelere atanmasında esneklik sağlar. Chain of Responsibility, sorumlulukları nesneler arasında dağıtmada ekstra esneklik sunar. Zincire yeni elemanlar ekleyerek ya da zinciri runtimeda değiştirerek, bir requesti handle etme sorumluluklarını değiştirebilir veya ekleyebilirsiniz. Bu özelliği subclasslama ile birleştirerek, handler'ları statik olarak da özelleştirebilirsiniz.

3. Request'in handle edilmesi garanti edilmez. Bir request'in explicit receiver'i olmadığından, request'in handle edileceğine dair bir garanti yoktur—request zincirin sonuna kadar ulaşabilir ve hiç handle edilmeden sona erebilir. Zincirin yanlış konfigure edilmesi durumunda da requestin handle edilmemesi olasıdır.

<h3>Related Patterns</h3>
Sorumluluk Zinciri genellikle Composite (163) ile birlikte gerçekleştirilir. Burada, bir component'in parenti onun successor'u olarak hareket edebilir.
