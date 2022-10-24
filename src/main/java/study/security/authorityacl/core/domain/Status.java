package study.security.authorityacl.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    PREPARE("줄제중 "),
    READY("시험 시작"),
    END("시험 종료");

    private final String name;
}
