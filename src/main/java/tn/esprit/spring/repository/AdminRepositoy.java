package tn.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Admin;

@Repository
public interface AdminRepositoy extends CrudRepository<Admin, Long> {

}
