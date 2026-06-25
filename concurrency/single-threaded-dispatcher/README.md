# JCIP Event Lab (Spigot-Style)
Spigot benzeri event dispatch modelini **study amaçlı** yeniden inşa eden küçük bir demo proje.

## Why this project?
Bu proje, game-server tarzı event sistemlerinde:
- tek thread üzerinde deterministik dispatch,
- event priority sıralaması,
- cancellable event akışı,
- async işlerin güvenli boundary ile offload edilmesi

konularını anlamak için yazıldı.

## Goals
- Spigot’taki event modelini kavramsal olarak taklit etmek
- Concurrency kararlarını görünür hale getirmek
- JCiP prensipleriyle thread-safety pratikleri yapmak

## Non-goals
- Gerçek bir Minecraft API kopyası olmak
- Production-ready framework sunmak
- Maksimum performans optimizasyonu yapmak

## Architecture (high-level)
- **EventBus**: listener kayıt/çıkış ve dispatch
- **EventDispatcher**: priority sırasına göre handler çağrımı
- **Event (base)**: ortak event sözleşmesi
- **CancellableEvent**: akışı iptal edebilen event tipi
- **Scheduler/Executor boundary**: IO ve ağır işler için async geçiş

## Threading Model
- Oyun state’i benzeri mutable state: **main event thread** üzerinde işlenir
- Ağır/IO işler: executor’a offload edilir
- Async callback’ten main state erişimi: doğrudan değil, event/tick kuyruğu üzerinden

## Event Flow
1. Event publish edilir
2. Listener’lar priority sırasına göre çağrılır (`LOWEST -> MONITOR`)
3. Event cancellable ise, iptal durumu bir sonraki handler davranışını etkiler
4. Dispatch tamamlanır, metrik/log kaydı alınır

## Demo Scenarios
- **Scenario 1:** Basit event publish/subscribe
- **Scenario 2:** Priority sıralaması gözlemi
- **Scenario 3:** Cancellable event
- **Scenario 4:** Async task + main-thread handoff