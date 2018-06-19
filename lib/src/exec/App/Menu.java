package exec.App;

import utils.Logger;

import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);
    Empresa empresa;

    public Menu(Empresa empresa){
        this.empresa = empresa;
    }

    public boolean menuPrincipal(){

        char opcao = this.printMenuPincipal();

        switch (opcao){
            case 49:
                this.menuCadastro();
                break;
            case 50:
                this.menuUpdate();
                break;
            case 51:
                this.menuDelete();
                break;
            case 52:
                this.menuListagem();
            default:
                break;
        }

        return false;
    }

    private char printMenuPincipal(){
        Logger.writeLine("================= Menu Principal =================");
        Logger.writeLine("Escolha uma opção");
        Logger.writeLine("1 - Cadastro");
        Logger.writeLine("2 - Atualização");
        Logger.writeLine("3 - Apagar dados");
        Logger.writeLine("4 - Listagens");
        Logger.writeLine("Pressione qualquer outra tecla para sair...");
       char opção =  this.entrada.next().charAt(0);

       return opção;
    }

    public void menuCadastro(){

        char opcao = this.printMenuCadastro();

        switch (opcao){
            case 49:
                this.empresa.addDepartamento();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuCadastro();
                break;
            case 50:
                this.empresa.addDependente();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuCadastro();
                break;
            case 51:
                this.empresa.addFuncionario();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuCadastro();
                break;
            case 52:
                this.empresa.addProjeto();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuCadastro();
                break;
            case 53:
                this.empresa.addFuncionarioProjeto();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuCadastro();
                break;
            case 54:
                this.empresa.addGerente();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuCadastro();
                break;
            default:
                this.menuPrincipal();
                break;
        }
    }


    private char printMenuCadastro(){
        Logger.writeLine("================= Menu de Cadastro =================");
        Logger.writeLine("Escolha uma opção");
        Logger.writeLine("1 - Cadastrar Departamento ");
        Logger.writeLine("2 - Cadastrar Dependente");
        Logger.writeLine("3 - Cadastrar Funcionário");
        Logger.writeLine("4 - Cadastrar Projeto");
        Logger.writeLine("5 - Adicionar Funcionário a um projeto");
        Logger.writeLine("6 - Adicionar um Gerente");
        Logger.writeLine("Pressione qualquer outra tecla para voltar...");
        char opção =  this.entrada.next().charAt(0);

        return opção;
    }

    public void menuUpdate(){

        char opcao = this.printMenuUpdate();

        switch (opcao){
            case 49:
                this.empresa.updateDepartamento();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuUpdate();
                break;
            case 50:
                this.empresa.updateDepentende();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuUpdate();
                break;
            case 51:
                this.empresa.updateFuncionario();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuUpdate();
                break;
            case 52:
                this.empresa.updateProjeto();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuUpdate();
                break;
            default:
                this.menuPrincipal();
                break;
        }
    }

    private char printMenuUpdate(){
        Logger.writeLine("================= Menu de Atualização =================");
        Logger.writeLine("Escolha uma opção");
        Logger.writeLine("1 - Editar Departamento ");
        Logger.writeLine("2 - Editar Dependente");
        Logger.writeLine("3 - Editar Funcionário");
        Logger.writeLine("4 - Editar Projeto");
        Logger.writeLine("Pressione qualquer outra tecla para voltar...");
        char opção =  this.entrada.next().charAt(0);

        return opção;
    }

    public void menuDelete(){

        char opcao = this.printMenuDelete();

        switch (opcao){
            case 49:
                this.empresa.deleteDepartamento();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuDelete();
                break;
            case 50:
                this.empresa.deleteDependente();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuDelete();
                break;
            case 51:
                this.empresa.deleteFuncionario();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuDelete();
                break;
            case 52:
                this.empresa.deleteProjeto();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuDelete();
                break;
            case 53:
                this.empresa.deleteFuncionarioProjeto();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuDelete();
                break;
            case 54:
                this.empresa.deleteGerente();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuDelete();
                break;
            default:
                this.menuPrincipal();
                break;
        }
    }

    private char printMenuDelete(){
        Logger.writeLine("================= Menu de Apagar dados =================");
        Logger.writeLine("Escolha uma opção");
        Logger.writeLine("1 - Apagar Departamento ");
        Logger.writeLine("2 - Apagar Dependente");
        Logger.writeLine("3 - Apagar Funcionário");
        Logger.writeLine("4 - Apagar Projeto");
        Logger.writeLine("5 - Apagar Funcionário a um projeto");
        Logger.writeLine("6 - Apagar um Gerente");
        Logger.writeLine("Pressione qualquer outra tecla para voltar...");
        char opção =  this.entrada.next().charAt(0);

        return opção;
    }

    public void menuListagem(){

        char opcao = this.printMmenuListagens();

        switch (opcao){
            case 49:
                this.empresa.listagemDepartamento();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuListagem();
                break;
            case 50:
                this.empresa.listageDependentes();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuListagem();
                break;
            case 51:
                this.empresa.listagemFuncionarios();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuListagem();
                break;
            case 52:
                this.empresa.listagemProjetos();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuListagem();
                break;
            case 53:
                this.empresa.listagemFuncionariosProjetos();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuListagem();
                break;
            case 54:
                this.empresa.listagemGerente();
                Logger.writeLine("Pressione qualquer para voltar...");
                this.entrada.next();
                this.menuListagem();
                break;
            default:
                this.menuPrincipal();
                break;
        }
    }

    private char printMmenuListagens(){
        Logger.writeLine("================= Menu de Listagem =================");
        Logger.writeLine("Escolha uma opção");
        Logger.writeLine("1 - Relação dos Departamentos");
        Logger.writeLine("2 - Relação dos Dependentes");
        Logger.writeLine("3 - Relação dos Funcionários");
        Logger.writeLine("4 - Relacao dos Projetos");
        Logger.writeLine("5 - Relação dos Funcionários e projetos");
        Logger.writeLine("6 - Relação dos Gerentes");
        Logger.writeLine("Pressione qualquer outra tecla para voltar...");
        char opção =  this.entrada.next().charAt(0);

        return opção;
    }
}
