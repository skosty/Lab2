README for Assignment 2

Author: Susannah Kosty
Email: skosty@utexas.edu
Date: September 25, 2013

To compile and run: 

	javac *java
	java [v] CovertChannel <InputFile>

The v flag redirects standard output to a log file <InputFile>.log. Information sent to Lyle from <InputFile> is saved to <InputFile>.out. All created files are saved in the same directory as <InputFile>, not necessarily the working directory.

File writes append to file, so running multiple times will produce duplicate data concatenated to the end of the output files. To avoid this, remove all log and out files between runs. 

Below are shown perfomance data

File		Bytes	Time ms	Bits	Bandwidth bits/ms
Test		4	58	32	0.55172413 
Ovid (50 lines)	2098	13534	16784	1.240135954 
Ovid (80 lines)	3422	20540	27376	1.332814021 

