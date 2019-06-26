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
            ruta = "C:/Users/Hugo Luna/Desktop/user.png";
        } else if (isMac()) {
            ruta = "/Users/hugoluna/Desktop/user.png";
        } else if (isUnix()) {
            ruta = "/home/hugo/Escritorio/user.png";
        } else if (isSolaris()) {
        } else {
            System.out.println("Sistema operativo no reconocido!!");
            ruta = "/Users/hugoluna/Desktop/user.png";
        }
        
        return ruta;
    }
    
    
    public String rutaImagenStatusOnline(){
        String ruta = "/Users/hugoluna/Desktop/status_online.png";
        if (isWindows()) {
            ruta = "C:/Users/Hugo Luna/Desktop/status_online.png";
        } else if (isMac()) {
            ruta = "/Users/hugoluna/Desktop/status_online.png";
        } else if (isUnix()) {
            ruta = "/home/hugo/Escritorio/status_online.png";
        } else if (isSolaris()) {
        } else {
            System.out.println("Sistema operativo no reconocido!!");
            ruta = "/Users/hugoluna/Desktop/status_online.png";
        }
        
        return ruta;
    }
    
    
    public String rutaImagenStatusOffline(){
        String ruta = "/Users/hugoluna/Desktop/status_offline.png";
        if (isWindows()) {
            ruta = "C:/Users/Hugo Luna/Desktop/status_offline.png";
        } else if (isMac()) {
            ruta = "/Users/hugoluna/Desktop/status_offline.png";
        } else if (isUnix()) {
            ruta = "/home/hugo/Escritorio/status_offline.png";
        } else if (isSolaris()) {
        } else {
            System.out.println("Sistema operativo no reconocido!!");
            ruta = "/Users/hugoluna/Desktop/status_offline.png";
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
