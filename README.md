# Запуск тестов

### Локальный запуск

Для локального запуска тестов используйте следующую команду:
```
./gradlew clean local-test -Dplatform=emulator
```
Параметр `platform` может принимать значения `emulator` либо `real-device` в зависимости от того, где планируется запуск тестов (эмулятор либо мобильный телефон).

---

### Запуск на Browserstack

Для запуска тестов удаленно на Browserstack используйте команду, где в параметры userName и accessKey передаются креды для доступа к Browserstack:
```
./gradlew clean bs-test -Dplatform=android -DuserName=ИМЯ_ПОЛЬЗОВАТЕЛЯ -DaccessKey=КОД_ДОСТУПА
```
Параметр `platform` может принимать значения `android` либо `ios` в зависимости от того, на какой платформе планируется запуск тестов (ios, android).
