package lt.codeacademy.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class SpotterDAO {

	 @Autowired
	    private SessionFactory sessionFactory;

	    public Spotter findSpotter(String name) {
	        Session session = this.sessionFactory.getCurrentSession();
	        return session.find(Spotter.class, name);
	    }

}
