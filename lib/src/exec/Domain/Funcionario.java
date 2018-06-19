package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;
import orm.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Funcionario extends Entity {

    @Varchar
    @Required
    private String nome;

    @Decimal
    @Required
    private double salario;

    @Varchar
    @Required
    private String cargo;

    @Varchar
    @Required
    private String rg;

    @Varchar
    @Required
    private String cpf;

    @DateTime
    @Required
    private LocalDate nascimento;

    @Integer
    @Required
    private int sexo;

    @Integer
    @AllowNull
    private int numero;

    @Varchar
    @Required
    private String endereco;

    @Varchar
    @Required
    private String cidade;

    @Varchar
    @AllowNull
    private String bairro;

    @Varchar
    @Required
    private String cep;

    @ForeingKey(table = "Departamento")
    private String departamentoId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }
}
