package br.ivan.security.springsecurityandthymeleaf

import br.ivan.security.springsecurityandthymeleaf.model.Role
import br.ivan.security.springsecurityandthymeleaf.model.RoleName
import br.ivan.security.springsecurityandthymeleaf.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component


@Component
class AppRunning : ApplicationRunner {

    @Autowired
    private lateinit var roleRepository: RoleRepository

    override fun run(args: ApplicationArguments?) {
        createRoles()
    }

    fun createRoles(){
        val roleAdm = Role(id = 1, name = RoleName.ROLE_ADMINISTRATOR )
        roleRepository.save(roleAdm)

        val roleUser= Role(id = 2, name = RoleName.ROLE_USER )
        roleRepository.save(roleUser)
    }

}