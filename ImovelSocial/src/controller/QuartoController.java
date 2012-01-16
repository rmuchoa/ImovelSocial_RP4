package controller;

import java.util.Arrays;
import java.util.List;

import model.dao.QuartoDAO;
import model.entity.Quarto;
import model.enumeration.TipoQuarto;

public class QuartoController {

    private Quarto quarto;
    private List<Quarto> quartos;
    private List<String> tiposDeQuarto = Arrays.asList(TipoQuarto.CASAL.toString(), TipoQuarto.SOLTEIRO.toString(), TipoQuarto.CONJUNTO.toString());
    
    public QuartoController() {
        this.quarto = new Quarto();
        this.buscarQuartos();
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
    
    public List<String> getTiposDeQuarto() {
        return tiposDeQuarto;
    }

    public void setTiposDeQuarto(List<String> tiposDeQuarto) {
        this.tiposDeQuarto = tiposDeQuarto;
    }
    
    public String cadastrar() {
        boolean resultado = new QuartoDAO().insert(quarto);
        if(resultado) {
            return "sucesso";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorId() {
        this.quarto = new QuartoDAO().selectById(quarto.getId());
        if (quarto != null) {
            return "cadastroQuarto";
        } else {
            return "fail";
        }
    }
    /*
    public String buscarPorImovel() {
        this.quartos = new QuartoDAO().selectByEndereco(quartos.get(0).getEndereco());
        if (quartos != null && !quartos.isEmpty()) {
            return "listaQuartos";
        } else if (quartos.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorEndereco() {
        this.quartos = new QuartoDAO().selectByEndereco(quartos.get(0).getEndereco());
        if (quartos != null && !quartos.isEmpty()) {
            return "listaQuartos";
        } else if (quartos.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    */
    public String buscarQuartos() {
        this.quartos = new QuartoDAO().selectAll();
        if (quartos != null && !quartos.isEmpty()) {
            return "listaQuartos";
        } else if (quartos.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
}
