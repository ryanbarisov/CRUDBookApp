package net.yanbarisov.bookapp.dao;

import net.yanbarisov.bookapp.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    private static final int PAGING_SIZE = 10;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book " + book + " was successfully saved.");
    }

    @Override
    public void readBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        if(!book.isReadAlready())
            book.setReadAlready(true);
        session.update(book);
        logger.info("Book" + book + " was read.");
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book " + book + " was successfully updated.");
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if(book != null) {
            session.delete(book);
        }

        logger.info("Book " + book + " was successfully removed.");
    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book " + book + " was successfully loaded.");

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks(int page) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book B");
        query.setFirstResult(PAGING_SIZE * (page-1));
        query.setMaxResults(PAGING_SIZE);

        List<Book> bookList = query.list();

        for(Book book : bookList) {
            logger.info("Book list: " + book);
        }

        return bookList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listFoundBooks(String title, String author, int year, boolean read) {
        Session session = this.sessionFactory.getCurrentSession();

        StringBuilder sb = new StringBuilder("from Book B ");
        int start = 0;

        if(!"".equals(title))
            sb.append((start++ == 0 ? "where " : "and ") + String.format("title = '%s'", title));

        if(!"".equals(author))
            sb.append((start++ == 0 ? "where " : "and ") + String.format("author = '%s'", author));

        if(year != 0)
            sb.append((start++ == 0 ? "where " : "and ") + "printYear = " + year);

        sb.append((start++ == 0 ? "where " : "and ") + "readAlready = " + read);

        logger.info("query: " + sb.toString());

        List<Book> bookList = session.createQuery(sb.toString()).list();

        for(Book book : bookList) {
            logger.info("Book list: " + book);
        }

        return bookList;
    }

}
