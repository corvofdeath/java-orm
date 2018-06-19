package exec;

import exec.App.Program;
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

                // run normal Program
                ApplicationContext context = new ApplicationContext();

                // TODO: rodar o programa
                Program app = new Program("Bussiness", context);

            }

        } catch (Exception e) {
            throw e;
        }

    }
}
