package managebean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.daoSexo;
import model.Sexo;

@ManagedBean(name = "beanSexo")
@ViewScoped
public class BeanSexo {
	private Sexo sexo = new Sexo();
	
	private List<Sexo> sexos = new ArrayList<Sexo>();
	
	private daoSexo daoSexo = new daoSexo();
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	public List<Sexo> getSexos() {
		return sexos;
	}
	
	@PostConstruct
	public void carregarSexos() {
		sexos = daoSexo.pesquisarObjetos(Sexo.class);
	}
	
	public String Salvar() {
		sexo = daoSexo.updadeMerge(sexo);
		sexos.add(sexo);
		return "";
	}
	
	public String Deletar() throws Exception {
		daoSexo.deleteById(sexo);
		sexos.remove(sexo);
		this.Novo();
		return "";
	}
	public String Novo() {
		sexo = new Sexo();
		return "";
	}

}
