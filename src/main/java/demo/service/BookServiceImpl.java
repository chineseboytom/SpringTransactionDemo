package demo.service;

import demo.dao.BookDao;
import demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Tom on 2017/4/10.
 */

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Transactional
    public void save(Book book) {
        try {
            bookDao.save(book);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }

    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
