
# Проект по автоматизации тестовых сценариев с помощью BrowserStack для приложения [Wikipedia](https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0) <img width="30" alt="Yadro" src="media/icons/Wikipedia-logo.svg">


## **Содержание:**

* [Технологии и инструменты](#star-технологии-и-инструменты)

* [Реализованные проверки](#open_file_folder-реализованные-проверки)

* [Запуск из терминала](#computer-запуск-из-терминала)

* [Сборка в Jenkins](#img-width25-altjenkins-srcmediaiconsjenkinssvg-сборка-в-jenkins)

* [Allure отчет](#img-width25-altallure-srcmediaiconsalluresvg-allure-отчет)

* [Интеграция с Allure TestOps](#img-width25-altalluretestops-srcmediaiconsallure_tosvg-интеграция-с-allure-testops)

* [Уведомление в Telegram при помощи бота](#img-width25-alttelegram-srcmediaiconstelegramsvg-уведомление-в-telegram-при-помощи-бота)

* [Примеры видео выполнения тестов на BrowserStack](#img-width25-altselenoid-srcmediaiconsselenoidsvg-примеры-видео-выполнения-тестов-на-selenoid)  
  <br>


---
## :star: Технологии и инструменты:

<p>
<a href="https://www.jetbrains.com/idea/"><img width="45" alt="IntelliJ IDEA" src="media/icons/Idea.svg"></a>
<a href="https://www.java.com/ru/"><img width="45" alt="Java" src="media/icons/java.svg"></a>
<a href="https://junit.org/"><img width="45" alt="JUnit5" src="media/icons/Junit5.svg"></a>
<a href="https://ru.selenide.org/"><img width="45" alt="Selenide" src="media/icons/Selenide.svg"></a>
<a href="https://ru.selenide.org/"><img width="45" alt="Appium" src="media/icons/appium.svg"></a>
<a href="https://ru.selenide.org/"><img width="45" alt="Appium Inspector" src="media/icons/appium_inspector.png"></a>
<a href="https://ru.selenide.org/"><img width="45" alt="BrowserStack" src="media/icons/BrowserStack.svg"></a>
<a href="https://allurereport.org/"><img width="45" alt="Allure" src="media/icons/Allure.svg"></a>
<a href="https://gradle.org/"><img width="45" alt="Gradle" src="media/icons/gradle-original.svg"></a>
<a href="https://www.jenkins.io/"><img width="45" alt="Jenkins" src="media/icons/jenkins.svg"></a>
<a href="https://qameta.io/"><img width="45" alt="Allure_TO" src="media/icons/Allure_TO.svg"></a>
</p>  
<br>


---
## :open_file_folder: Реализованные проверки:

- Проверка работы кнопок таббара: "Saved", "Search", "Activity"
- Поиск статей через строку поиска и через страницу поиска
  <br>


---
## :computer: Запуск из терминала:

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


---
## <img width="25" alt="Jenkins" src="media/icons/jenkins.svg"> Сборка в Jenkins:

<img alt="Сборка в Jenkins" src="media/images/jenkins.png">  
<br>


---
## <img width="25" alt="Allure" src="media/icons/Allure.svg"> Allure отчет:

**[Ссылка на Allure-отчет](https://jenkins.autotests.cloud/job/mobile-tests-kholomkina/4/allure/)**

**Overview:**

<img alt="Allure отчет" src="media/images/allure.png">
<br><br>

**Tests:**

<img alt="Allure отчет: тесты" src="media/images/allure-tests.png">  
<br>


---
## <img width="25" alt="AllureTestOps" src="media/icons/Allure_TO.svg"> Интеграция с Allure TestOps:

**[Ссылка на Allure TestOps](https://allure.autotests.cloud/project/5059/test-cases?treeId=9888)**


**Тест-кейсы:**

<img alt="Интеграция с Allure TestOps" src="media/images/AllureTestOps.png">
<br><br>

**Dashboard прогонов:**

<img alt="Интеграция с Allure TestOps: прогоны" src="media/images/AllureTestOps-прогоны.png">  
<br>


---
## <img width="25" alt="telegram" src="media/icons/telegram.svg"> Уведомление в Telegram при помощи бота:

<img alt="Интеграция с Telegram" src="media/images/telegram.png">
<br>


---
## <img width="25" alt="Selenoid" src="media/icons/BrowserStack.svg"> Примеры видео выполнения мобильных тестов на BrowserStack:

<img alt="BrowserStack video" src="media/gifs/wiki-mobile-test.gif"> 