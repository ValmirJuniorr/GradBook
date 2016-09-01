package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Pole;

@Stateless(name = "PoleDao")
public class PoleDao extends GenericDao {
	public Pole getById(int id) {
		return super.getById(Pole.class, id);
	}

	public List<Pole> getList() {
		TypedQuery<Pole> query = super.manager.createQuery("select p from Pole p", Pole.class);
		return query.getResultList();
	}
}
