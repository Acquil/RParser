package com.mycompany.rparser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.*;
/**
 *
 * @author aquil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to R  Parser!");
        
        String inputFile = null;
        Scanner in = new Scanner(System.in);
        String ch ="y";

        inputFile = "/home/aquil/sample.r";
        InputStream is = System.in;
        
        try {
            is = new FileInputStream(inputFile);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CharStream input=null;
        try {
            input = new ANTLRInputStream(is);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        RLexer lexer = new RLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        RemoveWhiteSpace filter = new RemoveWhiteSpace(tokens);
        filter.stream(); 
        tokens.reset();
         
        System.out.println("Token Table:");
        tokens.getTokens().forEach((tok) -> {
            System.out.println(tok);
        });

        System.out.println("\n\n");

        
        RParser parser = new RParser(tokens);
        parser.setBuildParseTree(true);
        RuleContext tree = parser.prog();


        if(parser.getNumberOfSyntaxErrors()==0)
        {
            System.out.println("No Errors!");
        }
        else{
            System.err.println("Errors Are Present!");            
        }
            
    }
    
}
