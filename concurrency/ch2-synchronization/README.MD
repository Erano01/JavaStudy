<h1>Synchronization</h1>

Threadler, öncelikle fieldlara ve referans olunan fieldların referans olduğu nesnelere erişimi paylaşarak iletişim kurar. 
Bu iletişim biçimi son derece verimlidir, ancak iki tip hatanın oluşmasını mümkün kılar:

thread karışması(thread interference) ve bellek tutarlılığı(memory consistency) hataları. Bu hataları önlemek için gereken araç senkronizasyondur(synchronization).

Ancak senkronizasyon, iki veya daha fazla thread'in aynı kaynağa aynı anda erişmeye çalışması ve Java runtime'inin bir veya daha fazla thread'i daha yavaş yürütmesine veya hatta yürütmeyi askıya almasına neden olması durumunda oluşan thread çekişmesine(thread contention) neden olabilir.

Açlık(starvation) ve canlı kilit(livelock), thread çekişmesinin(thread contention) biçimleridir. Daha fazla bilgi için Liveness bölümüne bakın.

Bu bölüm aşağıdaki konuları kapsamaktadır:
1. Thread interference, birden fazla thread'in paylaşılan verilere erişmesi durumunda hataların nasıl ortaya çıktığını açıklar.
2. Memory Consistency Errors, paylaşılan memory'nin tutarsız görünümlerinden kaynaklanan hataları açıklar.
3. Synchronized Methods, thread interference ve memory consistency errorlarını etkili bir şekilde önleyebilen basit bir idiomu açıklar.
4. Implicit Locks ve Synchronization daha genel bir senkronizasyon idiomunu tanımlar ve senkronizasyonun implicit locklara nasıl dayandığını açıklar.
5. Atomic Access, diğer threadler tarafından müdahale edilemeyen işlemlerin genel fikrinden bahseder.

<h3>Thread Interference</h3>

Counter adında basit bir sınıfı ele alalım


class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}

Sayaç, increment çağrısının her yapıldığında c'ye 1 ekleyecek ve decrement çağrısının her yapıldığında c'den 1 çıkaracak şekilde tasarlanmıştır.
Ancak, bir Counter nesnesine birden fazla threadden başvuruluyorsa, threadler arasındaki etkileşim bunun beklendiği gibi gerçekleşmesini engelleyebilir.

Müdahale(Interference), farklı threadlerde çalışan ancak aynı veriler üzerinde işlem yapan iki process iç içe geçtiğinde meydana gelir. Bu, iki process'in birden fazla adımdan oluştuğu ve adım dizilerinin çakıştığı anlamına gelir.

Counter örnekleri üzerindeki işlemlerin iç içe geçmesi mümkün görünmeyebilir, çünkü c üzerindeki her iki işlem de tek ve basit ifadelerdir.
Ancak, basit ifadeler bile sanal makine tarafından birden fazla adıma çevrilebilir. Sanal makinenin attığı belirli adımları incelemeyeceğiz — tek bir c++ ifadesinin üç adıma ayrıştırılabileceğini bilmek yeterlidir:

1. c'nin mevcut değerini al.
2. Alınan değeri 1 arttır.
3. Arttırılan değeri c'ye geri kaydet.

c-- ifadesi aynı şekilde ayrıştırılabilir, ancak ikinci adımda artış yerine azalma olur.

Diyelim ki Thread A, Thread B'nin azaltmayı çağırmasıyla hemen hemen aynı anda artırmayı çağırıyor. Eğer c'nin başlangıç ​​değeri 0 ise, iç içe geçmiş eylemleri şu sırayı izleyebilir:

1. Thread A: Retrieve c.
2. Thread B: Retrieve c.
3. Thread A: Increment retrieved value; result is 1.
4. Thread B: Decrement retrieved value; result is -1.
5. Thread A: Store result in c; c is now 1.
6. Thread B: Store result in c; c is now -1.

Thread A'nın sonucu kaybolur, Thread B tarafından üzerine yazılır. Bu özel iç içe geçirme yalnızca bir olasılıktır.
Farklı koşullar altında kaybolan Thread B'nin sonucu olabilir veya hiç hata olmayabilir. Öngörülemez oldukları için thread karışma(interference) hatalarını tespit etmek ve düzeltmek zor olabilir.

<h3>Memory Consistency Errors</h3>

Bellek tutarlılığı hataları, farklı threadlerin aynı olması gereken veriler hakkında tutarsız görünümlere sahip olması durumunda ortaya çıkar.
Bellek tutarlılığı hatalarının nedenleri karmaşıktır ve bu eğitimin kapsamının ötesindedir. Neyse ki, programcının bu nedenler hakkında ayrıntılı bir anlayışa ihtiyacı yoktur. Tek gereken, bunlardan kaçınmak için bir stratejidir.

Bellek tutarlılığı hatalarından kaçınmanın anahtarı, happen-before ilişkisini anlamaktır. Bu ilişki, belirli bir ifadenin bellek yazmalarının başka bir belirli ifade tarafından görülebileceğinin basit bir garantisidir.
Bunu görmek için, aşağıdaki örneği ele alalım. Basit bir int field'i tanımlandığını ve başlatıldığını varsayalım:

int counter = 0;

counter field'i A ve B olmak üzere iki thread arasında paylaşılır. Thread A'nın counter'i artırdığını varsayalım:
counter++;

Daha sonra, kısa bir süre sonra, B thread'i counter'i ekrana yazdırır:

System.out.println(counter);

Eğer iki ifade aynı threadde yürütülseydi, yazdırılan değerin "1" olacağını varsaymak güvenli olurdu.
Ancak iki ifade ayrı threadde yürütülürse, yazdırılan değer "0" olabilir, çünkü Thread A'nın sayaçtaki değişikliğinin Thread B tarafından görülebileceğinin garantisi yoktur; programcı bu iki ifade arasında bir "happens-before" ilişkisi kurmadığı sürece.

happens-before ilişkileri oluşturan birkaç eylem vardır. Bunlardan biri senkronizasyondur, bunu aşağıdaki bölümlerde göreceğiz.

Daha önce happens-before ilişkilerini yaratan iki eylem gördük.

1. Bir ifade Thread.start'ı çağırdığında, bu ifadeyle bir happen-before ilişkisi olan her ifade, yeni thread tarafından yürütülen her ifadeyle de bir happen-before ilişkisine sahip olur. Yeni thread'in oluşturulmasına yol açan kodun etkileri yeni thread tarafından görülebilir.
2. Bir thread sonlandığında ve başka bir threadde Thread.join metodunun dönmesine neden olduğunda, sonlanan thread tarafından yürütülen tüm ifadeler, join çağrısından sonraki ifadelerle happens-before ilişkisine sahiptir. Böylece, sonlanan threaddeki kodun etkileri, join işlemini gerçekleştiren thread tarafından görülebilir hale gelir.

Happens-before ilişkisi oluşturan diğer eylemlerin listesi için java.util.concurrent paketinin Özet (Summary) sayfasına bakabilirsiniz.


<h3>Synchronized Methods</h3>
Java programlama dili iki temel senkronizasyon idiom'u sunar: senkronize yöntemler ve senkronize ifadeler(synchronized methods and synchronized statements).

İkisinden daha karmaşık olan senkronize ifadeler bir sonraki bölümde açıklanmaktadır. Bu bölüm senkronize yöntemlerle ilgilidir.

Bir metodu senkronize hale getirmek için, deklerasyonuna synchronized anahtar kelimesini eklemeniz yeterlidir:

public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}

Eğer count, SynchronizedCounter'ın bir örneğiyse, bu yöntemleri senkronize hale getirmenin iki etkisi olur:

1. Aynı nesne üzerinde iki senkronize metodun aynı anda çalıştırılması mümkün değildir. Bir iş parçacığı (thread), bir nesne için senkronize bir metodu çalıştırırken, aynı nesne üzerinde başka bir senkronize metodu çalıştırmaya çalışan diğer tüm iş parçacıkları bekletilir (block edilir). Yani, diğer iş parçacıkları, ilk iş parçacığı işlemini tamamlayana kadar yürütme yapamaz.
2. Bir senkronize metot tamamlandığında, aynı nesne üzerinde daha sonra çağrılan diğer senkronize metotlar ile arasında bir "happens-before" ilişkisi oluşturulur. Bu, nesnenin durumundaki değişikliklerin diğer tüm iş parçacıkları tarafından görülebilir olmasını garanti eder.

Not: Kurucular (constructors) senkronize edilemez — Bir constructor'a synchronized anahtar kelimesi eklemek sözdizimi hatasına neden olur. Çünkü bir nesne oluşturulurken yalnızca onu oluşturan Thread nesneye erişebilir, bu yüzden kurucunun senkronize edilmesi mantıklı değildir.

Warning!
Eğer bir nesne birden fazla thread tarafından paylaşılacaksa, nesne oluşturulmadan önce başka threadler tarafından erişilmemesine dikkat edilmelidir.
Örneğin, eğer her sınıf örneğini saklamak için bir List (örneğin instances) kullanmak istiyorsanız, aşağıdaki gibi bir satır eklemek cazip gelebilir:

instances.add(this);

Ancak bu durumda, diğer threadler instances listesini kullanarak nesneye erişebilir ve bu erişim, nesne henüz tam olarak oluşturulmadan gerçekleşebilir.

Senkronize metotlar, thread çakışmalarını (thread interference) ve bellek tutarsızlığı hatalarını (memory consistency errors) önlemek için basit bir strateji sunar: Eğer bir nesne birden fazla iş parçacığı tarafından erişilebiliyorsa, o nesnenin değişkenlerine yapılan tüm okuma ve yazma işlemleri senkronize metotlar aracılığıyla gerçekleştirilmelidir.

(Önemli bir istisna: final alanlar, nesne oluşturulduktan sonra değiştirilemez, bu yüzden nesne oluşturulduktan sonra senkronize edilmemiş metotlar aracılığıyla güvenli bir şekilde okunabilir.)

Bu strateji etkili olsa da, canlılık (liveness) sorunlarına yol açabilir. Bu konuyu ilerleyen bölümlerde daha ayrıntılı olarak ele alacağız.

<h3>Intrinsic Locks and Synchronization</h3>
Senkronizasyon, intrinsic lock veya monitor lock olarak bilinen internal bir entity etrafında oluşturulur. (API spesifikasyonu genellikle bu entity'e basitçe "monitor" olarak atıfta bulunur.) 
intrinsic locklar senkronizasyonun her iki yönünde de rol oynar: bir nesnenin durumuna özel erişimi(exclusive access) zorlamak ve visibility için önemli olan "happens-before" ilişkileri kurmak.



