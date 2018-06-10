package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;

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
}
