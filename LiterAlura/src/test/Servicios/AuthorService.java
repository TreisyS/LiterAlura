package LiterAlura.LiterAlura;

import modelos.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthYearGreaterThanEqualAndDeathYearLessThanEqual(year, year);
    }

    public List<Author> getLivingAuthors() {
        return authorRepository.findByDeathYearIsNull();
    }
}
