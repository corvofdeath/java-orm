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
}
