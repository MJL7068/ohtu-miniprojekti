package miniproju.Domain;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("bookref")
public class Bookref extends Model {

    @Override
    public String toString() {
        String result = "";
        for (String key: this.toMap().keySet()) {
            result += key + ": " + this.get(key) + "\n";
        }
        return result;
    }
}
