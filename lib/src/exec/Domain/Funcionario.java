package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;

import java.util.Date;

public class Funcionario extends Entity {

    @Varchar
    private String nome;

    @Decimal
    private double salario;

    @Varchar
    private String cargo;

    @Varchar
    private String rg;

    @Varchar
    private String cpf;

    @DateTime
    private Date nascimento;

    @Integer
    private int sexo;

    @Integer
    private int numero;

    @Varchar
    private String endereco;

    @Varchar
    private String cidade;

    @Varchar
    private String bairro;

    @Varchar
    private String cep;

    @ForeingKey(table = "Departamento")
    private String departamentoId;
}
