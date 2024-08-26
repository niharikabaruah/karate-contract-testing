import com.intuit.karate.junit5.Karate;

public class KarateRunner {
    @Karate.Test
    Karate runTest() {
        String filePath = System.getProperty("karate.test");
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Nom du fichier de test non spécifié. Veuillez spécifier le nom du fichier de test en tant que propriété système avec -Dkarate.test=nom_du_fichier.feature");
        }
        String fileName = filePath.replace('\\', '/');
        return Karate.run(fileName).relativeTo(KarateRunner.class);
    }
}