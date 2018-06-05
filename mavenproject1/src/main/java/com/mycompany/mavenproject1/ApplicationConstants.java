/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author hp
 */
public class ApplicationConstants {
 
    // Twitter application specific secret constants.   
    public static final String CONSUMER_KEY_KEY = "YqQCbUU3blhO5jGSiK8gU17LY";
    public static final String CONSUMER_SECRET_KEY = "twsxarbwytFDWWFzgdc7HxprNo9vA3abgjGhOIJqUWWLAGkA4Y";
    public static final String ACCESS_TOKEN_KEY = "988498850-7b4JnIgWzn72TOaeqLCSTNyjNbDm7Y024aQgti69";
    public static final String ACCESS_TOKEN_SECRET_KEY = "0aWkNC4metbMtIn91aEe8byNFKUfa0FrYvwxSzDf06Li8";
 
    //public static final String CONSUMER_KEY_KEY = "7UK1wCbVrjvCyexWeOrNH0NXH";
    //public static final String CONSUMER_SECRET_KEY = "qNPV9ft7TiVL2tBbR11tQKxItpI3bfrqTCiXp1ArwuguziBZSM";
    //public static final String ACCESS_TOKEN_KEY = "1002953669472481280-6o02NLP5tXfvoNJJVFsF8T54JjT32x";
   // public static final String ACCESS_TOKEN_SECRET_KEY = "Z0lSzQOWShadJGm4eoj66AxHaTU5EvRuVA5pQgtXl9Lrs";
    
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