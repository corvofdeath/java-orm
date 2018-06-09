package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;

import java.util.Date;

public class Dependente extends Entity {

    @Varchar
    private String nome;

    @DateTime
    private Date nascimento;

    @Integer
    private int sexo;

    @Varchar
    private String relacionamento;


    @ForeingKey(table = "Funcionario")
    private int funcionarioId;
}
