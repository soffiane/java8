package outils;

/**
 * environnement embarqué : ressources reduites
 * interet : reduire empreinte memoire, pas toute la VM disponible
 * quand on a pas besoin de toute la plateforme
 * 3 profils supportés : 1 (java core),2 (core + jdbc rmi) et 3 (api complete)
 * on utilise jdeps pour determiner le niveau de profil dont on a besoin
 * avec l'option -profile
 */

public class ProfilsCompact {
}
