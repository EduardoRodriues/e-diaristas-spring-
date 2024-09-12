package br.com.treinaweb.e_diarista.core.models;

import java.math.BigDecimal;

import br.com.treinaweb.e_diarista.core.enums.Icone;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@ToString(onlyExplicitlyIncluded=true)
public class Servico {
    
    @EqualsAndHashCode.Include
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(name = "valor_minimo", nullable = false)
    private BigDecimal valorMinimo;

    @Column(name = "qtd_horas", nullable = false)
    private Integer qtdHoras;

    @Column(name = "porcentagem_comissao", nullable = false)
    private BigDecimal porcentagemComissao;

    @Column(name = "horas_quarto", nullable = false)
    private Integer horasQuarto;

    @Column(name = "valor_quarto", nullable = false)
    private BigDecimal valorQuarto;

    @Column(name = "horas_sala", nullable = false)
    private Integer horasSala;

    @Column(name = "valor_sala", nullable = false)
    private BigDecimal valorSala;

    @Column(name = "horas_banheiro", nullable = false)
    private Integer horasBanheiro;

    @Column(name = "valor_banheiro", nullable = false)
    private BigDecimal valorBanheiro;

    @Column(name = "horas_cozinho", nullable = false)
    private Integer horasCozinha;

    @Column(name = "valor_cozinho", nullable = false)
    private BigDecimal valorCozinha;

    @Column(name = "horas_quintal", nullable = false)
    private Integer horasQuintal;

    @Column(name = "valor_quintal", nullable = false)
    private BigDecimal valorQuintal;

    @Column(name = "horas_outros", nullable = false)
    private Integer horasOutros;

    @Column(name = "valor_outros", nullable = false)
    private BigDecimal valorOutros;

    @Column(nullable = false, length = 14)
    @Enumerated(EnumType.STRING)
    private Icone icone;

    @Column(nullable = false)
    private Integer posicao;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public BigDecimal getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public Integer getHorasQuarto() {
		return horasQuarto;
	}

	public BigDecimal getValorQuarto() {
		return valorQuarto;
	}

	public Integer getHorasSala() {
		return horasSala;
	}

	public BigDecimal getValorSala() {
		return valorSala;
	}

	public Integer getHorasBanheiro() {
		return horasBanheiro;
	}

	public BigDecimal getValorBanheiro() {
		return valorBanheiro;
	}

	public Integer getHorasCozinha() {
		return horasCozinha;
	}

	public BigDecimal getValorCozinha() {
		return valorCozinha;
	}

	public Integer getHorasQuintal() {
		return horasQuintal;
	}

	public BigDecimal getValorQuintal() {
		return valorQuintal;
	}

	public Integer getHorasOutros() {
		return horasOutros;
	}

	public BigDecimal getValorOutros() {
		return valorOutros;
	}

	public Icone getIcone() {
		return icone;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public void setPorcentagemComissao(BigDecimal porcentagemComissao) {
		this.porcentagemComissao = porcentagemComissao;
	}

	public void setHorasQuarto(Integer horasQuarto) {
		this.horasQuarto = horasQuarto;
	}

	public void setValorQuarto(BigDecimal valorQuarto) {
		this.valorQuarto = valorQuarto;
	}

	public void setHorasSala(Integer horasSala) {
		this.horasSala = horasSala;
	}

	public void setValorSala(BigDecimal valorSala) {
		this.valorSala = valorSala;
	}

	public void setHorasBanheiro(Integer horasBanheiro) {
		this.horasBanheiro = horasBanheiro;
	}

	public void setValorBanheiro(BigDecimal valorBanheiro) {
		this.valorBanheiro = valorBanheiro;
	}

	public void setHorasCozinha(Integer horasCozinha) {
		this.horasCozinha = horasCozinha;
	}

	public void setValorCozinha(BigDecimal valorCozinha) {
		this.valorCozinha = valorCozinha;
	}

	public void setHorasQuintal(Integer horasQuintal) {
		this.horasQuintal = horasQuintal;
	}

	public void setValorQuintal(BigDecimal valorQuintal) {
		this.valorQuintal = valorQuintal;
	}

	public void setHorasOutros(Integer horasOutros) {
		this.horasOutros = horasOutros;
	}

	public void setValorOutros(BigDecimal valorOutros) {
		this.valorOutros = valorOutros;
	}

	public void setIcone(Icone icone) {
		this.icone = icone;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

    
    
}
