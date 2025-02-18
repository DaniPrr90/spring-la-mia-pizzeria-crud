package org.lessons.java.spring.lamiapizzeria.repo;

import java.util.List;

import org.lessons.java.spring.lamiapizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    public List<Pizza> findById(int id);

    public List<Pizza> findByNomeContaining(String name);

    public List<Pizza> findByNomeContainingIgnoreCase(String query);
}