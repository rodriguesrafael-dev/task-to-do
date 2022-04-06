package br.com.tasktodo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tasktodo.entity.PriorityEntity;

public class PriorityRepositoryImpl implements PriorityRepository {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public void create(PriorityEntity priorityEntity) {
		entityManager.persist(priorityEntity); 
	}
	
	@Override
	public void priorityInit() {
		if (findAll().isEmpty()) {
			PriorityEntity priorityBaixa = new PriorityEntity(1, "baixa");
			PriorityEntity priorityMedia = new PriorityEntity(2, "media");
			PriorityEntity priorityAlta = new PriorityEntity(3, "alta");
			
			entityManager.persist(priorityBaixa);
			entityManager.persist(priorityMedia);
			entityManager.persist(priorityAlta);
		}
	}
	
	@Override
	public List<PriorityEntity> findAll() {
		try {
			return entityManager
					.createQuery("SELECT t FROM PriorityEntity t", PriorityEntity.class)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
}
