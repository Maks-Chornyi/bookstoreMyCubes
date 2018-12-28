package mycubes.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date birthday;
	private String address;
	private String authorInfo;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "author_and_authors_books", 
			joinColumns = { @JoinColumn(name = "author_id") },
			inverseJoinColumns = { @JoinColumn(name = "book_id") })
	private Set<Book> authorsBooks;
	
	public Author() {
	}
	
	public Author(String name, Date birthday, String address, String authorInfo) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.authorInfo = authorInfo;
	}
	
	public Author(String name, Date birthday, String address, String authorInfo, Set<Book> authorsBooks) {
		this(name, birthday, address, authorInfo);
		this.authorsBooks = authorsBooks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuthorInfo() {
		return authorInfo;
	}

	public void setAuthorInfo(String authorInfo) {
		this.authorInfo = authorInfo;
	}

	public Set<Book> getAuthorsBooks() {
		return authorsBooks;
	}

	public void setAuthorsBooks(Set<Book> authorsBooks) {
		this.authorsBooks = authorsBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", birthday=" + birthday + ", address=" + address
				+ ", authorInfo=" + authorInfo + ", authorsBooks=" + authorsBooks + "]";
	}
	
	
}