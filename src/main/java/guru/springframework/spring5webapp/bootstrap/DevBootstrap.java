package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:4/3/18
 * Time:7:23 PM
 * ------------------------------------
 * Desc:
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher p1 = new Publisher("长江文艺出版社");
        Author a1 = new Author("敬明","郭");
        Author a2 = new Author("安", "笛");

        Book b1 = new Book("梦里花落知多少","1111",p1);
        Book b2 = new Book("告别天堂", "1112", p1);

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        a2.getBooks().add(b2);
        publisherRepository.save(p1);
        authorRepository.save(a1);
        bookRepository.save(b1);
        authorRepository.save(a2);
        bookRepository.save(b2);
    }
}
