package org.lightcouch;



import org.lightcouch.pojo.Victime;

import java.net.MalformedURLException;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 18/07/12
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */
public class Tester {

    public static void  main (String argv[]) throws MalformedURLException, InterruptedException {


        long duree,start;
        // public CouchDbClient(java.lang.String dbName, boolean createDbIfNotExist, java.lang.String protocol, java.lang.String host, int port, java.lang.String username, java.lang.String password) { /* compiled code */ }
        Victime t = new Victime();
        t.state = Victime.STATES.ALIVE;
        t.date = new Date();
        t.prenom = "jean-emile";
        t.nom = "DARTOIS";

        /* http://192.168.1.123:59840/     */



                CouchDbClient dbClient = new CouchDbClient("jed6",true,"http","localhost",8888,"","");

        CouchDbClient dbClient2 = new CouchDbClient("jed6",true,"http","localhost",8889,"","");



        dbClient.replicator().addreplicatorTouchDB(dbClient2,true);

        dbClient2.replicator().addreplicatorTouchDB(dbClient,true);


        int nb = 10;
        int counter = 0;

        start= System.currentTimeMillis();
        for(int i=0;i<nb;i++){

            t.prenom = "jean-emile "+i;

            Response c =        dbClient.save(t);
            System.out.println("save "+c.getId());
            Victime t2 =  null;

            do {
                try
                {
                    t2 = dbClient2.find(Victime.class, c.getId());

                }catch (Exception e){
                    //ignore
                    Thread.sleep(1000);
                }
            }  while (t2 == null) ;


            if(t2.prenom.equals(t.prenom)){
                counter++;
                System.out.println("OK "+t2.get_id());
            }

        }

        System.out.println(counter);


        duree = (System.currentTimeMillis() - start)  / 1000;
        System.out.println("Duree ="+duree);




    }



}
