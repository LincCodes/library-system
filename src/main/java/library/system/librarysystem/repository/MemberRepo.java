package library.system.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.system.librarysystem.entity.Member;
@Repository
public interface MemberRepo extends JpaRepository<Member, Integer>{}
