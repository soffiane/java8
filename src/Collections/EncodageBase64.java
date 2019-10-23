package Collections;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Base64;

/**
 * java.util.Base64
 * methodes statiques
 * n'accepte pas de parametre null
 * types supportés : Basic, URL Safe, MIME
 * methodes : getEncoder(), getDecoder()...
 *
 *
 * usage de l'encodage
 * defini comme codage MIME, pour les protocole de transmission de texte
 * comme table ASCII
 * inconvenient : augmentation du volume des données (33%)
 */

public class EncodageBase64 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //encodage Basic
        String str64 = Base64.getEncoder().encodeToString("Soffiane Boudissa".getBytes("utf-8"));
        System.out.println(str64);
        //decodage Basic
        byte[] lesOctets = Base64.getDecoder().decode(str64);
        System.out.println(new String(lesOctets,"UTF-8"));

        //encodage URL
        String url64 = Base64.getUrlEncoder().encodeToString("http://localhost:8080?accueil".getBytes("utf-8"));
        System.out.println(url64);
        //decodage Url
        byte[] urlOctets = Base64.getUrlDecoder().decode(url64);
        System.out.println(new String(urlOctets,"UTF-8"));

        //encodage MIME (données binaire
        StringBuilder sb = new StringBuilder();
        sb.append("pouet");
        byte[] données = sb.toString().getBytes("utf-8");
        String mime64 = Base64.getMimeEncoder().encodeToString(données);
        System.out.println(mime64);
        //decodage Url
        byte[] mimeOctets = Base64.getMimeDecoder().decode(mime64);
        System.out.println(new String(mimeOctets,"UTF-8"));
    }
}
