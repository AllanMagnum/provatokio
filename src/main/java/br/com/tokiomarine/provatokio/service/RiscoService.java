package br.com.tokiomarine.provatokio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.provatokio.enums.TipoRisco;

@Service
public class RiscoService {
	
	public List<String> list() {
		List<String> tipos = new ArrayList<String>();
		Arrays.asList(TipoRisco.values()).forEach(t->{
			tipos.add(t.toString());
		});;
		return tipos;
	}
}
