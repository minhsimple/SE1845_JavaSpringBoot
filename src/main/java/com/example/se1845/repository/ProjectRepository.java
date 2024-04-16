package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.Project;

public interface ProjectRepository extends CrudRepository<Project, String> {

}
