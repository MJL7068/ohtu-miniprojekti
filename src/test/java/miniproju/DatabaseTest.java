package miniproju;

import static junit.framework.TestCase.assertTrue;

import miniproju.db.Database;
import org.junit.jupiter.api.Test;

class DatabaseTest {

    @Test
    public void dbIsnotEmpty() {
        Database db = new Database();
        assertTrue(db.allBookrefs().size() > 0);
    }

}
