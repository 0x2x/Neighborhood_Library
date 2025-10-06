# Neighborhood Libary.

Using abrivated commands
<img width="335" height="136" alt="image" src="https://github.com/user-attachments/assets/2360c9ee-c019-499a-94c0-03397c46f632" />


allow users to Check-in books, Check-out books and run their own library within the terminal.

## How to add books
Going to the initalize function found in Main.java
Create a book variable with the Type Book and label the book on what you feel is nice.
Fill in the class data
```
Book bookTwenty = new Book(1250, "isbn_016", "Nigel and the Eternal Flame", true, "Nigel Davey", "Sophia");
Id: 1250
ISBN: isbn_016
Title: Nigel and the Eternal Flame
isCheckedOut: true
checkedOutTo: Nigel Davey
Author: Sophia
```

# Important Notice
Data is **not saved** when the program ends. -- everything resets to hard-coded text.
To make the data save and read and change on users touch.
1. create a json file
2. update the code to read and write from the json file
3. this will act as a basic database for your library system.
