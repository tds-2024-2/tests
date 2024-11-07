package org.example;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository {

    Optional<Aluno> findByNumeroMatricula(int numeroMatricula);

    List<Turma> findAllTurmas();

}
