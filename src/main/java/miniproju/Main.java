package miniproju;

import miniproju.Domain.Bookref;
import miniproju.db.Database;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Database db = new Database();
        db.saveBookref("variety", "article", "year", 1980);

        for (Bookref br: db.allBookrefs()) {
            System.out.println(br);
        }

    }
}
