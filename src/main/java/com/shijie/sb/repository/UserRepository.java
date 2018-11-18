package com.shijie.sb.repository;

import com.shijie.sb.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ShiJie on 2018-11-13 21:50
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
