/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package versionessax;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;


import java.net.UnknownHostException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import com.google.gson.*;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;




/**
 *
 * @author Clau
 */
public class ReadSAX {
    
            
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        
        MongoClient mongo;
        DB db = null;
        DBCollection coll = null;
       
        List<Todo> prueba;
        Todo inser = new Todo();
        // muy bonito
        
       
        
        try{
            mongo = new MongoClient("localhost",27017);
            System.out.println("DBMS Mongo Conectado");
            db = mongo.getDB( "prueba" ); //nombre de la bd usada
            //Set <String> colec = db.getCollectionNames();
            coll = db.getCollection("pagina");
                //database.createCollection("pagina", (DBObject) inser);
            
            //System.err.println(colec);
            
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }
        //db.dropDatabase();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        File file = new File("asd.xml");
        if(file==null){
            System.out.println("null");
        }
        Handler handler = new Handler();
        saxParser.parse(file,handler);
        prueba = handler.getAlmacen();
        
        String json="";
        for (Todo prueba1 : prueba) {
            json = new Gson().toJson(prueba1 );
            DBObject dbObject = (DBObject)JSON.parse(json);
            coll.insert(dbObject);
        }
    
        
        //BasicDBObject searchQuery2 = new BasicDBObject().append("titulo", "adaptación ");
	/*DBCursor cursor2 = coll.find();
        while (cursor2.hasNext()) {
            DBObject objet = cursor2.next();
            System.out.println(objet);
            
        }*/
        };
     }
