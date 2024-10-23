package br.com.treinaweb.e_diarista.web.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.treinaweb.e_diarista.core.exceptions.ValidacaoException;
import br.com.treinaweb.e_diarista.web.dtos.AlterarSenhaForm;
import br.com.treinaweb.e_diarista.web.dtos.FlashMessage;
import br.com.treinaweb.e_diarista.web.dtos.UsuarioCadastroForm;
import br.com.treinaweb.e_diarista.web.dtos.UsuarioFormEdicao;
import br.com.treinaweb.e_diarista.web.services.WebServicoUsuario;
import jakarta.validation.Valid; 


@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {

    @Autowired
    private WebServicoUsuario service;


    @GetMapping
    public ModelAndView buscartodos() {
        var modelAndView = new ModelAndView("admin/usuario/lista");

        modelAndView.addObject("usuarios", service.buscarTodos());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {

        var modelAndView = new ModelAndView("admin/usuario/cadastro-form");

        modelAndView.addObject("cadastroForm", new UsuarioCadastroForm());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("cadastroForm") UsuarioCadastroForm cadastroForm,
     BindingResult result, 
      RedirectAttributes attrs) {

    if(result.hasErrors()) {
        return "admin/usuario/cadastro-form";
    }

    try {
        service.cadastrar(cadastroForm);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuario cadastrado com sucesso"));
    } catch(ValidacaoException e) {
        result.addError(e.getFieldError());
        return "admin/usuario/cadastro-form";
    }

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {

        var modelAndView = new ModelAndView("admin/usuario/edicao-form");

        modelAndView.addObject("edicaoForm", service.buscarPorId(id));

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id,
     @Valid @ModelAttribute("edicaoForm") UsuarioFormEdicao edicaoForm,
      BindingResult result,
       RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "admin/usuario/edicao-form";
        } try {

        service.editar(edicaoForm, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuario editado com sucesso"));
        } catch (ValidacaoException e) {
            result.addError(e.getFieldError());
            return "admin/usuario/edicao-form";
        }


        return "redirect:/admin/usuarios";
       }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluirPorId(id);

        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário excludo com sucesso"));

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/aletar-senhs")
    public ModelAndView alterarSenha() {
        var modelAndView = new ModelAndView("admin/usuario/alterar-senha");

        modelAndView.addObject("alterarSenhaForm", new AlterarSenhaForm());

        return modelAndView;
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha(@Valid @ModelAttribute("alterarSenhaForm") AlterarSenhaForm alterarSenhaForm,
     BindingResult result,
     RedirectAttributes attrs,
     Principal principal) {
        
        if(result.hasErrors()) {
            return "admin/usuario/alterar-senha";
        }

        try{
            service.alterarSenha(alterarSenhaForm, principal.getName());
            attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "senha alterada com sucesso"));
        } catch(ValidacaoException e) {
            result.addError(e.getFieldError());

            return "admin/usuario/alterar-senha";
        }

        return "/admin/usuarios/alterar-senha";
     }
    
    
}
