package br.ivan.security.springsecurityandthymeleaf.controller

import br.ivan.security.springsecurityandthymeleaf.repository.UserRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @GetMapping("/home")
    fun homePage(request: HttpServletRequest) : String {

        val userName = request.userPrincipal.name

        if (request.session.getAttribute(userName) == null){
            val user = userRepository.findByEmail(userName)
            request.session.setAttribute(userName, user)
        }

        return "home"
    }
}