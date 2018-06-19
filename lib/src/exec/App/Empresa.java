package exec.App;

import exec.Domain.*;
import exec.Infra.Repository;
import exec.Interfaces.IRepository;
import orm.Context.DbContext;
import orm.Entity;
import utils.Logger;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {

    private String nome;
    private IRepository repository;
    private Scanner scanner = new Scanner(System.in);
    private int countProjeto = 0;

    public  Empresa(String nome, DbContext dbContext){
        this.nome = nome;
        this.repository = new Repository(dbContext);
    }

    // Métodos de Adicionar

    public void addDepartamento(){
        Logger.writeLine("Cadastrando Departamento...");
        Departamento novoDepartamento = new Departamento();
        repository.create(Departamento.class, this.createDepartamento(novoDepartamento));
        Logger.writeLine("[Create] - Departamento adicionando com Sucesso!");
    }

    public void addDependente(){
        Logger.writeLine("Cadastrando dependente...");
        Funcionario funcionario = this.searchFuncionario();
        if(funcionario != null){
            Dependente novoDependente = new Dependente();
            repository.create(Dependente.class, this.createDependente(funcionario, novoDependente));
            Logger.writeLine("[Create] - Dependente adicionando com Sucesso!");
        } else
            Logger.writeLine("[Error] - Funcionário não cadastrado!");
    }

    public void addFuncionario(){
        Logger.writeLine("Cadastrando Funcionário...");
        Departamento departamento = this.searchDepartamento();
        if(departamento != null){
            Funcionario novoFuncionario = new Funcionario();
            repository.create(Funcionario.class, this.createFuncionario(departamento, novoFuncionario));
            Logger.writeLine("[Create] - Funcionário adicionando com Sucesso!");
        } else
            Logger.writeLine("[Error] - Departamento não cadastrado!");
    }

    public void addProjeto(){
        Logger.writeLine("Cadastrando Projeto...");
        Departamento departamento = this.searchDepartamento();
        if(departamento != null){
            Projeto novoProjeto = new Projeto();
            repository.create(Projeto.class, createProjeto(departamento, novoProjeto));
            Logger.writeLine("[Create] - Projeto adicionando com Sucesso!");
        } else
            Logger.writeLine("[Error] - Departamento não cadastrado!");
    }

    public void addGerente(){
        Logger.writeLine("Cadrastrando Gerente...");
        Funcionario funcionario = this.searchFuncionario();
        if(funcionario != null){
            repository.create(Gerente.class, this.createGerente(funcionario));
            Logger.writeLine("[Create] - Gerente adicionando com Sucesso!");
        } else
            Logger.writeLine("[Error] - Funcionário não cadastrado!");
    }

    public void addFuncionarioProjeto(){
        Logger.writeLine("Cadrastrando Funcionario ao Projeto...");
        Funcionario funcionario = this.searchFuncionario();
        if(funcionario != null){
            Projeto projeto = this.searchProjeto();
            if(projeto != null){
                repository.create(FuncionarioProjeto.class, this.createFuncionarioProjeto(funcionario, projeto));
                Logger.writeLine("[Create] - Cadastro realizado com sucesso!");
            } else
                Logger.writeLine("[Error] - Projeto não cadastrado!");
        } else
            Logger.writeLine("[Error] - Funcionário não cadastrado!");
    }

    // Métodos de Criação

    private Departamento createDepartamento(Departamento departamento){
        Departamento novoDepartamento = departamento;

        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite um nome para Departamento: ");
        String nome = this.scanner.nextLine();
        novoDepartamento.setNome(nome);
        Logger.writeLine("Digite um número para esse departamento: ");
        int numero = this.scanner.nextInt();
        novoDepartamento.setNumero(numero);

        return novoDepartamento;
    }

    private Dependente createDependente(Funcionario funcionario, Dependente dependente){
        Dependente novoDependente = dependente;

        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite o nome do dependente: ");
        String nome = this.scanner.nextLine();
        novoDependente.setNome(nome);
        Logger.writeLine("Digite a data de nascimento (Ano-mes-dia): ");
        LocalDate data = LocalDate.parse(this.scanner.nextLine());
        novoDependente.setNascimento(data);
        Logger.writeLine("Digite o sexo (0)-Masculino (1)-Feminino: ");
        int sexo = this.scanner.nextInt();
        novoDependente.setSexo(sexo);
        this.scanner = new Scanner(System.in);
        Logger.writeLine("Grua de Parentesco: ");
        String parentesco = this.scanner.nextLine();
        novoDependente.setRelacionamento(parentesco);
        novoDependente.setFuncionarioId(funcionario.getId());

        return novoDependente;
    }

    private Funcionario createFuncionario(Departamento departamento, Funcionario funcionario){
        Funcionario novoFuncionario = funcionario;

        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite o nome do Funcinário: ");
        String nome = this.scanner.nextLine();
        novoFuncionario.setNome(nome);
        Logger.writeLine("Digite o Salário: ");
        double salario = this.scanner.nextDouble();
        novoFuncionario.setSalario(salario);
        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite o Cargo: ");
        String cargo = this.scanner.nextLine();
        novoFuncionario.setCargo(cargo);
        Logger.writeLine("Digite o Rg: ");
        String rg = this.scanner.nextLine();
        novoFuncionario.setRg(rg);
        Logger.writeLine("Digite o Cpf: ");
        String cpf = this.scanner.nextLine();
        novoFuncionario.setCpf(cpf);
        Logger.writeLine("Digite a data de Nascimento (Ano-mes-dia): ");
        LocalDate data = LocalDate.parse(this.scanner.nextLine());
        novoFuncionario.setNascimento(data);
        Logger.writeLine("Digite o Sexo (0)-Masculino (1)-Feminino: ");
        int sexo = this.scanner.nextInt();
        novoFuncionario.setSexo(sexo);
        Logger.writeLine("Emdereço do Funcionário...");
        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite a rua: ");
        String rua = this.scanner.nextLine();
        novoFuncionario.setEndereco(rua);
        Logger.writeLine("Digite o Numero: ");
        int numero = this.scanner.nextInt();
        novoFuncionario.setNumero(numero);
        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite a Cidade: ");
        String cidade = this.scanner.nextLine();
        novoFuncionario.setCidade(cidade);
        Logger.writeLine("Digite o Bairro: ");
        String bairro = this.scanner.nextLine();
        novoFuncionario.setBairro(bairro);
        Logger.writeLine("Digite o Cep: ");
        String cep = this.scanner.nextLine();
        novoFuncionario.setCep(cep);
        novoFuncionario.setDepartamentoId(departamento.getId());

        return novoFuncionario;
    }

    private Projeto createProjeto(Departamento departamento, Projeto projeto){
        Projeto novoProjeto = projeto;

        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite o nome do projeto: ");
        String nome = this.scanner.nextLine();
        novoProjeto.setNome(nome);
        int numero = this.countProjeto++;
        novoProjeto.setNumero(numero);
        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite a localização: ");
        String localizacao = this.scanner.nextLine();
        novoProjeto.setLocalizacao(localizacao);
        novoProjeto.setDepartamentoID(departamento.getId());

        return novoProjeto;
    }

    private Gerente createGerente(Funcionario funcionario){
        Gerente novoGerente = new Gerente();

        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite a data de Inicio (Ano-mes-dia): ");
        LocalDate data = LocalDate.parse(this.scanner.nextLine());
        novoGerente.setInicio(data);
        novoGerente.setFuncionarioID(funcionario.getId());
        novoGerente.setDepartamentoID(funcionario.getDepartamentoId());
        funcionario.setCargo("Gerente");
        repository.update(Funcionario.class, funcionario);

        return novoGerente;
    }

    private FuncionarioProjeto createFuncionarioProjeto(Funcionario funcionario, Projeto projeto){
        FuncionarioProjeto funcionarioProjeto = new FuncionarioProjeto();

        this.scanner = new Scanner(System.in);
        Logger.writeLine("Digite a quantidade de horas do projeto: ");
        int horas = this.scanner.nextInt();
        funcionarioProjeto.setHoras(horas);
        funcionarioProjeto.setFuncionarioID(funcionario.getId());
        funcionarioProjeto.setProjetoID(projeto.getId());

        return funcionarioProjeto;
    }

    // Métodos de Procura

    private Funcionario searchFuncionario() {
        Logger.writeLine("Digite o CPF do Funcionário: ");
        String nome = "cpf='";
        nome += this.scanner.nextLine() + "'";
        Funcionario funcionario = repository.get(Funcionario.class, nome);
        if(funcionario != null)
            return funcionario;
        else
            return null;
    }

    private Departamento searchDepartamento(){
        Logger.writeLine("Digite o Codigo do Departamento: ");
        int numero =  this.scanner.nextInt();
        String busca = "numero='" + numero + "'";
        Departamento departamento = repository.get(Departamento.class, busca);
        if(departamento != null)
            return departamento;
        else
            return null;
    }

    private Projeto searchProjeto(){
        Logger.writeLine("Digite o código do Projeto: ");
        int numero =  this.scanner.nextInt();
        String busca = "numero='" + numero + "'";
        Projeto projeto = repository.get(Projeto.class, busca);
        if(projeto != null)
            return projeto;
        else
            return null;
    }

    private Dependente searchDependente(){
        Logger.writeLine("Digite o nome do Dependente: ");
        String nome = "nome='";
        nome += this.scanner.nextLine() + "'";
        Dependente dependente = repository.get(Dependente.class, nome);
        if(dependente != null)
            return dependente;
        else
            return null;
    }

    // Métodos de Delete

    public void deleteDepartamento(){
        Logger.writeLine("Deletando Departamento...");
        Departamento departamento = this.searchDepartamento();
        if(departamento != null){
            Entity tabelas[] = {new Funcionario(), new Gerente(), new Projeto()};
            if(verificaPesquisa(departamento, tabelas, "departamentoID")){
                repository.delete(Departamento.class, departamento);
                Logger.writeLine("[Delete] - Departamento apagado com sucesso!");
            } else
                Logger.writeLine("[Error] - Esse funcionário esta cadastrado em outros setores, por favor verificar!");
        } else
        Logger.writeLine("[Error] - Departamento não cadastrado!");
    }

    public void deleteDependente(){
        Logger.writeLine("Deletando Departamento...");
        Dependente dependente = this.searchDependente();
        if(dependente != null){
            repository.delete(Dependente.class, dependente);
            Logger.writeLine("[Delete] - Dependente apagado com sucesso!");
        } else
            Logger.writeLine("[Error] - Dependente não cadastrado!");
    }

    public void deleteFuncionario(){
        Logger.writeLine("Deletando Funcionário...");
        Funcionario funcionario = this.searchFuncionario();

        if(funcionario != null){
            Entity tabelas[] = {new Dependente(), new FuncionarioProjeto(), new Gerente()};
            if(verificaPesquisa(funcionario, tabelas, "funcionarioId")){
                repository.delete(Funcionario.class, funcionario);
                Logger.writeLine("[Delete] - Funcionário apagado com sucesso!");
            } else
                Logger.writeLine("[Error] - Esse funcionário esta cadastrado em outros setores, por favor verificar!");
        } else
            Logger.writeLine("[Error] - Funcionário não cadastrado!");
    }

    private boolean verificaPesquisa(Entity pesquisa, Entity[] tabelas, String campo){
        boolean flag = true;
        String id = campo + "='" + pesquisa.getId() + "'";;

        for (Entity entidade: tabelas) {
            Entity retorno = repository.get(entidade.getClass(), id);
            if(retorno != null)
                flag = false;
        }

        return flag;
    }

    public void deleteProjeto(){
        Logger.writeLine("Deletando Projeto...");
        Projeto projeto = this.searchProjeto();
        if(projeto != null){
            Entity tabelas[] = {new FuncionarioProjeto()};
            if(verificaPesquisa(projeto, tabelas, "projetoID")){
                repository.delete(Projeto.class, projeto);
                Logger.writeLine("[Delete] - Projeto apagado com sucesso!");
            } else
                Logger.writeLine("[Error] - Esse funcionário esta cadastrado em outros setores, por favor verificar!");
        } else
            Logger.writeLine("[Error] - Projeto não cadastrado!");
    }

    public void deleteGerente(){
        Logger.writeLine("Deletando Gerente...");
        Funcionario funcionario = this.searchFuncionario();
        Gerente gerente = repository.get(Gerente.class, "funcionarioID='" + funcionario.getId() + "'");
        if(gerente != null){
            repository.delete(Gerente.class, gerente);
            Logger.writeLine("[Delete] - Gerente apagado com sucesso!");
           } else
        Logger.writeLine("[Error] - Gerente não cadastrado!");
    }

    public void deleteFuncionarioProjeto(){
        Logger.writeLine("Deletando Funcionario de um Projeto...");
        Funcionario funcionario = this.searchFuncionario();
        FuncionarioProjeto funcionarioProjeto = repository.get(FuncionarioProjeto.class, "funcionarioID='" + funcionario.getId() + "'");
        if(funcionarioProjeto != null){
            repository.delete(FuncionarioProjeto.class, funcionarioProjeto);
            Logger.writeLine("[Delete] -  Funcionario apagado com sucesso!");
        } else
            Logger.writeLine("[Error] -  Funcionario não cadastrado!");
    }

    // Metódos de Updates

    public void updateDepartamento(){
        Logger.writeLine("Atualizando Departamento...");
        Departamento departamento = this.searchDepartamento();
        if(departamento != null){
            departamento = this.createDepartamento(departamento);
            repository.update(Departamento.class, departamento);
            Logger.writeLine("[Update] - Departamento atualizado com sucesso!");
        } else
            Logger.writeLine("[Error] - Departamento não cadastrado!");
    }

    public void updateDepentende(){
        Logger.writeLine("Atualizando Dependente...");
        Dependente dependente = this.searchDependente();
        if(dependente != null){
            Funcionario funcionario = this.searchFuncionario();
            if(funcionario != null){
                dependente = this.createDependente(funcionario, dependente);
                repository.update(Dependente.class, dependente);
                Logger.writeLine("[Update] - Dependente atualizado com sucesso!");
            } else
                Logger.writeLine("[Error] - Funcionário não cadastrado!");
        } else
            Logger.writeLine("[Error] - Dependente não cadastrado!");
    }

    public void updateFuncionario(){
        Logger.writeLine("Atualizando Funcionário...");
        Funcionario funcionario = this.searchFuncionario();
        if(funcionario != null){
            Departamento departamento = this.searchDepartamento();
            if(departamento != null){
                funcionario = this.createFuncionario(departamento, funcionario);
                repository.update(Funcionario.class, funcionario);
                Logger.writeLine("[Update] - Funcionário atualizado com sucesso!");
            } else
                Logger.writeLine("[Error] - Departamento não cadastrado!");
        } else
            Logger.writeLine("[Error] - Funcionário não cadastrado!");
    }

    public void updateProjeto(){
        Logger.writeLine("Atualizando Projeto...");
        Projeto projeto = this.searchProjeto();
        if(projeto != null){
            Departamento departamento = this.searchDepartamento();
            if(departamento != null){
                projeto = this.createProjeto(departamento, projeto);
                repository.update(Projeto.class, projeto);
                Logger.writeLine("[Update] - Projeto atualizado com sucesso!");
            } else
                Logger.writeLine("[Error] - Departamento não cadastrado!");
        } else
            Logger.writeLine("[Error] - Projeto não cadastrado!");
    }

    // Métodos de Listagem

    public void listagemDepartamento(){
        Logger.writeLine("Lista dos Departamentos...");
        ArrayList<Departamento> departamentos = repository.getAll(Departamento.class, "");
        Logger.writeLine("Id | Numero | Nome");

        for (Departamento depatamento: departamentos) {
            String texto = depatamento.getId() + " | " + depatamento.getNumero() + " | " + depatamento.getNome();
            Logger.writeLine(texto);
        }
    }

    public void listageDependentes(){
        Logger.writeLine("Lista dos Dependentes...");
        ArrayList<Dependente> dependentes = repository.getAll(Dependente.class, "");
        String texto = "";

        for (Dependente dependente: dependentes) {
            Funcionario funcionario = repository.get(Funcionario.class, "id='" + dependente.getFuncionarioId() + "'");
            texto += dependente.getId() + " | " +  dependente.getNome() + " | " + dependente.getRelacionamento() + " | " + funcionario.getNome() + "\n";
        }

        Logger.writeLine("");
        Logger.writeLine("Id | Nome | Parentesco | Funcionário");
        Logger.writeLine(texto);
    }

    public void listagemFuncionarios(){
        Logger.writeLine("Lista dos Funcionários...");
        ArrayList<Funcionario> funcionarios = repository.getAll(Funcionario.class, "");
        String texto = "";

        for (Funcionario funcionario: funcionarios) {
            Departamento departamento = repository.get(Departamento.class, "id='" + funcionario.getDepartamentoId() + "'");
            texto += funcionario.getId() + " | " +  funcionario.getNome() + " | " + funcionario.getSalario() + " | " + funcionario.getCargo() + " | " + funcionario.getRg() + " | " + funcionario.getCpf() + " | " + funcionario.getNascimento() + " | " + funcionario.getCidade() + " | " + departamento.getNome() + "\n";
        }

        Logger.writeLine("");
        Logger.writeLine("Id | Nome | Salário | Cargo | RG | CPF | Data de Nascimento | Cidade | Departamento");
        Logger.writeLine(texto);
    }

    public void listagemFuncionariosProjetos(){
        Logger.writeLine("Lista dos Funcionários e Projetos...");
        ArrayList<FuncionarioProjeto> funcionarioProjetos = repository.getAll(FuncionarioProjeto.class, "");
        String texto = "";

        for (FuncionarioProjeto funcionarioProjeto: funcionarioProjetos) {
            Funcionario funcionario = repository.get(Funcionario.class, "id='" + funcionarioProjeto.getFuncionarioID() + "'");
            Projeto projeto = repository.get(Projeto.class,"id='" + funcionarioProjeto.getProjetoID() + "'");
            texto += funcionarioProjeto.getId() + " | " +  funcionario.getNome() + " | " + projeto.getNome() + " | " + funcionarioProjeto.getHoras() + "\n";
        }

        Logger.writeLine("");
        Logger.writeLine("Id | Funcionário | Projeto | Horas");
        Logger.writeLine(texto);
        }

    public void listagemGerente(){
        Logger.writeLine("Listagem dos Gerentes...");
        ArrayList<Gerente> gerentes = repository.getAll(Gerente.class, "");
        String texto = "";

        for (Gerente gerente: gerentes) {
            Funcionario funcionario = repository.get(Funcionario.class, "id='" + gerente.getFuncionarioID() + "'");
            Departamento departamento = repository.get(Departamento.class,"id='" + gerente.getDepartamentoID() + "'");
            texto += gerente.getId() + " | " +  funcionario.getNome() + " | " + departamento.getNome() + " | " + gerente.getInicio() + "\n";
        }

        Logger.writeLine("");
        Logger.writeLine("Id | Funcionário | Departamento | Inicio");
        Logger.writeLine(texto);
    }

    public void listagemProjetos(){
        Logger.writeLine("Listagem dos Projetos...");
        ArrayList<Projeto> projetos = repository.getAll(Projeto.class, "");
        String texto = "";

        for (Projeto projeto: projetos) {
            Departamento departamento = repository.get(Departamento.class,"id='" + projeto.getDepartamentoID() + "'");
            texto += projeto.getId() + " | " +  projeto.getNome() + " | " + projeto.getNumero() + " | " + projeto.getLocalizacao() + " | " + departamento.getNome() + "\n";
        }

        Logger.writeLine("");
        Logger.writeLine("Id | Nome | Numero | Localização | Departamento");
        Logger.writeLine(texto);
    }

}

