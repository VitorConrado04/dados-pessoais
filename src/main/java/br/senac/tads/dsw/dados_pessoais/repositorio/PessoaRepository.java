package br.senac.tads.dsw.dados_pessoais.repositorio;

import br.senac.tads.dsw.dados_pessoais.entidade.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;



@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

	@Query("""
    SELECT p FROM PessoaEntity p
    WHERE LOWER(p.username) LIKE LOWER(CONCAT('%', :termo, '%'))
       OR LOWER(p.nome)     LIKE LOWER(CONCAT('%', :termo, '%'))
       OR LOWER(p.email)    LIKE LOWER(CONCAT('%', :termo, '%'))
    """)
	List<PessoaEntity> buscarPorTermo(@Param("termo") String termo);
	Optional<PessoaEntity> findByUsername(String username);

	boolean existsByUsername(String username);

}
