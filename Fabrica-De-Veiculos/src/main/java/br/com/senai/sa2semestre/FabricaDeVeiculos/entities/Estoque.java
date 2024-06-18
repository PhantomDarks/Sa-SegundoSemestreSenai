package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;
import jakarta.persistence.*;
import java.util.Objects;

/**
 * Representa um item de estoque no sistema.
 */
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;

    @ManyToOne()
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca peca;

    private Long quantidadeDisponivel;

    /**
     * Construtor padrão.
     */
    public Estoque() {
    }

    /**
     * Construtor com todos os campos.
     * @param peca a peça do estoque.
     * @param quantidadeDisponivel a quantidade disponível em estoque.
     */
    public Estoque(Peca peca, Long quantidadeDisponivel) {
        this.peca = peca;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    /**
     * Obtém o ID do item de estoque.
     * @return o ID do item de estoque.
     */
    public Long getIdEstoque() {
        return idEstoque;
    }

    /**
     * Define o ID do item de estoque.
     * @param idEstoque o novo ID do item de estoque.
     */
    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    /**
     * Obtém a peça relacionada ao item de estoque.
     * @return a peça relacionada ao item de estoque.
     */
    public Peca getPeca() {
        return peca;
    }

    /**
     * Define a peça relacionada ao item de estoque.
     * @param peca a nova peça relacionada ao item de estoque.
     */
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    /**
     * Obtém a quantidade disponível em estoque.
     * @return a quantidade disponível em estoque.
     */
    public Long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    /**
     * Define a quantidade disponível em estoque.
     * @param quantidadeDisponivel a nova quantidade disponível em estoque.
     */
    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    /**
     * Retorna uma representação em string do item de estoque.
     * A string inclui o ID do estoque, a peça e a quantidade disponível.
     *
     * @return uma string que representa o item de estoque.
     */
    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + idEstoque +
                ", peca=" + peca +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        return idEstoque.equals(estoque.idEstoque) && Objects.equals(peca, estoque.peca) && Objects.equals(quantidadeDisponivel, estoque.quantidadeDisponivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstoque, peca, quantidadeDisponivel);
    }
}
