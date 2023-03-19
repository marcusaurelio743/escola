package managebean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.daoLogin;
import model.Login;

@ManagedBean(name = "beanlogin")
@ViewScoped
public class Beanlogin {
	
	private Login login = new Login();
	private daoLogin daoLogin = new daoLogin();
	private List<Login> logins = new ArrayList<Login>();

	public void setLogin(Login login) {
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}
	@PostConstruct
	public void carregarLogins() {
		
		logins = daoLogin.pesquisarObjetos(Login.class);
	}
	
	public String logar() {
		login = daoLogin.autenticar(login.getLogin(), login.getSenha());		
		
		return "";
	}

	
	

}
