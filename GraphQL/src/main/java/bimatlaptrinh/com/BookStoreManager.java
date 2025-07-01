package bimatlaptrinh.com;


import bimatlaptrinh.com.model.Author;
import bimatlaptrinh.com.model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookStoreManager {

    Map<String, Book> booksMap = new HashMap<String, Book>();



    public BookStoreManager() {

        Book mfeBook = new Book();

        mfeBook.setId("777");
        mfeBook.setTitle("Mindset for you");
        mfeBook.setCategory("Software");


        mfeBook.addAuthor(new Author("100101", "Nhat Dac", "Noi Bai, Ha Noi"));
        mfeBook.addAuthor(new Author("100100", "Nhat Dac", "Noi Bai, Ha Noi"));
        booksMap.put(mfeBook.getTitle(), mfeBook);

        Book apiSecBook = new Book();
        apiSecBook.setId("778");
        apiSecBook.setTitle("Advanced API Security");
        apiSecBook.setCategory("Software");
        apiSecBook.addAuthor(new Author("100100", "Nhat Dac", "Noi Bai, Ha Noi") );

        booksMap.put(apiSecBook.getTitle(), apiSecBook);

        Book esbBook = new Book();
        esbBook.setId("779");
        esbBook.setTitle("Beginning WSO2 ESB");
        esbBook.setCategory("Software");
        esbBook.addAuthor(new Author("100101", "Nhat Dac", "Noi Bai, Ha Noi"));

        booksMap.put(esbBook.getTitle(), esbBook);
    }

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

}
