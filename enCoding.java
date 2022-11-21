/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass;
import java.util.*;

/**
 *
 * @author HP
 */
public class enCoding {
    
    Scanner s = new Scanner(System.in);
    String name;
    
public void encOde(){
    
    try{
        System.out.println("Enter your name: ");
        //Accepts input
        name = s.nextLine();
        
        //Using URL
        String encodeString = Base64.getEncoder().encodeToString(name.getBytes("utf-16"));
        System.out.println("Using URL(utf-8); Encoded "+name.toUpperCase()+" into: "+encodeString);
        
        Base64.Decoder decoder = Base64.getDecoder();
       String decodeString = new String(decoder.decode(encodeString));
       System.out.println("Decoded back to: "+decodeString);
       
        //using MIME
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 2; i++){
            sb.append(UUID.randomUUID().toString());
        }
            
            byte[] mimebytes = sb.toString().getBytes("utf-8");
            String eStr = Base64.getMimeEncoder().encodeToString(mimebytes);
            System.out.println("\n\nUsing MIME(utf-8); Encoded "+name.toUpperCase()+" into: \n"+eStr);
            
            Base64.Decoder decoderr = Base64.getMimeDecoder();
            String dStr = new String(decoderr.decode(eStr));
            System.out.println("Decoded message: " +dStr);
        
}catch(Exception e){
    System.err.println("Error: "+e.getMessage());
}
    
}

public static void main(String[]args){
enCoding check = new enCoding();
check.encOde();
}
    
}
