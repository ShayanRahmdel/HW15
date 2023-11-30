package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Term {

    private Integer year;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "mid_term")
    private MidTerm midTerm;

    public Term getPervTerm() {
        MidTerm pervMidTerm;
        if (midTerm.equals(MidTerm.Second)){
            pervMidTerm=MidTerm.First;
        }else {
            pervMidTerm = MidTerm.Second;
        }
        Integer pervYear = year;

        if (pervMidTerm==MidTerm.Second){
            pervYear-=1;
        }
        return new Term(pervYear,pervMidTerm);

    }
}
