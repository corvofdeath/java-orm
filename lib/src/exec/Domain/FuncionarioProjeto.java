package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;
import orm.Entity;

public class FuncionarioProjeto extends Entity {

    @ForeingKey(table = "Funcionario")
    private String funcionarioID;

    @ForeingKey(table = "Projeto")
    private String projetoID;

    @Integer
    @AllowNull
    private int horas;

    public String getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(String funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getProjetoID() {
        return projetoID;
    }

    public void setProjetoID(String projetoID) {
        this.projetoID = projetoID;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
