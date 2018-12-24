# CS111CProjectE
Trees and Big Data
First modify a binary search tree so that it allows duplicates. Then, use this new binary search tree to organize records from a big data set.

Part A: Binary Search Tree with Duplicates (80 points)

The class BinarySearchTreeWithDups represents a binary search tree in which duplicate entries are allowed.

A duplicate entry is placed in the entrys left subtree.
The process is this:
When adding an element, use the same process a normal binary search tree:
if the current is smaller than the new element, go into the right subtree
if the current is greater than the new element, go into the left subtree
However, when you find an element that is the same as the new element:
First, go into the left subtree.
Then resume your normal binary search tree search.
Review the provided tree picture that uses data from the driver to make sure you understand how the duplicates are added.
In this implementation, we will assume the getEntry method returns the first match it finds and the remove method removes the first match it finds. So the only modification required is the add method.
The class BinarySearchTreeWithDups extends BinarySearchTree,

The class shell is provided with empty methods that you will modify.
There are many classes required to get this lab to compile.
All are included in the provided zip. 
You should only modify the BinarySearchTreeWithDups class.
Begin by closely reviewing BinarySearchTree and BinaryTree classes.
Make sure you understand how these classes work before you implement BinarySeachTreeWithDups. 
You must have a good understanding of how the regular BST class works before you can make modifications. 
I cannot stress this point enough!
Implement Methods in BinarySearchTreeWithDups
For all methods, take advantage of the sorted nature of a binary search tree to write efficient code.

Write a addEntryHelperNonRecursive(T) method (20 points)
We override the add method to call a new private addEntryNonRecursive method.
The helper method allows duplicate entries to be added, using the algorithm described above.
Important: This method must be written without recursion in order for Part B to run.
I recommend reviewing the addEntry method in BinarySearchTree class and then thinking about how to modify it.
Write a countEntriesNonRecursive(T) method (20 points)
The method counts the number of times an element appears in the tree.
Important: This method must be written without recursion in order for Part B to run.
Write a countGreaterRecursive(T) method (20 points)
The method counts the number of elements in the tree greater than the parameter.
The elements in the tree implement Comparable, so you can invoke the compareTo method on the data inside of any node.
This method uses recursion.
You can add a private helper method if necessary.
Write a countGreaterWithStack(T) method (20 points)
The method does the same as the method above, but is not recursive.
The method uses a stack.
Test your program
Use the driver program to test your methods. You might consider adding more tests to the driver.
The zip file includes a picture of the tree created by the driver.
Critical: Make sure Part A is working properly before moving on to Part B!

Part B: Big Data (20 Points)

Use the working BinarySearchTreeWithDups class to process a big data file.

The data file is a list of San Francisco police incident reports for Larceny/Theft from 2003 to 2015
Data was downloaded from here (Links to an external site.)Links to an external site.. 
There are over 370,000 records in the file. 
In eclipse, place the data file in the same folder as the src/bin folders (one level above the .java files).
I have provided two classes to process the file:
PoliceReport represents a single report.
ProjectEPartBDriver reads in the data file and creates a list. 
It then creates trees from the list (building from sorted ascending, sorted descending, and shuffled).
The driver then "processes" the tree and list by counting the number of reports that were submitted on a specified set of days.
The time for the processing is displayed.
PoliceReport objects are compared for ordering and equivalence by their date.
Two reports with the same date are considered logically equivalent- "the same." You can see this in the equals and compareTo methods of the PoliceReport class.
Note: I use a somewhat clunky/hacked method of identifying search criteria (creating a "dummyRecord" with only a single criteria on which to match). The proper way to do this would be to use Comparator objects or, better yet, the Java 8 methods of filtering and matching streams. However, these programming concepts are beyond what you are expected to know for our course, so I used the more simpler (but rather inelegant!) approach. Please do not take this as an endorsement of this approach!
Run these files as described below and submit brief written answers to the following questions.
Note: I put a limit on the number of records that are read in.
On my machine, the driver completed in about 4 minutes using the limit of 100,000 records.
You can adjust this limit to be smaller if needed based on your own system. 
You might need to lower the limit to get data to answer the questions below. (Consider maybe 30,000 records.)
If you want to run the whole data file to play around with it, you can set the "using limit" variable to be false. If you do this, however, I recommend commenting out Section C, or else you'll be waiting a long time! :) 
Part B Questions
Which version of the tree had the fastest processing (Section A- built from sorted ascending, Section B- build from shuffled, or Section C- built from sorted descending)? Why do you think that is?
How can you explain the difference in building and processing time between the two versions of the tree that were built from the sorted lists Sections A and C)? The tree built from the ascending list was faster. Why?
Hint: Try drawing a small tree to see what is going on. Perhaps a tree built from 1, 1, 2, 2, 3, 4, 4, 5 and from 5, 4, 4, 3, 2, 2, 1.
In Section B, which processing was faster- the tree built from the shuffled list or the unsorted list? How would you describe the big-o of what was going on in the processing with these two structures?
What characteristic of a binary search tree affects its efficiency?
Extra Credit (20 points)

Write an O(n) countUniqueValues() method that returns a count of all unique values in a tree. For example, a tree with the contents (1, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 7, 7) would return 7 because there are 7 unique values (1, 2, 3, 4, 5, 6, 7). Your method must be linear to receive full credit!

Provided Files

ProjectEFiles.zip


Submitting

Zip together all .java files together for submission.

Include all files- even the provided files- including the interfaces and unchanged classes. 
Include the BinarySearchTreeWithDups class.
Include the driver programs, interface files, and all supporting files in your zip.
Include your written answers to Part B in the zip- include these as a .txt, .doc, .rtf, or .pdf file.
If submitting as a group, submit one assignment only through one group member's Canvas account. Put the names of all group members in Canvas comment box on the submission page.
