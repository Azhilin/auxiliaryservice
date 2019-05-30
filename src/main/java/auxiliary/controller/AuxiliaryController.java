package auxiliary.controller;

import auxiliary.service.AuxiliaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aux")
public class AuxiliaryController {

    @Autowired
    private AuxiliaryService auxiliaryService;

    @PutMapping("/{id}")
    public void add(@PathVariable Integer id) {
        auxiliaryService.add(id);
    }

    @GetMapping("/{id}")
    public Boolean getById(@PathVariable Integer id) {
        return auxiliaryService.getById(id);
    }
}
