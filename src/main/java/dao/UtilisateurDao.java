package dao;

/**
 * Created by François on 01-10-17.
 */
import java.util.List;

import beans.Utilisateur;

public interface UtilisateurDao {
    void ajouter( Utilisateur utilisateur );
    List<Utilisateur> lister();
}