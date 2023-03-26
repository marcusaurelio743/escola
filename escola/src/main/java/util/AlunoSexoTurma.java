package util;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "alunosexoturma")
public class AlunoSexoTurma implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String nome;
	private String bairro;
	private String cep;
	private String complemento;
	private String cpfresponsavel;
	private String localidade;
	private String logradouro;
	private String mae;
	private String naturalidade;
	private String pai;
	private String telefone;
	private String uf;
	private String sexo;
	private String turma;
	private Date datanascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpfresponsavel() {
		return cpfresponsavel;
	}

	public void setCpfresponsavel(String cpfresponsavel) {
		this.cpfresponsavel = cpfresponsavel;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoSexoTurma other = (AlunoSexoTurma) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AlunoSexoTurma [id=" + id + ", nome=" + nome + ", bairro=" + bairro + ", cep=" + cep + ", complemento="
				+ complemento + ", cpfresponsavel=" + cpfresponsavel + ", localidade=" + localidade + ", logradouro="
				+ logradouro + ", mae=" + mae + ", naturalidade=" + naturalidade + ", pai=" + pai + ", telefone="
				+ telefone + ", uf=" + uf + ", sexo=" + sexo + ", turma=" + turma + ", datanascimento=" + datanascimento
				+ "]";
	}
	

}
