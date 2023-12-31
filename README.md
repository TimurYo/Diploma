# Дипломный проект в рамках курса "Тестировщик ПО"
## Введение
Данный проект реализует системное тестирование веб-сервиса по покупке туров (далее продукт), оценивающее как функциональный аспект продукта, так и нефункциональный.

Функциональное тестирование включает в себя авто-тесты по следующим направлениям:
* UI-тестирование - функциональная оценка клиентской части продукта 
* API-тестирование - функциональная оценка клиент-серверного взаимодействия
* Тестирование баз данных - функциональная оценка систем управления базами данных (далее СУБД)

Нефункциональное тестирование включает в себя GUI-тестирование - оценка корректности графического интерфейса клиентской части продукта.

Также в проекте уделяется внимание тестированию требований, корректности технического задания.

## О тестируемом приложении
Приложение - это веб-сервис, который предлагает купить тур по определённой цене двумя способами:
1. Обычная оплата по дебетовой карте.
2. Уникальная технология: выдача кредита по данным банковской карты.

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

* сервису платежей, далее Payment Gate;
* кредитному сервису, далее Credit Gate.
Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом. Данные карт при этом сохранять не допускается.

Приложение состоит из 3 частей:
1. aqa-shop.jar - серверная часть приложения, содержащая в себе как front-end (html, css, js - оформление клиента), так и back-end (обеспечение взаимодействия с СУБД и gate-simulator) логику.
2. gate-simulator - эмулятор банковских серверов, обрабатывающих данные по карты, реализованный с помощью node.js.
3. СУБД - продукт поддерживает взаимодействие с 2 СУБД, MySQL и PostgeSQL.

[Подробнее о структуре продукта](https://github.com/netology-code/qa-diploma)

## Структура проекта
Техническая часть проекта: 
* [UI - тесты](https://github.com/TimurYo/Diploma/tree/main/src/test/java/uiTests), проверяющие покупку с помощью [дебетовой карты](https://github.com/TimurYo/Diploma/blob/main/src/test/java/uiTests/UiTestsPay.java), так и по [кредитной линии](https://github.com/TimurYo/Diploma/blob/main/src/test/java/uiTests/UiTestsCredit.java).
* [API - тесты](https://github.com/TimurYo/Diploma/blob/main/src/test/java/apiTests/ApiTests.java), оценивающие клиент-серверное взаимодействие.
* [Тестирование баз данных](https://github.com/TimurYo/Diploma/tree/main/src/test/java/dbTests) разделено на тестовые java-файлы, тестирующие таблицы баз данных по отдельности. Так структура таблиц в mySQL и postgeSQL идентична, тесты написаны универсально и способны работать с каждой из представленных СУБД.
* Проект интегрирован с [Appveyor CI](https://github.com/TimurYo/Diploma/blob/main/AppveyorStatus.md). [Описание запуска CI](https://github.com/TimurYo/Diploma/blob/main/.appveyor.yml)

Документальная часть проекта:
* [План системного тестирования продукта](https://github.com/TimurYo/Diploma/blob/main/projectDocuments/Plan.md)
* [Отчет по итога тестирования](https://github.com/TimurYo/Diploma/blob/main/projectDocuments/Report.md)
* [Комплексный отчет по итогам всего процесса автоматизации](https://github.com/TimurYo/Diploma/blob/main/projectDocuments/Summary.md)

## Создание окружения для запуска проекта
1. Для работы с проектом вам потребуются следующие предустановленные на ваш ПК приложения:
* [Intellij IDEA](https://www.jetbrains.com/ru-ru/idea/download/?section=windows) либо community edition, либо ultimate edition
* [Docker desktop](https://www.docker.com/products/docker-desktop/), либо Docker toolbox
* [Node.js](https://hub.docker.com/_/node)
* Git. Скорее всего Git у вас уже установлен.
* [Google Chrome](https://www.google.com/intl/ru_ru/chrome/)

2. После подготовки окружения вам необходимо выполнить клонирование этого проекта на ваш ПК (SSH-ключ: git@github.com:TimurYo/Diploma.git) и открыть в IDEA

## Запуск проекта
1. ### Создание и запуск docker-контейнеров с Gate-simulator и СУБД: MySQL и PosgreSQL 

Созданный docker-compose.yml содержит в себе параметры и описание необходимых контейнеров (gate-simulator, postgerSQL, mySQL). Поэтому для запуска в терминале вам требуется только ввести следующую команду:
```
docker-compose up
```

* _Так как тестовый объект - SUT поддерживает работу с mySQL и postgreSQL, для запуска jar-файла и авто-тестов с поддержкой каждой из СУБД вам потребуется 2 раза запускать приложение и авто-тесты. Перед новым запуском приложения закройте терминалы, в которых запускали jar-файл и авто-тесты, терминал с запуском контейнеров не закрывайте!_

2. ### Запуск SUT с поддержкой mySQL-СУБД 

* Так как по умолчанию проект работает с mySQL, для запуска приложения и авто-тестов вам не требуется командой передавать дополнительные параметры

Откройте еще один терминал и введите следующую команду для запуска приложения:
```
java -jar ./artifacts/aqa-shop.jar
```

Дождитесь сообщения следующего сообщения в терминале, означающего начало работы SUT:

```
2023-12-08 19:37:18.441  INFO 14676 --- [main] ru.netology.shop.ShopApplication: Started ShopApplication in 7.926 seconds (JVM running for 9 .372)
```

Для проверки корректности запуска SUT до запуска авто-тестов вы можете перейти по [ссылке](http://localhost:8080/).

Должна открыться главная страница сервиса по покупке туров
![image](https://i.gyazo.com/aa584a2c37f60dcee03904a3fffe265f.png)

3. ### Запуск авто-тестов с поддержкой mySQL

После успешного запуска SUT вам потребуется открыть еще один терминал (третий) для запуска авто-тестов.

Для этого в новом терминале введите следующую команду
```
./gradlew clean test --info
```
По завершении сборки проекта (запуска тестов) терминал будет доступен для ввода новых команд.
4. ### Формирование отчетов с помощью Allure по итогам тестирования SUT с поддержкой mySQL

В том терминале, в котором вы запускали авто-тесты по завершении последних введите следующую команду:
```
./gradlew allureServe
```
Об успешном формировании отчета будет свидетельствовать автоматически открывшаяся страница в google chrome.

5. ### Запуск SUT с поддержкой postgreSQL-СУБД

* Закройте открытые терминалы запуска jar-файла и авто-тестов. Терминал запуска контейнеров не закрывайте.

Заново откройте еще один терминал и введите следующую команду для запуска приложения:
```
java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar ./artifacts/aqa-shop.jar
```
На этот раз для запуска SUT с подключением к postgreSQL в команде мы передаем параметры подключения. 

Дождитесь сообщения следующего сообщения в терминале, означающего начало работы SUT:
```
2023-12-08 20:21:04.912  INFO 10288 --- [main] ru.netology.shop.ShopApplication: Started ShopApplication in 5.978 seconds (JVM running for 6.613)
```
Для проверки корректности запуска SUT откройте ту жу [страницу](http://localhost:8080/), которую запускали ранее.

6. ### Запуск авто-тестов с поддержкой postdreSQL

После успешного запуска SUT вам потребуется открыть еще один терминал (третий) для запуска авто-тестов.

Для этого в новом терминале введите следующую команду
```
./gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app --info
```
В команде передаем параметры подключения к базе данных, работающей с postgreSQL.
По завершении сборки проекта (запуска тестов) терминал будет доступен для ввода новых команд.

7. ### Формирование отчетов с помощью Allure по итогам тестирования SUT с поддержкой postgreSQL

В том терминале, в котором вы запускали авто-тесты по завершении последних введите следующую команду:
```
./gradlew allureServe
```
Об успешном формировании отчета будет свидетельствовать автоматически открывшаяся страница в google chrome.






