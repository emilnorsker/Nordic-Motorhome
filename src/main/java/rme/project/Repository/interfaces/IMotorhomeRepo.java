/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;


import rme.project.Models.Motorhome;

public interface IMotorhomeRepo extends CRUD<Motorhome> {

    int getLastInsertId();

    int Search(int id);

}
