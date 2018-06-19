package exec.App;

import orm.Context.DbContext;
import utils.Logger;

import java.util.Scanner;

public class Program {

    Scanner entrada = new Scanner(System.in);
    Empresa novaEmpresa;

    public Program(String nome, DbContext dbContext){
        this.novaEmpresa = new Empresa(nome, dbContext);
        this.runApp();
    }

    public void runApp(){

        boolean flag = true;
        Menu menu = new Menu(novaEmpresa);

        while (flag){

            flag = menu.menuPrincipal();

        }
    }
}
