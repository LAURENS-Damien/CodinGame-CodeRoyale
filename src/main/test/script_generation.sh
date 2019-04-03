#!/bin/bash

# Initialisation
cd ..
dossier_racine=`pwd`
cd -
file_generated=`pwd`/file_generated.txt
rm $file_generated
`touch $file_generated`

# On injecte la classe main dans le fichier genere
main_directory=`find $dossier_racine/java -type d -name "main"`
cd $main_directory
cat `ls | head -1` > $file_generated

# On injecte toutes les classes dans le fichier genere
classes_directory=`find $dossier_racine/java -type d -name "classes"`
cd $classes_directory
for file in `ls`
do
    cat $file >> $file_generated
done

# On supprime les lignes commençant par 'package'
sed -i -e '/^package/d' $file_generated

# On supprime les lignes commençant par 'import'
sed -i -e '/^import/d' $file_generated

# On supprimer la portee devant les classes et les enums
sed -i -e 's/public class/class/g' $file_generated
sed -i -e 's/public enum/enum/g' $file_generated
