package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.List;

import br.senac.tads.dsw.dados_pessoais.validacao.SenhasIguais; // cite: 1
import jakarta.validation.constraints.Email; // cite: 1
import jakarta.validation.constraints.NotBlank; // cite: 1
import jakarta.validation.constraints.NotNull; // cite: 1
import jakarta.validation.constraints.PastOrPresent; // cite: 1
import jakarta.validation.constraints.Size; // cite: 1

@SenhasIguais // será criada na seção 2.5 - adicione depois // cite: 1
public class Pessoa {

	private Integer id;

	@NotBlank(message = "O username é obrigatório") // cite: 1
	@Size(max = 64) // cite: 1
	private String username;

	@NotBlank(message = "O nome completo é obrigatório") // cite: 1
	@Size(max = 100) // cite: 1
	private String nome;

	@NotBlank // cite: 1
	@Size(max = 100) // cite: 1
	@Email // cite: 1
	private String email;

	@Size(max = 20) // cite: 1
	private String telefone;

	@NotNull // cite: 1
	@PastOrPresent // cite: 1
	private LocalDate dataNascimento;

	private String senha;

	private String senhaRepeticao;

	private List<String> conhecimentos;

	// ============================================================
	// CONSTRUTORES
	// ============================================================
	public Pessoa() {
	}

	public Pessoa(Integer id, String username, String nome, String email,
				  String telefone, LocalDate dataNascimento) {
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	// ============================================================
	// GETTERS E SETTERS
	// ============================================================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaRepeticao() {
		return senhaRepeticao;
	}

	public void setSenhaRepeticao(String senhaRepeticao) {
		this.senhaRepeticao = senhaRepeticao;
	}

	public List<String> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<String> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}
}
