package com.mini.bank.backend.repository.user

import com.mini.bank.backend.model.user.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
