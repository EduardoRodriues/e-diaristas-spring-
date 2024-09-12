package br.com.treinaweb.e_diarista.web.dtos;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.treinaweb.e_diarista.core.enums.Icone;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoForm {

    @NotNull
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorMinimo;

    @NotNull
    @PositiveOrZero
    private Integer qtdHoras;

    @NotNull
    @PositiveOrZero
    @Max(100)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal porcentagemComissao;

    @NotNull
    @PositiveOrZero
    private Integer horasQuarto;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuarto;

    @NotNull
    @PositiveOrZero
    private Integer horasSala;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorSala;

    @NotNull
    @PositiveOrZero
    private Integer horasBanheiro;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorBanheiro;

    @NotNull
    @PositiveOrZero
    private Integer horasCozinha;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorCozinha;

    @NotNull
    @PositiveOrZero
    private Integer horasQuintal;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuintal;

    @NotNull
    @PositiveOrZero
    private Integer horasOutros;

    @NotNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorOutros;

    @NotNull
    private Icone icone;

    @Positive
    private Integer posicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public BigDecimal getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public void setPorcentagemComissao(BigDecimal porcentagemComissao) {
		this.porcentagemComissao = porcentagemComissao;
	}

	public Integer getHorasQuarto() {
		return horasQuarto;
	}

	public void setHorasQuarto(Integer horasQuarto) {
		this.horasQuarto = horasQuarto;
	}

	public BigDecimal getValorQuarto() {
		return valorQuarto;
	}

	public void setValorQuarto(BigDecimal valorQuarto) {
		this.valorQuarto = valorQuarto;
	}

	public Integer getHorasSala() {
		return horasSala;
	}

	public void setHorasSala(Integer horasSala) {
		this.horasSala = horasSala;
	}

	public BigDecimal getValorSala() {
		return valorSala;
	}

	public void setValorSala(BigDecimal valorSala) {
		this.valorSala = valorSala;
	}

	public Integer getHorasBanheiro() {
		return horasBanheiro;
	}

	public void setHorasBanheiro(Integer horasBanheiro) {
		this.horasBanheiro = horasBanheiro;
	}

	public BigDecimal getValorBanheiro() {
		return valorBanheiro;
	}

	public void setValorBanheiro(BigDecimal valorBanheiro) {
		this.valorBanheiro = valorBanheiro;
	}

	public Integer getHorasCozinha() {
		return horasCozinha;
	}

	public void setHorasCozinha(Integer horasCozinha) {
		this.horasCozinha = horasCozinha;
	}

	public BigDecimal getValorCozinha() {
		return valorCozinha;
	}

	public void setValorCozinha(BigDecimal valorCozinha) {
		this.valorCozinha = valorCozinha;
	}

	public Integer getHorasQuintal() {
		return horasQuintal;
	}

	public void setHorasQuintal(Integer horasQuintal) {
		this.horasQuintal = horasQuintal;
	}

	public BigDecimal getValorQuintal() {
		return valorQuintal;
	}

	public void setValorQuintal(BigDecimal valorQuintal) {
		this.valorQuintal = valorQuintal;
	}

	public Integer getHorasOutros() {
		return horasOutros;
	}

	public void setHorasOutros(Integer horasOutros) {
		this.horasOutros = horasOutros;
	}

	public BigDecimal getValorOutros() {
		return valorOutros;
	}

	public void setValorOutros(BigDecimal valorOutros) {
		this.valorOutros = valorOutros;
	}

	public Icone getIcone() {
		return icone;
	}

	public void setIcone(Icone icone) {
		this.icone = icone;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
    
}
