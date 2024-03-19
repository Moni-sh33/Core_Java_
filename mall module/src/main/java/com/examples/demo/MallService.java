package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallService {
    @Autowired
	MallRepository repo;
	
	public ArrayList<MallEntity> listAll()
	{
		 return (ArrayList<MallEntity>)repo.findAll();
	}

	public void save(MallEntity mall)
	{
		repo.save(mall);	
	}

	public void delete(Integer id)
	{
		repo.deleteById(id);
	}
	
	public MallEntity get(Integer id) 
	 {
	 return repo.findById(id).get();
	 }
}
