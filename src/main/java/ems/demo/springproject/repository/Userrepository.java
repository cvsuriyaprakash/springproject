package ems.demo.springproject.repository;

import ems.demo.springproject.entityvalues.Userdetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<Userdetail, Long>{
    Userdetail findByUsername(String username);
}
