package com.mariamura.jwtAppDemo.repository.impl

import com.mariamura.jwtAppDemo.model.User
import com.mariamura.jwtAppDemo.repository.UserRepository
import com.mariamura.jwtAppDemo.utils.HibernateUtils
import org.hibernate.Session

class UserRepositoryImpl : UserRepository {
    override fun save(user: User?): User? {
        val session: Session = HibernateUtils.getSession().openSession()
        val transaction = session.beginTransaction()
        session.save(user)
        transaction.commit()
        session.close()
        return user
    }

    override fun getById(id: Int?): User? {
        val session: Session = HibernateUtils.getSession().openSession()
        val user: User = session[User::class.java, id]
        session.close()
        return user
    }

    override fun deleteById(id: Int?) {
        val session: Session = HibernateUtils.getSession().openSession()
        val transaction = session.beginTransaction()
        val user: User = session[User::class.java, id]
        session.delete(user)
        transaction.commit()
        session.close()
    }

    override val all: List<Any>
        get() {
            val session: Session = HibernateUtils.getSession().openSession()
            val users: List<User> = session.createQuery("from Users").list() as List<User>
            session.close()
            return users
        }

    override fun update(user: User?): User? {
        val session: Session = HibernateUtils.getSession().openSession()
        val transaction = session.beginTransaction()
        val user1: User? = user?.let {
            session[User::class.java, user.id].copy(
                name = it.name,
                events = it.events
            )
        }
        session.update(user1)
        transaction.commit()
        session.close()
        return user1
    }
}