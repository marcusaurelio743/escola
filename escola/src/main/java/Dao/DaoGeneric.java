package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.HibernateUtil;

public class DaoGeneric <E>{
protected EntityManager entityManager = HibernateUtil.getenEntityManager();
	
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E updadeMerge(E entidade) {//salva ou atualiza
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		 E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		return entidadeSalva;
	}
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E e = (E) entityManager.find(entidade.getClass(), id);
		transaction.commit();
		return e;
	}
	
	public List<E> pesquisarObjetos(Class<E> entidade){
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<E> listar =  entityManager.createQuery("from "+entidade.getName()).getResultList();
		transaction.commit();
		
		return listar;
		
	}
	
	public E pesquisarId( Class<E> entidade,Long id) {
		entityManager.clear();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E objeto = (E) entityManager.find(entidade, Long.valueOf(id));
		transaction.commit();
		return objeto;
	}
	
	public void deleteById(E entidade)throws Exception {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.createNativeQuery("delete from "+entidade.getClass().getSimpleName().toLowerCase()+ 	
				" where id = "+id).executeUpdate();//faz delete pelo id
		
		transaction.commit();//gravar alteração no banco de dados
		
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
