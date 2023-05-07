package com.tp.soap_wsdl_uddi.web;

import java.util.List;

import com.tp.soap_wsdl_uddi.entities.Compte;
import com.tp.soap_wsdl_uddi.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banque")
public class CompteRestController {
    @Autowired
    private CompteRepository cptRep;

    @GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Compte> CompteList() {
        return cptRep.findAll();
    }

    @GetMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public Compte getOne(@PathVariable(value = "id") Long id) {
        return cptRep.findById(id).get();
    }

    @PostMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE})

    public Compte save(@RequestBody Compte compte) {
        return cptRep.save(compte);
    }

    @PutMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public Compte update(@RequestBody Compte compte, @PathVariable(value = "id") Long id) {
        compte.setCode(id);
        return cptRep.save(compte);
    }

    @DeleteMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public void delete(@PathVariable(value = "id") Long id) {
        cptRep.deleteById(id);
    }

}
