package mycubes.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String bookId;
	private String title;
	private Date publishDate;
	private int countOfCopies;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            }, mappedBy="authorsBooks")
	private Set<Author> bookAuthors;

	public Book() {
	}
	
	public Book(String bookId, String title, Date publishDate, int countOfCopies, Set<Author> bookAuthors) {
		this.bookId = bookId;
		this.title = title;
		this.publishDate = publishDate;
		this.countOfCopies = countOfCopies;
		this.bookAuthors = bookAuthors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getCountOfCopies() {
		return countOfCopies;
	}
	public void setCountOfCopies(int countOfCopies) {
		this.countOfCopies = countOfCopies;
	}
	public Set<Author> getBookAuthors() { 
		return bookAuthors;
	}

	public void setBookAuthors(Set<Author> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate
				+ ", countOfCopies=" + countOfCopies + ", bookAuthors=" + bookAuthors + "]";
	}
}