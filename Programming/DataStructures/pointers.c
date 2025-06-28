// Task001: Pointers.

#include<stdio.h>
void main(){
	int age;
	int *ptr;
	age = 10;
	ptr = &age;
	printf("value of age is %d\n", age);
	printf("ptr is pointing to %d\n", *ptr);
	printf("address of age %d \n", &age);
	printf("value of ptr %d \n", ptr);
	printf("value of &ptr %d \n",&ptr);

}
