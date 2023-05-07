package com.tp.soap_wsdl_uddi.web;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tp.soap_wsdl_uddi.entities.Compte;
import com.tp.soap_wsdl_uddi.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/banque")
public class CompteRestJAXRSAPI {
    @Autowired
    private CompteRepository cptRep;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Compte> CompteList() {
        return cptRep.findAll();
    }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getOne(@PathParam(value = "id") Long id) {
        return cptRep.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte) {
        return cptRep.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte, @PathParam(value = "id") Long id) {
        compte.setCode(id);
        return cptRep.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam(value = "id") Long id) {
        cptRep.deleteById(id);
    }

}
