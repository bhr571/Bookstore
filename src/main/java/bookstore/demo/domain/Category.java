package bookstore.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long categoryId;
private String name;
@OneToMany(cascade=CascadeType.ALL, mappedBy="kategoria")
private List <Book> kirjat;
public Category(){}
public Category(String name) {
}
public long getCategoryId() {
    return categoryId;
}
public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
    @JsonIgnore
public List<Book> getKirjat() {
    return kirjat;
}
public void setKirjat(List<Book> kirjat) {
    this.kirjat = kirjat;
}
@Override
public String toString() {
    return this.name; 
}


}
