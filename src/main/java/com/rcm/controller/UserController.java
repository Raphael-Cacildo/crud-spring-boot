package com.rcm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rcm.models.User;
import com.rcm.repository.UserRepository;

@Controller
public class UserController {
	@Autowired //ESSA ANOTAÇÃO COLOCA O SPRING NO CONTROLE DO userRepository /INJEÇÃO DE DEPENDENCIA
	UserRepository userRepository;
	
	@GetMapping("/signup") // TRAZ O USUARIO CADASTRADO E RETORNA OS USUARIOS CADASTRADOS
    public String showSignUpForm(User user) {
        return "/eventos/add-user";
    }
     
    @PostMapping("/adduser") // ESTE METHODO ADICIONA UM USUARIO E VALIDA 
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
 
        userRepository.save(user);   //ESTA SALVANDO UM USUARIO
        model.addAttribute("users", userRepository.findAll()); //ESTA BUSCANDO TODOS OS ATRIBUTOS DOS USUARIOS E RETORNANDO NO INDEX 
        return "index";
    }
 
    // additional CRUD methods
    @GetMapping("/edit/{id}") // FAZ UMA VALIDAÇÃO SE O ID É DE UM USUARIO
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
         
        model.addAttribute("user", user);
        return "update-user"; // RETORNA O USUARIO ATUALIZADO
    }
    
    @PostMapping("/update/{id}") // ESTA ANOTAÇÃO PERMITE INSERIR UM ID 
    public String updateUser(@PathVariable("id") long id, @Valid User user, 
      BindingResult result, Model model) {
    	
        if (result.hasErrors()) { //VALIDAÇÃO DE USUARIO
            user.setId(id);
            return "update-user";
        }
             
        userRepository.save(user); // SALVA E RETORNA EM INDEX
        model.addAttribute("users", userRepository.findAll());
        return "index"; 
    }
         
    @GetMapping("/delete/{id}") // ESSA ANOTAÇÃO BUSCA O MAPEAMENTO DOS ID PARA ENTÃO PODER EXCLUIR UM ID 
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

}
