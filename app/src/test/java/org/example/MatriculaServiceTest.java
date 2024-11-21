package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





public class MatriculaServiceTest {

    MatriculaService matriculaService;
    AlunoRepository alunoRepository;
    TurmaRepository turmaRepository;
    
    @BeforeEach void Setup(){
  
        System.out.println("Teste");
        alunoRepository = new AlunoRepositoryFake();
        turmaRepository = new TurmaRepositoryFake();
        matriculaService = new MatriculaService(alunoRepository, turmaRepository); 
    }



    @Test void TestVerdade(){
        //System.out.println("Teste");
        assertTrue(true, "A verdade não foi Verdade");
    }
    @Test void TestFalso(){
        //System.out.println("Teste");
        assertFalse(false , "Não foi Falso");
    }

    @Test void TestHaUmaInstanciaDeMatriculaServices(){
        assertNotNull(matriculaService, "Matricula Services não é nulo");
    }

    @Test void TestAlunoNaoExisteLançaExceçãoNotFoundException(){
        try{
            matriculaService.matricular(123, "tds-2024-2");
            assertFalse(true);
        } catch (NotFoundException e) {
            System.out.println(e);
            assertEquals("Aluno 123 não encontrado", e.getMessage());
        }
        
    }

    
}
