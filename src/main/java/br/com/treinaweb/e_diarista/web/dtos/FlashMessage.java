package br.com.treinaweb.e_diarista.web.dtos;

import lombok.Data;



@Data
public class FlashMessage {
    
    private String classeCss;

    private String menssagem;

    

    public FlashMessage(String classeCss, String menssagem) {
        this.classeCss = classeCss;
        this.menssagem = menssagem;
    }

    public FlashMessage() {
    }

    public String getClasseCss() {
        return classeCss;
    }

    public void setClasseCss(String classeCss) {
        this.classeCss = classeCss;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    
}
