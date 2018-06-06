/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author team_diyana
 */
public class ApplicationConstants {
 
    // Twitter application specific secret constants.   
    public static final String CONSUMER_KEY_KEY = "*****UU3blhO5jGSiK8gU17LY";
    public static final String CONSUMER_SECRET_KEY = "******bwytFDWWFzgdc7HxprNo9vA3abgjGhOIJqUWWLAGkA4Y";
    public static final String ACCESS_TOKEN_KEY = "*********-7b4JnIgWzn72TOaeqLCSTNyjNbDm7Y024aQgti69";
    public static final String ACCESS_TOKEN_SECRET_KEY = "******metbMtIn91aEe8byNFKUfa0FrYvwxSzDf06Li8";
 
    
    // constants
    public static final String NOT_AVAILABLE = "Not Available";
    public static final String EMPTY = "";
 
    // Topology Constants 
    public static final String TOPOLOGY_NAME = "twitter-topology";
    public static final String TWITTER_SPOUT_ID = "twitterSpout";
    public static final String DETAILS_BOLT_ID = "detailsExtractorBolt";
    public static final String RETWEET_DETAILS_BOLT_ID = "retweetDetailsExtractorBolt";
    public static final String FILE_WRITER_BOLT_ID = "fileWriterBolt";
}
