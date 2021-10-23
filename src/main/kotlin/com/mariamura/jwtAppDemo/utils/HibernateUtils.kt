package com.mariamura.jwtAppDemo.utils

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

class HibernateUtils {

    init {
        try {
            val config = Configuration()
            sessionFactory = config.configure().buildSessionFactory()
        } catch (e: Throwable) {
            System.err.println(e.message)
            throw ExceptionInInitializerError(e)
        }
    }
    companion object {
        lateinit var sessionFactory: SessionFactory
        fun getSession(): SessionFactory {
            return sessionFactory
        }
    }
}