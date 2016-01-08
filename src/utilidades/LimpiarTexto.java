/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class LimpiarTexto {
    String texto;
    List<String> palabras;
    List<String> cantidad;
    
    public LimpiarTexto() {
    }

    public List<String> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<String> cantidad) {
        this.cantidad = cantidad;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }
    
    public void obtenPalabra(){
        int contador=0;
        ArrayList<String> palabraRepetida = new ArrayList();
        List<String> palabraContada = new ArrayList<>();
        List<String> contada = new ArrayList<>();
        String aux, aux2;
        StringTokenizer tokens = new StringTokenizer(texto);
        
        while(tokens.hasMoreTokens()){
            aux=tokens.nextToken();
            if(!palabraRepetida.contains(aux)){
                //System.out.println(aux);
                palabraRepetida.add(aux);
                StringTokenizer tokens2 = new StringTokenizer(texto);
                while (tokens2.hasMoreTokens()) {  
                    aux2=tokens2.nextToken();
                    if(aux.compareTo(aux2)==0){
                        contador++;
                        //System.out.println(aux +" " + Integer.toString(contador));
                    }
                }
                //System.out.println(aux +" " + Integer.toString(contador));
                palabraContada.add(aux);
                contada.add(Integer.toString(contador));
                contador=0;
            }
            
        }
        cantidad=contada;
        palabras=palabraContada;
    }
    
    public void quitaStopWords(){
         String[] StopWords = {"plegable","algún","alguna","algunas","alguno","algunos","ambos","ampleamos","ante","antes","aquel","aquellas","aquellos","aqui","arriba","atras","bajo","bastante","bien","cada","cierta","ciertas","cierto","ciertos","como","con","conseguimos","conseguir","consigo","consigue","consiguen","consigues","cual","cuando","dentro","desde","donde","dos","el","ellas","ellos","empleais","emplean","emplear","empleas","empleo","en","encima","entonces","entre","era","eramos","eran","eras","eres","es","esta","estaba","estado","estais","estamos","estan","estoy","fin","fue","fueron","fui","fuimos","gueno","ha","hace","haceis","hacemos","hacen","hacer","haces","hago","incluso","intenta","intentais","intentamos","intentan","intentar","intentas","intento","ir","la","largo","las","lo","los","mientras","mio","modo","muchos","muy","nos","nosotros","otro","para","pero","podeis","podemos","poder","podria","podriais","podriamos","podrian","podrias","por","por qué","porque","primero","puede","pueden","puedo","quien","sabe","sabeis","sabemos","saben","saber","sabes","ser","si","siendo","sin","sobre","sois","solamente","solo","somos","soy","su","sus","también","teneis","tenemos","tener","tengo","tiempo","tiene","tienen","todo","trabaja","trabajais","trabajamos","trabajan","trabajar","trabajas","trabajo","tras","tuyo","ultimo","un","una","unas","uno","unos","usa","usais","usamos","usan","usar","usas","uso","va","vais","valor","vamos","van","vaya","verdad","verdadera","verdadero","vosotras","vosotros","voy","yo"};
         String aux;
         String textoSinStopWords = "";
         StringTokenizer tokens = new StringTokenizer(texto);
         while(tokens.hasMoreTokens()){
            aux=tokens.nextToken().toLowerCase();
            
            int verificador = 0, k=0; 
            while((k<StopWords.length)&&verificador==0){
                if(aux.compareTo(StopWords[k])==0){ //si es distinta de 0 que las cuente
                    verificador=1;
                }
                k++;
            }
            if (verificador==0) {
                textoSinStopWords += aux + " "; 
                verificador=0;
            }
         }
         
         texto=textoSinStopWords;
    }
    
    
    
    public void quitaElementos(String texto){
            
            texto = texto.replace("á","a");
            texto = texto.replace("Á","A");
            texto = texto.replace("é","e");
            texto = texto.replace("É","E");
            texto = texto.replace("í","i");
            texto = texto.replace("Í","I");
            texto = texto.replace("ó","o");
            texto = texto.replace("Ó","O");
            texto = texto.replace("ú","u");
            texto = texto.replace("Ú","U");
            
        
            texto = texto.replace("["," ");
            texto = texto.replace("~"," ");
            texto = texto.replace("&"," ");
            texto = texto.replace("·"," ");
            texto = texto.replace("²"," ");
            texto = texto.replace("_"," ");
            texto = texto.replace("\""," ");
            texto = texto.replace("?"," ");
            texto = texto.replace("¿"," ");
            texto = texto.replace("."," ");
            texto = texto.replace("|"," ");
            texto = texto.replace("'"," ");
            texto = texto.replace("]"," ");
            texto = texto.replace("{"," ");
            texto = texto.replace("}"," ");
            texto = texto.replace("="," ");
            texto = texto.replace("|"," ");
            texto = texto.replace("$"," ");
            texto = texto.replace("%"," ");
            texto = texto.replace("#"," ");
            texto = texto.replace("!"," ");
            texto = texto.replace("¡"," ");
            texto = texto.replace("*"," ");
            texto = texto.replace(","," ");
            texto = texto.replace("("," ");
            texto = texto.replace(")"," ");
            texto = texto.replace(":"," ");
            texto = texto.replace("/"," ");
            texto = texto.replace("+"," ");
            texto = texto.replace(";"," ");
            texto = texto.replace("< span>< small>< p>"," ");
            texto = texto.replace("<small><span classplainlinks>"," ");
            this.texto = texto.replace("<p align\"left\">"," ");    
            
     
    }
    
}
