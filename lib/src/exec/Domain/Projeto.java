package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;
import orm.Entity;

public class Projeto extends Entity {

    @Varchar
    @Required
    private String nome;

    @Integer
    @Required
    private int numero;

    @Varchar
    @Required
    private String localizacao;


    @ForeingKey(table = "Departamento")
    private String departamentoID;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(String departamentoID) {
        this.departamentoID = departamentoID;
    }
}
