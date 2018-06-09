package exec.Domain;

import orm.Attributes.*;

import java.util.Date;

public class Gerente extends Entity {

    @ForeingKey(table = "Funcionario")
    private String funcionarioID;

    @ForeingKey(table = "Departamento")
    private String departamentoID;


    @DateTime
    private Date inicio;
}
