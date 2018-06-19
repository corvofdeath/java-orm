package exec.Domain;

import orm.Attributes.*;
import orm.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Gerente extends Entity {

    @ForeingKey(table = "Funcionario")
    private String funcionarioID;

    @ForeingKey(table = "Departamento")
    private String departamentoID;

    @DateTime
    @Required
    private LocalDate inicio;

    public String getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(String funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(String departamentoID) {
        this.departamentoID = departamentoID;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
}
