package com.gannon.asm.classgenerator;

public class Book {
	int k;
	int j;

	public Book() {
		k = 0;
		j = 0;
	}

	public Book(int a, int b) {
		k = a;
		j = b;
	}
	

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book(5, 6);
	}

}
