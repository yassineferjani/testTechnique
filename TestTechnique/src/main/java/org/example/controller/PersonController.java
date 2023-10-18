package org.example.controller;

import org.example.dto.PersonDTO;
import org.example.service.IPerson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    private final IPerson person ;

    public PersonController(final IPerson student) {
        this.person = student;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> findAll(){
        return person.findAll();
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable final UUID uuid){
        return person.findById(uuid).orElseThrow(() -> new RuntimeException("not exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO save(@RequestBody final PersonDTO dto){
        return person.save(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonDTO update(@RequestBody final PersonDTO dto){
        return person.update(dto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final UUID uuid){
        person.deleteById(uuid);
    }
}
