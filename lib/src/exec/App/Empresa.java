package exec.App;

import exec.Domain.Departamento;
import exec.Domain.Dependente;
import exec.Domain.Funcionario;
import exec.Infra.Repository;
import exec.Interfaces.IRepository;
import orm.Context.DbContext;
import utils.Logger;

import java.time.LocalDate;
import java.util.Scanner;

public class Empresa {

    private String nome;
    private IRepository repository;
    private Scanner scanner = new Scanner(System.in);

    public  Empresa(String nome, DbContext dbContext){
        this.nome = nome;
        this.repository = new Repository(dbContext);
    }

    public void addDepartamento(){
        Logger.writeLine("Cadastrando Departamento...");
        repository.create(Departamento.class, createDepartamento());
        Logger.writeLine("[Create] - Departamento adicionando com Sucesso!");
    }

    private Departamento createDepartamento(){
        Departamento novoDepartamento = new Departamento();

        Logger.writeLine("Digite um nome para Departamento: ");
        String nome = this.scanner.nextLine();
        novoDepartamento.setNome(nome);
        Logger.writeLine("Digite um número para esse departamento: ");
        int numero = this.scanner.nextInt();
        novoDepartamento.setNumero(numero);

        return novoDepartamento;
    }

    public void addDependente(){
        Logger.writeLine("Cadastrando dependente...");
        Funcionario funcionario = searchFuncionario();
        if(funcionario != null){
            createDependente(funcionario);
            Logger.writeLine("[Create] - Dependente adicionando com Sucesso!");
        } else
            Logger.writeLine("[Error] - Funcionário não cadastrado!");
    }

    private Dependente createDependente(Funcionario funcionario){
        Dependente novoDependente = new Dependente();

        Logger.writeLine("Digite o nome do dependente: ");
        String nome = this.scanner.nextLine();
        novoDependente.setNome(nome);
        Logger.writeLine("Digite a data de nascimento (Ano-mes-dia): ");
        LocalDate data = LocalDate.parse(this.scanner.nextLine());
        novoDependente.setNascimento(data);
        Logger.writeLine("Digite o sexo (0)-Masculino (1)-Feminino: ");
        int sexo = this.scanner.nextInt();
        novoDependente.setSexo(sexo);
        novoDependente.setRelacionamento(funcionario.getId());

        return novoDependente;
    }

    private Funcionario searchFuncionario() {
        Logger.writeLine("Digite o nome do Funcionário deste depedente: ");
        String nome = "nome=";
        nome += this.scanner.nextLine();
        Funcionario funcionario = repository.get(Funcionario.class, nome);
        if(funcionario != null)
            return funcionario;
        else
            return null;
    }


    public void addFuncionario(){
        Logger.writeLine("Cadastrando Funcionário...");
        Departamento departamento = searchDepartamento();
        if(departamento != null){
            repository.create(Funcionario.class, createFuncionario(departamento));
            Logger.writeLine("[Create] - Funcionário adicionando com Sucesso!");
        } else
            Logger.writeLine("[Error] - Departamento não cadastrado!");
    }

    private Departamento searchDepartamento(){
        Logger.writeLine("Digite o nome do Departamento deste Funcionário: ");
        String nome = "nome='";
        nome += this.scanner.nextLine() + "'";
        Departamento departamento = repository.get(Departamento.class, nome);
        if(departamento != null)
            return departamento;
        else
            return null;
    }

    private Funcionario createFuncionario(Departamento departamento){
        Funcionario novoFuncionario = new Funcionario();

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






}
