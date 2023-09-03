package com.SkyPro.Kurs4_DZ1.controller;

import com.SkyPro.Kurs4_DZ1.model.Faculty;
import com.SkyPro.Kurs4_DZ1.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public Collection<Faculty> getAll(){
        return facultyService.getAll();
    }

    @GetMapping("/{id}")
    public Faculty getById (@PathVariable("id") Long id){
        return facultyService.getById(id);
    }
    @GetMapping("/filtred")
    public Collection getByColor (@RequestParam("color") String color){
        return facultyService.getByColor(color);
    }

    @GetMapping("/by-color-or-name")
    public Collection <Faculty> getByColorOrName (@RequestParam String search){
        return facultyService.getByColorOrName(search,search);
    }

    @PostMapping
    public  Faculty create(@RequestBody Faculty faculty){
        return facultyService.create(faculty);
    }
    @PutMapping("/{id}")
    public Faculty update (@PathVariable("id") Long id,@RequestBody Faculty faculty){
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    public Faculty remove(@PathVariable("id") Long id){

        return facultyService.remove(id);
    }
    @GetMapping("/by-student")
    public Faculty getByStudent(@RequestParam Long studentId){
        return facultyService.getByStudent(studentId);
    }
}