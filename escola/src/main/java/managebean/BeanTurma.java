package managebean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		return "";
	}
	public String Deletar() throws Exception {
		daoTurma.deleteById(turma);
		turmas.remove(turma);
		this.Novo();
		
		return "";
	}
	

}
