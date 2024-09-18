package com.mini.bank.backend.service.user

import com.mini.bank.backend.dto.CreateUserRequest
import com.mini.bank.backend.dto.UpdateUserRequest
import com.mini.bank.backend.dto.UserResponse
import com.mini.bank.backend.model.user.User
import com.mini.bank.backend.repository.user.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.text.SimpleDateFormat
import java.util.*

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder ) {

    fun getAllUsers(): List<UserResponse> =
        userRepository.findAll().map { it.toResponse() }

    fun getUserById(userId: Long): UserResponse? =
        userRepository.findById(userId).orElse(null)?.toResponse()

    @Transactional
    fun createUser(createUserRequest: CreateUserRequest): UserResponse {
        // Encode the password before creating the user
        val encodedPassword = passwordEncoder.encode(createUserRequest.password)

        val user = User(
            userId = 0,
            lastName = createUserRequest.lastName,
            firstName = createUserRequest.firstName,
            dateOfBirth = parseDate(createUserRequest.dateOfBirth),
            email = createUserRequest.email,
            phoneNumber = createUserRequest.phoneNumber,
            address = createUserRequest.address,
            taxIdentifier = createUserRequest.taxIdentifier,
            gender = createUserRequest.gender,
            role = createUserRequest.role,
            username = createUserRequest.username,
            password = encodedPassword // Use the encoded password
        )
        return userRepository.save(user).toResponse()
    }

    @Transactional
    fun updateUser(userId: Long, updateUserRequest: UpdateUserRequest): UserResponse? {
        val existingUser = userRepository.findById(userId).orElse(null) ?: return null
        val updatedUser = existingUser.copy(
            lastName = updateUserRequest.lastName ?: existingUser.lastName,
            firstName = updateUserRequest.firstName ?: existingUser.firstName,
            dateOfBirth = updateUserRequest.dateOfBirth?.let { parseDate(it) } ?: existingUser.dateOfBirth,
            email = updateUserRequest.email ?: existingUser.email,
            phoneNumber = updateUserRequest.phoneNumber ?: existingUser.phoneNumber,
            address = updateUserRequest.address ?: existingUser.address,
            taxIdentifier = updateUserRequest.taxIdentifier ?: existingUser.taxIdentifier,
            gender = updateUserRequest.gender ?: existingUser.gender
        )
        return userRepository.save(updatedUser).toResponse()
    }

    @Transactional
    fun deleteUser(userId: Long): Boolean {
        if (!userRepository.existsById(userId)) return false
        userRepository.deleteById(userId)
        return true
    }

    private fun User.toResponse() = UserResponse(
        id = userId,
        lastName = lastName,
        firstName = firstName,
        dateOfBirth = dateOfBirth.toString(),  // Adjust the date formatting as needed
        email = email,
        phoneNumber = phoneNumber,
        address = address,
        taxIdentifier = taxIdentifier,
        gender = gender,
        role = role,
        username = username
    )

    // Example function to parse date strings; adjust as necessary
    private fun parseDate(dateString: String): Date {
        // Implement parsing logic, for example using SimpleDateFormat
        return SimpleDateFormat("yyyy-MM-dd").parse(dateString) ?: Date()
    }
}
