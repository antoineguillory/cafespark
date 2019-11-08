package model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import persistance.AlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class AlbumManager {

    private EntityManager em;

    public AlbumManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("bibliotheque", System.getProperties());
        this.em = factory.createEntityManager();
    }

    public String getAlbumByID(Long id) {
        AlbumEntity alentity;
        String json = "";
        alentity = this.em.find(AlbumEntity.class, id);

        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(alentity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String createAlbumByJSON(String postjson) {
        AlbumEntity alentity;

        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        // Pas de vérifications pour l'album artiste existant mais en théorie il faudrait
        // Pareil au cas ou l'user change l'id autoincrémenté
        try {
            alentity = mapper.readValue(postjson, AlbumEntity.class);
            em.getTransaction().begin();
            this.em.persist(alentity);
            em.getTransaction().commit();
            json = mapper.writeValueAsString(alentity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String updateAlbumByJSON(Long long_id, String qpar) {
        AlbumEntity alentity, alentity2;
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        alentity = this.em.find(AlbumEntity.class, long_id);
        try {
            alentity2 = mapper.readValue(qpar, AlbumEntity.class);
            em.getTransaction().begin();
            alentity.setNom(alentity2.getNom());
            alentity.setIdArtiste(alentity2.getIdArtiste());
            em.getTransaction().commit();
            json = mapper.writeValueAsString(alentity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String deleteAlbum(Long id) {
        AlbumEntity alentity = this.em.find(AlbumEntity.class, id);
        em.remove(alentity);
        return "successfully deleted";
    }
}
