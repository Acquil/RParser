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

        String inputFile = null;
//        if ( args.length>0 ) 
        inputFile = "/home/aquil/sample.r";
        InputStream is = System.in;
        
        if ( inputFile!=null ) {
            try {
                is = new FileInputStream(inputFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        

        // Print tokens 
        for (Object tok : tokens.getTokens()) {
			System.out.println(tok);
        }
        
        RParser parser = new RParser(tokens);
        parser.setBuildParseTree(true);
        RuleContext tree = parser.prog();

        
        System.out.println("\nOUTPUT:\n"+tree.toStringTree(parser));
    }
    
}
