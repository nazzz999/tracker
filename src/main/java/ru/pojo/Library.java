package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("Золушка", 235);
        Book bookTwo = new Book("Спящая красавица", 134);
        Book bookThree = new Book("Гадкий утенок", 78);
        Book bookFour = new Book("Clean Code", 132);
        Book[] books = new Book[4];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;

        System.out.println("Список всех книг: ");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPage());
        }

        System.out.println("Перестановка 0 и 3: ");
        Book bookOther = books[0];
        books[0] = books[3];
        books[3] = bookOther;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPage());
        }

        System.out.println("Книга с названием Clean Code: ");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " - " + book.getPage());
            }
        }
    }
}
