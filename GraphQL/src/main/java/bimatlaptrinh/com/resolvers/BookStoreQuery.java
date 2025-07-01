package bimatlaptrinh.com.resolvers;

import bimatlaptrinh.com.BookStoreManager;
import bimatlaptrinh.com.model.Author;
import bimatlaptrinh.com.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookStoreQuery {

    private final BookStoreManager bookStoreManager;

    public BookStoreQuery() {
        this.bookStoreManager = new BookStoreManager();
    }

    @QueryMapping
    public List<Book> books() {
        return new ArrayList<>(bookStoreManager.getBooksMap().values());
    }

    @QueryMapping
    public List<Author> findAuthor(@Argument String name) {
        return bookStoreManager.getBooksMap().values().stream()
                .flatMap(book -> book.getAuthors().stream())
                .filter(author -> author.getName().equalsIgnoreCase(name))
                .distinct()
                .toList();
    }

}
