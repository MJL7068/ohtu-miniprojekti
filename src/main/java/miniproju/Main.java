package miniproju;

<<<<<<< HEAD
import miniproju.Domain.Bookref;
import miniproju.db.Database;
=======
import miniproju.models.Reference;
import miniproju.services.ReferenceService;
import miniproju.services.ReferenceServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> branchTwo
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
<<<<<<< HEAD
        Database db = new Database();
        db.saveBookref("variety", "article", "year", 1980);

        for (Bookref br: db.allBookrefs()) {
            System.out.println(br);
        }

=======
        /////////
        Reference newRef = new Reference();
        newRef.setTitle("Extreme Programming Explained: Embrace Change (2nd Edition)");
        newRef.setAuthor("Beck, Kent and Andres, Cynthiat");
        newRef.setPublisher("Addison-Wesley Professional");
        newRef.setYear(2004);
        newRef.setAddress("Addison");
        newRef.setEdition("9th");

        Reference newRef2 = new Reference();
        newRef2.setTitle("Clean Code: A Handbook of Agile Software Craftsmanship");
        newRef2.setAuthor("Martin, Robert");
        newRef2.setPublisher("Prentice Hall");
        newRef2.setYear(2008);
        newRef2.setAddress("Prentice Hall");
        newRef2.setEdition("9th");
                
        rs.create(newRef);
        rs.create(newRef2);
>>>>>>> branchTwo
    }
}
