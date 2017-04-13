package demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Tom on 2017/4/8.
 */

@Entity
public class Book {
    @Id
    private String id;
    
}
