package com.mini.bank.backend.service.user

import com.mini.bank.backend.dto.CreateUserRequest
import com.mini.bank.backend.dto.UpdateUserRequest
import com.mini.bank.backend.dto.UserResponse
import com.mini.bank.backend.model.user.User
import com.mini.bank.backend.repository.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<UserResponse> =
        userRepository.findAll().map { it.toResponse() }

    fun getUserById(userId: Long): UserResponse? =
        userRepository.findById(userId).orElse(null)?.toResponse()

    @Transactional
    fun createUser(createUserRequest: CreateUserRequest): UserResponse {
        val user = User(name = createUserRequest.name, email = createUserRequest.email)
        return userRepository.save(user).toResponse()
    }

    @Transactional
    fun updateUser(userId: Long, updateUserRequest: UpdateUserRequest): UserResponse? {
        val existingUser = userRepository.findById(userId).orElse(null) ?: return null
        val updatedUser = existingUser.copy(name = updateUserRequest.name, email = updateUserRequest.email)
        return userRepository.save(updatedUser).toResponse()
    }

    @Transactional
    fun deleteUser(userId: Long): Boolean {
        if (!userRepository.existsById(userId)) return false
        userRepository.deleteById(userId)
        return true
    }

    private fun User.toResponse() = UserResponse(id = id, name = name, email = email)
}
