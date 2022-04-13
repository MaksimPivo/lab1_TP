/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runner;

import com.Utis.NewHibernateUtil;
import com.tasks.Task1;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        Task1 task1 = new Task1(s);
        task1.slectStudentyi();
        task1.amountStudentyiInGruppyi();

        s.close();
    }

}
