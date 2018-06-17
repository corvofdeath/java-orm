package exec;

import exec.Infra.ApplicationContext;
import orm.Context.Options;

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
            }

        } catch (Exception e) {
            throw e;
        }

    }
}
