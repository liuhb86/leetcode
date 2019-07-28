# copied
# Read from the file file.txt and print its transposed content to stdout.
awk '{for(i=1;i<=NF;i++){array[NR][i]=$i;}} END{for (col=1; col <=NF; col++) {for (row=1; row <= NR; row++) {if (row==NR){printf("%s", array[row][col]);}else {printf ("%s ",array[row][col])}}printf "\n";}}' file.txt
