package org.springside.examples.bootservice.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springside.examples.bootapi.BootApiApplication;
import org.springside.examples.bootapi.domain.Book;
import org.springside.examples.bootapi.repository.BookDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApiApplication.class)
@DirtiesContext
public class BookDaoTest {

	@Autowired
	private BookDao bookDao;

	@Test
	public void findByUserId() {
		List<Book> books = bookDao.findByOwnerId(1L);
		assertThat(books).hasSize(1);
		assertThat(books.get(0).title).isEqualTo("Big Data日知录");
	}
}