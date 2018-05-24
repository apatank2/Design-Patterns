CSX42: Assignment 2
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
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=SECOND

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

[Date: 03/13/2018] 

-----------------------------------------------------------------------

Graduation Timeline for Students:-

The main purpose of this project is to apply State pattern. We have to 
process the list of courses for each student. Input file Contains Bnumbers 
and list of Courses. File Processor class reads each line from input file, 
and passes the list of courses and bnumber to context class. Default State
for student before processing the courses is Not Graduated. List of courses 
is processed one by one. Based on the Course it changes the state, if course 
is between A and P then state is changed to Process Category state else it 
is change to Process Elective State. After processing each course we check
if graduation criteria is meet, if it is satisified then we change the state to
Graduated state and stop processing the next courses. If it is not satisfied
then we change the state to Not Graduate and process the next course. We also
process waitlist before start of new semester.
For storing the Courses Completed, Waitlist made used of ArrayList Data Structure 
it is used to store group of objects and also we can define ArrayList re-sizeable 
array which can grow and shrink dynamically. Performance of arraylist is also 
same as arrays.

Implementation of Waitlist :-

Implementation of Pre-req:-
If student takes D in first sem then he cannot take A,B,C or D in next sem because 
subject of Higher order is already taken previous semester.
For Eg :-
123 : D Z X A

Implementation if Co-Req:-
I have implemented co-req Semester wise.
For Eg :-
324 : D Z A W X

Here even if D is highest order A will be assign because A-D are considered co-req for
that semester. D will be added in waitlist and it will be processed with A before the
next semester starts.

Now for courses in following order :-
123 : D Z A B W C
D and A will be assigned to student in semester 1 as they are considered co-req but B and C
will not be assigned because course of highest order that is D is already completed in
previous semester.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

