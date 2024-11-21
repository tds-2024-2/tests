package org.example;
// Jupiter <=> JUnit 5 

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


/*
 * Mentalidade (mindset):
 * Nós não testamos para mostrar que o software funciona, (cognitive bias -> viés cognitivo)
 * nós testamos para mostrar que ele NÃO FUNCIONA.
 * 
 * confirmation bias
 */


public class MatriculaServiceTest {

    MatriculaService matriculaService;
    AlunoRepository alunoRepository;
    TurmaRepository turmaRepository;
    
    @BeforeEach void Setup(){
  
        System.out.println("Teste");
        // isolamento das dependências
        alunoRepository = new AlunoRepositoryFake(); // <- STUB/FAKE/PLACEHOLDER, SURROGATE/MOCK
        turmaRepository = new TurmaRepositoryFake();
        // a questão das dependências
        matriculaService = new MatriculaService(alunoRepository, turmaRepository); 
        // TESTE UNITÁRIO: testa uma "unidade" (classe/objeto)
        // se a gente estivesse usando o repositório real com banco e tudo, seria
        // um TESTE DE INTEGRAÇÃO
    }

    // TDD
    // AssertJ -> interface fluente (BDD) Behavior Driven Development

    @Test void TestVerdade(){
        // System.out.println("Teste");
        // assertTrue(true, "A verdade não foi Verdade");
        assertThat(true).isTrue();
    }
    
    @Test void TestFalso(){
        //System.out.println("Teste");
        assertThat(false).isFalse();
    }

    // Spring Modulith

    @Test void TestHaUmaInstanciaDeMatriculaServices(){
        assertThat(matriculaService).isNotNull();
        // assertNotNull(matriculaService, "Matricula Services não é nulo");
    }

    // the boys, watchmen (caricata de superheróis) (vigia)
    // who watches the watchmen => quem vigia os vigilantes
    @Test void TestAlunoNaoExisteLançaExceçãoNotFoundException(){
        // assertion library, matcher library
        // JUnit (Jupiter), complementam: Hamcrest, AssertJ

        assertThatThrownBy(() -> 
            matriculaService.matricular(123, "tds-2024-2"))
                    .isInstanceOf(NotFoundException.class)
                    .hasMessage("Aluno 123 não encontrado");
        
        // Assertions.assertThrows(NotFoundException.class, () -> {
        //     matriculaService.matricular(123, "tds-2024-2");
        // });

        // try{
        //     matriculaService.matricular(123, "tds-2024-2");
        //     fail("A exceção não foi lançada");
        // } catch (NotFoundException e) {
        //     System.out.println(e);
        //     assertEquals("Aluno 123 não encontrado", e.getMessage());
        // }
        
    }    
}
