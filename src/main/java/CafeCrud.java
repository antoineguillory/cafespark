import static spark.Spark.*;

public class CafeCrud {
    public static void main(String[] args) {
        get("/", (req, res) -> "Bienvenue sur ma super machine à café");
        post("/cafe", (request, response) -> {
            System.out.println(request.body());
            return "nouveau type de café ajouté";
        });
    }
}
