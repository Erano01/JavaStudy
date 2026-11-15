# Javadoc Documentation

Notlar kodun içinde Javadoc olarak tutulur:

- `src/main/javadoc/overview.html` → tüm concurrency projelerinin ana sayfası
- `package-info.java` → bölümün genel notları
- Sınıf Javadoc'u → örneğe özel notlar
- `//` satır yorumu → satır seviyesindeki kısa uyarılar

Gereksinimler: **JDK 25** ve **Maven**.

## IntelliJ'de okumak (en kolay yol)

- **Ctrl+Q**: imlecin üzerindeki sınıfın/paketin notlarını gösterir.
- **Ctrl+Alt+Q**: Javadoc'u dosyanın içinde biçimlenmiş halde gösterir (rendered view).
- Tarayıcıda görmek için sağdaki Maven panelinden: *Plugins → javadoc → javadoc:javadoc*.

IntelliJ Maven ile birlikte gelir; sadece *File → Project Structure → SDK* altında JDK 25 seçili olmalı.

## Arch Linux

```bash
# Kurulum (bir kerelik)
sudo pacman -S jdk25-openjdk maven git
sudo archlinux-java set java-25-openjdk

# Projeyi al
git clone https://github.com/Erano01/JavaStudy.git
cd JavaStudy/concurrency

# Tüm alt projelerin Javadoc'unu tek sitede üret ve sun
mvn javadoc:aggregate
jwebserver -p 8000 -d "$PWD/target/reports/apidocs"
```

Tarayıcıda **http://localhost:8000** adresini açın. Sunucuyu Ctrl+C ile kapatın.

> **Not:** Chrome Flatpak olarak kuruluysa `file://` ile `~/` altındaki dosyaları açamaz
> (`xdg-open` sessizce başarısız olur). Bu yüzden `jwebserver` kullanılıyor.
> `Address already in use` hatası alırsanız 8000 portunu başka bir süreç kullanıyordur;
> `-p 8001` gibi başka bir port deneyin.

## Windows 11 (PowerShell)

```powershell
# Kurulum (bir kerelik)
winget install EclipseAdoptium.Temurin.25.JDK
winget install Git.Git
# Maven: https://maven.apache.org/download.cgi adresinden zip'i indirip açın,
# bin klasörünü PATH'e ekleyin (ya da IntelliJ'yi kullanın)

# Projeyi al
git clone https://github.com/Erano01/JavaStudy.git
cd JavaStudy\concurrency

# Tüm alt projelerin Javadoc'unu tek sitede üret ve aç
mvn javadoc:aggregate
start target\reports\apidocs\index.html
```

Windows'ta dosya tarayıcıda doğrudan açılır; sunucu gerekmez.

## Notlar

- Maven Java 25'ten eski bir JDK ile çalışıyorsa build hata verir. Komutun başına
  `JAVA_HOME=/usr/lib/jvm/java-25-openjdk` ekleyin (Linux) veya varsayılan JDK'yı 25 yapın.
- Ana sayfada paketler projelere göre gruplanır. Yeni bir alt proje eklediğinizde
  `concurrency/pom.xml`'deki `<groups>` listesine bir `<group>` ve `overview.html`'e bir satır ekleyin.
- Tek bir projenin Javadoc'u için o projenin klasöründe `mvn javadoc:javadoc` çalıştırın.
- Notları değiştirdikten sonra `mvn javadoc:aggregate`'i tekrar çalıştırıp sayfayı yenilemeniz yeterli.
- `mvn site` gerekmez; çok fazla bağımlılık indirir. Notları görmek için `javadoc:aggregate` yeterli.
