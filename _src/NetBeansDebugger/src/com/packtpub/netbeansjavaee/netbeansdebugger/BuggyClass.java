/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.netbeansdebugger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heffel
 */
public class BuggyClass {
    
    private List<String> musicalNotes;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BuggyClass buggyClass = new BuggyClass();
        
        buggyClass.initializeList();
        
        buggyClass.printListValues();
    }

    private void initializeList() {
        if (musicalNotes == null){
            musicalNotes = new ArrayList<>();
            musicalNotes.add("do");
            musicalNotes.add("re");
            musicalNotes.add("mi");
            musicalNotes.add("fa");
            musicalNotes.add("so");
            musicalNotes.add("la");
            musicalNotes.add("ti");
        }
    }

    private void printListValues() {
        for (int i=1; i<musicalNotes.size(); i++){
            System.out.println(musicalNotes.get(i));
        }
    }
}
