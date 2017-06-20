#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

void work(char * name, int seed) {
    int num_times;
    num_times = 10;

    srand(seed);

    int i;

    for (i = 0; i < num_times; i++) {
        sleep(rand() % 5);
        printf("%s: %d\n", name, i);    
    }

}

int main() {
	printf("funcion fork()\n");
	
	printf("pid = %d\n", getpid());

	int pid;
	pid = fork();	
    printf("pid = %d\n", pid);

    if (pid < 0) {
        perror("fork failed...");
    } else if (pid == 0) {
        printf("%s\n", "I am the child proccess");
        work("Child", rand());
        printf("%s\n", "Child finished");
        exit(0);
    }      

    printf("%s\n", "I am the parent proccess");
    work("Parent", rand());
    printf("%s\n", "Parent finished");

	return 0;
}
