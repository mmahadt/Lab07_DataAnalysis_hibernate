/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author mmahad.bese14seecs
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import softcons.lab07.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmployeeDao {

    public Session currSession = null;

    public EmployeeDao() {
        HibernateUtil.createSessionFactory();
        currSession = HibernateUtil.getSessionFactory().openSession();
    }

    public void finalize() {
        currSession.close();
    }

    public void save(ArrayList<Employee> newEmpList) {
        Transaction t = currSession.beginTransaction();
        for (int i = 0; i < newEmpList.size(); i++) {
            currSession.persist((Employee) newEmpList.get(i));
        }
        t.commit();
    }

    public void printEmployees() {
        Query query = currSession.createQuery("from Employee");
        List<Employee> list = query.list();

        Iterator<Employee> itr = list.iterator();
        while (itr.hasNext()) {
            Employee emp = itr.next();
            System.out.println("Emp Name: " + emp.getFirstName());
        }
    }
}
