/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.out;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class MainTopology {

    public static void main(String[] args) throws InvalidFormatException, IOException, AlreadyAliveException, InvalidTopologyException, AuthorizationException, InterruptedException {
        // TopologyBuilder instance. Defines the data flow between the components in the topology.
        TopologyBuilder topologyBuilder = new TopologyBuilder();
        // Register the twitter spout and assign it a unique id.
        topologyBuilder.setSpout(ApplicationConstants.TWITTER_SPOUT_ID, new TwitterSpout() {
        });
        /*
         *  TwitterSpout ----> DetailsExtractorBolt
         *  Assigned parallelism 2 for DetailsExtractorBolt.
         */
        topologyBuilder.setBolt(ApplicationConstants.DETAILS_BOLT_ID, new DetailsExtractorBolt() {
        }, 2)
                .shuffleGrouping(ApplicationConstants.TWITTER_SPOUT_ID);
        /*
         *  TwitterSpout ----> RetweetDetailsExtractorBolt
         *  Assigned parallelism 2 for RetweetDetailsExtractorBolt.
         */
        topologyBuilder.setBolt(ApplicationConstants.RETWEET_DETAILS_BOLT_ID, new RetweetDetailsExtractorBolt() {
        }, 2)
                .shuffleGrouping(ApplicationConstants.TWITTER_SPOUT_ID);
        // Join DetailsExtractorBolt and RetweetDetailsExtractorBolt ----> FileWriterBolt
        topologyBuilder.setBolt(ApplicationConstants.FILE_WRITER_BOLT_ID, new FileWriterBolt())
                .fieldsGrouping(ApplicationConstants.DETAILS_BOLT_ID, new Fields("title"))
                .fieldsGrouping(ApplicationConstants.RETWEET_DETAILS_BOLT_ID, new Fields("title"));
        // Config instance. It defines topology's runtime behavior.
        Config config = new Config();
        // To run storm in local mode.

        if (args != null && args.length > 0) {
            config.setNumWorkers(1);
            StormSubmitter.submitTopology(args[0], config, topologyBuilder.createTopology());
        } else {

            final LocalCluster cluster = new LocalCluster();
            // deploy topology in local mode.

            cluster.submitTopology(ApplicationConstants.TOPOLOGY_NAME, config, topologyBuilder.createTopology());

            // This method will kill the topology while shutdown the JVM.
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    //System.out.println("dia panggil sini");
                    cluster.killTopology(ApplicationConstants.TOPOLOGY_NAME);
                    //System.out.println("sebelum shutdown dia jalan sini");
                    
                    //System.out.println("Selepas shutdown dia jadi apa");
                    //System.out.println("Convert .csv to .txt \n");
                    //readwrite r = new readwrite();
                    //r.readData();
                    
                    System.out.println("\n\nCalculate and analyse data......\n");
                    
                    System.out.println("Project - STIW3054 A172 \n");

                    System.out.println("Analyse data from Tweets from Twitter \n");

                    System.out.println("Result \n");

                    System.out.println("General Details \n");
                    CountingWord cw = new CountingWord();
                    try {
                        cw.countWord();
                    } catch (IOException ex) {
                        Logger.getLogger(MainTopology.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ReadDetail rd = new ReadDetail();
                    try {
                        rd.readDetails();
                    } catch (IOException ex) {
                        Logger.getLogger(MainTopology.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("\n\n Details for each line \n");

                    AnalyseLIne al = new AnalyseLIne();
                    try {
                       al.analyseLine();
                    } catch (IOException ex) {
                        Logger.getLogger(MainTopology.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("\n\nDetails for each character \n");

                    ReadCharacter rc = new ReadCharacter();
                    try {
                        rc.readChar();
                    } catch (IOException ex) {
                        Logger.getLogger(MainTopology.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    cluster.shutdown();
                }
            });

            //System.out.println("Pengiraan bermula");
            sleep(5 * 60000); // 5 Minit
            System.exit(0);

        }
        //sleep(10000);
        //System.out.println("Sistem mati disini");
        //System.exit(0);
    }

}