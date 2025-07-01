package bimatlaptrinh.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    private String id;
    private String title;
    private String category;
    private ArrayList<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        authors.add(author);
    }
}
