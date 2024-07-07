package br.ivan.security.springsecurityandthymeleaf.repository


import br.ivan.security.springsecurityandthymeleaf.model.Role
import br.ivan.security.springsecurityandthymeleaf.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoleRepository : JpaRepository<Role, Long>