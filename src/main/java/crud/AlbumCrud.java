package crud;

import org.apache.openjpa.persistence.EntityManagerImpl;
import org.apache.openjpa.persistence.OpenJPAEntityManager;
import org.graalvm.compiler.replacements.nodes.ArrayEqualsNode;
import persistance.AlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.text.ParseException;

import static spark.Spark.get;
import static spark.Spark.post;

public class AlbumCrud {



    public static void main(String[] args) {
        get("/album/read/:id", (req, res) -> {
            String id = req.queryParams("id");
            try {
                Integer int_id = Integer.parseInt(id);
            } catch(NumberFormatException e) {
                res.status(404);
                return "not found";
            }
        });
    }
}
