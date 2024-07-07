package br.ivan.security.springsecurityandthymeleaf.service

import br.ivan.security.springsecurityandthymeleaf.model.RoleName
import br.ivan.security.springsecurityandthymeleaf.model.User
import br.ivan.security.springsecurityandthymeleaf.repository.RoleRepository
import br.ivan.security.springsecurityandthymeleaf.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
) {

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    fun criarUsuario(user: User){
        user.password = bCryptPasswordEncoder.encode(user.password)
        val roleUser = roleRepository.findById(1L).orElse(null)
        user.roles = mutableListOf(roleUser)
        userRepository.save(user)
    }

}