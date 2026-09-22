package br.senac.tads.dsw.dados_pessoais;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid; // cite: 2

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	private final PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping
	public List<Pessoa> obterPessoas() {
		return pessoaService.obterPessoas();
	}

	@GetMapping("/{username}")
	public Pessoa obterPessoa(@PathVariable("username") String username) {
		Optional<Pessoa> optPessoa = pessoaService.obterPessoa(username);

		if (optPessoa.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPessoa.get();
	}

	@PostMapping
	public ResponseEntity<?> incluirNovo(@RequestBody Pessoa pessoa) {
		pessoaService.incluirNovaPessoa(pessoa);

		URI location = ServletUriComponentsBuilder
			.fromCurrentContextPath()
			.path("/pessoas/{username}")
			.buildAndExpand(pessoa.getUsername())
			.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("/validacao") // Adicionado um caminho para evitar conflito com o primeiro @PostMapping
	public ResponseEntity<?> incluirNovoComValidacao(@RequestBody @Valid Pessoa pessoa) { // cite: 2
		// NOTAR O @Valid na linha acima // cite: 2

		pessoaService.incluirNovaPessoa(pessoa); // cite: 2
		URI location = ServletUriComponentsBuilder // cite: 2
			.fromCurrentContextPath() // cite: 2
			.path("/pessoas/{username}") // cite: 2
			.buildAndExpand(pessoa.getUsername()) // cite: 2
			.toUri(); // cite: 2
		return ResponseEntity.created(location).build(); // cite: 2
	}
}
