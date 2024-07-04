package LiterAlura.LiterAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Book>> getBooksByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(bookService.getBooksByLanguage(language));
    }

    @GetMapping("/options")
    public ResponseEntity<List<String>> getOptions() {
        return ResponseEntity.ok(List.of(
            "Buscar un libro por título",
            "Listar los libros registrados en la base de datos",
            "Listar los autores registrados",
            "Listar los autores vivos en un año determinado",
            "Listar los libros por idioma"
        ));
    }
}

