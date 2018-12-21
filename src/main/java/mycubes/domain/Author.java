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
	private String adress;
	private String authorInfo;	
	@ManyToMany
	private Set<Book> authorsBooks;
	
	public Author() {
	}
	
	public Author(String name, Date birthday, String adress, String authorInfo) {
		this.name = name;
		this.birthday = birthday;
		this.adress = adress;
		this.authorInfo = authorInfo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getAuthorsBooks() {
		return authorsBooks;
	}

	public void setAuthorsBooks(Set<Book> authorsBooks) {
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getAuthorInfo() {
		return authorInfo;
	}
	public void setAuthorInfo(String authorInfo) {
		this.authorInfo = authorInfo;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", birthday=" + birthday + ", adress=" + adress + ", authorInfo="
				+ authorInfo + "]";
	}	
}