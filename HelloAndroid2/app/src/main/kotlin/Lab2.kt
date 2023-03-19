/*
* Instructions
*
* Make a copy of this code in a new scratch file.
*
* Read the code provided
*
* Follow the instructions in the TODO
* messages and add code, or comments, as instructed
*
* You will not modify the code provided unless the instruction tells you to.
*
* To submit: Either create a Gist and submit the link to the Gist file https://gist.github.com/
* Or, submit your kotlin scratch file.
*
* * */


/** Variables **/

val product = "Graphics Card"

var quantity = 10
quantity = 20

// TODO create a new constant value to store the manufacturer. Set the value to "NVIDIA"

// TODO create a new variable to store the price. Set the price to 234.56, which is a number of dollars.

// TODO write a comment and explain why the following line is an error
//product = "Motherboard"

// TODO write a comment and explain why the following line is an error
//product = null

// TODO print a message, using the variables declared above, and template string
//  "The product name is Graphics Card, the manufacturer is NVIDIA, the quantity available is 20, and the price each is $234.56"



/** Conditional Code **/

// use the variables declared above.

// TODO write an if-else statement to print the message "Graphics cards are available" if the quantity
//  variable is 1 or more.
//  Else, print the message "No graphics cards available".
//  You may change the value of the quantity variable to test your code.


// Graphic card prices are divided into three categories.
// Graphics cards that cost up to $100 are cheap
// Graphics cards that cost more than $100, up to $200 are mid-range
// Graphics cards that cost more than $200 are expensive

// TODO write code to create a string description "cheap", "mid-range" or "expensive" based on the price of
//  the graphics card variable declared above.  You may use if/else if/else or a when statement.

// TODO print a message with the price of the graphics card, and the price category name.
//  For example, "The graphics card costs $234.56 and is in the expensive category."
//  You may change the value of the price variable to test your code.



/** Functions **/

// TODO write a function that takes two String arguments, and returns a String value.
//  Your function will compare the length of the two Strings, and return the longer string.
//  If the strings are the same length, return the first String.
//  Call your function with some example data to verify it is working correctly.
//  For example, if your function is called with "Albatross" and "Bird" it will return "Albatross" because it has more letters.
//  For example, if your function is called with "Cat" and "Elephant" it will return "Elephant" because it has more letters.
//  For example, if your function is called with "Cat" and "Dog" it will return "Cat" because the two strings have the same number of letters, but "Cat" is the first argument.



/** Lists **/

val androidVersions: MutableList<String> = mutableListOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
    "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kitkat", "Lollipop", "Marshmallow",
    "Nougat", "Oreo", "Pie", "Quince Tart", "Red Velvet Cake", "Snow Cone", "Tiramisu")

// TODO add the newest Android version code name to the end of the androidVersions list

// TODO read the earliest Android version from the list and print it

// TODO read the newest Android version from the list, and print it

// TODO print the number of Android versions in the list


val trees = listOf("Oak", "Pine", "Birch")
// TODO write a comment to explain why the following line is an error
// TODO how can you fix this error?
//trees.add("Fir")

// TODO print the name of each tree, one per line.



/** Maps **/

val stateTrees = mutableMapOf("Michigan" to "White Pine", "Minnesota" to "Red Pine", "Wisconsin" to "Sugar Maple")

// TODO write a statement to add Iowa's state tree, the "Bur Oak" to the stateTrees map

// TODO read Minnesota's state tree from the map and print it

// TODO write code to calculate how many state trees are types of pine tree.
//  In other words, count the number of values in the map that contain the text "Pine".



/** Null safety **/

// TODO using the stateTrees map, read California's state tree, and print the name of that tree in uppercase.
//  If that tree is not found in the map, print "No Tree Found".

// TODO what type of data is returned for the value? Explain why it isn't a String.