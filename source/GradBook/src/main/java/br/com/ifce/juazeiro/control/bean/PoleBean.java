package br.com.ifce.juazeiro.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ifce.juazeiro.model.Pole;
import br.com.ifce.juazeiro.model.dao.PoleDao;
import br.com.ifce.juazeiro.util.FacesUtil;

@ManagedBean(name = "poleBean")
@ViewScoped
public class PoleBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5056935125784552499L;
	
	@EJB
	private PoleDao poleDao;
	private Pole pole;
	private List<Pole> poles;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Pole getPole() {
		return this.pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}

	public List<Pole> getPoles() {
		if (this.poles == null) {
			this.poles = this.poleDao.getList();
		}
		return poles;
	}
	

	public void setPoles(List<Pole> poles) {
		this.poles = poles;
	}

	public void create() {
		this.poleDao.merge(this.pole);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.poleDao.merge(this.pole);
		this.setPoles(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Pole pole) {
		this.poleDao.remove(pole);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setPole(new Pole());
		this.setPoles(null);
	}

}
