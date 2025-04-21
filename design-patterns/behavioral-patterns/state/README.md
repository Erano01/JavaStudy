<h1>State Design Pattern</h1>

<h3>Intent</h3>
Bir nesnenin iç durumu(internal state) değiştiğinde davranışını değiştirmesine izin verin. Nesne sınıfını değiştirmiş gibi görünecektir.


<h3>Also Known As</h3>
Objects for States

<h3>Motivation</h3>
Bir network connection'u temsil eden TCPConnection sınıfını düşünün. Bir TCPConnection nesnesi birkaç farklı durumdan birinde olabilir: Established(kurulmuş), Listening(Dinleniyor), Closed(Kapatılmış). 
Bir TCPConnection nesnesi diğer nesnelerden istek aldığında, geçerli durumuna bağlı olarak farklı şekilde yanıt verir. 
Örneğin, Open request'in etkisi, bağlantının Closed durumunda mı yoksa Established durumunda mı olduğuna bağlıdır. 
State pattern, TCPConnection'ın her durumda nasıl farklı davranışlar sergileyebileceğini açıklar.

Bu patterndaki temel fikir, network connectionun durumlarını temsil etmek için TCPState adlı soyut bir sınıf tanıtmaktır. 
TCPState sınıfı, farklı operasyonel durumları temsil eden tüm sınıflar için ortak bir arayüz bildirir. 
TCPState'in alt sınıfları, duruma özgü davranışı gerçekleştirir. 
Örneğin, TCPEstablished ve TCPClosed sınıfları, TCPConnection'ın Established ve Closed durumlarına özgü davranışı gerçekleştirir.

![image](https://github.com/user-attachments/assets/cabb48a9-2151-4e7c-814b-0ad3f2d909d3)


TCPConnection sınıfı, TCP connectionun geçerli durumunu temsil eden bir durum nesnesi (TCPState'in bir alt sınıfının örneği) tutar. 
Connection sınıfı, tüm state-specific istekleri bu durum nesnesine devreder. 
TCPConnection, connectionun durumuna özgü işlemleri gerçekleştirmek için TCPState alt sınıf örneğini kullanır.

Connection durumu değiştiğinde, TCPConnection nesnesi stateobjectit'in kullandığı durumu değiştirir. Bağlantı, established durumdan closed duruma geçtiğinde, örneğin, TCPConnection, TCPEstablished örneğini bir TCPClosed örneğiyle değiştirir.

<h3>Applicability</h3>
Aşağıdaki durumlardan herhangi birinde State Patternini kullanın:

1. Nesnenin davranışı kendi durumuna göre değişiyorsa, ve bu nesne çalışırken(runtime) durumuna göre davranışını değiştirmesi gerekiyorsa.

2. Operasyonlar, nesnenin durumuna bağlı olarak büyük ve çok parçalı koşullu ifadeler (if-else veya switch-case yapıları) içeriyorsa. Bu durum genellikle bir veya daha fazla numaralandırılmış sabitle (enum) temsil edilir. Çoğu zaman, birkaç işlem aynı koşullu yapıyı içerir. State deseni, bu koşullu ifadelerin her bir dalını ayrı bir sınıfa yerleştirir. Bu, nesnenin durumunu, diğer nesnelerden bağımsız olarak değişebilen ayrı bir nesne gibi ele almanıza olanak tanır.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/fce9ba26-0b0b-4aa5-afe0-a6450fed8f88)


<h3>Participants</h3>
• Context (TCPConnection)
   ◇ clientlerin ilgilendiği arayüzleri tanımlar.
   ◇ mevcut state'i tanımlayan bir ConcreteState subclass instanceini maintain eder.
• State (TCPState)
   ◇ Context'in belirli bir state'i ile ilişkili davranışı kapsüllemek için bir arayüz tanımlar.
• ConcreteState subclasses (TCPEstablished, TCPListen, TCPClosed)
   ◇ tüm subclasslar Context'in durumu ile alakalandırılmış(associated) davranışları gerçekleştirir.

<h3>Collaborations</h3>
Context (Bağlam), duruma özgü istekleri mevcut ConcreteState (SomutDurum) nesnesine devreder.
Bir context, isteği işleyen State nesnesine kendisini bir argüman olarak iletebilir. Bu, gerekirse State nesnesinin context’e erişmesine olanak tanır.
Context, clientler için birincil arayüzdür. Clientler, bir context’i State nesneleri ile yapılandırabilir. Bir context yapılandırıldıktan sonra, clientlerin State nesneleriyle doğrudan ilgilenmesine gerek kalmaz.
Hangi durumun diğerini takip edeceğine ve bunun hangi koşullarda gerçekleşeceğine context ya da ConcreteState alt sınıflarından herhangi biri karar verebilir.

<h3>Consequences</h3>
1. Duruma özgü davranışı yerelleştirir ve farklı durumlara göre davranışı bölümlendirir. 
   
   State deseni, belirli bir durumla ilişkili tüm davranışları tek bir nesneye koyar. Tüm duruma özgü kodlar bir State alt sınıfında bulunduğu için, yeni durumlar ve geçişler, yeni alt sınıflar tanımlanarak kolayca eklenebilir.
   
   Alternatif olarak, içsel durumları tanımlamak için veri değerleri kullanılabilir ve Context içindeki işlemler bu verileri açıkça kontrol edebilir. Ancak bu durumda, Context’in içinde dağılmış şekilde benzer görünümlü koşullu veya case ifadeleri olur. Yeni bir durumu eklemek, birkaç işlemi değiştirmeyi gerektirebilir ve bu da bakımı zorlaştırır.
   
   State deseni bu sorunu ortadan kaldırır, ancak başka bir sorunu beraberinde getirebilir: çünkü farklı durumlara ait davranışları çeşitli State alt sınıflarına dağıtır. Bu, sınıf sayısını artırır ve tek sınıfa göre daha dağınık bir yapı sunar. Ancak, eğer çok sayıda durum varsa, bu dağılım aslında faydalıdır; çünkü aksi takdirde büyük koşullu ifadeler gerekli olurdu.
   
   Uzun prosedürlerde olduğu gibi, büyük koşullu ifadeler de istenmeyen yapılardır. Tek parça halindedirler ve kodu daha az açık hale getirirler, bu da onların değiştirilmesini ve genişletilmesini zorlaştırır. State deseni, duruma özgü kodu yapılandırmak için daha iyi bir yol sunar. Durum geçişlerini belirleyen mantık, büyük if ya da switch ifadelerinde değil, State alt sınıfları arasında bölüştürülmüştür. Her durum geçişi ve davranışı bir sınıfta kapsüllenerek, yürütme durumu (execution state) fikrine tam anlamıyla bir nesne statüsü kazandırılır. Bu yaklaşım, koda yapı kazandırır ve niyetini daha net hale getirir.

2. Durum geçişlerini açık hale getirir.
   Bir nesne mevcut durumunu yalnızca içsel veri değerleriyle tanımladığında, durum geçişlerinin açık bir temsili olmaz; bunlar yalnızca bazı değişkenlere yapılan atamalarla görünür. Farklı durumlar için ayrı nesneler tanıtmak, bu geçişleri daha açık hale getirir. Ayrıca, State nesneleri, Context’i tutarsız iç durumlara karşı koruyabilir; çünkü durum geçişleri Context açısından atomiktir—birden fazla değişken yerine yalnızca bir değişken (Context'in State nesne değişkeni) yeniden bağlanır [dCLF93].

3. State nesneleri paylaşılabilir.
   Eğer State nesnelerinin örnek değişkenleri (instance variable) yoksa—yani temsil ettikleri durum tamamen türlerine (type) kodlanmışsa—Context’ler bir State nesnesini paylaşabilir. Bu şekilde durumlar paylaşıldığında, aslında flyweight (hafif) nesneler haline gelirler (bkz. Flyweight deseni, s. 195); içsel durum taşımazlar, yalnızca davranışa sahiptirler.
   

<h3>Related Patterns</h3>
Flyweight (195) deseni, State nesnelerinin ne zaman ve nasıl paylaşılabileceğini açıklar. 
State nesneleri genellikle Singleton'lardır (127).













