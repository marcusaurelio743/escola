package Dao;


import javax.persistence.EntityTransaction;

import model.Login;

public class daoLogin extends DaoGeneric<Login> {
	
	public Login autenticar( String login, String senha) {
		Login objeto = null;
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		try {
			objeto = (Login) entityManager.
					createQuery("select p from Login p where p.login = '"
							+login+"' and p.senha = '"+senha+"'").getSingleResult();
		}catch (javax.persistence.NoResultException e) {/*tratamento se não encontrar o usuario no sistema*/
			
		}
		
		transaction.commit();
		
		
		return objeto;
	}

}
