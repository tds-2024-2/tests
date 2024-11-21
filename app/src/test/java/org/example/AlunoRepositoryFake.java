package org.example;

import java.util.List;
import java.util.Optional;

public class AlunoRepositoryFake implements AlunoRepository{

    @Override
    public Optional<Aluno> findByNumeroMatricula(int numeroMatricula) {
        
        if(numeroMatricula == 20221111){
            Aluno a = new Aluno();
            a.setNome("Alisson");
            a.setMatricula(20221111);
            return Optional.of(a);
        }
        return Optional.empty();
    }

    @Override
    public List<Turma> findAllTurmas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllTurmas'");
    }
    
}
