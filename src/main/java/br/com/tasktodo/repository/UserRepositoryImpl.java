package br.com.tasktodo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tasktodo.entity.UserEntity;

public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(UserEntity userEntity) {
		entityManager.persist(userEntity);
	}
	
	@Override
	public void update(UserEntity userEntity) {
		entityManager.merge(userEntity);
    }

	@Override
	public void delete(UserEntity userEntity) {
		if (entityManager.contains(userEntity)) {
            entityManager.remove(userEntity);
        } else {
        	UserEntity managedCustomer = entityManager.find(UserEntity.class, userEntity.getId());
            if (managedCustomer != null) {
                entityManager.remove(managedCustomer);
            }
        }
		
	}

	@Override
	public List<UserEntity> findAll() {
		try {
			return entityManager
					.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
					.getResultList();
		} catch (Exception e) {
			return null;
		}		
	}
	
}
