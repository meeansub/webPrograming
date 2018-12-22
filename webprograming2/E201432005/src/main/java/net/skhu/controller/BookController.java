package net.skhu.controller;


import net.skhu.dto.Book;
import net.skhu.dto.Category;
import net.skhu.dto.Publisher;
import net.skhu.mapper.BookMapper;
import net.skhu.mapper.CategoryMapper;
import net.skhu.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    BookMapper bookMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    PublisherMapper publisherMapper;

    @RequestMapping("category/list")
    public String list(Model model){
        List<Category> category =categoryMapper.findAll();
        model.addAttribute("categorys",category);

        return "category/list";
    }


    @RequestMapping("book/list1")
    public String list1(Model model){
        List<Book> books=bookMapper.findAll();
        model.addAttribute("books",books);

        return "book/list1";
    }


    @RequestMapping(value="book/create", method=RequestMethod.GET)
    public String create(Model model) {
        Book book= new Book();
        List<Category> categories = categoryMapper.findAll();
        List<Publisher> publishers = publisherMapper.findAll();


        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        model.addAttribute("publishers", publishers);
        return "book/create";
    }

    @RequestMapping(value="book/create", method=RequestMethod.POST)
    public String create(Book book) {
        bookMapper.insert(book);
        return "redirect:list1";
    }

    @RequestMapping(value="book/edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Book book =bookMapper.findOne(id);
        List<Category> categories = categoryMapper.findAll();
        List<Publisher> publishers = publisherMapper.findAll();

        model.addAttribute("book", book);
        model.addAttribute("publishers", publishers);
        model.addAttribute("categories", categories);
        return "book/edit";
    }

    @RequestMapping(value="book/edit", method=RequestMethod.POST)
    public String edit(Book book) {
        bookMapper.update(book);
        return "redirect:list1";


    }
    @RequestMapping("book/delete")
    public String delete(@RequestParam("id") int id) {
        bookMapper.delete(id);
        return "redirect:list1";
    }

    @RequestMapping("book/list2")
    public String list2(Model model){
        List<Book> books=bookMapper.findAll();
        model.addAttribute("books",books);

        return "book/list2";
    }







}
