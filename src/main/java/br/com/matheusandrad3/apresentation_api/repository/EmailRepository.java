package br.com.matheusandrad3.apresentation_api.repository;
import br.com.matheusandrad3.apresentation_api.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
