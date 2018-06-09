package exec.Domain;

import orm.Attributes.*;
import orm.Attributes.Integer;

public class Departamento extends Entity {

    @Integer
    @Unique
    private int numero;

    @Varchar
    private String nome;
}
