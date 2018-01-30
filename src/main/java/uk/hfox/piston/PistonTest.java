package uk.hfox.piston;

import org.laxio.piston.ignition.PistonIgnition;
import uk.hfox.morphix.connector.MorphixConnector;
import uk.hfox.morphix.mongo.connection.MongoConnector;

public class PistonTest {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                PistonIgnition.main("--instances 0".split("\\s+"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        thread.start();
        MorphixConnector connector = MongoConnector.builder().timeout(5000).build().build();
        connector.connect();
    }

}
