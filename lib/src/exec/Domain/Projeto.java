package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;

public class Projeto extends Entity {

    @Varchar
    private String nome;

    @Integer
    private int numero;

    @Varchar
    private String localizacao;


    @ForeingKey(table = "Departamento")
    private String departamentoID;
}
