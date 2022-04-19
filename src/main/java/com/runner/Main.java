package com.runner;

import com.Utis.NewHibernateUtil;
import com.tasks.Task2;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        Task2 task2 = new Task2(s);
        task2.updateGruppyi();

        s.close();
    }

}
