package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Login;

public class daoLogin extends DaoGeneric<Login> {
	
	public Login autenticar( String login, String senha) {
		Login objeto = null;
		
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		transaction.begin();
			objeto = (Login) getEntityManager().
					createQuery("select l from Login l where l.login  = '"+login+"' and l.senha = '"+senha+"'").getSingleResult();
		
		transaction.commit();
		
		
		return objeto;
	}

}
