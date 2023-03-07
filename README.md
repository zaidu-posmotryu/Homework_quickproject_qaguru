## Небольшой автотест для проверки инструментов поиска на сайте [wildberries.ru](https://www.wildberries.ru/)
### Технологический стек
________
<img src="images/logo/Java.svg" width="50" height="50"/>   <img src="images/logo/Intelij_IDEA.svg" width="50" height="50"/>   <img src="images/logo/Gradle.svg" width="50" height="50"/>   <img src="images/logo/JUnit5.svg" width="50" height="50"/>   <img src="images/logo/Selenide.svg" width="50" height="50"/>   <img src="images/logo/GitHub.svg" width="50" height="50"/>   <img src="images/logo/Jenkins.svg" width="50" height="50"/>   <img src="images/logo/Selenoid.svg" width="50" height="50"/>   <img src="images/logo/Allure_Report.svg" width="50" height="50"/>   <img src="images/logo/Allure_TestOps.svg" width="50" height="50"/>      <img src="images/logo/Jira.png" width="50" height="50"/>   <img src="images/logo/Telegram.svg" width="50" height="50"/>

-----
* Написан на ``Java`` с использованием фреймворка ``Selenide``
* Применяется фреймворк для модульного тестирования ``JUnit 5`` 
* ``Gradle`` используется для автоматизированной сборки проекта
* Удаленно тест запускается с помощью сервера``Jenkins``
* ``Selenoid`` запускает браузеры в контейнерах ``Docker``
* Система ``Allure Report`` формирует отчет о запуске тестов
* Интеграция с ``Jira`` и ``Allure TestOps``
* ``Telegram``-бот отправляет уведомление о результатах прохождения тестов

###  Содержание тестов:
Проверка работы инструментов поиска по сайту при
1. введении запроса в поисковую строку
2. клике на автоподсказку
3. установке определенного параметра в фильтре результатов
4. переходе на страницу товара и окно быстрого просмотра
5. смене валюты для отображения цен
6. смене пункта выдачи товара

### <img src="images/logo/Jenkins.svg" width="40" height="40"/> Параметризованная сборка в [Jenkins](https://jenkins.autotests.cloud/job/016-sun_of_summer-Homework-quickproject/build?delay=0sec) 

<img src="images/screenshots/jenkins_job.png" width="80%" height="80%"/>  

### <img src="images/logo/Allure_Report.svg" width="50" height="50"/> Чтобы увидеть отчёт о прохождении тестов в Allure Report, нужно кликнуть на иконку **"Allure Report"**  

 <img src="images/screenshots/allure-overview.PNG" width="80%" height="80%"/>  

 <img src="images/screenshots/allure-behaviors.PNG" width="80%" height="80%"/>  

### <img src="images/logo/Allure_TestOps.svg" width="50" height="50"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1970/dashboards)

<img src="images/screenshots/testops-dashboard.PNG" width="80%" height="80%"/> 

<img src="images/screenshots/testops-testcases.PNG" width="80%" height="80%"/> 

### <img src="images/logo/Allure_TestOps.svg" width="50" height="50"/> Интеграция с Jira

<img src="images/screenshots/jira.PNG" width="80%" height="80%"/> 

### <img src="images/logo/Selenoid.svg" width="30" height="30"/> Видео прохождения тестов в Selenoid  

![Alt text](selenoid-test-video.gif)


### <img src="images/logo/Telegram.svg" width="30" height="30"/> Уведомления о прохождении тестов в Telegram  

<img src="images/screenshots/telegram-bot.PNG" width="30%" height="30%" />  
