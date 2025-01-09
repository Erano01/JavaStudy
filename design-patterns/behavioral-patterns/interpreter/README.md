<h1>Interpreter</h1>

<h3>Intent</h3>
Bir dil verildiğinde, dilbilgisi(grammer) için bir gösterim(representation) ve bu gösterimi kullanarak dildeki cümleleri yorumlayan bir yorumlayıcı(interpreter) tanımlayın.

Given a language, define a represention for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

//Burada bahsedilen “language” programlama dili olan değil string bir ifadeyi, cümleyi kastetmektir.

<h3>Motivation</h3>
Belirli bir tür sorun yeterince sık meydana geliyorsa, o zaman sorunun örneklerini basit bir dilde cümleler halinde ifade etmek faydalı olabilir.
Daha sonra bu cümleleri yorumlayarak sorunu çözen bir yorumlayıcı oluşturabilirsiniz.
Örneğin, bir desenle(pattern ile) eşleşen stringleri aramak yaygın bir sorundur.
Regular expression'lar, stringlerin patternlarini belirtmek için kullanılan standart bir dildir.
Her patterni stringlerle eşleştirmek için özel algoritmalar oluşturmak yerine, arama(search) algoritmaları, eşleştirilecek bir dizi stringi belirten regular expression'u yorumlayabilir.
Interpreter design patterni, basit diller için bir dilbilgisinin nasıl tanımlanacağını, cümlelerin dil içinde nasıl temsil edileceğini ve bu cümlelerin nasıl yorumlanacağını açıklar.
Aşağıdaki dilbilgisinin regular expressionları(düzenli ifadeleri) tanımladığını varsayalım:

![image](https://github.com/user-attachments/assets/ce032321-28ec-4402-a8fd-1c6eda6f05b5)

Sembol ifadesi(symbol expression) başlangıç ​​sembolüdür ve literal bir terminal sembolüdür ve basit kelimeleri tanımlar.
Interpreter design patterni her dilbilgisi kuralını temsil etmek için bir sınıf kullanır. Kuralın sağ tarafındaki semboller bu sınıfların instance değişkenleridir.
Yukarıdaki dilbilgisi beş sınıfla temsil edilir: soyut bir sınıf RegularExpression ve onun dört alt sınıfı LiteralExpression, AlternationExpression, SequenceExpression ve RepetitionExpression
Son üç sınıf, alt ifadeleri(sub expressions) tutan değişkenleri tanımlar.
![image](https://github.com/user-attachments/assets/2ba020b1-e9c3-46e5-8293-dc224bb72df0)

Bu dilbilgisi tarafından tanımlanan her regular expression, bu sınıfların örneklerinden oluşan soyut bir syntax ağacıyla temsil edilir. Örneğin, soyut syntax ağacı(abstract syntax tree)

![image](https://github.com/user-attachments/assets/67909dec-acd1-478b-924a-eb0c56d15035)

RegularExpression'ın her alt sınıfında Interpret operasyonunu tanımlayarak bu düzenli ifadeler için bir yorumlayıcı oluşturabiliriz.
Yorumlama, ifadenin yorumlanacağı contexti bir argüman olarak alır. Context, input stringini ve şimdiye kadar ne kadarının eşleştirildiğine dair bilgileri içerir.
RegularExpression'ın her alt sınıfı, geçerli bağlama göre input stringinin bir sonraki kısmıyla eşleşmek için Interpret'i gerçekleştirir.
Örneğin,
• LiteralExpression, girdinin tanımladığı literal ile eşleşip eşleşmediğini kontrol edecektir
• AlternationExpression, girdinin alternatiflerinden herhangi biriyle eşleşip eşleşmediğini kontrol edecektir.
• RepetitionExpression, girdinin tekrarladığı ifadenin birden fazla kopyasına sahip olup olmadığını kontrol eder.

<h3>Applicability</h3>
Yorumlanacak bir dil olduğunda Interpreter design patternini kullanın ve dildeki ifadeleri soyut syntax ağaçları olarak temsil edebilirsiniz. Interpreter patterni şu durumlarda çok iyi çalışır:

• Dilbilgisi basit olacaksa. Karmaşık dilbilgileri için, dilbilgisi için sınıf hiyerarşisi büyük ve yönetilemez hale gelir. Parser generatorları gibi araçlar bu gibi durumlarda daha iyi bir alternatiftir. Soyut syntax ağaçları oluşturmadan ifadeleri yorumlayabilirler, bu da alandan ve muhtemelen zamandan tasarruf sağlayabilir.
• verimlilik kritik bir endişe değilse. En verimli yorumlayıcılar genellikle parse ağaçlarını doğrudan yorumlayarak değil, önce başka bir biçime çevirerek gerçekleştirilir. Örneğin, regular expressionlar sıklıkla state machinelarına dönüştürülür. Ancak o zaman bile, yorumlayıcı Interpreter design pattern tarafından gerçekleştirilebilir, bu nedenle pattern hala uygulanabilirdir.

<h3>Structure</h3>
![image](https://github.com/user-attachments/assets/727d8655-a608-4dbe-a143-8189ab7ebcf0)

<h3>Participants</h3>
• AbstractExpression (RegularExpression)
soyut syntax ağacındaki tüm düğümler(nodes) için ortak olan soyut bir Interpret() operasyonu tanımlar.

• TerminalExpression (LiteralExpression)
dilbilgisindeki terminal sembollerle ilişkili bir Interpret() operasyonu gerçekleştirir. Bir cümledeki her terminal sembol için bir instance gereklidir.

• NonterminalExpression (AlternationExpression, RepetitionExpression, SequenceExpressions)
dilbilgisindeki her ![image](https://github.com/user-attachments/assets/0d1973a3-9a78-4a2e-8713-a722fe23a172)  kuralı için böyle bir sınıfa ihtiyaç vardır. R1'den Rn'ye kadar olan sembollerin her biri için AbstractExpression tipinde instace değişkenleri korur.
dilbilgisindeki nonterminal olan semboller için bir Interpret operasyonu gerçekleştirir. Interpret, genellikle R1'den Rn'ye kadar olan değişkenleri temsil eden değişkenler üzerinde kendini yinelemeli(recursively) olarak çağırır.

• Context
interpreter için global olan bilgileri içerir.

• Client
dilbilgisinin tanımladığı dilde belirli bir cümleyi temsil eden soyut bir syntax ağacı oluşturur (veya verilir). 
Soyut syntax ağacı NonterminalExpression ve TerminalExpression sınıflarının instancelarından derlenmiştir(assembled). Interpret operasyonunu invoke eder(çağırır).

<h3>Collaborations</h3>
• Client, cümleyi NonterminalExpression ve TerminalExpression örneklerinin soyut bir syntax ağacı olarak oluşturur (veya verilir). Daha sonra client context'i başlatır ve Interpret() operasyonunu çağırır.
• Her NonterminalExpression düğümü(node), Interpret'i her alt ifadede(subexpression) Interpret açısından tanımlar. Her TerminalExpression'ın Interpret operasyonu, yinelemedeki(recursion) temel durumu tanımlar.
• Her düğümdeki Interpret() operasyonları, yorumlayıcının durumunu depolamak ve erişmek için context'i kullanır.

<h3>Consequences</h3>
Interpreter design patternin aşağıdaki faydaları ve dezavantajları vardır:

1. Dilbilgisini değiştirmek ve genişletmek kolaydır. Bu design pattern dilbilgisi kurallarını temsil etmek için sınıfları kullandığından, dilbilgisini değiştirmek veya genişletmek için inheritance kullanabilirsiniz. Mevcut ifadeler artarak değiştirilebilir ve yeni ifadeler eski ifadelerin varyasyonları olarak tanımlanabilir.

2. Dilbilgisini gerçekleştirmek da kolaydır. Soyut syntax ağacında düğümleri tanımlayan sınıfların benzer gerçekleştirmeleri vardır. Bu sınıfların yazılması kolaydır ve genellikle bunların oluşturulması bir compiler veya parser generator ile otomatikleştirilebilir.

3. Kompleks dilbilgisi kurallarının bakımı zordur. Interpreter patterni dilbilgisindeki her kural için en az bir sınıf tanımlar (BNF kullanılarak tanımlanan dilbilgisi kuralları birden fazla sınıf gerektirebilir). Bu nedenle birçok kural içeren dilbilgilerinin yönetimi ve bakımı zor olabilir. Sorunu hafifletmek için başka design patternlar uygulanabilir (Uygulama bölümüne bakın). Ancak dilbilgisi çok karmaşık olduğunda parser veya compiler generator'leri gibi diğer teknikler daha uygundur

//BNF (Backus-Naur Form), bir dilin sentaksını veya gramerini tanımlamak için kullanılan resmi bir gösterimdir.
![image](https://github.com/user-attachments/assets/7a4e7411-296d-4c61-9222-2e991b339159)

4. İfadeleri yorumlamanın yeni yollarını ekleme. Interpreter patterni, bir ifadeyi yeni bir şekilde değerlendirmeyi daha kolay hale getirir. Örneğin, ifade sınıflarında yeni bir operasyon tanımlayarak bir ifadenin güzel yazdırılmasını(pretty printing) veya type-checking'i destekleyebilirsiniz. Bir ifadeyi yorumlamanın yeni yollarını oluşturmaya devam ediyorsanız, dilbilgisi sınıflarını değiştirmekten kaçınmak için Visitor (331) desenini kullanmayı düşünün.

<h3>Implementation</h3>
Interpreter ve Composite (163) patternleri birçok gerçekleştirme sorununu paylaşır. Aşağıdaki sorunlar Interpreter'a özgüdür:

1. Soyut syntax ağacının(Abstract syntax tree) oluşturulması. Interpreter design pattern, soyut syntax ağacının nasıl oluşturulacağını açıklamaz. Başka bir deyişle, parsing'i ele almaz. Soyut syntax ağacı, table-driven parser, hand-crafted parser (genellikle recursive descent) veya doğrudan client tarafından oluşturulabilir.

2. Interpret operasyonunu tanımlama. Interpret operasyonunu ifade sınıflarında tanımlamanız gerekmez. Eğer yeni bir yorumlayıcı oluşturmanın yaygın olduğu bir durum söz konusuysa, Interpret işlemini ayrı bir "ziyaretçi" (visitor) nesnesine koymak için Visitor (331) desenini kullanmak daha iyi olur. Örneğin, bir programlama dili için oluşturulan bir gramer, soyut sözdizim ağaçları üzerinde tür kontrolü (type-checking), optimizasyon, kod üretimi gibi birçok işlem gerektirir. Bu işlemleri her gramer sınıfında tanımlamaktan kaçınmak için bir ziyaretçi kullanılması daha olasıdır. 

3. Terminal sembollerin Flyweight deseniyle paylaşılması. Cümlelerinde bir terminal sembolün birçok kez geçtiği gramerler, bu sembolün tek bir kopyasının paylaşılmasından fayda sağlayabilir. Bilgisayar programlarına ait gramerler buna iyi bir örnektir—her program değişkeni kod boyunca birçok yerde görünebilir. Motivasyon örneğinde, bir cümle terminal sembolü olan dog'ı (LiteralExpression sınıfıyla modellenen) birçok kez içerebilir. Terminal düğümler genellikle soyut sözdizim ağacındaki konumlarıyla ilgili bilgi saklamaz. Üst düğümler, yorumlama sırasında ihtiyaç duydukları bağlamı onlara iletir. Bu nedenle, paylaşılan (intrinsic) durum ile dışarıdan iletilen (extrinsic) durum arasında bir ayrım vardır ve Flyweight (195) deseni uygulanır. Örneğin, dog için oluşturulan her LiteralExpression örneği, şimdiye kadar eşleşen alt dizgiyi (substring) içeren bir bağlam alır. Ve bu tür her LiteralExpression örneği, ağacın neresinde olursa olsun aynı işlemi yapar: Yorumlama işleminde, girdinin bir sonraki bölümünün dog içerip içermediğini kontrol eder.

<h3>Known Uses</h3>
Interpreter deseni, nesne yönelimli dillerle yazılmış derleyicilerde yaygın olarak kullanılır; örneğin, Smalltalk derleyicileri. SPECTalk, giriş dosya formatlarının tanımlarını yorumlamak için bu deseni kullanır [Sza92]. QOCA constraint-solvingtoolkit, constraintleri değerlendirmek için bu deseni kullanır [HHMV92].
Eğer pattern en genel biçimiyle ele alınırsa (yani, Composite patternine dayanan bir sınıf hiyerarşisi üzerinde dağıtılmış bir işlem olarak), neredeyse her Composite deseni kullanımı Interpreter desenini de içerir. Ancak, Interpreter deseni, sınıf hiyerarşisini bir dil tanımlıyor gibi düşünmek istediğiniz durumlar için ayrılmalıdır.

<h3>Related Patterns</h3>
Composite (163): Abstract syntax tree, Composite patternin bir instance'idır.
Flyweight (195), Abstract syntax tree'da terminal sembollerinin nasıl paylaşılacağını gösterir.
Iterator (257): Interpreter, mimariyi dolaşmak için bir Iterator kullanabilir.
Visitor (331), Abstract syntax tree'daki her düğümdeki davranışı tek bir sınıfta maintain etmek için kullanılabilir.

