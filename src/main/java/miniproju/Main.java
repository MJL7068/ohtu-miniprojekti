package miniproju;

import miniproju.models.Reference;
import miniproju.services.ReferenceService;
import miniproju.services.ReferenceServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ReferenceService rs;
    
    public static void main(String args[]) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        /////////
        Reference newRef = new Reference("eka");
        Reference newRef2 = new Reference("toka");
                
        rs.create(newRef);
        rs.create(newRef2);
    }
}
