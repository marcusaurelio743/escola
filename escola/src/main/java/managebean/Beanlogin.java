package managebean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
public String deslogar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		
		HttpServletRequest req = (HttpServletRequest) externalContext.getRequest();
		HttpSession session = req.getSession();
		
		session.removeAttribute("usuarioLogado");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) context.getCurrentInstance().
		getExternalContext().getRequest();
		httpServletRequest.getSession().invalidate();
		
	
		
		return "index.jsf";
	}
	
	public String logar() {
		//verificar se o usuario existe
		Login usuario = daoLogin.autenticar(login.getLogin(), login.getSenha());
		
		//se o usuario existi
		if(usuario != null) {
			//adiciona o usuario na sessão usuarioLogado
			
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			
			HttpServletRequest req = (HttpServletRequest) externalContext.getRequest();
			HttpSession session = req.getSession();
			
			session.setAttribute("usuarioLogado", usuario);
			return"principal.jsf";
			
		}else {
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("usuário não encontrado!!"));
		}
		
		return "index.jsf";
	}

	
	

}
