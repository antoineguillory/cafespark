package crud;

import model.AlbumManager;
import persistance.AlbumEntity;

import static spark.Spark.get;
import static spark.Spark.post;

public class AlbumCrud {


    public static void main(String[] args) {
        //CREATE
        get("/album/read/:id", (req, res) -> {
            res.type("application/json");
            String id = req.params(":id");
            try {
                Long long_id = Long.parseLong(id);
                AlbumManager am = new AlbumManager();
                String json = am.getAlbumByID(long_id);
                return json;
            } catch(NumberFormatException e) {
                res.status(404);
                return "not found";
            }
        });

        //REPLACE
        post("/album/replace/:id", (req, res) -> {
           res.type("application/json");
            String id = req.params(":id");
            String qpar = req.body();
            try {
                Long long_id = Long.parseLong(id);
                AlbumManager am = new AlbumManager();
                String json = am.replaceAlbumByID(long_id, qpar);
                return json;
            } catch(NumberFormatException e) {
                res.status(404);
                return "not found";
            }
        });
    }
}
