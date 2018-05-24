CSX42: Assignment 1
Name:  Abhishek Patankar

Following are the commands and the instructions to run ANT on your project.
-----------------------------------------------------------------------

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------

## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 02/13/2018] 

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Student Courses Backup System :-
The main purpose of this project is to apply Observer pattern. We have to 
store the Bnumber and courses, student has registered. Input file Contains 
list of Bnumbers and Course corresponding to that Bnumber on each line. 
File Processor class reads each line from input file, we have to store 
this student data into a Data Structure. Data Structure used for storing 
student information is Binary Search Tree (BST) because the cost of 
Insert(), Find() is O(LogN) time complexity, where N is the number nodes 
in the tree so advantage is that we can perform operations in logarithmic 
time and it is also good for the performance when N is large. We can 
also get all the keys sorted order by just doing InOrder traversal on the 
tree. But if the tree is not balanced worst case will be O(n). File processor 
reads and returns line by line which is inserted into BST using Treebuilder 
class. Two copies of the BST, backup-1 and backup-2, are also created while 
the original BST is being created. For each node Bnumber and courses 
registered are stored, and the backup node 1 and backup node 2 of backup 1 
and backup 2 tree are registered as observer for a node of Original tree, 
so any changes are done to that node such as Deleting the course or updating 
the course then same is notified to the observers of that node. Basically
Observer pattern is implemented by updating each node in backup-1 and 
backup-2 whenever a node in the original BST is changed. For storing the 
observer made used of ArrayList Data Structure it is used to store group 
of objects and also we can define ArrayList re-sizeable array which can grow 
and shrink dynamically. Performance of arraylist is also same as arrays. So 
tree builder class is used to insert,search, update a node for BST. Node 
class is used to store Bnumber, courses and also child nodes that is left 
and right. As student canbe registered to multiple courses so used List to 
stored the multiple courses for every Bnumber. BST does not handle deletes. 
If all the courses are removed then also Bnumber stays as a node of a tree. 
Result class is used to write the output of the Original tree, backup1 
tree and backup2 tree into three output files and also there should be no 
difference between this three files.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

BST :-
https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
