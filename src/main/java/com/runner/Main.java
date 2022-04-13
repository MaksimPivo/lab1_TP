/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runner;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import com.Utis.Studentyi;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    /**
     * @param args the command line argumentss
     */
    public static void main(String[] args) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        Transaction t1 = s.beginTransaction();
        List<Studentyi> q = s.createQuery("from Studentyi s").list();
        for (Studentyi u : q) {
            System.out.print(u.getFamiliya() + " " + u.getImya() + " " + u.getOtchestvo() + " - " + u.getGruppyi().getNazvanie() + ";\n");
        }
        t1.commit();

        Transaction t2 = s.beginTransaction();
        List<Studentyi> st = s.createQuery("from Studentyi s").list();
        st.stream().collect(Collectors.groupingBy(Studentyi::getGruppyi)).forEach((a, b) -> System.out.println(a.getNazvanie() + " - " + b.stream().count()));
        t2.commit();

        s.close();
    }

}
