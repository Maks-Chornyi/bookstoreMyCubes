package mycubes.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@ManyToMany
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