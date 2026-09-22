package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class PessoaAlteracaoDto {

	@NotBlank(message = "O nome completo é obrigatório")
	@Size(max = 100)
	private String nome;

	@NotBlank
	@Size(max = 100)
	@Email
	private String email;

	@Size(max = 20)
	private String telephone;

	@NotNull
	@PastOrPresent
	private LocalDate dataNascimento;

	private List<String> conhecimentos;

	// --- GETTERS E SETTERS ---

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<String> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<String> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	public String getTelefone() {
		return telephone;
	}
}
