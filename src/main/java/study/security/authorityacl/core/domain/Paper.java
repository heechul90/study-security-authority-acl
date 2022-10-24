package study.security.authorityacl.core.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Paper {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paper_id")
    private Long id;

    private String title;
    private String tutorId;
    private Status status;

    public Paper(String title, String tutorId, Status status) {
        this.title = title;
        this.tutorId = tutorId;
        this.status = status;
    }
}
