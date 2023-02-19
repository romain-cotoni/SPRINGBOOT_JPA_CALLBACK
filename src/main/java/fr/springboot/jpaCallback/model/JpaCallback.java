package fr.springboot.jpaCallback.model;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class JpaCallback {
	
	@PrePersist
	@PreUpdate
	public void beforeInsertOrUpdate(AppModel appModel) {
		System.out.println("Before Persist or Update was called from JpaCallback.class");
	}
	
	@PostPersist
	@PostLoad
	@PostUpdate
	public void postLoad(AppModel appModel) {
		System.out.println("Post Load was called from JpaCallback.class");
	}
	
}
