package bookstore.demo.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
String title;
String author;
int publicationYear; 
String isbn; 
double price;
@ManyToOne
@JoinColumn(name ="categoryId")
private Category kategoria;
    public Book() {
    }

    
public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
public Book(String title, String author, int publicationYear, String isbn, double price, Category kategoria) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.kategoria = kategoria;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{");
        sb.append("title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", publicationYear=").append(publicationYear);
        sb.append(", isbn=").append(isbn);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public Category getKategoria() {
        return kategoria;
    }

    public void setKategoria(Category kategoria) {
        this.kategoria = kategoria;
    }
}