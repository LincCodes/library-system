package library.system.librarysystem.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import library.system.librarysystem.entity.Book;
import library.system.librarysystem.entity.Librarian;
import library.system.librarysystem.entity.Member;
import library.system.librarysystem.service.BookServ;
import library.system.librarysystem.service.LibrarianServ;
import library.system.librarysystem.service.MemberServ;

@Controller
public class LibraryController {

  @Autowired
  private LibrarianServ serv;

  @Autowired
  private BookServ bserv;

  @Autowired
  private MemberServ mserv;
  
  @GetMapping("/")
  public String home(Model model){
    Librarian lib = new Librarian();
    model.addAttribute("librarian", lib);
    return "index";
  }

  @PostMapping("/")
  public String login(@ModelAttribute("librarian") Librarian lib){
    Librarian exists = serv.exists(lib.getEmail(), lib.getPassword());
    if(Objects.nonNull(exists)) return "redirect:/admin";
    return "redirect:/register";
  }

  @GetMapping("register")
  public String register(Model model){
    Librarian lib = new Librarian();
    model.addAttribute("librarian", lib);
    return "register";
  }

  @PostMapping("register")
  public String reg(@ModelAttribute("librarian") Librarian lib){
    serv.save(lib);
    return "redirect:/admin";
  }

  @GetMapping("admin")
  public String admin(){
    return "admin";
  }

  @GetMapping("members")
  public ModelAndView members(){
    return new ModelAndView("members", "members", mserv.allMember());
  }

  @GetMapping("books")
  public ModelAndView books(){
    return new ModelAndView("books", "books", bserv.allBooks());
  }

  @GetMapping("addmember")
  public String addmember(Model model){
    Member member = new Member();
    model.addAttribute("member", member);
    return "add-member";
  }
  @GetMapping("addbook")
  public String addbook(Model model){
    Book book = new Book();
    model.addAttribute("book", book);
    return "add-book";
  }

  @PostMapping("addmember")
  public String addMember(@ModelAttribute("member") Member member){
    mserv.save(member);
    return "redirect:/members";
  }
  @PostMapping("addbook")
  public String addBook(@ModelAttribute("book") Book book){
    bserv.save(book);
    return "redirect:/books";
  }

  @GetMapping("editmember/{id}")
  public String editmember(@PathVariable int id, Model m){
    m.addAttribute("member", mserv.getById(id));
    return "edit-member";
  }

  @GetMapping("editbook/{id}")
  public String editbook(@PathVariable int id, Model m){
    m.addAttribute("book", bserv.getById(id));
    return "edit-book";
  }

  @PostMapping("/editmember/{id}")
  public String editMember(@PathVariable int id, @ModelAttribute("member") Member m, Model x){
    Member member = mserv.getById(id);
    member.setName(m.getName());
    member.setContact(m.getContact());
    member.setEmail(m.getEmail());
    member.setAge(m.getAge());
    member.setLocation(m.getLocation());
    mserv.save(member);
    return "redirect:/members";
  }

  @PostMapping("/editbook/{id}")
  public String editBook(@PathVariable int id, @ModelAttribute("book") Book b, Model m){
    Book book = bserv.getById(id);
    book.setAuthor(b.getAuthor());
    book.setTitle(b.getTitle());
    book.setDescription(b.getDescription());
    bserv.save(book);
    return "redirect:/books";
  }

  @GetMapping("deletemember/{id}")
  public String deletemember(@PathVariable int id){
    mserv.deleteById(id);
    return "redirect:/members";
  }

  @GetMapping("deletebook/{id}")
  public String deletebook(@PathVariable int id){
    bserv.deleteById(id);
    return "redirect:/books";
  }
  

}
