package com.tp.soap_wsdl_uddi.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.tp.soap_wsdl_uddi.entities.Compte;
import com.tp.soap_wsdl_uddi.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(serviceName = "banqueWS")
public class CompteSOAPWS {
    @Autowired
    private CompteRepository cptRep;

    @WebMethod
    public List<Compte> CompteList() {
        return cptRep.findAll();
    }

    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id) {
        return cptRep.findById(id).get();
    }

    @WebMethod
    public Compte save(@WebParam Compte compte) {
        return cptRep.save(compte);
    }

    @WebMethod
    public Compte update(@WebParam Compte compte, @WebParam(name = "id") Long id) {
        compte.setCode(id);
        return cptRep.save(compte);
    }

    @WebMethod
    public void delete(@WebParam(name = "id") Long id) {
        cptRep.deleteById(id);
    }

}

