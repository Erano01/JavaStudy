<h1>Introduction</h1>

Algoritmaları tasarlayıp analiz ettiğinizde, bunların nasıl çalıştığını ve nasıl tasarlanacağını tanımlayabilmeniz gerekir.
Algoritmalarınızın doğru şeyi yaptığını ve bunu verimli bir şekilde yaptığını göstermek için bazı matematiksel araçlara da ihtiyacınız var. Bu bölüm sizi hazırlayacaktır. Bu kitabın sonraki bölümleri bu temel üzerine inşa edilecektir.

Bölüm 1, algoritmalara ve modern bilgi işlem sistemlerine(computing systems) genel bir bakış sağlar. Bu bölüm, bir algoritmanın ne olduğunu açıklar ve bazı örnekler sıralar. 
Ayrıca, algoritmaların hızlı donanım, grafiksel kullanıcı arayüzleri, nesne yönelimli sistemler ve networkler gibi teknolojilerin yanında algoritmaların bir teknoloji olarak ele alınması gerektiğini savunur.

Bölüm 2'de, n sayıdan oluşan bir diziyi sıralama sorununu çözen ilk algoritmalarımızı görüyoruz.
Bunlar, herhangi bir geleneksel(conventional) programlama diline doğrudan çevrilemese de, algoritmanın yapısını yeterince açık bir şekilde ileten ve böylece onu istediğiniz dilde uygulayabileceğiniz bir sözde kod ile (pseudocode) yazılmıştır.
İncelediğimiz sıralama(sorting) algoritmaları, artımlı(incremental) bir yaklaşım kullanan insertion sort ve "divide-and-conquer" olarak bilinen recursive bir teknik kullanan merge sort'dur.
Her birinin gerektirdiği süre n değeriyle artsa da, artış oranı iki algoritma arasında farklılık gösterir.
Bu çalışma sürelerini 2. Bölümde belirliyoruz ve bunları ifade etmek için yararlı bir "asymptotic" notasyonu geliştiriyoruz.

Bölüm 3, asimptotik notasyonu kesin olarak tanımlar. Asimptotik notasyonu, fonksiyonların büyümesini -- çoğunlukla algoritmaların çalışma süresini tanımlayan fonksiyonları -- yukarıdan ve aşağıdan sınırlamak için kullanacağız.
Bölüm, en sık kullanılan asimptotik notasyonları gayri resmi(informally) olarak tanımlayarak ve bunların nasıl uygulanacağına dair bir örnek vererek başlıyor.
Daha sonra asimptotik notasyonları resmen tanımlar ve bunların nasıl bir araya getirileceğine dair kuralları sunar.
Bölüm 3'ün geri kalanı temel olarak matematiksel notasyonun bir sunumudur, bu daha çok, size yeni matematiksel kavramlar öğretmekten ziyade, notasyon kullanımınızın bu kitaptakiyle uyumlu olduğundan emin olmak içindir.

Bölüm 4, Bölüm 2'de tanıtılan divide-and-conquer methodunu daha derinlemesine inceler. Strassen's suprising method de dahil olmak üzere kare(square) matrisleri çarpmak için divide-and-conquer algoritmalarına ilişkin iki ek örnek sağlar.
Bölüm 4 recursive algoritmaların çalışma sürelerini(running times) tanımlamak için yararlı olan yinelemeleri(recurrences) çözme methodları içerir.
Substitution methodunda, bir cevabı tahmin edersiniz ve doğruluğunu kanıtlarsınız. Recursion tree'ler tahmin üretmenin bir yolunu sağlar.
Bölüm 4 ayrıca divide-and-conquer algoritmalarından kaynaklanan yinelemeleri(recurrences) çözmek için sıklıkla kullanabileceğiniz "master method"in güçlü tekniğini de sunar.
Bölüm, master teoremin dayandığı temel bir teoremin kanıtını(proof of master theorem) sağlasa da, kanıta dalmadan ana yöntemi kullanmakta özgürsünüz. Bölüm 4, bazı ileri düzey konularla sona eriyor.

Bölüm 5 olasılıksal analiz (probabilistic analysis) ve rastgele algoritmaları (randomized algorithms) tanıtır. Genellikle, bir algoritmanın çalışma süresini belirlemek için olasılıksal analiz kullanırsınız. 
Bu durumlarda, doğal bir olasılık dağılımının varlığı nedeniyle, çalışma süresi aynı boyuttaki farklı girdilerde farklılık gösterebilir.
Bazı durumlarda, girdilerin bilinen bir olasılık dağılımına uyduğunu varsayabilirsiniz, böylece çalışma süresini tüm olası girdiler üzerinde ortalamış olursunuz. Diğer durumlarda ise olasılık dağılımı girdilerden değil, algoritmanın çalışması sırasında yapılan rastgele seçimlerden kaynaklanır. Davranışı yalnızca girdilerine değil, aynı zamanda bir rastgele sayı üreteci tarafından üretilen değerlere de bağlı olan bir algoritma, rastgeleleştirilmiş (randomized) bir algoritmadır. Rastgeleleştirilmiş algoritmalar, girdilere bir olasılık dağılımı uygulamak için kullanılabilir—böylece hiçbir özel girdinin her zaman kötü performansa neden olmasını engelleyebilir—veya belirli bir hata payına izin verilen algoritmaların hata oranını sınırlandırmak için de kullanılabilir.

Ekler A–D, bu kitabı okurken faydalı bulacağınız diğer matematiksel konuları içermektedir. Ek bölümlerindeki konuların çoğunu bu kitabı okumadan önce görmüş olabilirsiniz (ancak kullandığımız özel tanımlar ve gösterim biçimleri geçmişte gördüklerinizden bazı durumlarda farklı olabilir), bu yüzden ekleri bir başvuru kaynağı olarak düşünmelisiniz. Öte yandan, muhtemelen Bölüm I’deki konuların çoğunu daha önce görmediniz. Bölüm I’deki tüm bölümler ve ekler, öğretici bir üslupla yazılmıştır.







