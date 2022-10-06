package com.crud.sample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.sample.Model.Crud;
import com.crud.sample.Repo.CrudRepository;
import com.crud.sample.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:80")

public class CrudController {
    @Autowired
    private CrudRepository crudRepo;

    @GetMapping("/view")
    public List<Crud> getview(){
        return crudRepo.findAll();
    }

    @GetMapping("/read/{id}")
    ResponseEntity<Crud> getread(@PathVariable long id){
        Crud read=crudRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Fetching failed"));
        return ResponseEntity.ok().body(read);

    }

    @PostMapping("/save")
    public String addsave(@RequestBody Crud save){
        crudRepo.save(save);
        return "Data Saved..";
    }
    
    @PutMapping("/edit/{id}")
    ResponseEntity<Crud> updateedit(@PathVariable long id,@RequestBody Crud edit){
        Crud updatededit=crudRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Updating Failed"));
        updatededit.setfirst_name(edit.getfirst_name());
        updatededit.setmiddle_name(edit.getmiddle_name());
        updatededit.setlast_name(edit.getlast_name());
        updatededit.setbirthday(edit.getbirthday());
        updatededit.setage(edit.getage());
        updatededit.setaddress(edit.getaddress());  
        updatededit.setvehicle(edit.getvehicle());
        updatededit.setgasoline(edit.getgasoline());
        updatededit.setliters(edit.getliters());
        updatededit.setprice(edit.getprice());
        crudRepo.save(updatededit);
        return ResponseEntity.ok().body(updatededit);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteremove(@PathVariable long id){
        Crud remove=crudRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Deleting Failed"));
        crudRepo.delete(remove);
        return "Data Deleted";
    }

}