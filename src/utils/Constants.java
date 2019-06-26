/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author hugoluna
 */
public class Constants {

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String OSArch = System.getProperty("os.arch").toLowerCase();
    private static String OSVersion = System.getProperty("os.version").toLowerCase();

    public final String IPSERVER = "192.168.1.81";
    
    
    public String rutaImagen(){
        String ruta = "/Users/hugoluna/Desktop/user.png";
        if (isWindows()) {
            System.out.println("Es un Windows");
            ruta = "";
        } else if (isMac()) {
            System.out.println("Es un Mac");
            ruta = "/Users/hugoluna/Desktop/user.png";
        } else if (isUnix()) {
            System.out.println("Es un Unix/Linux");
            ruta = "";
        } else if (isSolaris()) {
            System.out.println("Es Solaris");
        } else {
            System.out.println("Sistema operativo no reconocido!!");
            ruta = "/Users/hugoluna/Desktop/user.png";
        }
        
        return ruta;
    }
    
    
    
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

}
