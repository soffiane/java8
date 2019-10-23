package ConcurrenceEtReseau;

import java.net.URLPermission;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.Permission;

/**
 * package java.net
 * classe et interface pour acces reseau
 * : adresse, socket, interface (bas niveau)
 * : URI, URL, Connexions (haut niveau)
 *
 * class URLPermission
 * permission d'acceder à une ressource
 * constructeur(URL, Action (get,post etc...)
 */

public class JavaNETPermissionTest {

    public static void main(String[] args){
        Permission maPermission = new URLPermission("https://www.eixa6.com/");
        try {
            AccessController.checkPermission(maPermission);
            System.out.println("permission granted");
        } catch (AccessControlException e){
            System.out.println(e);
        }

    }
}
