###Scrabanagram
  + Problem 1 and 2 answers are available in `hw1.txt`

####Compiling and Running
Download all files.

mySQL:
  + Create database named 'dictionary'
  + Create table named 'dictionary' under the db
  + word VARCHAR(40), count INTEGER
  
To use preset wordlist:
Replace username and password with your own in TransferMain.java:
```bash
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE_NAME, "username", "password");
```

To use customized wordlist:
Replace words.txt with your own:
Replace username and password with your own in DictionaryMain.java:
```bash
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE_NAME, "username", "password");
```

####Credits:
https://github.com/thejasonhsu
