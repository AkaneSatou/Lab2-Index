/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versionessax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import utilidades.LimpiarTexto;


public class Handler extends DefaultHandler {
    private List<Todo> almacen = new ArrayList<Todo>();
    private Todo todo;
    List<String> hola;
    private String buffer;
    LimpiarTexto limpiartexto = new LimpiarTexto();
    public Handler() {
       System.out.println("construct");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       buffer += new String(ch, start, length);
        //System.out.println(buffer);
        
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println(qName);
        switch(qName){
            case "title":
                limpiartexto.quitaElementos(buffer);
                limpiartexto.quitaStopWords();
                buffer=limpiartexto.getTexto();
                todo.setTitulo(buffer);
                break;
            case "id": 
                
                hola.add(buffer);
                break;
            case "text":
                
                //System.out.println(buffer);
                limpiartexto.quitaElementos(buffer);
                limpiartexto.quitaStopWords();
                limpiartexto.obtenPalabra();
                todo.setCantidad(limpiartexto.getCantidad());
                todo.setPalabras(limpiartexto.getPalabras());
                almacen.add(todo);
                break;
        }
        
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("startElement");
        switch(qName){
            
            case "title":
                
                todo = new Todo();
                hola = new ArrayList<String>();
                buffer="";
                break;
            case "id":
                buffer="";
                break;
            case "text":
                //System.out.println(qName);
                todo.setId(hola);
                buffer="";
                break;
        }
        
    }

    public List<Todo> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(List<Todo> almacen) {
        this.almacen = almacen;
    }
   
    
}
