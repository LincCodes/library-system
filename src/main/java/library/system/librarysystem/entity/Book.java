package library.system.librarysystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "book")
public class Book {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @Column(name="author")
  private String author;

  @Column(name="title")
  private String title;

  @Column(name="description")
  private String description;


  public Book() {
  }


  public Book(int id, String author, String title, String description) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.description = description;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  
}
