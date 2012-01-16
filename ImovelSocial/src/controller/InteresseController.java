package controller;

import java.util.List;

import model.dao.InteresseDAO;
import model.entity.Interesse;

public class InteresseController {

    private Interesse interesse;
    private List<Interesse> interesses;
    
    public InteresseController() {
        this.interesse = new Interesse();
        this.buscarInteresses();
    }

    public Interesse getInteresse() {
        return interesse;
    }

    public void setInteresse(Interesse interesse) {
        this.interesse = interesse;
    }

    public List<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Interesse> interesses) {
        this.interesses = interesses;
    }
    
    public String cadastrar() {
        boolean resultado = new InteresseDAO().insert(interesse);
        if(resultado) {
            return "sucesso";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorId() {
        this.interesse = new InteresseDAO().selectById(interesse.getId());
        if (interesse != null) {
            return "cadastroInteresse";
        } else {
            return "fail";
        }
    }
    /*
    public String buscarPorUsuario() {
        this.interesses = new InteresseDAO().selectByUsuario(interesses.get(0).getUsuario());
        if (interesses != null && !interesses.isEmpty()) {
            return "listaInteresses";
        } else if (interesses.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorVaga() {
        this.interesses = new InteresseDAO().selectByVaga(interesses.get(0).getVaga());
        if (interesses != null && !interesses.isEmpty()) {
            return "listaInteresses";
        } else if (interesses.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    */
    public String buscarInteresses() {
        this.interesses = new InteresseDAO().selectAll();
        if (interesses != null && !interesses.isEmpty()) {
            return "listaInteresses";
        } else if (interesses.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
}
