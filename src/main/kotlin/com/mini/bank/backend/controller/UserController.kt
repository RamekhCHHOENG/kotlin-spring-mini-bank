package com.mini.bank.backend.controller

import com.mini.bank.backend.dto.CreateUserRequest
import com.mini.bank.backend.dto.UpdateUserRequest
import com.mini.bank.backend.dto.UserResponse
import com.mini.bank.backend.service.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping("")
    fun getAllUsers(): ResponseEntity<List<UserResponse>> =
        ResponseEntity.ok(userService.getAllUsers())

    @PostMapping("")
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<UserResponse> =
        ResponseEntity(userService.createUser(request), HttpStatus.CREATED)

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") userId: Long): ResponseEntity<UserResponse> =
        userService.getUserById(userId)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @PutMapping("/{id}")
    fun updateUserById(
        @PathVariable("id") userId: Long,
        @RequestBody request: UpdateUserRequest
    ): ResponseEntity<UserResponse> =
        userService.updateUser(userId, request)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable("id") userId: Long): ResponseEntity<Unit> =
        if (userService.deleteUser(userId)) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
}
