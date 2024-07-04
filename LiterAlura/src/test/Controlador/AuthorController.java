package LiterAlura.LiterAlura;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/alive/{year}")
    public ResponseEntity<List<Author>> getAuthorsAliveInYear(@PathVariable int year) {
        return ResponseEntity.ok(authorService.getAuthorsAliveInYear(year));
    }

    @GetMapping("/living")
    public ResponseEntity<List<Author>> getLivingAuthors() {
        return ResponseEntity.ok(authorService.getLivingAuthors());
    }
}
