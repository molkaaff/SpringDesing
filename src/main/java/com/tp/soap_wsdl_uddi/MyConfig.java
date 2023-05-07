package com.tp.soap_wsdl_uddi;

import com.tp.soap_wsdl_uddi.web.CompteRestJAXRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfig {

    @Bean
    SimpleJaxWsServiceExporter serviceExporter() {
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8887/");
        System.out.println("Web Service Déployé");
        return serviceExporter;
    }

    @Bean
    public ResourceConfig resourceconfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJAXRSAPI.class);
        return jerseyServlet;
    }

}
