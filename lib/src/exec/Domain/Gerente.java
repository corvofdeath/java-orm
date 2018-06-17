package exec.Domain;

import orm.Attributes.*;
import orm.Entity;

import java.util.Date;

public class Gerente extends Entity {

    @ForeingKey(table = "Funcionario")
    private String funcionarioID;

    @ForeingKey(table = "Departamento")
    private String departamentoID;

    @DateTime
    @Required
    private Date inicio;
}
