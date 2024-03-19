package com.example.demo;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
public class MallController {

    @Autowired
    MallService mallservice;

    @GetMapping("/malls")
    public ArrayList<MallEntity> list() {
        return mallservice.listAll();
    }

    @GetMapping("/malls/{id}")
    public void get(@PathVariable("id") Integer id) 
    {
            mallservice.get(id);
    }

    // for Create operation
    @PostMapping("/malls")
    public ResponseEntity<String> add(@RequestBody MallEntity mall) {
        try {
            mallservice.save(mall);
            return ResponseEntity.status(HttpStatus.CREATED).body("Mall added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding the mall: " + e.getMessage());
        }
    }

    // for Delete operation
    @DeleteMapping("/malls/{id}")
    public void delete(@PathVariable("id") Integer id) 
    {
        mallservice.delete(id);
    }

    // for Update operation
    @PutMapping("/malls/{id}")
    public ResponseEntity<?> update(@RequestBody MallEntity mall, @PathVariable Integer id) {
        try {
            mallservice.get(id);
            mallservice.save(mall);
            return ResponseEntity.status(HttpStatus.OK).body("Mall updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mall with ID " + id + " not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating the mall: " + e.getMessage());
        }
    }
}
