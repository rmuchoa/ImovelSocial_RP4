package controller;

import java.util.Arrays;
import java.util.List;

import model.dao.ImovelDAO;
import model.entity.Imovel;
import model.enumeration.Logradouro;
import model.enumeration.TipoImovel;

public class ImovelController {

    private Imovel imovel;
    private List<Imovel> imoveis;
    private List<String> tipos = Arrays.asList(TipoImovel.CASA.toString(), TipoImovel.APARTAMENTO.toString(), TipoImovel.HOTEL.toString(), TipoImovel.PENSAO.toString(), TipoImovel.KITNET.toString(), TipoImovel.ALBERGUE.toString());
    private List<String> cidades = Arrays.asList("Alegrete", "Bagé", "Caçapava do Sul", "Dom Pedrito", "Itaqui", "Jaguarão", "Santana do Livramento", "São Borja", "São Gabriel", "Uruguaiana");
    private List<String> logradouros = Arrays.asList(Logradouro.AEROPORTO.toString(), Logradouro.ALAMEDA.toString(), Logradouro.AREA.toString(), Logradouro.AVENIDA.toString(), Logradouro.CAMPO.toString(), Logradouro.CHACARA.toString(), Logradouro.COLONIA.toString(), Logradouro.CONDOMINIO.toString(), Logradouro.CONJUNTO.toString(), Logradouro.DISTRITO.toString(), Logradouro.ESPLANADA.toString(), Logradouro.ESTACAO.toString(), Logradouro.ESTRADA.toString(), Logradouro.FAVELA.toString(), Logradouro.FEIRA.toString(), Logradouro.JARDIM.toString(), Logradouro.LADEIRA.toString(), Logradouro.LAGO.toString(), Logradouro.LAGOA.toString(), Logradouro.LARGO.toString(), Logradouro.LOTEAMENTO.toString(), Logradouro.MORRO.toString(), Logradouro.NUCLEO.toString(), Logradouro.PARQUE.toString(), Logradouro.PATIO.toString(), Logradouro.PRACA.toString(), Logradouro.QUADRA.toString(), Logradouro.RECANTO.toString(), Logradouro.RESIDENCIAL.toString(), Logradouro.RODOVIA.toString(), Logradouro.RUA.toString(), Logradouro.SETOR.toString(), Logradouro.SITIO.toString(), Logradouro.TRAVESSA.toString(), Logradouro.TRECHO.toString(), Logradouro.TREVO.toString(), Logradouro.VALE.toString(), Logradouro.VEREDA.toString(), Logradouro.VIA.toString(), Logradouro.VIADUTO.toString(), Logradouro.VIELA.toString(), Logradouro.VILA.toString());
    
    public ImovelController() {
        this.imovel = new Imovel();
        this.buscarImoveis();
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }
    
    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public List<String> getLogradouros() {
        return logradouros;
    }

    public void setLogradouros(List<String> logradouros) {
        this.logradouros = logradouros;
    }
    
    public String cadastrar() {
        boolean resultado = new ImovelDAO().insert(imovel);
        if(resultado) {
            return "sucesso";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorId() {
        this.imovel = new ImovelDAO().selectById(imovel.getId());
        if (imovel != null) {
            return "cadastroImovel";
        } else {
            return "fail";
        }
    }
    /*
    public String buscarPorEndereco() {
        this.imoveis = new ImovelDAO().selectByEndereco(imoveis.get(0).getEndereco());
        if (imoveis != null && !imoveis.isEmpty()) {
            return "listaImoveis";
        } else if (imoveis.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    */
    public String buscarImoveis() {
        this.imoveis = new ImovelDAO().selectAll();
        if (imoveis != null && !imoveis.isEmpty()) {
            return "listaImoveis";
        } else if (imoveis.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
}
