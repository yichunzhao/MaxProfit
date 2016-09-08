/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxprofit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YNZ
 */
public class CopyrightWriter {

    public static String copyRight = "// Copyright 2016\n" + "// All rights reserved\n" + "// ********************\n";
    public static String htmlCopyRight = "<!--\nCopyright 2016\n" + "All rights reserved\n" + "-->\n";
    public static String hashCopyRight = "# Copyright 2016 #\n" + "# All rights reserved #\n";

    public static void writeCopyright(String copyRight) throws IOException {
        File file = new File("CopyRight.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(copyRight);
        }
    }
    
    public static void main(String[] args) {
        try {
            //writeCopyright(copyRight);
            //writeCopyright(htmlCopyRight);
            writeCopyright(hashCopyRight);
            
        } catch (IOException ex) {
            Logger.getLogger(CopyrightWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
