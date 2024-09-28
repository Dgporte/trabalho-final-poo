package br.com.terratech_store.vendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.terratech_store.enums.TipoPagamentoEnum;

public class Pedido {
	private String tipoDado = "Pedido";
	private int idPedido;
	private int fkCarrinho;
	private double valorTotal;
	private LocalDate dataPedido;
	private TipoPagamentoEnum tipoPagamentoEnum;
	private static List<Integer> listaIdsPedido = new ArrayList<>();
	private static Map<Integer, Pedido> mapaPedido = new HashMap<>();

	public Pedido() {
	}

	public Pedido(String tipoDado, int fkCarrinho) {
		verificaId();
		this.fkCarrinho = fkCarrinho;
		this.dataPedido = LocalDate.now();
	}

	private void verificaId() {
		if (listaIdsPedido.isEmpty()) {
			this.idPedido = 1;
			listaIdsPedido.add(idPedido);
		} else {
			this.idPedido = listaIdsPedido.get(listaIdsPedido.size() - 1) + 1;
			listaIdsPedido.add(idPedido);
		}
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public TipoPagamentoEnum getTipoPagamentoEnum() {
		return tipoPagamentoEnum;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public int getFkCarrinho() {
		return fkCarrinho;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setTipoPagamentoEnum(TipoPagamentoEnum tipoPagamentoEnum) {
		this.tipoPagamentoEnum = tipoPagamentoEnum;
	}

	public static Map<Integer, Pedido> getMapaPedido() {
		return mapaPedido;
	}

	@Override
	public String toString() {
		return "Pedido [tipoDado=" + tipoDado + ", idPedido=" + idPedido + ", fkCarrinho=" + fkCarrinho
				+ ", valorTotal=" + valorTotal + ", dataPedido=" + dataPedido + ", tipoPagamentoEnum="
				+ tipoPagamentoEnum + "]";
	}

}
