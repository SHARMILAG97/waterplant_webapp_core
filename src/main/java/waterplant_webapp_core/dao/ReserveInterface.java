package waterplant_webapp_core.dao;

import java.util.List;

import waterplant_webapp_core.exception.DBException;
import waterplant_webapp_core.model.Reserve;

public interface ReserveInterface {
	
	public void addReserve(Reserve rev, int Reservecans) throws DBException;
	public Reserve getReserveId(Reserve rev) throws DBException;
	public Reserve findByReserveId(int Rid) throws DBException ;
	public void updateReserve(int ordercans, int Rid) throws DBException;
	public List<Reserve> viewReserve() throws DBException ;

}
