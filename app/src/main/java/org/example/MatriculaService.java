package org.example;

import java.time.LocalDate;
import java.util.List;

import org.example.Matricula.Status;

public class MatriculaService {

    private static int codigo = 1;

    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public MatriculaService(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public Matricula matricular(final int numeroMatricula, final String codigoTurma) {

        final Aluno aluno = alunoRepository.findByNumeroMatricula(numeroMatricula)
            .orElseThrow(() -> new NotFoundException("Aluno " + numeroMatricula + " não encontrado"));

        final Turma turma = turmaRepository.findByCodigo(codigoTurma)
            .orElseThrow(() -> new NotFoundException("Turma " + codigoTurma + " não encontrada"));

        if (turma.getMatriculas().stream().anyMatch(m -> m.getAluno().equals(aluno))) {
            throw new DomainException("Aluno " + numeroMatricula + " já matriculado na turma " + turma.getCodigo());
        }

        final Disciplina disciplina = turma.getDisciplina();

        if (turma.getNumeroMatriculas() >= turma.getVagas()) {
            final List<Turma> historico = turmaRepository.findAllContainingAluno(aluno);

            final List<Turma> historicoDisciplina = historico.stream()
                .filter(t -> t.getDisciplina().equals(disciplina))
                .toList();
            
            if (historicoDisciplina.stream().anyMatch(
                t -> t.getMatriculas().stream().anyMatch(m -> Status.APROVADO.equals(m.getStatus())))) {
                
                throw new DomainException("Aluno " + numeroMatricula + " já foi aprovado em disciplina " + disciplina.getCodigo());
            }

            if (historicoDisciplina.stream().noneMatch(
                    t -> t.getMatriculas().stream().anyMatch(m -> Status.REPROVADO.equals(m.getStatus())))) {

                throw new DomainException("Não há vagas na turma " + turma.getCodigo());
            }
        }

        final Matricula mat = new Matricula();
        mat.setCodigo(codigo++);
        mat.setAluno(aluno);
        mat.setData(LocalDate.now());
        mat.setStatus(Status.REGULAR);

        return mat;
    }
}
