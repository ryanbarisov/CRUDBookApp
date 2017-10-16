package net.yanbarisov.bookapp.controller;

import net.yanbarisov.bookapp.model.Book;
import net.yanbarisov.bookapp.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="/books/{page}", method = RequestMethod.GET)
    public String listBooks(@PathVariable int page, Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks(page));

        return "/books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if(book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books/1";
    }

    @RequestMapping("/read/{id}")
    public String readBook(@PathVariable("id") int id) {
        this.bookService.readBook(id);

        return "redirect:/books/1";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        this.bookService.removeBook(id);

        return "redirect:/books/1";
    }

    @RequestMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") int id, Model model) {
        return "redirect:/bookdata/{id}";
    }

    @RequestMapping("/bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "/bookdata";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchBooks() {

        return "/search";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String listFoundBooks(@RequestParam("title") String title,
                                 @RequestParam("author") String author,
                                 @RequestParam(name="year", defaultValue = "0") int year,
                                 @RequestParam(name="read", defaultValue = "false") boolean read,
                                 Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listFoundBooks(title, author, year, read));

        return "/books";
    }

}
