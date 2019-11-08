package crud;

import model.AlbumManager;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

public class AlbumCrud {


    public static void crud() {

        //CREATE
        post("/album/create", (req, res) -> {
            res.type("application/json");
            String qpar = req.body();
            AlbumManager am = new AlbumManager();
            String json = am.createAlbumByJSON(qpar);
            return json;
        });

        //READ
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


        //UPDATE
        put("/album/update/:id", (req, res) -> {
            String id = req.params(":id");
            res.type("application/json");
            String qpar = req.body();
            AlbumManager am = new AlbumManager();
            Long long_id = Long.parseLong(id);
            String json = am.updateAlbumByJSON(long_id, qpar);
            return json;
        });

        //DELETE
        delete("/album/delete/:id", (req, res) -> {
            String id = req.params(":id");
            Long long_id = Long.parseLong(id);
            res.type("application/json");
            AlbumManager am = new AlbumManager();
            String json = am.deleteAlbum(long_id);
            return json;
        });
    }

}
