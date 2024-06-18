package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Representa um usuário no sistema.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String perfil;

    /**
     * Construtor com todos os campos.
     * @param idUsuario o ID do usuário.
     * @param nome o nome do usuário.
     * @param email o email do usuário.
     * @param senha a senha do usuário.
     * @param perfil o perfil do usuário.
     */
    public Usuario(Long idUsuario, String nome, String email, String senha, String perfil) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    /**
     * Construtor padrão.
     */
    public Usuario() {
    }

    /**
     * Obtém o ID do usuário.
     * @return o ID do usuário.
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o ID do usuário.
     * @param idUsuario o novo ID do usuário.
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtém o nome do usuário.
     * @return o nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * @param nome o novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o email do usuário.
     * @return o email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * @param email o novo email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     * @return a senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * @param senha a nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o perfil do usuário.
     * @return o perfil do usuário.
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * Define o perfil do usuário.
     * @param perfil o novo perfil do usuário.
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Retorna uma representação em string do usuário.
     * A string inclui o ID do usuário, nome, email, senha e perfil.
     *
     * @return uma string que representa o usuário.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return idUsuario.equals(usuario.idUsuario) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(perfil, usuario.perfil);
    }

    @Override
    public int hashCode() {
        int result = idUsuario.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (perfil != null ? perfil.hashCode() : 0);
        return result;
    }
}
