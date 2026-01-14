package org.javaproject.studentregistrationsystem.geofrey.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.javaproject.studentregistrationsystem.geofrey.config.HibernateUtil;
import org.javaproject.studentregistrationsystem.geofrey.model.Student;

public class StudentDAO {

    public Student login(String firstName, String registrationNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Student s WHERE s.firstName = :fname AND s.registrationNumber = :regNum";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("fname", firstName);
            query.setParameter("regNum", registrationNumber);
            return query.uniqueResult(); // returns null if no match
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }
}
