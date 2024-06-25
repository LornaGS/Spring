

import com.qa.lbg.domain.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// controllers handle requests
@RestController
public class CatController {

    private final List<Cat> cats = new ArrayList<>();

    // this method will be called when a GET request is sent to /hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/cat/new")
    public ResponseEntity<Cat> createCat(@RequestBody Cat newCat) {
        this.cats.add(newCat);
        Cat added = this.cats.get(this.cats.size() - 1);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    @GetMapping("/cat/all")
    public List<Cat> getAll() {
        return this.cats;
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<?> getCat(@PathVariable Integer id) {
        if (id == null || id < 0 || id >= this.cats.size())
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(this.cats.get(id));
    }


    @PatchMapping("/cat/{id}")
    public Cat updateCat(@PathVariable(name = "id") Integer id,
                         @RequestParam(name = "name", required = false) String name,
                         @RequestParam(name = "colour", required = false) String colour,
                         @RequestParam(name = "age", required = false) Integer age,
                         @RequestParam(name = "nature", required = false) String nature,
                         @RequestParam(name = "lives", required = false) Integer lives) {

        Cat toUpdate = this.cats.get(id);

        if (name != null) toUpdate.setName(name);
        if (colour != null) toUpdate.setColour(colour);
        if (age != null) toUpdate.setAge(age);
        if (nature != null) toUpdate.setNature(nature);
        if (lives != null) toUpdate.setLives(lives);

        return toUpdate;
    }

    @DeleteMapping("/cat/{id}")
    public Cat removeCat(@PathVariable Integer id) {
        return this.cats.remove(id.intValue());
    }
}