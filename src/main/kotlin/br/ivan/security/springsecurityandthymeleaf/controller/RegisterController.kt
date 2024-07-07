package br.ivan.security.springsecurityandthymeleaf.controller


import br.ivan.security.springsecurityandthymeleaf.model.RoleName
import br.ivan.security.springsecurityandthymeleaf.model.User
import br.ivan.security.springsecurityandthymeleaf.repository.UserRepository
import br.ivan.security.springsecurityandthymeleaf.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RegisterController {

    @Autowired
    lateinit var userService: UserService


    @GetMapping("/singup")
    fun registerPage(model : Model) : String {

        val user = User()
        model.addAttribute("user", user)

        return "cadastro"
    }

    @PostMapping("/register")
    fun registerUser(user: User) : String {

        userService.criarUsuario(user)

        return "redirect:/login"
    }

}