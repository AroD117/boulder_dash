package model;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public interface IModel 
{
	public map getMap();
	public void setMap(map map);
	public int getMap_choice();
    public void setMap_choice(int map_choice);
    public void connection ();
}
