package fr.springboot.jpaCallback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.springboot.jpaCallback.model.AppModel;

@Repository
public interface AppRepository extends JpaRepository<AppModel,Integer> {
	
}
