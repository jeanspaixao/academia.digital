package me.dio.academia.digital.security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.repository.AlunoRepository;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartApplication implements CommandLineRunner {
    @Autowired
    private AlunoRepository repository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Aluno user = repository.findByNome("admin");
        if(user==null){
            user = new Aluno();
            user.setNome("admin");
            user.setBairro("adminBairro");
            user.setCpf("12332112393");
            user.setPassword("master123");
   //         ((Aluno) user.getRoles()).add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByNome("aluno");
        if(user ==null){
            user = new Aluno();
            user.setNome("aluno");
            user.setBairro("alunoBairro");
            user.setCpf("78998778912");
            user.setPassword("aluno123");
 //           ((Aluno) user.getRoles()).add("USERS");
            repository.save(user);
        }
    }
}