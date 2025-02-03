<h1>1.1 Algorithms</h1>

Gayri resmi olarak, bir algoritma, girdi olarak bir değer veya değerler kümesi alan ve belirli bir zaman diliminde çıktı olarak bir değer veya değerler kümesi üreten iyi tanımlanmış herhangi bir hesaplama prosedürüdür.
Dolayısıyla bir algoritma, girdiyi çıktıya dönüştüren bir dizi hesaplama adımıdır.

// algoritma = girişleri ve çıkışları ve aradaki bütün adımları belli olan bir hesaplama prosedürüdür/konvansiyondur.
// https://en.wikipedia.org/wiki/Halting_problem
// hashing algoritmaları cihazların işleme gücüne göre secure'liğini kaybeder. (kaç bit olduğuna bağlı misal 56 bit daha kötüyken 256 bit daha iyidir -> SHA-256)
// CPU'nun işleme hızından bağımsız olarak O notasyonu algoritmanın hızını belirler.
// Core sayısı, paralel programlama ile birlikte önemli derecede CPU'ların işleme hızını artırır.
// Eskiden bazı dillerde değişkenlerin bit değerlerinin olmasının sebebi daha dar alanlarda değişkenlerin yığılmasını engellemekti.

Bir algoritmayı, iyi tanımlanmış bir hesaplama problemini çözmek için bir araç olarak da görebilirsiniz.
Problemin ifadesi, genellikle keyfi olarak büyük boyuttaki problem örnekleri için istenen girdi/çıktı ilişkisini genel terimlerle belirtir.
Algoritma, tüm problem örnekleri için girdi/çıktı ilişkisini elde etmek için belirli bir hesaplama prosedürünü tanımlar.

Örneğin, bir sayı dizisini(sequence of number) monotonik artan sıraya(increasing order) göre sıralamanız(sort) gerektiğini varsayalım.

Bu sorun pratikte sıklıkla ortaya çıkar ve birçok standart tasarım tekniği ve analiz aracının tanıtılması için verimli bir zemin sağlar. Sıralama sorununu resmi olarak nasıl tanımladığımızı burada görebilirsiniz:

Input: n sayıda bir dizi sayı (a1, a2, ..., an).
Output: Giriş dizisinin {a'1, a'2, ....., a'n} şeklinde bir permütasyonu (yeniden düzenlenmesi) öyle ki a'1 <= a'2 <= .... <= a'n

//Matematikte permütasyon, n elemanlı bir kümenin k elemanlı alt kümelerinin (kendi içinde) k kere yer değiştirme sayısıdır.

 Böylece, giriş dizisi {31,41,59,26,41,58} verildiğinde doğru bir sıralama algoritması çıktı olarak {26, 31, 41,41, 58, 59} dizisini döndürür. Böyle bir giriş dizisine sıralama probleminin bir örneği denir

Genel olarak, bir problemin instance'i problem ifadesinde empoze edilen kısıtlamaları(constraints) karşılayan ve problemin çözümünü hesaplamak için gereken girdiden oluşur.

Çünkü birçok program bunu ara bir adım(intermediate step) olarak kullandığından, sıralama(sorting) bilgisayar biliminde temel bir işlemdir.
Sonuç olarak, elinizin altında çok sayıda iyi sıralama algoritması bulunur.

Belirli bir uygulama için hangi algoritmanın en iyi olduğu, diğer faktörlerin yanı sıra, sıralanacak element sayısına, elementlerin ne ölçüde sıralanmış olduğuna, element değerleri üzerindeki olası kısıtlamalara, bilgisayarın mimarisine ve kullanılacak depolama aygıtlarının türüne bağlıdır: main memory, diskler veya hatta -- eski zamanlarda -- bantlar.

Bir hesaplama problemi için bir algoritma, girdi olarak sağlanan her problem örneği için, sonlu zamanda hesaplamasını durdurup bitirirse ve problem örneğine doğru çözümü ortaya koyarsa doğrudur.
Doğru bir algoritma verilen hesaplama problemini çözer. Yanlış bir algoritma bazı giriş örneklerinde hiç durmayabilir veya yanlış bir cevapla durabilir. 
Beklediğinizden farklı olarak, hata oranlarını kontrol edebilirseniz, hatalı algoritmalar bazen yararlı olabilir.
Büyük asal sayıları bulmak için algoritmaları incelediğimiz 31. Bölümde, kontrol edilebilir bir hata oranına sahip bir algoritmanın örneğini göreceğiz.
Ancak normalde yalnızca doğru algoritmalarla ilgileneceğiz.

Bir algoritma İngilizce olarak, bir bilgisayar programı olarak veya hatta bir donanım tasarımı olarak belirtilebilir. Tek gereklilik, spesifikasyonun takip edilecek hesaplama prosedürünün kesin bir tanımını sağlamasıdır.

<h3>What kinds of problems are solved by algorithms?</h3>
Sorting(sıralama), algoritmaların geliştirildiği tek hesaplama problemi değildir.
(Muhtemelen bu kitabın boyutunu gördüğünüzde bundan şüphelenmişsinizdir.) Algoritmaların pratik uygulamaları her yerde mevcuttur ve aşağıdaki örnekleri içerir:

1. İnsan Genomu Projesi, insan DNA'sındaki yaklaşık 30.000 geni tanımlama, insan DNA'sını oluşturan yaklaşık 3 milyar kimyasal baz çiftinin dizilerini belirleme, bu bilgiyi veritabanlarında depolama ve veri analizi için araçlar geliştirme hedeflerine önemli ölçüde ilerleme kaydetmiştir. Bu adımların her biri, sofistike algoritmalar gerektirir. İlgili çeşitli problemleri çözme yöntemleri bu kitabın kapsamının ötesindedir, ancak bu biyolojik problemleri çözmek için kullanılan birçok yöntem burada sunulan fikirleri kullanarak bilim insanlarının kaynakları verimli bir şekilde kullanarak görevleri başarmalarını sağlar. Dynamic programming, özellikle DNA dizileri arasındaki benzerlikleri belirleme gibi biyolojik problemleri çözmek için önemli bir tekniktir (Bölüm 14'te tartışılmaktadır). Elde edilen tasarruflar, hem insan hem de makine açısından zamandadır ve laboratuvar teknikleriyle daha fazla bilgi çıkarılabildiği için maliyettedir.
2. İnternet, dünyanın her yerindeki insanların büyük miktarda bilgiye hızla erişmesini ve bu bilgileri geri almasını sağlar. Akıllı algoritmaların yardımıyla, internet siteleri bu büyük veri hacmini yönetebilir ve manipüle edebilir. Algoritmaların hayati derecede kullanıldığı problem örnekleri arasında, verilerin seyahat ettiği iyi yolları bulma (bu tür problemleri çözme teknikleri Bölüm 22'de yer almaktadır) ve bir arama motoru kullanarak belirli bilgilerin bulunduğu sayfaları hızlı bir şekilde bulma (ilgili teknikler Bölüm 11 ve 32'de mevcuttur) yer alır.
3. Elektronik ticaret, malların ve hizmetlerin elektronik ortamda müzakere edilmesini ve değişimini mümkün kılar ve kişisel bilgilerin gizliliğine dayanır, örneğin kredi kartı numaraları, şifreler ve banka hesap özetleri. Elektronik ticarette kullanılan temel teknolojiler, numerical algorithms ve number theory'e dayanan, public-key cryptography ve digital signatures gibi araçlardır (Bölüm 31'de ele alınmaktadır).
4. Üretim ve diğer ticari işletmeler, genellikle sınırlı kaynakları en faydalı şekilde tahsis etmek zorundadır. Bir petrol şirketi, beklenen karını maksimize etmek için kuyularını nerelere yerleştireceğini bilmek isteyebilir. Bir politikacı, seçim kazanma şansını maksimize etmek için kampanya reklamlarını nereye harcayacağını belirlemek isteyebilir. Bir havayolu, her uçağın uçuş ekibinin sağlanmasını ve hükümet düzenlemelerine uygun şekilde ekip planlamasının yapılmasını sağlayarak, uçuşları en ucuz şekilde atamak isteyebilir. Bir internet servis sağlayıcısı, müşterilerine daha etkili hizmet verebilmek için ek kaynakları nerelere yerleştireceğini belirlemek isteyebilir. Tüm bu örnekler, bunları linear programlama(doğrusal programlama) olarak modelleyerek çözülebilen problemlerdir ve bu konu Bölüm 29'da ele alınmaktadır.

Bu örneklerin bazı ayrıntıları bu kitabın kapsamının ötesinde olsa da, bu problemlere ve problem alanlarına uygulanabilecek temel teknikleri sunuyoruz. Ayrıca aşağıdaki gibi birçok özel problemi nasıl çözeceğinizi de gösteriyoruz:

1. Bir yol haritanız var ve bitişik kavşaklar arasındaki mesafeler belirtilmiş. Bir kavşaktan diğerine en kısa rotayı belirlemek istiyorsunuz. Olası rotaların sayısı çok büyük olabilir, özellikle de kendisiyle kesişen rotalara izin vermiyorsanız. Tüm olası rotalar arasından en kısa olanı nasıl seçebilirsiniz? İlk olarak, yol haritasını (aslında gerçek yolların bir modeli) bir graph olarak modelleyerek başlayabilirsiniz (bu konuya VI. Bölüm ve Ek B’de değineceğiz). Bu graph'da, bir düğümden(node) diğerine en kısa yolu bulmak istiyorsunuz. Bölüm 22, bu problemi verimli bir şekilde nasıl çözeceğinizi gösteriyor.
2. Bir mekanik tasarımınız var ve bu tasarım, birbirini içerebilen parçalardan oluşan bir kütüphane ile ifade ediliyor. Parçaları, her parçanın kendisini kullanan diğer parçalardan önce listeleneceği bir sıraya koymalısınız. Tasarım n parçadan oluşuyorsa, olası sıralamaların sayısı n! (n faktöriyel) kadar olur. Faktöriyel fonksiyonu, üstel fonksiyonlardan(exponential function) bile daha hızlı büyüdüğü için (eğer yalnızca birkaç parçanız yoksa), her olası sıralamayı oluşturup doğrulamak pratik değildir. Bu problem, topolojik sıralamanın(topological sorting) bir örneğidir ve Bölüm 20, bu problemi verimli bir şekilde nasıl çözeceğinizi açıklar.
3. Bir doktorun, bir görüntünün kanserli bir tümörü mü yoksa iyi huylu bir tümörü mü temsil ettiğini belirlemesi gerekiyor. Doktorun elinde, bazıları kanserli ve bazıları iyi huylu olduğu bilinen birçok tümör görüntüsü var. Kanserli bir tümör, diğer kanserli tümörlere iyi huylu tümörlerden daha fazla benzerlik gösterecektir ve iyi huylu bir tümör de diğer iyi huylu tümörlere daha fazla benzeyecektir. Doktor, Bölüm 33’te ele alınan kümeleme algoritmalarını(clustering algorithm) kullanarak hangi sonucun daha olası olduğunu belirleyebilir.
4. Büyük bir metin dosyasını, daha az yer kaplayacak şekilde sıkıştırmanız gerekiyor. Bunu yapmanın birçok yöntemi vardır, bunlardan biri LZW sıkıştırmasıdır ve tekrarlayan karakter dizilerini bulmaya dayanır. Bölüm 15, farklı bir yaklaşımı, Huffman coding'i ele alır. Bu yöntem, karakterleri farklı uzunluklarda bit dizileriyle kodlar; daha sık kullanılan karakterler daha kısa bit dizileriyle temsil edilir.

Bu listeler kesinlikle kapsamlı değildir (bu kitabın kalınlığından bunu zaten tahmin etmiş olabilirsiniz), ancak birçok ilginç algoritmik problemin ortak iki özelliğini sergilerler:

1. Çok sayıda aday çözüm bulunur ve bunların büyük çoğunluğu problemi çözmez. Problemi gerçekten çözen veya en iyi olan bir çözümü, her olası çözümü açıkça incelemeden bulmak büyük bir zorluk teşkil edebilir.
2. Pratik uygulamalara sahiptirler. Yukarıdaki problemler arasında en belirgin pratik örneklerden biri en kısa yolu bulma problemidir. Örneğin, bir nakliye firması (kamyon taşımacılığı veya demiryolu şirketi gibi), bir yol veya demiryolu ağı boyunca en kısa yolları bulmaya finansal açıdan ilgi duyar; çünkü daha kısa yollar seçmek iş gücü ve yakıt maliyetlerini düşürür. Benzer şekilde, internetteki bir yönlendirme düğümü (router), bir mesajı hızlı bir şekilde iletebilmek için ağdaki en kısa yolu bulmak zorunda olabilir. Veya New York’tan Boston’a gitmek isteyen bir kişi, bir navigasyon uygulaması kullanarak en kısa sürüş rotasını belirlemek isteyebilir.

Her algoritma ile çözülen problem, kolayca tanımlanabilen bir aday çözüm kümesine sahip değildir. Örneğin, düzenli zaman aralıklarında alınan bir sinyal örneklerini temsil eden sayısal değerler verildiğinde, ayrık Fourier dönüşümü zaman domenini (zaman alanını) frekans domenine (frekans alanına) dönüştürür. Yani, sinyali sinüzoidlerin ağırlıklı toplamı olarak yaklaştırır ve böylece örneklenen sinyali yaklaşık olarak yeniden oluşturabilecek çeşitli frekansların kuvvetlerini üretir.

Ayrık Fourier dönüşümleri yalnızca sinyal işleme alanında değil, aynı zamanda veri sıkıştırma, büyük polinomların ve tam sayıların çarpımı gibi alanlarda da uygulanır. Bölüm 30, bu problem için hızlı Fourier dönüşümünü (fast Fourier transform, yaygın olarak FFT olarak adlandırılır) sağlayan verimli bir algoritmayı sunar. Ayrıca, donanım tabanlı bir FFT devresinin tasarımını da özetlemektedir.


<h3>Data Structures</h3>
Bu kitap, birkaç data structure da ele almaktadır. Data structure, verileri saklama ve organize etme yöntemidir; böylece erişim ve değişiklikler kolaylaşır. Uygun data structurelarını kullanmak, algoritma tasarımının önemli bir parçasıdır. Tek bir data structure her amaca uygun değildir, bu yüzden birkaç data structure'in güçlü ve zayıf yönlerini bilmek önemlidir.

<h3>Technique</h3>
Bu kitabı bir algoritma tarif kitabı (cookbook) gibi kullanabilirsiniz. Ancak, yayınlanmış bir algoritma bulamadığınız bir problemle karşılaşabilirsiniz. Kitap, algoritma tasarlama ve analiz etme tekniklerini öğreterek:
• Algoritmaları kendiniz geliştirmenizi,
• Doğru sonuç verdiğini kanıtlamanızı,
• Verimliliklerini analiz etmenizi sağlar.

Bazı bölümler doğrudan belirli problemlere odaklanır:
• medians and order statistics (Bölüm 9)
• computing minimum spanning trees (Bölüm 21)
• determining a maximum flow in a network (Bölüm 24)

Diğer bölümler, belirli teknikleri ele alır:
• Divide-and-Conquer (Bölüm 2 ve 4)
• Dynamic Programming (Bölüm 14)
• Amortized analysis (Bölüm 16)

<h3>Hard Problems</h3>
Kitabın çoğu, verimli algoritmalardan bahseder. Genellikle hız, verimliliğin bir ölçütüdür: "Bir algoritma sonucunu ne kadar sürede üretir?"
Ancak, makul sürede çözülemeyen bazı problemler de vardır. Bölüm 34, bu problemlerin özel bir alt kümesini inceler: NP-Complete Problemler

NP-Complete Problemler Neden Önemlidir?
1. Hiçbir verimli algoritma bulunamamıştır, ancak var olmadığı da kanıtlanamamıştır.
2. Bir NP-Complete problem için verimli bir algoritma bulunursa, tüm NP-Complete problemler için de bulunur.
3. Bazı NP-Complete problemler, çözümü bilinen problemlere çok benzerdir. Küçük bir değişiklik, verimli çözülebilir bir problemi NP-Complete hale getirebilir.

Bir problemin NP-Complete olduğunu gösterebilirseniz, boşuna verimli bir algoritma aramak yerine yaklaşım algoritmaları (approximation algorithms) geliştirebilirsiniz.

Örnek: Gezgin Satıcı Problemi (Traveling Salesperson Problem - TSP)

Bir dağıtım şirketinin her gün birkaç adrese teslimat yapması gerektiğini düşünelim. Amaç, tüm durakları ziyaret eden en kısa yolu bulmak.  Bu problem NP-Complete'dır ve verimli bir çözüm bilinmemektedir. Approximation algoritmaları, en iyi sonuca yakın çözümler üretir. Bölüm 35, bu tip approximation algoritmalarını açıklar.

<h3>Alternative Computing Models</h3>
Uzun yıllar boyunca işlemci saat hızlarının istikrarlı bir şekilde arttığını görebiliyorduk. Ancak, fiziksel sınırlamalar sürekli artan saat hızlarına temel bir engel oluşturmaktadır: 
Saat hızı arttıkça güç yoğunluğu süperlineer olarak artar ve belirli bir seviyeyi aştığında çiplerin erime riski doğar. 
Daha fazla hesaplama işlemi gerçekleştirebilmek için, artık çipler tek bir işlemci yerine birden fazla işlem çekirdeği (core) içerecek şekilde tasarlanmaktadır. 
Bu çok çekirdekli bilgisayarları, tek bir çip üzerinde birden fazla sıralı (ardışık) bilgisayar varmış gibi düşünebiliriz.
 Başka bir deyişle, bunlar bir tür paralel bilgisayardır. 
 Çok çekirdekli bilgisayarlardan en iyi performansı elde etmek için algoritmaların paralellik göz önünde bulundurularak tasarlanması gerekmektedir.

26. bölüm, birden fazla işlem çekirdeğinden yararlanan task-parallel algoritmalar için bir model sunmaktadır. Bu model hem teorik hem de pratik açılardan avantajlar sunar ve modern paralel programlama platformlarının çoğu bu tür paralellik modellerini benimsemektedir.

Bu kitaptaki çoğu örnek, algoritma çalışmaya başlamadan önce tüm giriş verilerinin hazır olduğunu varsayar. Algoritma tasarımına yönelik çalışmaların büyük bir kısmı da aynı varsayımı yapar. Ancak, birçok önemli gerçek dünya senaryosunda veri zamanla gelir ve algoritma, gelecekte hangi verilerin geleceğini bilmeden nasıl ilerleyeceğine karar vermek zorundadır.
Örneğin, bir veri merkezinde işler sürekli olarak gelip gider ve bir zamanlama algoritması (scheduling algorithm), hangi işin ne zaman ve nerede çalıştırılacağına, gelecekte hangi işlerin geleceğini bilmeden karar vermelidir. İnternet trafiği, mevcut duruma dayanarak yönlendirilmelidir; ancak, gelecekte trafiğin nereden geleceği önceden bilinemez. Hastanelerdeki acil servislerde triage (önceliklendirme) kararları, gelecekte hangi hastaların geleceğini ve hangi tedavilere ihtiyaç duyacaklarını bilmeden verilmelidir.

Giriş verilerini başlangıçta tamamen alıp ardından işleyen algoritmaların aksine, verilerini zamanla alan algoritmalara çevrimiçi (online) algoritmalar denir ve bunlar 27. bölümde ele alınmaktadır.

<h3>Exercises</h3>

1.1-1 Sıralama(Sorting) gerektiren gerçek dünya örnekleri verin. İki nokta arasındaki en kısa mesafenin bulunmasını gerektiren bir örnek verin.

1.1-2 Hız dışında, gerçek dünya senaryolarında dikkate alınması gereken başka hangi verimlilik ölçütleri vardır?

1.1-3 Daha önce gördüğünüz bir data structure'i seçin ve güçlü ve zayıf yönlerini tartışın.

1.1-4 En kısa yol(shortest path) problemi ile gezgin satıcı(traveling-salesperson) problemi nasıl benzer ve nasıl farklıdır?

1.1-5 Sadece en iyi çözümün kabul edilebilir olduğu bir gerçek dünya problemi önerin. Daha sonra, yaklaşık(approximately) en iyi çözümün yeterli olduğu bir problem bulun.

1.1-6 Bazen tüm giriş verilerinin önceden mevcut olduğu, ancak bazen giriş verilerinin zamanla geldiği bir gerçek dünya problemi açıklayın.
