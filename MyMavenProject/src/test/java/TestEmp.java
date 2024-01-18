import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;


public class TestEmp {

	public static void main(String[] args) {
		Employee e1=new Employee(1,"Varadraj","Pune");
		Employee e2=new Employee(2,"Abhi","Pune");
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(e1);
		session.save(e2);
		tr.commit();
		session.close();

	}

}
