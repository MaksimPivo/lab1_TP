package com.runner;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import com.Utis.Spetsialnosti;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        Date date = new SimpleDateFormat( "yyyy.MM.dd" ).parse( "2013.04.03" );
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
