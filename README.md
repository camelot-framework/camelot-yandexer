Yandexer example
===
Camelot usage example. It uses PhantomJS via webdriver to fetch the count of the results of the search query from Yandex.
Then it accumulates the counts and displays them on the screen.

## How to launch

First make sure you have the following installed in your system:
* JDK >= 1.7
* Maven >= 3.2
* PhantomJS >= 1.9.0

Clone the project
```
git clone https://github.com/camelot-framework/camelot-yandexer.git
```

Launch it using maven command line
```
cd camelot-yandexer
mvn clean compile camelot-test:run
```

Open [http://localhost:8080/camelot](http://localhost:8080/camelot) in your browser. You should see the Camelot dashboard.
Add the Collector widget to the dashboard by selecting it from the "Manage widgets..." button. Now start entering the
search queries to the "Enter query" field and pressing the "Enter" button. You should see the count of the results for
each query on the screen after a while.
