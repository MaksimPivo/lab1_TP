package com.runner;

import com.Utis.NewHibernateUtil;
import com.Utis.Spetsialnosti;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        Date date = new Date();
//        date.setYear(2013); //неправилный парсинг даты(3913)
        date.setYear(113);
        date.setMonth(3);
        date.setDate(23);
        Spetsialnosti spetsialnosti = new Spetsialnosti();
        Transaction t = s.beginTransaction();
        spetsialnosti.setKodSpets(2);
        spetsialnosti.setDateFormir(date);
        spetsialnosti.setNazvanie("Programmnoe obespechenie informationnih sistem");
        spetsialnosti.setStatusDate(new Date());
        t.commit();
        s.save(spetsialnosti);

        s.close();
    }

}
