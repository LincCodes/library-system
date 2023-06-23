package library.system.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.system.librarysystem.entity.Book;
import library.system.librarysystem.repository.BookRepo;


@Service
public class BookServ {
  
  @Autowired
  private BookRepo repo;

  public List<Book> allBooks(){
    return repo.findAll();
  }

  public void save(Book b){
    repo.save(b);
  }

  public Book getById(int id){
    return repo.findById(id).get();
  }
  public void deleteById(int id){
    repo.deleteById(id);
  }


}
