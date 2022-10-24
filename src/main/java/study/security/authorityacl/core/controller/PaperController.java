package study.security.authorityacl.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.security.authorityacl.core.domain.Paper;
import study.security.authorityacl.core.service.PaperService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/papes")
public class PaperController {

    private final PaperService paperService;

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    @GetMapping("/{paperId}")
    public Paper findPaper(@AuthenticationPrincipal User user, @PathVariable("paperId") Long paperId) {
        return paperService.findPaper(paperId);
    }
}
