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

import com.crud.sample.Model.Inventory;
import com.crud.sample.Repo.InventoryRepository;
import com.crud.sample.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "http://localhost:80")

public class InventoryController {
    @Autowired
    private InventoryRepository InventoryRepo;

    @GetMapping("/list")
    public List<Inventory> getview(){
        return InventoryRepo.findAll();
    }

    @GetMapping("/read/{id}")
    ResponseEntity<Inventory> getread(@PathVariable long id){
        Inventory read=InventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Fetching failed"));
        return ResponseEntity.ok().body(read);

    }

    @PostMapping("/add")
    public String addsave(@RequestBody Inventory add){
        InventoryRepo.save(add);
        return "Data Saved..";
    }
    
    @PutMapping("/update/{id}")
    ResponseEntity<Inventory> updateedit(@PathVariable long id,@RequestBody Inventory update){
        Inventory updatededit=InventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Updating Failed"));
        updatededit.setgasoline(update.getgasoline());
        updatededit.setprice(update.getprice());
        updatededit.setliters(update.getliters());
        InventoryRepo.save(updatededit);
        return ResponseEntity.ok().body(updatededit);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteremove(@PathVariable long id){
        Inventory delete=InventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Deleting Failed"));
        InventoryRepo.delete(delete);
        return "Data Deleted";
    }

}