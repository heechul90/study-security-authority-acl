package study.security.authorityacl.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.security.authorityacl.core.domain.Paper;
import study.security.authorityacl.core.repository.PaperRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaperService {

    private final PaperRepository paperRepository;

    public Paper findPaper(Long paperId) {
        return paperRepository.findById(paperId).orElse(null);
    }

    public Paper savePaper(Paper paper) {
        return paperRepository.save(paper);
    }
}
