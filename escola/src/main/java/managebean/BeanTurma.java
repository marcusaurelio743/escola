package managebean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Dao.daoTurma;
import model.Turma;

@ManagedBean(name = "beanTurma")
@ViewScoped
public class BeanTurma {
	private daoTurma daoTurma = new daoTurma();
	private Turma turma = new Turma();

	private List<Turma> turmas = new ArrayList<Turma>();

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Turma getTurma() {
		return turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}
	
	
	@PostConstruct
	
	public void carregarTurmas() {
		turmas = daoTurma.pesquisarObjetos(Turma.class);
	}
	
	public String Novo() {
		turma = new Turma();
		return "";
	}
	
	public String Salvar() {
		turma = daoTurma.updadeMerge(turma);
		turmas.add(turma);
		this.mostrarMsg("registro Salvo com sucesso!!!");
		return "";
	}
	public String Deletar() throws Exception {
		daoTurma.deleteById(turma);
		turmas.remove(turma);
		this.Novo();
		this.mostrarMsg("registro Deletado!!!");
		return "";
	}
	
	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(msg, message);
		
	}
	

}
