# Book Reviews

Book Reviews Test project

These are the Project Files.

## Run from Project Files

To run the project from the files , the easiest way is to open them in
any IDE( IntelliJ IDEA in my case).

The configuration will be initialized automatically,
so you will just have to press the green run arrow.

![img.png](img.png)

## Run from JAR file (recommended)

The easiest way to run the project is through the jar file provided (Google Drive from link in the name or email) (unzip
it
first) :

[demo-0.0.1-SNAPSHOT.jar](https://drive.google.com/file/d/1943iBpI3DLK5-zpMIBdDqNDnBqH9KHDV/view?usp=sharing)

1. open terminal
2. cd to the folder where demo-0.0.1-SNAPSHOT.jar exists
3. run :

   ```
   java -jar demo-0.0.1-SNAPSHOT.jar
   ```

This is the file exported after running the application in IntelliJ .

## Requests (API Calls)

Examples :

```
curl -X GET --location "http://localhost:8080/api/v1/reviews"

curl -X GET --location "http://localhost:8080/api/v1/reviews/sortByRating?numberOfBooks=10"

curl -X POST --location "http://localhost:8080/api/v1/reviews/add" \
    -H "Content-Type: application/json" \
    -d "{
          \"bookId\": 2,
          \"rating\": 1,
          \"review\":\"\"
        }"
       
curl -X GET --location "http://localhost:8080/api/v1/books" 

curl -X GET --location "http://localhost:8080/api/v1/books/2"

curl -X GET --location "http://localhost:8080/api/v1/bookReviews/2"
```