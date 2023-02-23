package com.dmainali.jdbcdemo.controller;

import com.dmainali.jdbcdemo.ItemException;
import com.dmainali.jdbcdemo.dao.ItemDao;
import com.dmainali.jdbcdemo.model.Item;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemDao dao;

    @PostMapping("/item")
    public int add(@RequestBody Item item, HttpServletResponse response){
        try {
            dao.save(item);
            response.setStatus(HttpServletResponse.SC_CREATED);
            return 1;
        }catch(ItemException e){
            System.out.println(e.getMessage());
            response.setStatus(HttpServletResponse.SC_OK);
            return 0;
        }
    }

    @GetMapping("/item")
    public List<Item> getAll(){
        return dao.findAll();
    }

    @GetMapping("/item/{id}")
    public Item getOne(@PathVariable int id){
        return dao.findbyID(id);
    }

    @PutMapping("/update/{id}")
    public Item updatebyId(@RequestBody Item item, @PathVariable int id){
       if(item.getId() != 0 && item.getId()>0){
           id= item.getId();
       }
        return dao.updateById(item,id);
    }

    @DeleteMapping( value ="/delete/{id}")
    public int delete(Item item){
        return dao.deleteById(item);
    }

}
