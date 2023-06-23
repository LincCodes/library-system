package library.system.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.system.librarysystem.entity.Librarian;
@Repository
public interface LibrarianRepo extends JpaRepository<Librarian, Integer>{

  Librarian findByEmailAndPassword(String email, String password);
}
