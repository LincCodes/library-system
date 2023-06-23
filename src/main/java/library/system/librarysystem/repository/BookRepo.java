package library.system.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.system.librarysystem.entity.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{}
