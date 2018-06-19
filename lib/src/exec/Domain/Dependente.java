package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;
import orm.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Dependente extends Entity {

    @Varchar
    @Required
    private String nome;

    @DateTime
    @Required
    private LocalDate nascimento;

    @Integer
    @Required
    private int sexo;

    @Varchar
    @Required
    private String relacionamento;

    @ForeingKey(table = "Funcionario")
    private int funcionarioId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
}
