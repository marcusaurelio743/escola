package managebean;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public void pesquisaCep(AjaxBehaviorEvent event)  {
		
		try {
			URL  url = new URL("https://viacep.com.br/ws/"+aluno.getCep()+"/json/");
			
			URLConnection connection = url.openConnection();
			
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			
			String cep = " ";
			StringBuilder jsonCep = new StringBuilder();
			
			while((cep  = br.readLine()) != null) {
				jsonCep.append(cep);
				
				
				
			}
			ObjectMapper objectMapper = new ObjectMapper(); 
			Aluno pessoaAux = objectMapper.readValue(jsonCep.toString(), Aluno.class);
			
			aluno.setCep(pessoaAux.getCep());
			aluno.setLogradouro(pessoaAux.getLogradouro());
			aluno.setComplemento(pessoaAux.getComplemento());
			aluno.setBairro(pessoaAux.getBairro());
			aluno.setLocalidade(pessoaAux.getLocalidade());
			aluno.setUf(pessoaAux.getUf());
			
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
			
		}

	public String Salvar()  {
		//converter o tipo de dados pois pega na tela o tipo long e é preciso converter para objeto
		aluno.setTurma(daoTurma.pesquisarId(Turma.class, idTurma));
		aluno.setSexo(daosexo.pesquisarId(Sexo.class, idSexo));
		/*=========================================================*/
		aluno = daoaluno.updadeMerge(aluno);
		alunos.add(aluno);
		mostrarMsg("registro Salvo com sucesso!!!");
		return "";
	}
	public String deletar() throws Exception {
		daoaluno.deleteById(aluno);
		alunos.remove(aluno);
		this.Novo();
		mostrarMsg("registro deletado");
		return "";
	}
	
	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(msg, message);
		
	}
	
}
