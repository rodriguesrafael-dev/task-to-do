package br.com.tasktodo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tasktodo.entity.TaskEntity;

public class TaskRepositoryImpl implements TaskRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(TaskEntity taskEntity) {
		entityManager.persist(taskEntity);
	}
	
	@Override
	public void update(TaskEntity taskEntity) {
		entityManager.merge(taskEntity);
    }

	@Override
	public void delete(TaskEntity taskEntity) {
		if (entityManager.contains(taskEntity)) {
            entityManager.remove(taskEntity);
        } else {
        	TaskEntity managedTask = entityManager.find(TaskEntity.class, taskEntity.getId());
            if (managedTask != null) {
                entityManager.remove(managedTask);
            }
        }		
	}
	
	@Override
	public List<TaskEntity> listTaskFilter(long id, String title, String userEntity, String taskStattusEntity) {
		List<TaskEntity> list = new ArrayList<>();
		try {
			list = entityManager
					.createQuery(
							"SELECT t FROM TaskEntity t JOIN t.userEntity u JOIN t.taskStattusEntity ts "
							+ "WHERE t.id=:id "
							+ "OR t.title=:title "
							+ "OR u.userName=:userEntity "
							+ "OR ts.taskStattusDescription=:taskStattusEntity "
							+ "ORDER BY t.id", TaskEntity.class)
					.setParameter("id", id)
					.setParameter("title", title)
					.setParameter("userEntity", userEntity)
					.setParameter("taskStattusEntity", taskStattusEntity)
					.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<TaskEntity> findAll() {
		try {
			return entityManager
					.createQuery("SELECT t FROM TaskEntity t", TaskEntity.class)
					.getResultList();			
		} catch (Exception e) {
			return null;
		}		
	}
	
	@Override
	public List<TaskEntity> listTaskStattus() {
		try {
			return entityManager
					.createQuery("SELECT t FROM TaskEntity t WHERE t.taskStattusEntity.id = '1' ORDER BY t.id", TaskEntity.class)
					.getResultList();
		} catch (Exception e) {
			return null;
		}		
	}

}
