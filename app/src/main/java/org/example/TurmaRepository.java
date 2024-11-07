package org.example;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository {

    Optional<Turma> findByCodigo(String codigoTurma);

    List<Turma> findAllContainingAluno(Aluno aluno);

}
