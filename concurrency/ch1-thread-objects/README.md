<h1>Thread Objects</h1>

Her iş parçacığı, Thread sınıfının bir örneğiyle(instance) ile ilişkilendirilir. Concurrent bir uygulama oluşturmak için Thread nesnelerini kullanmanın iki temel stratejisi vardır.

1. Thread oluşturma ve yönetimini doğrudan kontrol etmek için, uygulamanın asenkron(asynchronous) bir taskı başlatması gerektiğinde her seferinde Thread'i örneklendirmeniz yeterlidir.
2. Thread yönetimini uygulamanızın geri kalanından soyutlamak için uygulamanın tasklarını bir yürütücüye(executor'a) iletin.

Bu bölüm, Thread nesnelerinin kullanımını belgelemektedir. Executorlar, diğer bölüm olan high-level concurrency objects da incelenmektedir.


<h1>Defining and Starting a Thread</h1>

Thread örneği oluşturan bir uygulama, o thread'de çalışacak kodu sağlamalıdır. Bunu yapmanın iki yolu vardır:

1. Bir Runnable nesnesi sağlayın. Runnable arayüzü, threadde yürütülen kodu içermesi amaçlanan tek bir method olan run() ‘ı tanımlar. HelloRunnable örneğinde olduğu gibi Thread constructor’una Runnable nesnesi geçirilir.

![image](https://github.com/user-attachments/assets/d9ee6d6d-fc4b-4056-a6af-3bbe556e4e0c)

2. Thread sınıfını subclasslama.Thread sınıfının kendisi Runnable'i gerçekleştirir, ancak run() methodu hiçbirşey yapmaz. Bir uygulama, HelloThread örneğinde olduğu gibi kendi run() gerçekleştirmesini sağlayarak Thread'i sınıfını subclasslayabilir.

![image](https://github.com/user-attachments/assets/83588c3c-1462-4bcc-a657-2d8adb40dc41)

Her iki örnekte de yeni bir thread başlatmak için Thread.start'ın çağrıldığına dikkat edin.

Bu idiomlardan hangisini kullanmalısınız? Runnable nesnesini kullanan ilk idiom daha geneldir, çünkü Runnable nesnesi Thread dışındaki bir sınıfı alt sınıfa ayırabilir.

İkinci idiom basit uygulamalarda kullanımı daha kolaydır, ancak task sınıfınızın Thread'in bir alt tipi olması gerektiği gerçeğiyle sınırlıdır. Bu ders, Runnable task'ını yürüten Thread nesnesinden ayıran ilk yaklaşıma odaklanır.
Bu yaklaşım daha esnek olmakla kalmaz, aynı zamanda daha sonra ele alınacak high-level thread management API'lerine de uygulanabilir.

Thread sınıfı, thread management için yararlı bir dizi method tanımlar. Bunlara, methodu çağıran thread'in durumu hakkında bilgi sağlayan veya thread'in durumunu etkileyen statik methodlar dahildir.
Diğer methodlar, thread'in ve Thread nesnesini yönetmeye dahil olan diğer threadlerden çağrılır. Bu methodlardan bazılarını aşağıdaki bölümlerde inceleyeceğiz.

<h1>Pausing Execution with Sleep</h1>

Thread.sleep, geçerli thread'in yürütülmesini belirli bir süre askıya almasına neden olur. Bu, işlemci zamanını bir uygulamanın diğer threadlere veya bir bilgisayar sisteminde çalışıyor olabilecek diğer uygulamalara sunmanın etkili bir yoludur.
Sleep methodu, aşağıdaki örnekte gösterildiği gibi hızlandırma için ve daha sonraki bir bölümdeki SimpleThreads örneğinde olduğu gibi, zaman gereksinimleri olduğu anlaşılan görevlere sahip başka bir threadi beklemek için de kullanılabilir.

İki overload edilmiş sleep methodu versiyonu sağlanır: biri uyku süresini milisaniyeye, diğeri ise uyku süresini nanosaniyeye belirtir. 
Ancak, bu uyku sürelerinin kesin olması garanti edilmez çünkü bunlar temeldeki işletim sisteminin sağladığı olanaklarla sınırlıdır.
Ayrıca, uyku(sleep) periyodu, daha sonraki bir bölümde göreceğimiz gibi, kesmelerle(interrupts) sonlandırılabilir. 
Her durumda, uykuyu çağırmanın threadi tam olarak belirtilen zaman periyodu boyunca askıya alacağını varsayamazsınız.

SleepMessages örneği, mesajları dört saniyelik aralıklarla yazdırmak için uyku modunu kullanır:

![image](https://github.com/user-attachments/assets/2b632a55-61ff-4ba5-998e-7a91be87a04c)

main methodunun tanımında InterruptedException throw ettiğine dikkat edin. Bu, sleep'in sleep etkinken başka bir thread'in geçerli thread'i kesmesi(interrupt) durumunda fırlatacağı bir exception'dur. Bu uygulama, kesintiye neden olacak başka bir thread'i tanımlamadığından, InterruptedException'u yakalama zahmetine girmez.

<h1>Interrupts</h1>
Bir interrupt, bir thread'e yaptığı işi bıraktırıp başka bir şey yapması gerektiğinin bir göstergesidir.
Bir thread'in bir kesintiye nasıl yanıt vereceğine karar vermek programcıya bağlıdır, ancak thread'in sonlanması çok yaygındır. Bu, bu derste vurgulanan kullanımdır.

Bir thread, kesintiye uğrayacak thread için Thread nesnesinde interrupt() methodunu çağırarak bir kesinti gönderir.
Kesinti mekanizmasının doğru çalışması için, kesintiye uğrayan threadin kendi kesintisini desteklemesi gerekir.

<h3>Supporting Interruption</h3>
Bir thread kendi kesintisini nasıl destekler? Bu, şu anda ne yaptığına bağlıdır. Thread, InterruptedException fırlatan methodları sık sık çağırıyorsa, bu istisnayı yakaladıktan sonra basitçe run methodundan döner.

Örneğin, SleepMessages örneğindeki central message döngüsünün bir thread'in Runnable nesnesinin çalıştırma yönteminde olduğunu varsayalım. O zaman kesmeleri desteklemek için aşağıdaki gibi değiştirilebilir:

![image](https://github.com/user-attachments/assets/6e613319-5692-43f6-814b-25d0db9f8453)

sleep() gibi, InterruptedException fırlatan birçok yöntem, geçerli işlemlerini iptal edecek ve bir kesinti alındığında hemen geri dönecek şekilde tasarlanmıştır.

Bir thread, InterruptedException fırlatan bir yöntemi çağırmadan uzun süre geçerse ne olur? O zaman, bir kesinti alındığında true döndüren Thread.interrupted'ı periyodik olarak çağırması gerekir.
Örneğin: 

![image](https://github.com/user-attachments/assets/f583fae3-e91c-4ece-a082-3f5d9d1b7af9)

Bu basit örnekte, kod yalnızca kesmeyi test eder ve kesinti çağrısı geldiğinde thread'dan çıkar.
Daha karmaşık uygulamalarda, bir InterruptedException fırlatmak daha mantıklı olabilir:

![image](https://github.com/user-attachments/assets/027c58df-a573-4038-ab4f-912ef012ad04)

Bu, kesme işleme kodunun bir catch ifadesinde merkezileştirilmesine olanak tanır.

<h3>The Interrupt Status Flag</h3>
Kesinti mekanizması, kesinti durumu olarak bilinen internal bir flag kullanılarak uygulanır. Thread.interrupt'ı çağırmak bu flag'ı ayarlar.
Bir thread, Thread.interrupted statik yöntemini çağırarak bir kesinti olup olmadığını kontrol ettiğinde, kesinti durumu temizlenir. 
Bir thread tarafından başka bir thread'in kesinti durumunu sorgulamak için kullanılan statik olmayan isInterrupted yöntemi, kesinti durumu flag'ını değiştirmez.

Konvansiyona göre, bir InterruptedException fırlatarak çıkan herhangi bir method, bunu yaptığında kesme durumunu temizler.

<h1>Joins</h1>
Join methodu bir thread'in diğerinin tamamlanmasını beklemesine izin verir. Eğer t, threadi şu anda yürütülmekte olan bir Thread nesnesiyse,
![image](https://github.com/user-attachments/assets/b10e9b15-b314-4131-a9fb-542d3e2cf23c)
geçerli thread'in, t'nin threadi sonlanana kadar yürütmeyi duraklatmasını sağlar.

Join'in overload edilmesi, programcının bir bekleme süresi belirlemesine olanak tanır. Ancak, uykuda olduğu gibi, join zamanlama için işletim sistemine bağlıdır, bu nedenle join'in tam olarak belirttiğiniz kadar bekleyeceğini varsaymamalısınız.

Sleep gibi, join de bir kesintiye InterruptedException ile çıkarak yanıt verir.



