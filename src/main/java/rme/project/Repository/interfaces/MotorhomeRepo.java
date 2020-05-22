/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;


import rme.project.Models.Motorhome;

public interface MotorhomeRepo extends CRUD<Motorhome>
{

    int Search (int id);

}
