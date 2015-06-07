package api.controller;

import org.apache.commons.httpclient.HttpMethod;
import org.opensaml.util.resource.HttpResource;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import api.domain.ConfigResolver;
import api.domain.ValueGetterResolver;

@RestController
public class ApiController {
    
    @RequestMapping("/")
    public String index() {
        return "<h2> Info dedo fernetero </h2>"
        	 + "<p><b>Tiempo de actualizacion: </b>"+ ConfigResolver.getDelta()+" minutos</p>"+
        	   "<p><b>Valor actual: </b>" + ValueGetterResolver.getValue()+"</p>"+
        	 "<h3>Operaciones:</h3>"+
        	   "<p>/config?delta=n : Configura el tiempo de refresco</p>" +
        	 "<p>/value : retorna el valor actual</p>";
    }
    
    @RequestMapping("/value")
    public String getValue() {
        return Long.toString(ValueGetterResolver.getValue());
    }
    
    @RequestMapping(value = "/config")
    public String getValue(@RequestParam("delta") int delta) {
    	ConfigResolver.configureDelta(delta);
        return "Se configuro el delta a :" + delta;
    }
    
}
