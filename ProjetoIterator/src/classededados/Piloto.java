/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classededados;

/**
 *
 * @author Wésia
 */
public class Piloto {
    
    
    private int Matricula;
    private String Nome;
    private String paisOrigem;
    private int Idade;
    private String Equipe;
    private String motor;
    private String pontos;

    public Piloto(int Matricula, String Nome, String paisOrigem, int Idade, String Equipe, String motor, String pontos) {
        this.Matricula = Matricula;
        this.Nome = Nome;
        this.paisOrigem = paisOrigem;
        this.Idade = Idade;
        this.Equipe = Equipe;
        this.motor = motor;
        this.pontos = pontos;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public String getEquipe() {
        return Equipe;
    }

    public void setEquipe(String Equipe) {
        this.Equipe = Equipe;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
    
}
    
    

   