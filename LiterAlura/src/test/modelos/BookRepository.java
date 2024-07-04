package LiterAlura.LiterAlura;

public interface BookRepository extends JpaRepository<Book, Long> {
	    Optional<Book> findByTitle(String title);
	    List<Book> findByLanguage(String language);
	}

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthYearGreaterThanEqualAndDeathYearLessThanEqual(Integer birthYearStart, Integer birthYearEnd);
    List<Author> findByDeathYearIsNull();
}