package controller;

import java.util.List;

import model.dao.VagaDAO;
import model.entity.Vaga;

public class VagaController {
    
    private Vaga vaga;
    private List<Vaga> vagas;
    
    public VagaController() {
        this.vaga = new Vaga();
        this.buscarVagas();
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
    
    public String cadastrar() {
        boolean resultado = new VagaDAO().insert(vaga);
        if(resultado) {
            return "sucesso";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorId() {
        this.vaga = new VagaDAO().selectById(vaga.getId());
        if (vaga != null) {
            return "cadastroVaga";
        } else {
            return "fail";
        }
    }
    /*
    public String buscarPorTipoVaga() {
        this.vagas = new VagaDAO().selectByTipoVaga(vaga.getTipoVaga());
        if (vagas != null && !vagas.isEmpty()) {
            return "listaVagas";
        } else if (vagas.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    */
    public String buscarVagas() {
        this.vagas = new VagaDAO().selectAll();
        if (vagas != null && !vagas.isEmpty()) {
            return "listaVagas";
        } else if (vagas.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
}
