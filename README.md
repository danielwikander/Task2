# TaskOne - Writes n lines of random numbers to a file.

### Installation
```
git clone https://github.com/danielwikander/Task2
cd Task2/src/
javac TaskTwo.java
```

### How to run
`java TaskTwo [filepath] [order]`

For example:

`java TaskTwo testFile desc`

Using the above command, TaskTwo will print all the numbers from 'testFile' in descending order.

### Manpage
```
NAME
    TaskTwo - Reads numbers from a file and prints them in order.

Synopsis 
    TaskTwo [filepath] [order]
    
Description
    Reads numbers from a file and prints them in order.
    Requires one argument to run (filepath).
    The second argument selects the order to sort in.
    If no order is given, it will be sorted in ascending order.
    Arguments must be written in the order: filepath, sorting order.

Arguments
    filepath:         The path the the file to create/overwrite. Must be a valid filepath.
    order [OPTIONAL]: The order that the numbers will be printed in.
                      Order can be 'asc' (ascending) or 'desc' (descending).

Examples
    TaskTwo testFile desc
        The file 'testFile' will be read and its numbers will be printed in descending order.
    TaskTwo testFile
        The file 'testFile' will be read and its numbers will be printed in ascending order.
```
