/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;


import rme.project.Models.Motorhome;

public interface IMotorhomeRepo extends CRUD<Motorhome> {

    /**
     * @Author Mikkel Åxman
     * @return
     */
    int getLastInsertId();

    /**
     * @Author Mikkel Åxman
     * @param id
     * @return
     */
    int Search(int id);

}
