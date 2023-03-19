package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	//fabrica de conexão do hibernate
	
		public static EntityManagerFactory factory = null;
		
		static {
			//chamar sempre o init() e criar a conexão com banco de dados
			init();
		}
		
		private static void init () {
			try {
				
				if(factory == null) {
					
					//ler o persistence unit do projeto presistence.xml
					
					factory = Persistence.createEntityManagerFactory("escola-es");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static EntityManager getenEntityManager() {
			
			return factory.createEntityManager();/*prover a parte de persistencia de dados */
		}
		public static Object getPrimaryKey(Object entidade) {
			//metodo me retorna primary key 
			return factory.getPersistenceUnitUtil().getIdentifier(entidade);
		}

}
