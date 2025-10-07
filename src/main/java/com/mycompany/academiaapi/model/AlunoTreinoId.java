package com.mycompany.academiaapi.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * ID composto para AlunoTreinoVinculo.
 * @author wesia
 */
@Embeddable
public class AlunoTreinoId implements Serializable {

    private Long alunoId;
    private Long treinoId;

    public AlunoTreinoId() {}
    public AlunoTreinoId(Long alunoId, Long treinoId) {
        this.alunoId = alunoId;
        this.treinoId = treinoId;
    }

    // getters/setters
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public Long getTreinoId() { return treinoId; }
    public void setTreinoId(Long treinoId) { this.treinoId = treinoId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlunoTreinoId)) return false;
        AlunoTreinoId that = (AlunoTreinoId) o;
        return Objects.equals(getAlunoId(), that.getAlunoId()) && Objects.equals(getTreinoId(), that.getTreinoId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlunoId(), getTreinoId());
    }
}
