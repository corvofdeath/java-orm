package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;
import orm.Entity;

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
    private Date nascimento;

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
}
