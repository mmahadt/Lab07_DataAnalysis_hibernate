/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author mmahad.bese14seecs
 */
import java.util.ArrayList;
import dao.EmployeeDao;
import softcons.lab07.model.CSVReader;
import softcons.lab07.model.Employee;

public class Executioner {
	public static void main(String[] args) {
		ArrayList<Employee> newEmployees = new ArrayList<Employee>();
		Employee e1=new Employee();  
                
                CSVReader csvReader=new CSVReader();
                
                ArrayList<String> users = csvReader.readCSV(0);
                
                ArrayList<String> timePerUser = csvReader.readCSV(3);
                
		e1.setId(1001);  e1.setFirstName("Fahad");  e1.setLastName("Satti");
		newEmployees.add(e1);
		
		Employee e2=new Employee();  
		e2.setId(1002);  e2.setFirstName("Tahir");  e2.setLastName("Azim"); 			newEmployees.add(e2);
    		EmployeeDao empDao = new EmployeeDao();
		
		try{
			empDao.save(newEmployees);
		}finally{
			empDao.finalize();
		}
	}
}

