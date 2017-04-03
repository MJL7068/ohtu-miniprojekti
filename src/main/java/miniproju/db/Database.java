package miniproju.db;

import miniproju.Domain.Bookref;
import org.javalite.activejdbc.Base;

import java.io.File;
import java.sql.*;
import java.util.*;

public class Database {

    public Database() {
        init();
        Base.open("org.sqlite.JDBC", "jdbc:sqlite:sql/data.db", "", "");
    }

    public List<Bookref> allBookrefs() {
        return Bookref.findAll();
    }

    public void saveBookref(Object... attributes) {
        Bookref.createIt(attributes);
    }

    private void init() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sql/data.db");
            Statement statement = conn.createStatement();
            statement.executeUpdate(readSql());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private String readSql() {
        String sqlBlob = "";
        System.out.println("Opening file...");
        try (Scanner reader = new Scanner(new File("sql/create-tables.sql"))) {
            while (reader.hasNextLine()) {
                sqlBlob += reader.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sqlBlob;
    }

}
