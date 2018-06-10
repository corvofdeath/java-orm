package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;

import java.util.Date;

public class Dependente extends Entity {

    @Varchar
    @Required
    private String nome;

    @DateTime
    @Required
    private Date nascimento;

    @Integer
    @Required
    private int sexo;

    @Varchar
    @Required
    private String relacionamento;

    @ForeingKey(table = "Funcionario")
    private int funcionarioId;
}
