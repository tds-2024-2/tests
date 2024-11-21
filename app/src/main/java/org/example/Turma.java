package org.example;

import java.util.ArrayList;
import java.util.List;

// o que faz um objeto ser um objeto?
// o que deve ter um objeto? ESTADO E COMPORTAMENTO

public class Turma { // O objeto Turma tem estado e comportamento?

    private String codigo; // tds-2024-2
    private Disciplina disciplina;
    private Periodo periodo;
    private int vagas;
    private List<Matricula> matriculas = new ArrayList<>();

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    // get e setVagas são métodos, mas não são comportamento

    public int getVagas() { // propriedade (é um meio de expor atributo)
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getNumeroMatriculas() {
        return this.matriculas.size();
    }

}
