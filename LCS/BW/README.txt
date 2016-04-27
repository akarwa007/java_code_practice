ReadMe



Something about the Blob program implementation
———————————————————————————————————————————————

This program implements two algorithms. 
1. Naive Algorithm

This algorithm independently detects the top, left , right , bottom edges by finding
cells part of the blob and then moving away from them towards the end surface until a series of zeroes is found which confirms the edges.

2. Optimized Algorithm

This algorithm attempts to visit all member cells of the Blob by taking advantage of the 
neighborhood proper of blob. It keeps adjusting the top,left,right,bottom edges as it visits all the cells of the Blob. 


3. Limitations & Approach

a)This program is not a full fledged , all use case scenario , program. Rather is it for demonstration of the algorithm. 
b)It has a simple but strict input file format. 
c)It assumes an NXN matrix, though a legal Blob can be found in a NXM matrix as well. T   his will require only a minor change in the program.
d) I researched the web to find a program to start from. I found two solutions , once in python and the other in C++. 
   The python solution was incomprehensible , while the C++ code was locked. I then researched further and linked the blob edge detection to image processing and got a clue from there to use the visiting algorithm. 

How to run the Blob program 
———————————————————————————

1. Unzip the Archive.zip file to a folder
2. Remove the .txt extension from the Blob.java.txt and Blob.class.txt files.
3. Modify the file.txt file if you wish to. Otherwise let it default to the 10X10 blob.
   Ensure that you keep the format of the file as NxN , square matrix.
   Ensure that there is no empty string or empty line at the end of the file.

To run the Blob program through command line

java Blob file,txt

For the default file.txt file, it should print the following

------The Blob looks like this----------
0,0,0,0,0,0,0,0,0,0,
0,0,1,1,1,0,0,0,0,0,
0,0,1,1,1,1,1,0,0,0,
0,0,1,0,0,0,1,0,0,0,
0,0,1,1,1,1,1,0,0,0,
0,0,0,0,1,0,1,0,0,0,
0,0,0,0,1,0,1,0,0,0,
0,0,0,0,1,1,1,0,0,0,
0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,
--------------End of Blob--------------
Processing through Naive algorithm

Results

top is 1
left is 2
right is 6
bottom is 7
cellreads is 52
------The Blob looks like this----------
0,0,0,0,0,0,0,0,0,0,
0,0,1,1,1,0,0,0,0,0,
0,0,1,1,1,1,1,0,0,0,
0,0,1,0,0,0,1,0,0,0,
0,0,1,1,1,1,1,0,0,0,
0,0,0,0,1,0,1,0,0,0,
0,0,0,0,1,0,1,0,0,0,
0,0,0,0,1,1,1,0,0,0,
0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,
--------------End of Blob--------------
Processing through Optimized algorithm

Results

top is 1
left is 2
right is 6
bottom is 7
cellreads is 44
