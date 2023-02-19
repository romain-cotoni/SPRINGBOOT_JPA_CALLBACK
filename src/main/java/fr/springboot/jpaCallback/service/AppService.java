package fr.springboot.jpaCallback.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.springboot.jpaCallback.model.AppModel;
import fr.springboot.jpaCallback.repository.AppRepository;
import jakarta.transaction.Transactional;

@Service
public class AppService {

	@Autowired
	private AppRepository appRepository;

	public Iterable<AppModel> getEntities() {
		return appRepository.findAll();
	}
	
	public AppModel getEntity(int id) throws Exception {
		return appRepository.findById(id).get();		
	}

	public AppModel createEntity(AppModel appModel) throws Exception {
	    return appRepository.save(appModel);
	}

	@Transactional
	public AppModel updateEntity(int id, AppModel appModel) throws Exception {
		AppModel appModelToModify = appRepository.findById(id).orElseThrow();
		appModelToModify.setLabel(appModel.getLabel());
		appModelToModify.setLevel(appModel.getLevel());
		appModelToModify.setLastModified(new Date());
		return appRepository.save(appModelToModify);
	}


}
