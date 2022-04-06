package br.com.tasktodo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tasktodo.entity.TaskStattusEntity;

public class TaskStattusRepositoryImpl implements TaskStattusRepository {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public void create(TaskStattusEntity taskStattusEntity) {
		entityManager.persist(taskStattusEntity); 
	}
	
	@Override
	public void taskStattusInit() {
		if (findAll().isEmpty()) {
			TaskStattusEntity  taskStattusEmAndamento = new TaskStattusEntity (1, "em andamento");
			TaskStattusEntity  taskStattusConcluido = new TaskStattusEntity (2, "concluido");
			
			entityManager.persist(taskStattusEmAndamento);
			entityManager.persist(taskStattusConcluido);		
		}
	}
	
	@Override
	public List<TaskStattusEntity> findAll() {
		try {
			return entityManager
					.createQuery("SELECT t FROM TaskStattusEntity t", TaskStattusEntity.class)
					.getResultList();
		} catch (Exception e) {
			return null;
		}		
	}
	
}
