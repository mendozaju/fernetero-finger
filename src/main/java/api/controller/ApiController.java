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
        	 + "<p><b>Tiempo de entrada de una nueva venta: </b>"+ ConfigResolver.getDelta()+" minutos</p>"+
        	   "<p><b>Numero actual de ventas: </b>" + ValueGetterResolver.getValue()+"</p>"+
        	 "<h3>Operaciones:</h3>"+
        	   "<p>/config?delta=n : Configura el tiempo de entrada de una nueva venta</p>" +
        	 "<p>/value : retorna el valor actual</p>"+
        	 "<p>/reset : reseta el numero de ventas a 0</p>";
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
    
    @RequestMapping(value = "/reset")
    public String reset() {
    	ValueGetterResolver.value = 0;
        return "Se reseteo el numero de ventas a 0";
    }
    
}
