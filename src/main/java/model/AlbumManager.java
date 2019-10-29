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

    public String replaceAlbumByID(Long id, String postjson) {
        AlbumEntity alentity, alentity2;

        String json = "";
        alentity = this.em.find(AlbumEntity.class, id);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        try {
            alentity2 = mapper.readValue(postjson, AlbumEntity.class);
            if(alentity.getId() != alentity2.getId()) return "";
            em.getTransaction().begin();
            this.em.remove(alentity);
            alentity.setNom(alentity2.getNom());
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

}
