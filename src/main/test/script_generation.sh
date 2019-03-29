#!/bin/bash
file_generated=`pwd`/file_generated.txt
`touch $file_generated`

#for file in `ls -R ../`
classes_directory=`find ../java -type d -name "classes"`
cd $classes_directory
for file in `ls`
do
    #echo `pwd`
    echo $file + '' + $file_generated
    cat $file > $file_generated
done
