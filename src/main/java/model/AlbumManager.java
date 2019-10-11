package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import persistance.AlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AlbumManager {

    @PersistenceContext
    protected EntityManager em;

    public AlbumManager() {

    }

    public String getAlbumByID(Integer id) {
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

}
