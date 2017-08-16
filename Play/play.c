
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#define SIZE 4
#define LOOP 50

int main() {

    printf("%s\n", "Hola mundo!");

    int * arreglo = malloc(SIZE * sizeof(int));

    int pid = getpid();

    printf("%s%d\n", "Parent pid: ", pid);

    int childPid = fork();

    //printf("%s%d\n", "Child pid: ", childPid);
 
    int i, j = 0, num;

    for (i = 0; i < LOOP; i++) {
        if (j == SIZE) {
            j = 0;       
        } 
        
        if (childPid > 0) {
            num = rand() % 100;
            printf("%s%d%s%d\n", "Saving to child number: ",
                num, " at position: ", j);
        } else {
            num = rand() % 100;
            printf("%s%d%s%d\n", "Saving to parent number: ",
                num, " at position: ", j);
        }

        arreglo[j] = num;

        j++;
    }

    return 0;
}
