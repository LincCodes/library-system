package library.system.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.system.librarysystem.entity.Member;
import library.system.librarysystem.repository.MemberRepo;


@Service
public class MemberServ {
  
  @Autowired
  private MemberRepo repo;

  public List<Member> allMember(){
    return repo.findAll();
  }

  public void save(Member m){
    repo.save(m);
  }

  public Member getById(int id){
    return repo.findById(id).get();
  }

  public void deleteById(int id){
    repo.deleteById(id);
  }
}
