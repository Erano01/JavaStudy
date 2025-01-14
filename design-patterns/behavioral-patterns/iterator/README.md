<h1>Iterator</h1>

<h3>Intent</h3>
Altta yatan sunumu/yapıyı açığa çıkarmadan, torba nesnesinin elementlerine sırayla erişmenin bir yolunu sağlamak.

Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

// aggregate object -> torba nesnesi

<h3>Also Known As</h3>
Cursor

<h3>Motivation</h3>
Bir liste gibi torba nesne, iç yapısını açığa çıkarmadan elemanlarına erişmenin bir yolunu sağlamalıdır.
Ayrıca, neyi başarmak istediğinize bağlı olarak, listede farklı şekillerde gezinmek isteyebilirsiniz.
Ancak muhtemelen farklı gezinmeler için operasyonlar ile Liste arayüzünü şişirmek istemezsiniz, ihtiyaç duyacağınız operasyonları önceden tahmin edebilseniz bile.
Aynı listede birden fazla beklemeli gezinmeye(traversal pending) de ihtiyacınız olabilir.
Iterator patterni tüm bunları yapmanıza olanak tanır. Bu desendeki temel fikir, erişim ve gezinme sorumluluğunu liste nesnesinden alıp bir iterator nesnesine koymaktır.
Iterator sınıfı, listenin elemanlarına erişmek için bir arayüz tanımlar. Iterator nesnesi, geçerli elemanın izini sürmekten sorumludur; yani, hangi elemanın daha önce gezildiğini bilir.

Örneğin, bir List sınıfı, aralarında aşağıdaki ilişki olan bir Listlterator'ı çağırır:
![image](https://github.com/user-attachments/assets/fba3cee1-ad1d-4f34-b3d7-2b2212fcf8b8)

Listlterator'ı örnekleyebilmeniz için öncelikle gezilebilecek List'i sağlamanız gerekir. Listlterator örneğine sahip olduğunuzda, listenin elemanlarına sırayla erişebilirsiniz.
Currentltem operasyonu listedeki geçerli elemanı döndürür, First() operasyonu geçerli konumu ilk elemana ayarlar yani iteratoru başa alır, Next geçerli konumdaki elemanı bir sonraki elemana ilerletir ve IsDone son elemanın ötesine geçip geçmediğimizi, yani gezinmeyi tamamlayıp tamamlamadığımızı test eder.

Gezinme mekanizmasını Liste nesnesinden ayırmak, farklı gezinme politikaları için iteratorları Liste arayüzünde enumlaştırmadan tanımlamamızı sağlar.
Örneğin, FilteringListlterator yalnızca belirli filtreleme kısıtlamalarını karşılayan elemanlara erişim sağlayabilir.

Iterator ve listenin birbirlerine bağımlı(coupled) olduğunu ve client'in bunun başka bir torba mimariden(aggregate structure) ziyade, dolaşılan bir liste olduğunu bilmesi gerektiğini unutmayın. Çünkü client belirli bir torba mimariye kendini adar.
Client kodunu değiştirmeden torba sınıfa değişiklik uygulayabilirsek daha iyi olur.
Bunu, iterator kavramını polimorfik iterasyonu destekleyecek şekilde genelleştirerek yapabiliriz.

Örnek olarak, bir listenin SkipList gerçekleştirmesine de sahip olduğumuzu varsayalım.
Hem List hem de SkipList nesneleri için çalışan kod yazabilmek istiyoruz.

Listeleri işlemek için ortak bir arayüz sağlayan bir AbstractList sınıfı tanımlıyoruz. Benzer şekilde, ortak bir iterator arayüzünü tanımlayan soyut bir Iterator sınıfına ihtiyacımız var.
Daha sonra farklı liste gerçekleştirmeleri için somut Iterator alt sınıfları tanımlayabiliriz.
Sonuç olarak, iterator mekanizması somut torba(aggregate) sınıflarından bağımsız hale gelir.

![image](https://github.com/user-attachments/assets/60fb22b7-cdd6-402e-b110-c0ffa37d4df1)

Geriye kalan sorun iterator'un nasıl oluşturulacağıdır. Somut Liste alt sınıflarından bağımsız kod yazmak istediğimizden, belirli bir sınıfı basitçe örnekleyemeyiz.
Bunun yerine, liste nesnelerini, kendilerine karşılık gelen iteratoru oluşturmaktan sorumlu hale getiriyoruz.
Bu, clientlerin bir iterator nesnesi requestinde bulunduğu Createlterator gibi bir operasyonu gerektirir.

Createlterator() bir factory method örneğidir (bkz. Factory Method (107)). Bunu burada bir client'in uygun iterator için bir liste nesnesi istemesine izin vermek için kullanıyoruz.
Factory Method yaklaşımı, biri listeler için, diğeri iterator'lar için olmak üzere iki sınıf hiyerarşisine yol açar.
Createlterator factory methodu iki hiyerarşiyi "birbirine bağlar".

<h3>Applicability</h3>
Aşağıdaki durumlarda iterator patterni kullanın:
• Bir torba nesnenin içeriğine, onun iç sunumunu açığa çıkarmadan erişmek.
• Torba nesnelerin çoklu geçişlerini(multiple traversals) desteklemek için(Bunun için eş zamanlı programlama gerekebilir).
• Farklı torba mimarileri gezmek için tekdüze bir arayüz sağlamak (yani, polimorfik iterasyonu desteklemek).

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/a756853c-2c1f-412b-a394-f616eb7c795b)

<h3>Participants</h3>
• Iterator
Elemanlara erişmek ve onları gezebilmek için bir arayüz tanımlar.

• ConcreteIterator
 Iterator arayüzünü gerçekleştirir. Gezilen torbanın mevcut pozisyonun takibini yapar.

• Aggregate
Iterator nesnesi oluşturmak için arayüz tanımlar.
// Kendisinden torba nesnesi olarak bahsettik. Torba nesnesi soyutlaması sağlar.

• ConcreteAggregate
ConcreteIterator'un örneğini döndürmek için Iterator oluşturan arayüzü(Aggregate class/interface'i) gerçekleştirir.

<h3>Collaborations</h3>
Bir Concretelterator, torbadaki mevcut nesnelerin takibini yapar ve gezinmedeki sonraki gezinecek nesneyi hesaplar.

<h3>Consequences</h3>
Iterator patterninin üç önemli sonucu vardır:

1. Bir torbanın gezilmesi üzerinde varyasyonları destekler. Kompleks torbalar birçok farklı şekilde gezilebilir. Örneğin, code generation ve semantik kontrol operasyonları parse tree'ların gezilmesini gerektirir. Code generation, parse tree'yi inorder veya preorder şeklinde gezebilir. Iterator’lar, gezinme algoritmasını değiştirmeyi kolaylaştırır: Sadece mevcut iterator örneğini farklı bir tanesiyle değiştirmeniz yeterlidir. Ayrıca yeni gezinmeler desteklemek için Iterator alt sınıfları tanımlayabilirsiniz.
2. Iteratorlar torba arayüzlerini basitleştirir. Iterator'ın gezinme arayüzü, Torbada benzer bir arayüze olan ihtiyacı ortadan kaldırır ve böylece torba arayüzünü basitleştirir.
3. Torba üzerinde birden fazla gezinme beklemede olabilir. Iterator kendi gezinme durumunu izler. Bu nedenle aynı anda birden fazla gezinme sürecine sahip olabilirsiniz.

<h3>Related Patterns</h3>
Composite (163): Iteratorlar genellikle Composite gibi recursive mimarilere uygulanır.
Factory Method (107): Polimorfik iterator'lar, uygun Iterator alt sınıfını örneklendirmek için factory methodlarına güvenir.
Memento (283): genellikle Iterator pattern ile birlikte kullanılır. Bir iterator bir iterasyonun durumunu yakalamak için bir memento kullanabilir. Iterator mementoyu dahili(internal) olarak depolar.

//java'daki koleksiyon mimarisi örneği
![image](https://github.com/user-attachments/assets/604c5de6-ef1f-4741-940d-b19c0eb264e1)
