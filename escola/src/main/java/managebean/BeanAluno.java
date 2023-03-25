package managebean;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.net.ssl.TrustManager;

import Dao.daoSexo;
import Dao.daoTurma;
import Dao.daoaluno;
import model.Aluno;
import model.Sexo;
import model.Turma;

@ManagedBean(name = "beanAluno")
@ViewScoped
public class BeanAluno {
	private daoaluno daoaluno = new daoaluno();
	private daoSexo daosexo = new daoSexo();
	private daoTurma daoTurma = new daoTurma();
	private Aluno aluno = new Aluno();
	private List<Turma> turmas = new ArrayList<Turma>();
	private List<Sexo> sexos = new ArrayList<Sexo>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private Long idSexo;
	private Long idTurma;
	
	@PostConstruct
	public void init() {
		sexos = daosexo.pesquisarObjetos(Sexo.class);
		turmas = daoTurma.pesquisarObjetos(Turma.class);
		alunos = daoaluno.pesquisarObjetos(Aluno.class);
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public String Novo() {
		aluno = new Aluno();
		return "";
	}
	
	
	

	public Long getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Long idSexo) {
		this.idSexo = idSexo;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String Salvar()  {
		//converter o tipo de dados pois pega na tela o tipo long e é preciso converter para objeto
		aluno.setTurma(daoTurma.pesquisarId(Turma.class, idTurma));
		aluno.setSexo(daosexo.pesquisarId(Sexo.class, idSexo));
		/*=========================================================*/
		aluno = daoaluno.updadeMerge(aluno);
		
		return "";
	}
	
}
