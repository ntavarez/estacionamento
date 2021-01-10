package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.Carro;
import exceptions.EstacionamentoException;

public class Estacionamento {

	private final int VAGASLIMITE = 10;
	private final int IDADELIMITE = 55;

	List<Carro> carros = new ArrayList<>();

	public void estacionar(Carro carro) {

		if (carrosEstacionados() == VAGASLIMITE) {
			for (Iterator<Carro> i = carros.iterator(); i.hasNext();) {
				if (i.next().getMotorista().getIdade() <= IDADELIMITE) {
					i.remove();
					break;
				}
			}
		}
		
		if (carrosEstacionados() == VAGASLIMITE) throw new EstacionamentoException("Estacionamento cheio.");
		carros.add(carro);
	}

	public int carrosEstacionados() {
		return carros.size();
	}

	public boolean carroEstacionado(Carro carro) {
		return carros.contains(carro);
	}
}
