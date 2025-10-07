package com.mycompany.academiaapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade Aluno.
 * @author wesia
 */
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String email;
    private LocalDate dataNascimento;
    private boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlunoTreinoVinculo> vinculos = new ArrayList<>();

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }

    public List<Pagamento> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<Pagamento> pagamentos) { this.pagamentos = pagamentos; }

    public List<AlunoTreinoVinculo> getVinculos() { return vinculos; }
    public void setVinculos(List<AlunoTreinoVinculo> vinculos) { this.vinculos = vinculos; }
}
