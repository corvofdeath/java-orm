package exec;

import exec.Domain.Departamento;
import exec.Infra.ApplicationContext;
import orm.Context.Options;
import utils.Logger;

import java.util.Date;

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
                teste.setNome("Filipe");
                teste.setNumero(15);
                teste.setCreatedAt(new Date());
                teste.setUpdatedAt(new Date());

                context.getDbset(Departamento.class).insert(teste);
            }

        } catch (Exception e) {
            throw e;
        }

    }
}
