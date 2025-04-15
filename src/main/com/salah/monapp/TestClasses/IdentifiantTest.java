package main.com.salah.monapp.TestClasses;
import main.com.salah.monapp.entity.Identifiant;
import org.junit.jupiter.api.Test; // ✔️ Bon import
import static org.junit.jupiter.api.Assertions.assertEquals; // ✔️ Bon import aussi

class IdentifiantTest {

    @Test
    void testCreationIdentifiant() {
        Identifiant id = new Identifiant("testUser", "1234");
        assertEquals("testUser", id.getUsername());
        assertEquals("1234", id.getPassword());
    }
}

