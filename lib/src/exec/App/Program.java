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

        while (flag){

            Logger.writeLine("1 - departamento, x - sair");

            switch (this.entrada.nextInt()){
                case 1:
                    this.novaEmpresa.addFuncionario();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
