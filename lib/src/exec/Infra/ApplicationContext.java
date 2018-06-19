package exec.Infra;

import exec.Domain.*;
import orm.Context.*;

public class ApplicationContext extends DbContext {

    public ApplicationContext() {
        super("mysql://localhost:3306/mybussiness", "root", "root");
    }
    public ApplicationContext(Options option) {
        super("mysql://localhost:3306/mybussiness", "root", "root", option);
    }

    @Override
    protected void fillDbSets() {

        // initialize dbsets for application
        DbSet<Funcionario> funcionarios = new DbSet<>(Funcionario.class);
        DbSet<Dependente> dependentes = new DbSet<>(Dependente.class);
        DbSet<Departamento> departamentos = new DbSet<>(Departamento.class);
        DbSet<FuncionarioProjeto> funcionarioProjeto = new DbSet<>(FuncionarioProjeto.class);
        DbSet<Gerente> gerentes = new DbSet<>(Gerente.class);
        DbSet<Projeto> projetos = new DbSet<>(Projeto.class);

        // register dbsets on dbcontext
        this.addDbSet(Funcionario.class, funcionarios);
        this.addDbSet(Dependente.class, dependentes);
        this.addDbSet(Departamento.class, departamentos);
        this.addDbSet(FuncionarioProjeto.class, funcionarioProjeto);
        this.addDbSet(Gerente.class, gerentes);
        this.addDbSet(Projeto.class, projetos);
    }
}
