package library.system.librarysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.system.librarysystem.entity.Librarian;
import library.system.librarysystem.repository.LibrarianRepo;

@Service
public class LibrarianServ {

  @Autowired
  private LibrarianRepo repo;
  
  public void save(Librarian lib){
    repo.save(lib);
  }

  public Librarian exists(String email, String password){
    return (Librarian) repo.findByEmailAndPassword(email, password);
  }
}
