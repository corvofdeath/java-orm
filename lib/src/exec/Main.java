package exec;

import exec.Domain.Departamento;
import exec.Infra.ApplicationContext;
import orm.Context.Options;
import orm.Querys.Implementation.Queryable;
import utils.Logger;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws Exception {
        try {

            if (args.length > 0) {

                for (String option: args) {

                    // create dump and exit
                    if (option.equals("-dump")) {
                        ApplicationContext context = new ApplicationContext(Options.dump);
                    }
                }
            } else {

                // run normal program
                ApplicationContext context = new ApplicationContext();

                // TODO: rodar o programa

                Departamento teste = new Departamento();
                teste.setNome("Doido");
                teste.setNumero(21);

                //context.getDbset(Departamento.class).insert(teste);
                Departamento dep = (Departamento) context.getDbset(Departamento.class).get(new Queryable("departamento").where("nome='asdasd'"));
                Logger.writeLine(dep.getNome());

            }

        } catch (Exception e) {
            throw e;
        }

    }
}
