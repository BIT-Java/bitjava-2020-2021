package pl.edu.knbit.bitjava.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.knbit.bitjava.shop.model.User;

/**
 * Created by surja on 23.11.2020
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
