package demo.dao;

import demo.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Tom on 2017/4/8.
 */

@Repository
public class BookDaoJpaImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }
}
