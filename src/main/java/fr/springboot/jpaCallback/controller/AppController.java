package fr.springboot.jpaCallback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.springboot.jpaCallback.model.AppModel;
import fr.springboot.jpaCallback.service.AppService;

@RestController
@RequestMapping("/api/listener")
public class AppController {

	private static int count = 0; 
	
	@Autowired
	private AppService appService;
	
	@GetMapping("")
	public Iterable<AppModel> getEntities() {
		return appService.getEntities();
	}
	
	@GetMapping("/{id}")
	public AppModel getEntity(@PathVariable int id) throws Exception {
		return appService.getEntity(id);
	}

	@PostMapping("")
	public AppModel createEntity() throws Exception {
		AppModel appModel = new AppModel("hello-jpacallback "+(++count),count);
		return appService.createEntity(appModel);
	}
	
	@PatchMapping("/{id}")
	public AppModel updateEntity(@PathVariable int id) throws Exception {
		AppModel appModel = new AppModel("hello-jpacallback updated "+(++count),count);
		return appService.updateEntity(id, appModel);
	}
	
}
