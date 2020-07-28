package br.com.leodevel.quarkusbasicproject.repositories;

import javax.enterprise.context.ApplicationScoped;

import br.com.leodevel.quarkusbasicproject.models.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}