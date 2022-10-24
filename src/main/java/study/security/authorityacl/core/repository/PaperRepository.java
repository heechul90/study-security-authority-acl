package study.security.authorityacl.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.security.authorityacl.core.domain.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long> {
}
