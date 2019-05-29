package model;

import java.io.IOException;
import java.sql.SQLException;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 */
public final class ModelFacade implements IModel
{
	private map Map;
	boulder_dashDAO DAO;
	private int map_choice = 1;
	
	/**
     * Instantiates a new model facade.
	 * @throws IOException 
     */
	public ModelFacade() throws IOException, SQLException 
    {
        super();
        this.DAO = new boulder_dashDAO();
        this.DAO.open();
        this.Map = new map(this.DAO.getMAp(map_choice));
        this.DAO.close();
    }
	
	public void connection () 
	{
        this.DAO.open();
        try {
            this.Map.setMap(this.DAO.getMAp(map_choice));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.DAO.close();
    }
	
    public map getMap() 
    {
		return Map;
	}
    
	public void setMap(map map)
	{
		Map = map;
	}

	@Override
	public int getMap_choice() 
	{
		return map_choice;
	}

	@Override
	public void setMap_choice(int map_choice) 
	{
		this.map_choice = map_choice;
	}
	
	
}
