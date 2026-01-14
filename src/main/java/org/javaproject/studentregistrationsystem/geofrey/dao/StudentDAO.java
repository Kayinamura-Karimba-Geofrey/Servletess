package org.javaproject.studentregistrationsystem.geofrey.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.javaproject.studentregistrationsystem.geofrey.config.HibernateUtil;
import org.javaproject.studentregistrationsystem.geofrey.model.Student;

public class StudentDAO {

    public Student login(String name, String regNo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Student s WHERE s.name = :name AND s.regNo = :regNo";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("name", name);
            query.setParameter("regNo", regNo);
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
